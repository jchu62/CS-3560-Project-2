package com.example.project2;

import javax.swing.*;

public class Admin extends JFrame{

    private JPanel treePanel;
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

    public static Admin getInstance() {
        if (instance == null)
        {
            instance = new Admin();
        }
        return instance;
    }
    private Admin()
    {
        treePanel = new JPanel();
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

    }
}
