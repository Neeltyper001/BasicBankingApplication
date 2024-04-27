package com.gui.panels;

import com.accounts.Account;
import com.constants.FrameDimensions;
import com.gui.main.MainFrame;
import com.gui.main.Renderers;
import com.gui.texts.AvailableBalance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardPanel extends JPanel implements FrameDimensions {

    private static AvailableBalance availableBalance;
    private JButton debit;
    private JButton credit;
    private JButton transfer;
    private JButton logOut;
    private JButton updatePassword;
    private JButton updatePin;
    private TransactionPanel debitPanel;
    private TransactionPanel creditPanel;
    private TransferPanel transferPanel;
    private UpdatePanel updatePasswordPanel;
    private UpdatePanel updatePinPanel;

    public DashboardPanel(Account account,String username){
        this.setLayout(null);
        setBounds(0,250,FRAME_WIDTH,450);
        this.setBackground(Color.WHITE);
        this.availableBalance = new AvailableBalance(account.getAmount()+"");

        this.debit = new JButton();
        this.debit.setText("withdraw");
        this.debit.setBounds(150,100,100,40);

        this.credit = new JButton();
        this.credit.setText("deposit");
        this.credit.setBounds(300,100,100,40);

        this.transfer = new JButton();
        this.transfer.setText("Transfer");
        this.transfer.setBounds(450,100,100,40);

        this.updatePassword = new JButton();
        this.updatePassword.setText("Update Password");
        this.updatePassword.setBounds(600,100,150,40);

        this.updatePin = new JButton();
        this.updatePin.setText("Update Pin");
        this.updatePin.setBounds(800,100,100,40);

        this.logOut = new JButton();
        this.logOut.setText("Log out");
        this.logOut.setBounds(450,300,100,40);

        this.debitPanel = new TransactionPanel("debit",account);
        this.creditPanel = new TransactionPanel("credit",account);
        this.transferPanel = new TransferPanel(account);
        this.updatePasswordPanel = new UpdatePanel(account,"New Password","Update Password" ,username);
        this.updatePinPanel = new UpdatePanel(account,"New Pin","Update Pin",username);


        this.add(debitPanel);
        this.add(creditPanel);
        this.add(transferPanel);
        this.add(updatePasswordPanel);
        this.add(updatePinPanel);

        Renderers.addPanels("debitPanel",debitPanel);
        Renderers.addPanels("creditPanel",creditPanel);
        Renderers.addPanels("transferPanel",transferPanel);
        Renderers.addPanels("updatePasswordPanel",updatePasswordPanel);
        Renderers.addPanels("updatePinPanel",updatePinPanel);

        this.debit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("debit clicked");
                Renderers.renderOut("updatePasswordPanel");
                Renderers.renderOut("updatePinPanel");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("transferPanel");
                Renderers.renderIn("debitPanel");
            }
        });

        this.credit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("credit clicked");
                Renderers.renderOut("updatePasswordPanel");
                Renderers.renderOut("updatePinPanel");
                Renderers.renderOut("transferPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderIn("creditPanel");
            }
        });

        this.transfer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("credit clicked");
                Renderers.renderOut("updatePasswordPanel");
                Renderers.renderOut("updatePinPanel");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderIn("transferPanel");
            }
        });

        this.updatePassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("updatePasswordPanel clicked");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderOut("transferPanel");
                Renderers.renderOut("updatePinPanel");
                Renderers.renderIn("updatePasswordPanel");

            }
        });

        this.updatePin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("updatePinPanel clicked");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderOut("transferPanel");
                Renderers.renderOut("updatePasswordPanel");
                Renderers.renderIn("updatePinPanel");

            }
        });

        this.logOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Logout clicked");
                Renderers.renderOut("dashboardPanel");
                Renderers.renderIn("loginPanel");
                Renderers.renderIn("buttonsPanel");
                Renderers.removePanels("dashBoardPanel");
                MainFrame.getMainPanel().removeDashboardPanel();
            }
        });

        this.add(availableBalance);
        this.add(this.debit);
        this.add(this.credit);
        this.add(this.transfer);
        this.add(this.updatePassword);
        this.add(this.updatePin);
        this.add(this.logOut);
        this.setVisible(false);
    }

    public static AvailableBalance getAvailableBalance(){
        return DashboardPanel.availableBalance;
    }
}
