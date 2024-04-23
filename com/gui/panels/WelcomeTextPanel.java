package com.gui.panels;

import com.gui.texts.WelcomeText;

import javax.swing.*;
import java.awt.*;

public class WelcomeTextPanel extends JPanel {
    private WelcomeText welcomeText;
    public WelcomeTextPanel(){
        setLayout(null);
        welcomeText = new WelcomeText("Welcome");
        this.setBackground(Color.ORANGE);
        this.add(welcomeText);
    }
}
