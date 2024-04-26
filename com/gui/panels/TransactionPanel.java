package com.gui.panels;

import com.constants.FrameDimensions;
import com.gui.main.MainFrame;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class TransactionPanel extends JPanel implements FrameDimensions {
    private static JLabel accountNoLabel;
    private static JTextField accountNoField;
    private static JLabel amountLabel;
    private static JTextField amountField;
    private static JPasswordField pinNoField;
    private static JButton transactionButton;
    public TransactionPanel(String transactionType){
        setLayout(new GridLayout(3,2,10,10));
        this.setBounds(250,170,500,100);
        this.setBackground(Color.WHITE);
        TransactionPanel.accountNoLabel = new JLabel();
        TransactionPanel.accountNoLabel.setText("Account No. ");
        TransactionPanel.accountNoField = new JTextField();
        try{
            TransactionPanel.accountNoField = new JFormattedTextField(new MaskFormatter("#########"));
        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(MainFrame.getMainPanel(),e.getMessage());
        }
        TransactionPanel.amountLabel = new JLabel();
        TransactionPanel.amountLabel.setText("Amount ");
        TransactionPanel.amountField = new JTextField();
        TransactionPanel.pinNoField = new JPasswordField();
        TransactionPanel.transactionButton = new JButton();
        TransactionPanel.transactionButton.setText(transactionType);
        TransactionPanel.transactionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("transaction panel");
                int option = JOptionPane.showConfirmDialog(null, pinNoField, "Please enter your PIN:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    // Get the entered PIN
                    char[] pinChars = pinNoField.getPassword();
                    String pin = new String(pinChars);

                    System.out.println("Entered PIN: " + pin);
                } else {

                    System.out.println("No PIN entered.");
                }
            }
        });
        this.add(accountNoLabel);
        this.add(accountNoField);
        this.add(amountLabel);
        this.add(amountField);
        this.add(transactionButton);
        this.setVisible(false);
    }

}
