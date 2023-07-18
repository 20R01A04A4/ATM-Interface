import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atm extends JFrame {
    private int balance;
    private JLabel balanceLabel;

    public Atm() {
        setTitle("Banking Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");

        balanceLabel = new JLabel("Your current balance is: " + balance);
        balanceLabel.setHorizontalAlignment(JLabel.CENTER);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(null, "Enter deposit amount:");
                if (amountStr != null) {
                    try {
                        int amount = Integer.parseInt(amountStr);
                        deposit(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid amount.");
                    }
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(null, "Enter withdrawal amount:");
                if (amountStr != null) {
                    try {
                        int amount = Integer.parseInt(amountStr);
                        withdraw(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid amount.");
                    }
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for banking with us!");
                System.exit(0);
            }
        });

        add(depositButton);
        add(withdrawButton);
        add(balanceButton);
        add(exitButton);
    }

    public void deposit(int amount) {
        balance += amount;
        JOptionPane.showMessageDialog(null, amount + " deposited successfully!");
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient balance!");
        } else {
            balance -= amount;
            JOptionPane.showMessageDialog(null, amount + " withdrawn successfully!\nPlease collect your cash.");
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Your current balance is: " + balance);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Atm().setVisible(true);
            }
        });
    }
}