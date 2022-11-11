package com.example.project2;

import javax.swing.*;

public class UserGUI extends JFrame
{
    private JPanel mainPanel;
    private JButton followUserButton;
    private JButton postTweetButton;
    private JTextField userIDTextField;
    private JTextField textMessageTextField;
    private JList followerList;
    private JList messageList;

    public UserGUI()
    {
        this.setTitle("User View");
        mainPanel = new JPanel();
        followUserButton = new JButton();
        postTweetButton = new JButton();
        userIDTextField = new JTextField();
        textMessageTextField = new JTextField();
        followerList = new JList();
        messageList = new JList();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        setBounds(480, 120, 360, 480);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        userIDTextField.setBounds(10, 10, 150, 20);
        mainPanel.add(userIDTextField);
    }
}
