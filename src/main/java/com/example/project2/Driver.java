package com.example.project2;

public class Driver
{
    public static void main(String args[])
    {
        Admin panel = Admin.getInstance();
        panel.setResizable(false);
        panel.setVisible(true);
    }
}
