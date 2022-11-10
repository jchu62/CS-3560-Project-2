package com.example.project2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JButton;

public class Admin{

    private JPanel mainPane;
    private static Admin instance = Admin.getInstance();
    private JTree tree;
    private Admin(){}

    public static Admin getInstance() {
        if (instance == null)
        {
            instance = new Admin();
        }
        return instance;
    }
}
