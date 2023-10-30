package me.tunisiaa;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(10, 10, "medium");
        b.render();
        b.showLoserDialog();
        System.out.println("Hello world!");
    }
}