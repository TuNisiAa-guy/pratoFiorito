package me.tunisiaa;

import javax.swing.*;
import javax.swing.border.Border;

import me.tunisiaa.Board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener{
    public boolean wasClicked = false;
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
        this.setBorderPainted(true);
        this.setBackground(Color.GRAY);
        this.board.add(this);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isBomb){
            setForeground(Color.RED);
        }
        //updateNeighbors();
        this.setBorderPainted(false);
        if(this.isBomb){
            this.setText("\udca3");
        }else{
            this.setNumber();
        }
        this.wasClicked = true;
    }
    /*public void updateNeighbors(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1){
                    continue;
                }
                try{
                    Cell c = board.board[i + y - 1][j + x - 1];
                    if(!c.wasClicked){
                        c.setNumber();
                        c.wasClicked = true;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    //throw new RuntimeException(e);
                }
            }
        }
    }*/

    public void setNumber(){
        if(this.wasClicked){
            return;
        }
        int bombs = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1){
                    continue;
                }
                try{
                    if(board.board[i + y - 1][j + x - 1].isBomb){
                        bombs++;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    //throw new RuntimeException(e);
                }

            }
        }
        this.setText(Integer.toString(bombs));
    }
}
