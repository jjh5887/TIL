package me.powerarc.designpatterns.structural_patterns.decorator_pattern._01_before;

public class Client {

	private final CommentService commentService;

	public Client(CommentService commentService) {
		this.commentService = commentService;
	}

	private void writeComment(String comment) {
		commentService.addComment(comment);
	}

	public static void main(String[] args) {
		Client client = new Client(new CommentService());
		client.writeComment("오징어게임");
		client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
		client.writeComment("http://whiteship.me");

		System.out.println();
		client = new Client(new TrimmingCommentService());
		client.writeComment("오징어게임");
		client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
		client.writeComment("http://whiteship.me");

		System.out.println();
		client = new Client(new SpamFilteringCommentService());
		client.writeComment("오징어게임");
		client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
		client.writeComment("http://whiteship.me");

	}

}
