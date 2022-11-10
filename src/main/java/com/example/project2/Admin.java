package com.example.project2;

public class Admin
{
    private static Admin instance = new Admin();

    private Admin(){}

    public static Admin getInstance()
    {
        return instance;
    }

}
