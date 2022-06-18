package me.powerarc.designpatterns.creational_patterns.prototype_pattern._02_after;

public class App {

	public static void main(String[] args) throws CloneNotSupportedException {
		GithubRepository repository = new GithubRepository();
		repository.setUser("whiteship");
		repository.setName("live-study");

		GithubIssue githubIssue = new GithubIssue(repository);
		githubIssue.setId(1);
		githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

		String url = githubIssue.getUrl();
		System.out.println(url);

		GithubIssue clone = (GithubIssue)githubIssue.clone();
		System.out.println(clone.getUrl());

		repository.setUser("Kwonho");

		System.out.println();
		System.out.println(clone != githubIssue);
		System.out.println(clone.equals(githubIssue));
		System.out.println(clone.getClass() == githubIssue.getClass());

		// shallow copy
		System.out.println(clone.getRepository() == githubIssue.getRepository());

		System.out.println(clone.getUrl());
		System.out.println(githubIssue.getUrl());
	}

}
