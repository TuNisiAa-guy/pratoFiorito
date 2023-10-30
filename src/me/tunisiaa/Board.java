package me.tunisiaa;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JFrame {
    private boolean[][] bombs;

    public int width;
    public int height;
    public final int cellSize = 50;
    public final int cellDistance = 2;
    public int density;

    public Cell[][] board;
    public int strikes = 0;
    public int clicked = 0;
    public int total;

    public Board(int width, int height, String difficulty){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        switch(difficulty.toLowerCase()){
            case "easy":
                this.density = 10;
                break;
            case "medium":
                this.density = 20;
                break;
            case "hard":
                this.density = 30;
                break;
            default:
                throw new IllegalArgumentException("The difficulty chosen is not currently available, choose between \"easy\", \"medium\" and \"hard\".");
        }
        this.width = width;
        this.height = height;
        this.total = this.width * this.height;
        board = new Cell[width][height];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Random r = new Random();
                boolean isBomb = r.nextInt(100) < this.density;
                if(isBomb){
                    total--;
                }
                board[i][j] = new Cell(this, j, i, isBomb);
            }
        }
        this.setLayout(null);
        this.setSize(this.width * (this.cellSize + this.cellDistance + 1) + 4, this.height * (this.cellSize + this.cellDistance + 1) + 27);
        this.setResizable(false);
        this.setTitle(String.format("Minesweeper : %s strikes", this.strikes));
    }
    public void render(){
        this.setVisible(true);
    }

    public void showLoserDialog(){
        JDialog dialog = new JDialog(this, "You lost");
        dialog.setSize(300, 200);
        JLabel labelOne = new JLabel("You lost!");
        labelOne.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel labelTwo = new JLabel(String.format("You uncovered %s%s of the field", clicked*100.0/total, "%"));
        labelTwo.setFont(new Font("Arial", Font.PLAIN, 16));
        labelOne.setBounds(75, 50,0, 0);
        labelTwo.setBounds(120, 50, 0, 0);
        dialog.add(labelOne);
        dialog.add(labelTwo);
        dialog.setVisible(true);
    }
}
