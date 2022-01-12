package main;

import util.Token;

public class App {
    public static void main(String[] args) {

        Token[] players = {Token.CAT, Token.DUCK, Token.HAT};

        Board.init(players);

        System.out.println("Hello, World!");

    }
}
