package com.gui.buttons;

import com.gui.main.Renderers;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToRegister extends JButton {

    public ToRegister(String buttonText){
        this.setText(buttonText);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Renderers.renderOut("loginPanel");
                Renderers.renderIn("registerPanel");
            }
        });
    }
}
