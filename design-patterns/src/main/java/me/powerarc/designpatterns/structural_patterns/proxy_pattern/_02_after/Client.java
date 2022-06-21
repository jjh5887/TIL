package me.powerarc.designpatterns.structural_patterns.proxy_pattern._02_after;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
