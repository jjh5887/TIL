package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._02_after;

import me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before.Request;

public class LoggingRequestHandler extends RequestHandler {

	public LoggingRequestHandler(
		RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Request request) {
		System.out.println("로깅");
		super.handle(request);
	}
}