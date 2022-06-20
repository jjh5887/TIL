package me.powerarc.designpatterns.structural_patterns.decorator_pattern._01_before;

public class SpamFilteringCommentService extends CommentService {

	@Override
	public void addComment(String comment) {
		boolean isSpam = isSpam(comment);
		if (!isSpam) {
			super.addComment(comment);
		}
	}

	private boolean isSpam(String comment) {
		return comment.contains("http");
	}
}
