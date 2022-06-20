package me.powerarc.designpatterns.structural_patterns.decorator_pattern._01_before;

public class TrimmingCommentService extends CommentService {

	@Override
	public void addComment(String comment) {
		super.addComment(trim(comment));
	}

	private String trim(String comment) {
		return comment.replace("...", "");
	}

}
