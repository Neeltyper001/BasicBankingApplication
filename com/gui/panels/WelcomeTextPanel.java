package com.gui.panels;

import com.constants.FrameDimensions;
import com.gui.texts.WelcomeText;

import javax.swing.*;
import java.awt.*;

public class WelcomeTextPanel extends JPanel implements FrameDimensions {
    private WelcomeText welcomeText;
    public WelcomeTextPanel(){
        setLayout(null);
        welcomeText = new WelcomeText("Welcome to our banking system ");
        this.setBackground(Color.ORANGE);
        this.setBounds(0,0,FRAME_WIDTH,250);
        this.add(welcomeText);
    }

}
