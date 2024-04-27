package com.gui.main;

import com.constants.FrameDimensions;

import javax.swing.*;

public class MainFrame extends JFrame implements FrameDimensions {
    private static MainPanel mainPanel;
    public MainFrame(){
        MainFrame.mainPanel = new MainPanel();
        setBounds(X_COORD,Y_COORD,FRAME_WIDTH,FRAME_HEIGHT);
        this.add(MainFrame.mainPanel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static MainPanel getMainPanel(){
        return MainFrame.mainPanel;
    }
}
