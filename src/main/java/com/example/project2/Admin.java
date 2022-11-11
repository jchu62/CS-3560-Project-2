package com.example.project2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setBounds(360, 120, 640, 480);

        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(null);

        // will wait on implementing tree

        textField.setBounds(300,10,150,25);
        mainPanel.add(textField);

        addUserButton.setBounds(455, 10, 75, 25);
        mainPanel.add(addUserButton);

        addGroupButton.setBounds(535, 10, 75, 25);
        mainPanel.add(addGroupButton);

        openUserButton.setBounds(455, 40, 75, 25);
        mainPanel.add(openUserButton);

        userTotalButton.setBounds(455, 200, 75, 25);
        mainPanel.add(userTotalButton);

        groupTotalButton.setBounds(535,200,75,25);
        mainPanel.add(groupTotalButton);

        userTotalMessageButton.setBounds(455,250, 75,25);
        mainPanel.add(userTotalMessageButton);

        positiveMessagePercentButton.setBounds(535,250,75,25);
        mainPanel.add(positiveMessagePercentButton);
    }
}
