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
    private static JButton debit;
    private static JButton credit;
    private static JButton transfer;
    private static JButton logOut;
    private static TransactionPanel debitPanel;
    private static TransactionPanel creditPanel;
    private static TransferPanel transferPanel;

    public DashboardPanel(Account account){
        this.setLayout(null);
        setBounds(0,250,FRAME_WIDTH,450);
        this.setBackground(Color.WHITE);
        DashboardPanel.availableBalance = new AvailableBalance(account.getAmount()+"");
        DashboardPanel.debit = new JButton();
        DashboardPanel.debit.setText("witdraw");
        DashboardPanel.debit.setBounds(300,100,100,40);
        DashboardPanel.credit = new JButton();
        DashboardPanel.credit.setText("deposit");
        DashboardPanel.credit.setBounds(450,100,100,40);
        DashboardPanel.transfer = new JButton();
        DashboardPanel.transfer.setText("Transfer");
        DashboardPanel.transfer.setBounds(600,100,100,40);
        DashboardPanel.logOut = new JButton();
        DashboardPanel.logOut.setText("Log out");
        DashboardPanel.logOut.setBounds(450,300,100,40);
        DashboardPanel.debitPanel = new TransactionPanel("debit",account);
        DashboardPanel.creditPanel = new TransactionPanel("credit",account);
        DashboardPanel.transferPanel = new TransferPanel(account);
        this.add(debitPanel);
        this.add(creditPanel);
        this.add(transferPanel);
        Renderers.addPanels("debitPanel",debitPanel);
        Renderers.addPanels("creditPanel",creditPanel);
        Renderers.addPanels("transferPanel",transferPanel);

        this.debit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("debit clicked");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("transferPanel");
                Renderers.renderIn("debitPanel");
            }
        });

        this.credit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("credit clicked");
                Renderers.renderOut("transferPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderIn("creditPanel");
            }
        });

        this.transfer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("credit clicked");
                Renderers.renderOut("creditPanel");
                Renderers.renderOut("debitPanel");
                Renderers.renderIn("transferPanel");
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
        this.add(this.logOut);
        this.setVisible(false);
    }

    public static AvailableBalance getAvailableBalance(){
        return DashboardPanel.availableBalance;
    }
}
