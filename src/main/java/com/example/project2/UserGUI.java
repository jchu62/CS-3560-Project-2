package com.example.project2;

import javax.swing.*;

public class UserGUI extends JFrame
{
    private User user;
    private JPanel mainPanel;
    private JButton followUserButton;
    private JButton postMessageButton;
    private JTextField userIDTextField;
    private JTextField textMessageTextField;
    private JList followerList;
    private JList messageList;
    private JLabel label;

    public UserGUI(User user)
    {
        this.user = user;
        this.setTitle("User " + this.user.toString() + " View");
        mainPanel = new JPanel();
        followUserButton = new JButton();
        postMessageButton = new JButton();
        userIDTextField = new JTextField();
        textMessageTextField = new JTextField();
        followerList = new JList();
        messageList = new JList();
        label = new JLabel();

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
        followUserButton.addActionListener(a -> {
            for(User otherUsers : Admin.getInstance().getUserList())
            {
                if (otherUsers.verifyID(userIDTextField.getText()))
                {
                    this.user.follow(otherUsers);
                }
            }
            followerList.setListData(this.user.getFollowerList());
            userIDTextField.setText("");
                });
        mainPanel.add(followUserButton);

        followerList.setBounds(10, 60, 330, 100);
        followerList.setListData(this.user.getFollowerList());
        mainPanel.add(followerList);

        textMessageTextField.setBounds(10, 170, 200, 20);
        mainPanel.add(textMessageTextField);

        postMessageButton.setBounds(225, 170, 115, 40);
        postMessageButton.setText("Send Message");
        postMessageButton.addActionListener(a -> {
            this.user.sendMessage(textMessageTextField.getText());
            messageList.setListData(this.user.getMessageList());
            textMessageTextField.setText("");
                });
        mainPanel.add(postMessageButton);

        label.setBounds(10, 190, 200, 20);
        label.setText("Welcome " + this.user.toString());
        mainPanel.add(label);

        messageList.setBounds(10, 220, 330, 200);
        messageList.setListData(this.user.getMessageList());
        mainPanel.add(messageList);

    }
}
