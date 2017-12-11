package com;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;
import javax.swing.*;

public class Bricks {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    final int colX;
    final int rowY;
    public Bricks(int row, int col)
    {
        map=new int[row][col];
        colX=col;
        rowY=row;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.println(col);

                map[i][j]=1;
            }
        }
        brickWidth=560/col;
        brickHeight=150/row;
        System.out.println(brickWidth);
    }

    public void draw(Graphics g){
        for(int i=0;i<rowY;i++){
            for(int j=0;j<colX;j++){

                if(map[i][j]>0){
                    g.setColor(Color.RED);
                    g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
                    g.setColor(Color.BLACK);

                }
            }
        }
    }
    public void setBrickValue(int value, int row,int col){
        map[row][col]=value;
    }
}
