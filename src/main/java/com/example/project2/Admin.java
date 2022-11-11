package com.example.project2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame{

    private JTree tree;
    private JPanel mainPanel;
    private JTextField textField;
    private JButton addUserButton;
    private JButton addGroupButton;
    private JButton openUserButton;
    private JButton userTotalButton;
    private JButton groupTotalButton;
    private JButton userTotalMessageButton;
    private JButton positiveMessagePercentButton;
    private JLabel textLabel;
    private static Admin instance = Admin.getInstance();

    // singleton
    public static Admin getInstance() {
        if (instance == null)
        {
            instance = new Admin();
        }
        return instance;
    }
    private Admin()
    {
        this.setTitle("Admin View");
        tree = new JTree();
        mainPanel = new JPanel();
        textField = new JTextField();
        addUserButton = new JButton();
        addGroupButton = new JButton();
        openUserButton = new JButton();
        userTotalButton = new JButton();
        groupTotalButton = new JButton();
        userTotalMessageButton = new JButton();
        positiveMessagePercentButton = new JButton();
        textLabel = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setBounds(360, 120, 640, 480);

        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(null);

        // will wait on implementing tree

        textField.setBounds(250,10,150,25);
        mainPanel.add(textField);

        addUserButton.setBounds(405, 10, 100, 25);
        addUserButton.setText("Add User");
        addUserButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                System.out.println("Phooey");
            }
        });
        mainPanel.add(addUserButton);

        addGroupButton.setBounds(515, 10, 100, 25);
        addGroupButton.setText("Add Group");
        mainPanel.add(addGroupButton);

        openUserButton.setBounds(405, 40, 100, 25);
        openUserButton.setText("Open User");
        mainPanel.add(openUserButton);

        userTotalButton.setBounds(305, 200, 150, 25);
        userTotalButton.setText("Amount of Users");
        mainPanel.add(userTotalButton);

        groupTotalButton.setBounds(465,200,150,25);
        groupTotalButton.setText("Amount of Groups");
        mainPanel.add(groupTotalButton);

        userTotalMessageButton.setBounds(305,250, 150,25);
        userTotalMessageButton.setText("Total Messages");
        mainPanel.add(userTotalMessageButton);

        positiveMessagePercentButton.setBounds(465,250,150,25);
        positiveMessagePercentButton.setText("Positive Percentage");
        mainPanel.add(positiveMessagePercentButton);

        textLabel.setBounds(445, 300, 50, 25);
        textLabel.setText("Test");
        mainPanel.add(textLabel);
    }
}
