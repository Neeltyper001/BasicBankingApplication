package com.gui.buttons;

import com.eventListeners.RenderOps;
import com.gui.main.MainPanel;
import com.gui.main.Renderers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToLogin extends JButton {
    public ToLogin(String buttonText){
        this.setText(buttonText);
        RenderOps.addButtons("login",this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Renderers.renderOut("registerPanel");
                Renderers.renderIn("loginPanel");
            }
        });
    }
}
