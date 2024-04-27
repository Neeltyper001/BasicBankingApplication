package com.gui.panels;

import com.accounts.Account;
import com.constants.FrameDimensions;
import com.gui.main.MainFrame;
import com.gui.main.MainPanel;
import com.gui.main.Renderers;
import com.users.LoginUser;
import org.mindrot.jbcrypt.BCrypt;

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
    private JLabel loginLabel;
    private JLabel sectionLabel;
    public LoginPanel(){
        this.setLayout(new GridLayout(4,2,3,10));
        this.setBounds(300,350,500,120);
        this.usernameLabel = new JLabel();
        this.usernameLabel.setText("Username");
        this.usernameLabel.setFont(new Font("Arial",Font.BOLD,16));

        this.loginLabel = new JLabel();
        this.loginLabel.setText("Login");
        this.loginLabel.setFont(new Font("Arial",Font.BOLD,21));
        this.loginLabel.setForeground(Color.red);

        this.sectionLabel = new JLabel();
        this.sectionLabel.setText("Section");
        this.sectionLabel.setFont(new Font("Arial",Font.BOLD,21));
        this.sectionLabel.setForeground(Color.red);

        this.usernameField = new JTextField();
        this.passwordLabel = new JLabel();
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Arial",Font.BOLD,16));
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
                    DashboardPanel dashboardPanel = new DashboardPanel(account,username);
                    Renderers.addPanels("dashboardPanel",dashboardPanel);
                    MainFrame.getMainPanel().addDashBoardPanel();
                    Renderers.renderOut("loginPanel");
                    Renderers.renderOut("buttonsPanel");
                    Renderers.renderIn("dashboardPanel");
                }

            }
        });
        this.add(this.loginLabel);
        this.add(this.sectionLabel);
        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(this.loginSubmit);
    }
}
