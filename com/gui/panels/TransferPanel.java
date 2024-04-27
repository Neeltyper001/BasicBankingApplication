package com.gui.panels;

import com.accounts.Account;
import com.accounts.CheckPin;
import com.constants.FrameDimensions;
import com.gui.main.MainFrame;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class TransferPanel extends JPanel implements FrameDimensions {

    private  JLabel receipentsAccountNoLabel;
    private  JTextField receipentsAccountNoField;
    private  JLabel amountLabel;
    private  JTextField amountField;
    private  JPasswordField pinNoField;
    private  JButton transactionButton;
    public TransferPanel(Account account){
        setLayout(new GridLayout(3,2,0,5));
        this.setBounds(250,170,500,100);
        this.setBackground(Color.white);

        this.receipentsAccountNoLabel = new JLabel();
        this.receipentsAccountNoLabel.setText("Receipent's Account No.");
        try{
            this.receipentsAccountNoField = new JFormattedTextField(new MaskFormatter("#########"));
        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(MainFrame.getMainPanel(),e.getMessage());
        }
        this.amountLabel = new JLabel();
        this.amountLabel.setText("Amount ");
        this.amountField = new JTextField();
        this.pinNoField = new JPasswordField();
        this.transactionButton = new JButton();
        this.transactionButton.setText("Send amount");
        this.transactionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("transfer panel");
                int option = JOptionPane.showConfirmDialog(null, pinNoField, "Please enter your PIN:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    // Get the entered PIN
                    char[] pinChars = pinNoField.getPassword();
                    String pinNo = new String(pinChars);
                    System.out.println("Entered PIN: " + pinNo);
                    boolean isValidPin = CheckPin.CheckPin(account , pinNo);
                    if(isValidPin){
                        boolean transactionStatus = account.transferAmount(amountField.getText(),receipentsAccountNoField.getText());
                        if(transactionStatus){
                            DashboardPanel.getAvailableBalance().setAvailableBalance(account.getAmount()+"");
                        }
                    }
                   else{
                       JOptionPane.showMessageDialog(MainFrame.getMainPanel(),"Invalid pin");
                    }


                } else {

                    System.out.println("No PIN entered.");
                }
            }
        });
        this.add(receipentsAccountNoLabel);
        this.add(receipentsAccountNoField);
        this.add(amountLabel);
        this.add(amountField);
        this.add(transactionButton);
        this.setVisible(false);
    }
}
