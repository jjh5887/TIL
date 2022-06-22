package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._02_after;

import me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before.Request;

public abstract class RequestHandler {

	// 다음 처리를 할 RequestHandler
	private RequestHandler nextHandler;

	public RequestHandler(
		RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void  handle(Request request) {
		if (nextHandler != null) {
			nextHandler.handle(request);
		}
	}
}
