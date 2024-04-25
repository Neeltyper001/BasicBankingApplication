package com.gui.panels;

import com.constants.FrameDimensions;
import com.gui.main.MainFrame;
import com.users.RegisterUser;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class RegisterPanel extends JPanel implements FrameDimensions {
    private JLabel fullnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel accountNoLabel;
    private JLabel pinLabel;
    private JTextField fullnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JFormattedTextField accountNoField;
    private JPasswordField pinField;
    private JButton registerSubmit;

    public RegisterPanel(){
        this.setLayout(new GridLayout(6,2,3,10));
        this.setBounds(300,350,500,180);
        // fullname labels
        this.fullnameLabel = new JLabel();
        this.fullnameLabel.setText("Fullname");
        this.fullnameLabel.setFont(new Font("Arial",Font.BOLD,23));

        // username labels
        this.usernameLabel = new JLabel();
        this.usernameLabel.setText("Username");
        this.usernameLabel.setFont(new Font("Arial",Font.BOLD,23));

        // password labels
        this.passwordLabel = new JLabel();
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Arial",Font.BOLD,23));

        // accountNo labels
        this.accountNoLabel = new JLabel();
        this.accountNoLabel = new JLabel("Account no.(9 max)");
        this.accountNoLabel.setFont(new Font("Arial",Font.BOLD,23));

        // pin labels
        this.pinLabel = new JLabel();
        this.pinLabel = new JLabel("Pin");
        this.pinLabel.setFont(new Font("Arial",Font.BOLD,23));

        // text fields and password fields
        this.fullnameField = new JTextField();
        this.usernameField = new JTextField();
        this.passwordField = new JPasswordField();
        try{
            this.accountNoField = new JFormattedTextField(new MaskFormatter("#########"));
        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(MainFrame.getMainPanel(),e.getMessage());
        }
        this.pinField = new JPasswordField();

        this.registerSubmit = new JButton();
        this.registerSubmit.setText("Register");
        this.registerSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fullname = fullnameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String accountNo = accountNoField.getText();
                String pin = new String(pinField.getPassword());
                if(pin.length() != 4 || accountNo.length() != 9){
                    JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Pin should be of 4 and account no should be of 9");
                    return;
                }
                System.out.println(fullname);
                System.out.println(username);
                System.out.println(password);
                System.out.println(accountNo);
                System.out.println(pin);
                RegisterUser.registeUser(fullname,username,password,accountNo,pin);
                fullnameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                accountNoField.setText("");
                pinField.setText("");
            }
        });
        this.add(this.fullnameLabel);
        this.add(this.fullnameField);
        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(this.accountNoLabel);
        this.add(this.accountNoField);
        this.add(this.pinLabel);
        this.add(this.pinField);
        this.add(this.registerSubmit);
        this.setVisible(false);
    }
}
