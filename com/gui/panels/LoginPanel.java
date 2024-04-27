package com.gui.panels;

import com.accounts.Account;
import com.constants.FrameDimensions;
import com.gui.main.MainFrame;
import com.gui.main.MainPanel;
import com.gui.main.Renderers;
import com.users.LoginUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel implements FrameDimensions {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginSubmit;

    public LoginPanel(){
        this.setLayout(new GridLayout(3,2,3,10));
        this.setBounds(300,350,500,100);
        this.usernameLabel = new JLabel();
        this.usernameLabel.setText("Username");
        this.usernameLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.usernameField = new JTextField();
        this.passwordLabel = new JLabel();
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Arial",Font.BOLD,23));
        this.passwordField = new JPasswordField();
        this.loginSubmit = new JButton();
        this.loginSubmit.setText("login");
        this.loginSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println(username);
                System.out.println(password);
                Account account = LoginUser.loginUser(username,password);
                usernameField.setText("");
                passwordField.setText("");
                System.out.println(account.getLoginStatus());

                if(account.getLoginStatus()){
                    System.out.println("trying to render dashboard");
                    DashboardPanel dashboardPanel = new DashboardPanel(account);
                    Renderers.addPanels("dashboardPanel",dashboardPanel);
                    MainFrame.getMainPanel().addDashBoardPanel();
                    Renderers.renderOut("loginPanel");
                    Renderers.renderOut("buttonsPanel");
                    Renderers.renderIn("dashboardPanel");
                }

            }
        });
        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(this.loginSubmit);
    }
}
