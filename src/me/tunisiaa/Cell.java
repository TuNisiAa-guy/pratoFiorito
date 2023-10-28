package me.tunisiaa;

import javax.swing.*;
import me.tunisiaa.Board;

public class Cell extends JButton {
    public final int x;
    public final int y;

    public boolean isBomb;

    public Board board;

    public Cell(Board b, int x, int y, boolean isBomb){
        this.x = x;
        this.y = y;
        this.isBomb = isBomb;
        this.board = b;
        JButton jb = new JButton(Integer.toString(checkNeighbors()));
        jb.setBounds(x*(this.board.cellSize + this.board.cellDistance), y*(this.board.cellSize + this.board.cellDistance), x*(this.board.cellSize + this.board.cellDistance) + this.board.cellSize, y*(this.board.cellSize + this.board.cellDistance) + this.board.cellSize);
        this.board.add(jb);
    }
    public int checkNeighbors(){
        return 0;
    }
}
