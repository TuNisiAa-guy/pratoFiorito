package me.tunisiaa;

import javax.swing.*;
import java.util.Random;

public class Board extends JFrame {
    private boolean[][] bombs;

    public int width;
    public int height;
    public final int cellSize = 50;
    public final int cellDistance = 5;
    public int density;

    public Board(int width, int height, String difficulty){
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
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Random r = new Random();
                boolean isBomb = r.nextInt(100) < this.density;
                this.add(new Cell(this, j, i, isBomb));
            }
        }
        this.setLayout(null);
        this.setSize(this.width * (this.cellSize + this.cellDistance), this.height * (this.cellSize + this.cellDistance));
    }
    public void render(){
        this.setVisible(true);
    }

}
