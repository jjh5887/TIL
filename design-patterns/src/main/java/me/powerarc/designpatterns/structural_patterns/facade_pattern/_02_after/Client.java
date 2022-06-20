package me.powerarc.designpatterns.structural_patterns.facade_pattern._02_after;

public class Client {

	public static void main(String[] args) {
		EmailSettings emailSettings = new EmailSettings();
		emailSettings.setHost("localhost");

		EmailSender emailSender = new EmailSender(emailSettings);

		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setFrom("kwonho");
		emailMessage.setTo("powerarc");
		emailMessage.setSubject("오징어 게임");
		emailMessage.setText("밖은 더 지옥이더라고..");

		emailSender.sendEmail(emailMessage);
	}
}
