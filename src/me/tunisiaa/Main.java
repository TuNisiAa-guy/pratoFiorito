package me.tunisiaa;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(10, 10, "easy");
        b.render();
        b.showLoserDialog();
        System.out.println("Hello world!");
    }
}