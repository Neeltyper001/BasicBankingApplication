package com.gui.panels;

import com.accounts.Account;
import com.constants.FrameDimensions;
import com.users.UpdateUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdatePanel extends JPanel implements FrameDimensions {

    private JLabel newUpdateFieldLabel;
    private JPasswordField passwordField;
    private JButton update;

    public UpdatePanel(Account account,String panelType,String buttonName,String username){
        setLayout(new GridLayout(2,2,6,10));
        this.setBounds(370,170,300,50);
        this.setBackground(Color.white);

        this.newUpdateFieldLabel = new JLabel();
        this.newUpdateFieldLabel.setText(panelType);
        this.newUpdateFieldLabel.setFont(new Font("Arial",Font.BOLD,15));

        this.passwordField = new JPasswordField();
        this.update = new JButton();
        this.update.setText(buttonName);

        this.update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(panelType+"Clicked");
                char[] pass = passwordField.getPassword();
                String password = new String(pass);
                switch(panelType){
                    case "New Password":
                        UpdateUser.updatePassword(password,username);break;
                    case "New Pin":
                        UpdateUser.updatePin(password,account.getAccountNum());break;
                    default:
                        System.out.println("default case");
                }
            }
        });

        this.add(newUpdateFieldLabel);
        this.add(passwordField);
        this.add(update);
        this.setVisible(false);
    }
}
