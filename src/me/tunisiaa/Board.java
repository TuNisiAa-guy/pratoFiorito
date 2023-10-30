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

    public Board(int width, int height, String difficulty){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
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
        board = new Cell[width][height];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Random r = new Random();
                boolean isBomb = r.nextInt(100) < this.density;
                board[i][j] = new Cell(this, j, i, isBomb);
            }
        }
        this.setLayout(null);
        this.setSize(this.width * (this.cellSize + this.cellDistance) + this.cellDistance, this.height * (this.cellSize + this.cellDistance) + this.cellDistance);
    }
    public void render(){
        this.setVisible(true);
    }

    public void showLoserDialog(){
        JDialog dialog = new JDialog(this, "You lost");
        dialog.setSize(300, 200);
        JLabel labelOne = new JLabel("You lost!");
        labelOne.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel labelTwo = new JLabel(":(");
        labelTwo.setFont(new Font("Arial", Font.PLAIN, 50));
        labelOne.setBounds(75, 50,0, 0);
        labelTwo.setBounds(120, 50, 0, 0);
        dialog.add(labelOne);
        dialog.add(labelTwo);
        dialog.setVisible(true);
    }
}
