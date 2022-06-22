package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before;

public class RequestHandler {

    public void handler(Request request) {
        System.out.println(request.getBody());
    }
}
