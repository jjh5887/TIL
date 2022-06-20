package me.powerarc.designpatterns.structural_patterns.decorator_pattern._02_after;

public class Client {

	private final CommentService commentService;

	public Client(CommentService commentService) {
		this.commentService = commentService;
	}

	public void writeComment(String comment) {
		commentService.addComment(comment);
	}
}
