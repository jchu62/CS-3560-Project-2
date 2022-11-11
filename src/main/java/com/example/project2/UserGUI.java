package com.example.project2;

import javax.swing.*;

public class UserGUI extends JFrame
{
    private JPanel mainPanel;
    private JButton followUserButton;
    private JButton postMessageButton;
    private JTextField userIDTextField;
    private JTextField textMessageTextField;
    private JList followerList;
    private JList messageList;

    public UserGUI()
    {
        this.setTitle("User View");
        mainPanel = new JPanel();
        followUserButton = new JButton();
        postMessageButton = new JButton();
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

        userIDTextField.setBounds(10, 10, 200, 20);
        mainPanel.add(userIDTextField);

        followUserButton.setBounds(225, 10, 115, 40);
        followUserButton.setText("Follow User");
        mainPanel.add(followUserButton);

        followerList.setBounds(10, 60, 330, 100);
        mainPanel.add(followerList);

        textMessageTextField.setBounds(10, 170, 200, 20);
        mainPanel.add(textMessageTextField);

        postMessageButton.setBounds(225, 170, 115, 40);
        postMessageButton.setText("Send Message");
        mainPanel.add(postMessageButton);

        messageList.setBounds(10, 220, 330, 200);
        mainPanel.add(messageList);

    }
}
