package com.gui.panels;

import com.constants.FrameDimensions;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements FrameDimensions {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginSubmit;
    public LoginPanel(){
        this.setLayout(new GridLayout(2,2,3,10));
        this.setBounds(300,350,500,50);
        this.usernameLabel = new JLabel();
        this.usernameLabel.setText("Username");
        this.usernameLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.usernameField = new JTextField();
        this.passwordLabel = new JLabel();
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.passwordField = new JPasswordField();
        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
    }
}
