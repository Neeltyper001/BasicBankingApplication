package com.gui.main;

import com.constants.FrameDimensions;

import javax.swing.*;

public class MainFrame extends JFrame implements FrameDimensions {
    private MainPanel mainPanel;
    public MainFrame(){
        mainPanel = new MainPanel();
        setBounds(X_COORD,Y_COORD,FRAME_WIDTH,FRAME_HEIGHT);
        this.add(this.mainPanel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
