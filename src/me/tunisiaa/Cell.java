package me.tunisiaa;

import javax.swing.*;
import me.tunisiaa.Board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setFont(new Font("arial", Font.BOLD, 30));
        this.setBounds(x*(this.board.cellSize + this.board.cellDistance), y*(this.board.cellSize + this.board.cellDistance), this.board.cellSize, this.board.cellSize);
            this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isBomb){
                    setForeground(Color.RED);
                }
                checkNeighbors();
            }
        });
        this.board.add(this);
    }
    public void checkNeighbors(){
        int bombs = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1){
                    continue;
                }
                if(board.board[i][j].isBomb){
                    bombs++;
                }
            }
        }
        this.setText(Integer.toString(bombs));
    }
}
