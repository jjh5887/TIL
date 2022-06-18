package me.powerarc.designpatterns.creational_patterns.factory_method._02_after;

public class Client {

	public static void main(String[] args) {
		// open closed 법칙 위배
		Ship whiteship = new WhiteshipFactory().orderShip("Whiteship", "kwonho@mail.com");
		System.out.println(whiteship);

		Ship blackship = new BlackshipFactory().orderShip("Blackship", "kwonho@mail.com");
		System.out.println(blackship);

		// interface 적용
		System.out.println();
		Client client = new Client();
		client.print(new WhiteshipFactory(), "Whiteship", "kwonho@mail.com");
		client.print(new BlackshipFactory(), "Blackship", "kwonho@mail.com");

	}

	private void print(ShipFactory shipFactory, String name, String email) {
		System.out.println(shipFactory.orderShip(name, email));
	}

}
