package com.gui.panels;

import com.constants.FrameDimensions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransferPanel extends JPanel implements FrameDimensions {
    private static JLabel accountNoLabel;
    private static JTextField accountNoField;
    private static JLabel receipentsAccountNoLabel;
    private static JTextField receipentsAccountNoField;
    private static JLabel amountLabel;
    private static JTextField amountField;
    private static JPasswordField pinNoField;
    private static JButton transactionButton;
    public TransferPanel(){
        setLayout(new GridLayout(4,2,0,5));
        this.setBounds(250,170,500,100);
        this.setBackground(Color.white);
        TransferPanel.accountNoLabel = new JLabel();
        TransferPanel.accountNoLabel.setText("Account No. ");
        TransferPanel.accountNoField = new JTextField();
        TransferPanel.receipentsAccountNoLabel = new JLabel();
        TransferPanel.receipentsAccountNoLabel.setText("Receipent's Account No.");
        TransferPanel.receipentsAccountNoField = new JTextField();
        TransferPanel.amountLabel = new JLabel();
        TransferPanel.amountLabel.setText("Amount ");
        TransferPanel.amountField = new JTextField();
        TransferPanel.pinNoField = new JPasswordField();
        TransferPanel.transactionButton = new JButton();
        TransferPanel.transactionButton.setText("Send amount");
        TransferPanel.transactionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("transfer panel");
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
        this.add(receipentsAccountNoLabel);
        this.add(receipentsAccountNoField);
        this.add(amountLabel);
        this.add(amountField);
        this.add(transactionButton);
        this.setVisible(false);
    }
}
