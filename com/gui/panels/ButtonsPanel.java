package com.gui.panels;

import com.constants.FrameDimensions;
import com.gui.buttons.ToLogin;
import com.gui.buttons.ToRegister;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel implements FrameDimensions {
    private ToLogin toLogin;
    private ToRegister toRegister;
    public ButtonsPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.toLogin = new ToLogin("To Login");
        this.toRegister = new ToRegister("To Register");
        this.setBounds(0,550,FRAME_WIDTH,100);
        this.add(toLogin);
        this.add(toRegister);
    }
}
