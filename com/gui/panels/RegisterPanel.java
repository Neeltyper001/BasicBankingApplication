package com.gui.panels;

import com.constants.FrameDimensions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterPanel extends JPanel implements FrameDimensions {
    private JLabel fullnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField fullnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerSubmit;

    public RegisterPanel(){
        this.setLayout(new GridLayout(4,2,3,10));
        this.setBounds(300,350,500,120);
        this.fullnameLabel = new JLabel();
        this.fullnameLabel.setText("Fullname");
        this.fullnameLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.usernameLabel = new JLabel();
        this.usernameLabel.setText("Username");
        this.usernameLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.fullnameField = new JTextField();
        this.usernameField = new JTextField();
        this.passwordLabel = new JLabel();
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.passwordField = new JPasswordField();
        this.registerSubmit = new JButton();
        this.registerSubmit.setText("Register");
        this.registerSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fullname = fullnameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println(fullname);
                System.out.println(username);
                System.out.println(password);
            }
        });
        this.add(this.fullnameLabel);
        this.add(this.fullnameField);
        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(this.registerSubmit);
        this.setVisible(false);
    }
}
