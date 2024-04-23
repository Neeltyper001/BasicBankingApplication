package com.gui.main;

import com.gui.panels.WelcomeTextPanel;

import javax.swing.*;

public class MainPanel extends JPanel {

    private WelcomeTextPanel welcomeTextPanel;
    public MainPanel(){
        this.welcomeTextPanel = new WelcomeTextPanel();
        this.add(this.welcomeTextPanel);
    }
}
