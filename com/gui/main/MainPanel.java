package com.gui.main;

import com.constants.FrameDimensions;
import com.eventListeners.RenderOps;
import com.gui.panels.ButtonsPanel;
import com.gui.panels.LoginPanel;
import com.gui.panels.WelcomeTextPanel;

import javax.swing.*;

public class MainPanel extends JPanel implements FrameDimensions {
    private Renderers renderers;
    private WelcomeTextPanel welcomeTextPanel;
    private LoginPanel loginPanel;
    private ButtonsPanel buttonsPanel;
    private RenderOps renderOps;
    public MainPanel(){
        setLayout(null);
        this.renderers = new Renderers();
        this.renderOps = new RenderOps();
        this.welcomeTextPanel = new WelcomeTextPanel();
        this.loginPanel = new LoginPanel();
        this.buttonsPanel = new ButtonsPanel();
        this.add(this.welcomeTextPanel);
        this.add(this.loginPanel);
        this.add(this.buttonsPanel);
        this.renderers.addPanels("welcomeTextPanel",welcomeTextPanel);

    }
}
