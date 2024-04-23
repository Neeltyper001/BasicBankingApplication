package com.gui.texts;

import javax.swing.*;
import java.awt.*;

public class WelcomeText extends JLabel {
    public WelcomeText(String text){
        this.setText(text);
        this.setFont(new Font("Aerial", Font.BOLD,33));
        this.setForeground(Color.red);
    }
}
