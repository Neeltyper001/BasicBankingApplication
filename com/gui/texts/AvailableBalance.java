package com.gui.texts;

import com.constants.FrameDimensions;

import javax.swing.*;
import java.awt.*;

public class AvailableBalance extends JLabel implements FrameDimensions {

    public AvailableBalance(String availableBalance){
        this.setText("Available balance: "+availableBalance);
        this.setFont(new Font("Arial",Font.BOLD,30));
        this.setForeground(Color.BLACK);
        this.setBounds(300,20,500,40);
    }

    public void setAvailableBalance(String availableBalance){
        this.setText("Available balance: "+availableBalance);
    }
}
