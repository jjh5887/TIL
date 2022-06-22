package me.powerarc.designpatterns.behavioral_patterns.chain_of_responsibilities._01_before;

public class Request {

    private String body;

    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
