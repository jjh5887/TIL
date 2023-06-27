package study.querydsl;

import static org.assertj.core.api.Assertions.*;
import static study.querydsl.entity.QMember.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

	@Autowired
	EntityManager em;

	JPAQueryFactory queryFactory;

	@BeforeEach
	public void before() {
		queryFactory = new JPAQueryFactory(em);

		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		em.persist(teamA);
		em.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);

		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);

		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);

		em.flush();
		em.clear();

		List<Member> members = em.createQuery("select m from Member m", Member.class)
			.getResultList();

		for (Member member : members) {
			System.out.println("member = " + member);
			System.out.println("-> member.team " + member.getTeam());
		}
	}

	@Test
	public void startJPQL() {
		// member1 찾기
		Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
			.setParameter("username", "member1")
			.getSingleResult();

		assertThat(findMember.getUsername()).isEqualTo("member1");
	}

	@Test
	public void startQuerydsl() {
		// "m" -> jpql alias -> 같은 테이블을 조인하는 경우에만 이런 형태로 선언해서 사용
		// QMember m = new QMember("m");
		// QMember m = QMember.member;

		Member findMember = queryFactory
			// static import 쓰는걸 권장
			.select(member)
			.from(member)
			.where(member.username.eq("member1"))
			.fetchOne();

		assertThat(findMember.getUsername()).isEqualTo("member1");

	}

	@Test
	public void search() {
		Member findMember = queryFactory
			.selectFrom(member)
			.where(member.username.eq("member1")
				.and(member.age.between(10, 30)))
			.fetchOne();

		assertThat(findMember.getUsername()).isEqualTo("member1");
		assertThat(findMember.getAge() >= 10 && findMember.getAge() <= 30).isTrue();
	}

	@Test
	public void searchAndParam() {
		Member findMember = queryFactory
			.selectFrom(member)
			// and 인 경우에는 , 로 넘기면 다 and로 묶어서 넘겨줌
			// null 이 있는 경우 무시해줘서 코드 작성이 편리해짐
			.where(
				member.username.eq("member1"),
				member.age.between(10, 30))
			.fetchOne();

		assertThat(findMember.getUsername()).isEqualTo("member1");
		assertThat(findMember.getAge() >= 10 && findMember.getAge() <= 30).isTrue();
	}
}
