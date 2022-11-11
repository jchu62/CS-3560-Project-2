package com.example.project2;

public class Driver
{
    public static void main(String args[])
    {
        Admin admin = Admin.getInstance();
        admin.setResizable(true);
        admin.setVisible(true);
    }
}
