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
//        setBounds(360, 120, 640, 480);
//
//        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setSize(640, 480);
        mainPanel.setLayout(null);

        // will wait on implementing tree

        textField.setBounds(40,40,100,50);
        mainPanel.add(textField);

        addUserButton.setBounds(500, 50, 200, 200);
        mainPanel.add(addUserButton);

        addGroupButton.setBounds(500, 60, 200, 200);
        mainPanel.add(addGroupButton);

        openUserButton.setBounds(300, 300, 200, 200);
        mainPanel.add(openUserButton);

        userTotalButton.setBounds(200, 200, 100, 100);
        mainPanel.add(userTotalButton);

        groupTotalButton.setBounds(10,10,30,30);
        mainPanel.add(groupTotalButton);

        userTotalMessageButton.setBounds(40,40, 40,40);
        mainPanel.add(userTotalMessageButton);

        positiveMessagePercentButton.setBounds(4,4,4,4);
        mainPanel.add(positiveMessagePercentButton);
    }
}
