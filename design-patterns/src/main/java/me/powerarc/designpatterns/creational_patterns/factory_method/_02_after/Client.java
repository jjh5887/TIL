package me.powerarc.designpatterns.creational_patterns.factory_method._02_after;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = new WhiteshipFactory().orderShip("Whiteship", "kwonho@mail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackshipFactory().orderShip("Blackship", "kwonho@mail.com");
        System.out.println(blackship);
    }

}
