package me.powerarc.designpatterns.creational_patterns.prototype_pattern._03_java;

import org.modelmapper.ModelMapper;

import me.powerarc.designpatterns.creational_patterns.prototype_pattern._01_before.GithubIssue;
import me.powerarc.designpatterns.creational_patterns.prototype_pattern._01_before.GithubRepository;

public class ModelMapperExample {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

        ModelMapper modelMapper = new ModelMapper();
        GithubIssueData githubIssueData = modelMapper.map(githubIssue, GithubIssueData.class);
        System.out.println(githubIssueData);
    }
}
