package me.powerarc.designpatterns.behavioral_patterns.iterator._02_after;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import me.powerarc.designpatterns.behavioral_patterns.iterator._01_before.Post;

public class RecentPostIterator implements Iterator<Post> {

	private final Iterator<Post> internalIterator;

	private Board board;

	public RecentPostIterator(List<Post> posts) {
		Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
		this.internalIterator = posts.iterator();
	}

	@Override
	public boolean hasNext() {
		return this.internalIterator.hasNext();
	}

	@Override
	public Post next() {
		return this.internalIterator.next();
	}
}
