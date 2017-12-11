package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;

public class GameArea extends JPanel implements KeyListener, Action{

    private boolean play=false;
    private int score=0;
    private int brickNumber=21;

    private int delay=5;
    private Timer timer;

    private int boardX=310;

    private int ballX=120;
    private int ballY=350;
    private int ballXdirection=-1;
    private int ballYdirection=-2;
    private int row =3;
    private int col =7;

    private Bricks bricks;

    GameArea(){
        bricks=new Bricks(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
       timer=new Timer(delay,this);
       timer.start();


    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(1,1, 692, 592);


        bricks.draw((Graphics2D )g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString(""+score,590,30);

        g.setColor(Color.blue);
        g.fillRect(0,0, 3, 592);
        g.fillRect(0,0, 692, 3);
        g.fillRect(691,0, 3, 592);

        g.setColor(Color.GREEN);
        g.fillRect(boardX, 550,100,8);

        g.setColor(Color.YELLOW);
        g.fillOval(ballX, ballY,20,20);

        if(ballY>570){
            play=false;

            g.setFont(new Font("serif", Font.BOLD,75));
            g.drawString("You Lost",220,320);
            g.setFont(new Font("serif", Font.BOLD,35));
            g.drawString("Press Enter to restart",210,460);

        }

        g.dispose();

    }


    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timer.start();

        if(play){
            if(new Rectangle(ballX,ballY,20,20).intersects(boardX,550,100,8)){
                ballYdirection=-ballYdirection;
            }

        A:    for(int i=0; i < row;i++){
                for(int j=0; j < col;j++){

                    if(bricks.map[i][j]>0)
                    {
                        int brickX=j* bricks.brickWidth+80;
                        int brickY=i* bricks.brickWidth+50;
                        int brickWidth= bricks.brickWidth;
                        int brickHeight= bricks.brickHeight;

                        Rectangle rect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballRec=new Rectangle(ballX,ballY,20,20);
                        Rectangle brickRec=rect;

                        if(ballRec.intersects(brickRec)){
                            System.out.println("xdxdxd");
                            bricks.setBrickValue(0,i,j);
                            brickNumber--;
                            score+=5;

                            if(brickX+20<=brickRec.x|| ballX+1>=brickRec.x+brickRec.width){
                                ballXdirection=-ballXdirection;
                            }else{
                                ballYdirection=-ballYdirection;
                            }
                            break A;
                        }
                    }else{
                    }
                }
            }

            ballX+=ballXdirection;
            ballY+=ballYdirection;
            if(ballX<0){this.ballXdirection=-ballXdirection;}
            if(ballY<0){this.ballYdirection=-ballYdirection;}
            if(ballX>650){this.ballXdirection=-ballXdirection;}

        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(boardX>=600){}else{moveRight();}
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(boardX<=0){}else{moveLeft();}
        }

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play){
                play=true;
                ballY=350;
                ballX=120;
                ballYdirection=-2;
                ballXdirection=-1;
                score=0;
                bricks=new Bricks(3,7);
                repaint();

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveRight(){
        play=true;
        boardX+=30;
    }
    public void moveLeft(){
        play=true;
        boardX-=30;
    }
}
