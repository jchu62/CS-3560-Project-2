package com.example.project2;

public class Admin
{
    private static Admin instance = new Admin();

    private Admin(){}

    // lazy initialization
    public static Admin getInstance() {
        if (instance == null)
        {
            instance = new Admin();
        }
        return instance;
    }

}
