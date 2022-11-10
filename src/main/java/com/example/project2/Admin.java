package com.example.project2;

import java.util.List;
import java.util.UUID;
public class Admin
{
    private List<User> userList;
    private List<UserGroup> userGroupList;
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
    public void createUser(String name)
    {
        userList.add(new User(UUID.randomUUID(), name));
    }
}
