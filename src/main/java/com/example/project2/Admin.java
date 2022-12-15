package com.example.project2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Enumeration;

public class Admin extends JFrame{

    private JTree tree;
    private JPanel mainPanel;
    private JTextField textField;
    private JButton addUserButton;
    private JButton addGroupButton;
    private JButton openUserButton;
    private JButton getUserUUIDButton;
    private JButton verifyUUIDButton;
    private JButton getLastUpdatedUser;
    private JButton userTotalButton;
    private JButton groupTotalButton;
    private JButton userTotalMessageButton;
    private JButton positiveMessagePercentButton;
    private JLabel textLabel;
    private int totalUsers = 0;
    private int totalGroups = 1;
    private List<User> userList = new ArrayList<>();
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
        mainPanel = new JPanel();
        textField = new JTextField();
        addUserButton = new JButton();
        addGroupButton = new JButton();
        openUserButton = new JButton();
        getUserUUIDButton = new JButton();
        verifyUUIDButton = new JButton();
        getLastUpdatedUser = new JButton();
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

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new UserGroup("Root", System.currentTimeMillis()));
        tree = new JTree(root);
        tree.setModel(new DefaultTreeModel(root));
        DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
        tree.setBounds(10, 10, 220, 480);
        mainPanel.add(tree);

        textField.setBounds(250,10,150,25);
        mainPanel.add(textField);

        addUserButton.setBounds(405, 10, 100, 25);
        addUserButton.setText("Add User");
        addUserButton.addActionListener(a -> {
            if (!textField.getText().equals(""))
            {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new User(UUID.randomUUID(), textField.getText(), System.currentTimeMillis()));
                if (selectedNode != null && (!(selectedNode.getUserObject() instanceof User)))
                {
                treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                userList.add((User) newNode.getUserObject());
                totalUsers++;
                }
                else
                {
                    textLabel.setText("Please select a valid user.");
                }
            }
            else
            {
                textLabel.setText("Please enter a valid name.");
            }
            textField.setText("");
        });
        mainPanel.add(addUserButton);

        addGroupButton.setBounds(515, 10, 100, 25);
        addGroupButton.setText("Add Group");
        addGroupButton.addActionListener(a ->
        {
            if (!textField.getText().equals(""))
            {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new UserGroup(textField.getText(), System.currentTimeMillis()));
                if (selectedNode != null )
                {
                    treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                    totalGroups++;
                }
                else
                {
                    textLabel.setText("Please select a valid group.");
                }
            }
            else
            {
                textLabel.setText("Please enter a valid name.");
            }
            textField.setText("");
        });
        mainPanel.add(addGroupButton);

        openUserButton.setBounds(405, 40, 100, 25);
        openUserButton.setText("Open User");
        openUserButton.addActionListener(a -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && ((selectedNode.getUserObject() instanceof User))) {
                User selectedUser = (User) selectedNode.getUserObject();
                new UserGUI(selectedUser);
                textLabel.setText(("Time created is " + selectedUser.getCreationTime()));
            }
            else
            {
                textLabel.setText("Please select a valid user.");
            }
        });
        mainPanel.add(openUserButton);

        getUserUUIDButton.setBounds(515, 40, 100, 25);
        getUserUUIDButton.setText("Get User ID");
        getUserUUIDButton.addActionListener(a -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && ((selectedNode.getUserObject() instanceof User))) {
                User selectedUser = (User) selectedNode.getUserObject();
                System.out.println(selectedUser.getID());
            }
            else
            {
                textLabel.setText("Please select a valid user.");
            }
        });
        mainPanel.add(getUserUUIDButton);

        verifyUUIDButton.setBounds(405, 70, 100, 25);
        verifyUUIDButton.setText("Verify ID");
        verifyUUIDButton.addActionListener(a -> {

                });
        mainPanel.add(verifyUUIDButton);

        getLastUpdatedUser.setBounds(515, 70, 100, 25);
        getLastUpdatedUser.setText("Get Last Updated User");
        getLastUpdatedUser.addActionListener(a ->
        {

        });
        mainPanel.add(getLastUpdatedUser);

        userTotalButton.setBounds(305, 200, 150, 25);
        userTotalButton.setText("Amount of Users");
        userTotalButton.addActionListener(a -> {
            textLabel.setText("Total Users = " + totalUsers);
        });
        mainPanel.add(userTotalButton);

        groupTotalButton.setBounds(465,200,150,25);
        groupTotalButton.setText("Amount of Groups");
        groupTotalButton.addActionListener(a -> {
            textLabel.setText("Total Groups = " + totalGroups);
        });
        mainPanel.add(groupTotalButton);

        userTotalMessageButton.setBounds(305,250, 150,25);
        userTotalMessageButton.setText("Total Messages");
        userTotalMessageButton.addActionListener(a -> {
            UserVisitorCountMessage visitor = new UserVisitorCountMessage();
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
            for (Enumeration enumeration = treeNode.depthFirstEnumeration(); enumeration.hasMoreElements();)
            {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
                if (node.getUserObject() instanceof User){
                User selectedUser = (User)node.getUserObject();
                selectedUser.accept(visitor);
            }

            }
            textLabel.setText("Total Messages = " + visitor.getTotalMessages());
                });
        mainPanel.add(userTotalMessageButton);

        positiveMessagePercentButton.setBounds(465,250,150,25);
        positiveMessagePercentButton.setText("Positive Percentage");
        positiveMessagePercentButton.addActionListener(a -> {
            UserVisitorCountMessage visitor = new UserVisitorCountMessage();
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
            for (Enumeration enumeration = treeNode.depthFirstEnumeration(); enumeration.hasMoreElements();)
            {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
                if (node.getUserObject() instanceof User) {
                    User selectedUser = (User) node.getUserObject();
                    selectedUser.accept(visitor);
                }
            }
            textLabel.setText("Positive Message % = " + (visitor.getPositiveMessages() * 100.0/visitor.getTotalMessages()));
        });
        mainPanel.add(positiveMessagePercentButton);

        textLabel.setBounds(345, 300, 200, 25);
        textLabel.setText("Test");
        mainPanel.add(textLabel);
    }

    public List<User> getUserList()
    {
        return userList;
    }
}
