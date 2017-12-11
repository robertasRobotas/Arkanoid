package com;

import javax.swing.*;

public class Main{

public static void main(String[]args) {

    JFrame jframe=new JFrame();
    GameArea gameArea=new GameArea();
    jframe.setBounds(10,10,700,600);
    jframe.setTitle("RobertasAnkudovicius");
    jframe.setResizable(false);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.add(gameArea);
    jframe.setVisible(true);

}





}