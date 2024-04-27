package com.gui.texts;

import com.constants.FrameDimensions;

import javax.swing.*;
import java.awt.*;

public class WelcomeText extends JLabel implements FrameDimensions {
    public WelcomeText(String text){
        this.setBounds(250, 100,FRAME_WIDTH,50);
        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD,33));
        this.setForeground(Color.red);
    }


}
