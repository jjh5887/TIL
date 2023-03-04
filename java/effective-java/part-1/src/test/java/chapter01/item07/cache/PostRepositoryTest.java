package chapter01.item07.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostRepositoryTest {

	@Test
	void cache() throws InterruptedException {
		PostRepository postRepository = new PostRepository();
		CacheKey key1 = new CacheKey(1);
		postRepository.getPostById(key1);

		assertFalse(postRepository.getCache().isEmpty());

		// key 참조 제거
		key1 = null;

		// TODO run gc
		System.out.println("run gc");
		System.gc();
		System.out.println("wait");
		Thread.sleep(3000L);

		// gc 되면서 해당 key를 가지는 value값이 map에서 자동으로 삭제
		assertTrue(postRepository.getCache().isEmpty());
	}

}