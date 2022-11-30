package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._02_after;

import me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before.Request;

public class PrintRequestHandler extends RequestHandler {

	public PrintRequestHandler(
		RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Request request) {
		System.out.println(request.getBody());
		super.handle(request);
	}
}