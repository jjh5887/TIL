package me.powerarc.designpatterns.structural_patterns.decorator_pattern._02_after;

public class App {

	private static final boolean enabledSpamFilter = true;

	private static final boolean enabledTrimming = true;

	public static void main(String[] args) {
		CommentService commentService = new DefaultCommentService();

		if (enabledSpamFilter) {
			commentService = new SpamFilteringCommentDecorator(commentService);
		}

		if (enabledTrimming) {
			commentService = new TrimmingDecorator(commentService);
		}

		Client client = new Client(commentService);
		client.writeComment("오징어게임");
		client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
		client.writeComment("http://whiteship.me");
	}

}
