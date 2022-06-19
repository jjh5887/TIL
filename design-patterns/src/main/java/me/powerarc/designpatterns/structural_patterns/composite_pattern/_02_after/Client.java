package me.powerarc.designpatterns.structural_patterns.composite_pattern._02_after;

public class Client {

	public static void main(String[] args) {
        // tree 구조에서 전체나 부분을 똑같이 처리할 수 있음
		Item doranBlade = new Item("도란검", 450);
		Item healPotion = new Item("체력 물약", 50);

		Bag bag = new Bag();
		bag.add(doranBlade);
		bag.add(healPotion);

		Client client = new Client();
		client.printPrice(doranBlade);
		client.printPrice(bag);
	}

	private void printPrice(Component component) {
		System.out.println(component.getPrice());
	}

}
