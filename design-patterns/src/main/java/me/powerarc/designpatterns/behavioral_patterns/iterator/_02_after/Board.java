package me.powerarc.designpatterns.behavioral_patterns.iterator._02_after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.powerarc.designpatterns.behavioral_patterns.iterator._01_before.Post;

public class Board {

	List<Post> posts = new ArrayList<>();

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void addPost(String content) {
		this.posts.add(new Post(content));
	}

	public Iterator<Post> getRecentPostIterator() {
		return new RecentPostIterator(this.posts);
	}
}
