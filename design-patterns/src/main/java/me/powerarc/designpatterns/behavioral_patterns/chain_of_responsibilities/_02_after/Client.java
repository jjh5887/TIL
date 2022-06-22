package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._02_after;

import me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before.Request;

public class Client {

	private RequestHandler requestHandler;

	public Client(
		RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	public void doWork() {
		Request request = new Request("이번 놀이는 뽑기입니다.");
		requestHandler.handle(request);
	}

	public static void main(String[] args) {
		RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
		Client client = new Client(chain);
		client.doWork();
	}
}
