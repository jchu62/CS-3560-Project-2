package com.example.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements UserElement{
    private UUID uuid;
    private String name;
    private List<User> currentFollowers;
    private List<User> currentlyFollowing;
    private List<String> messageList;

    public User(UUID uuid, String name)
    {
        this.uuid = uuid;
        this.name = name;
        currentFollowers = new ArrayList<User>();
        currentlyFollowing = new ArrayList<User>();
        currentFollowers.add(this);
        currentlyFollowing.add(this);
    }

    public void addFollowing(User user)
    {
        if (!currentlyFollowing.contains(user))
        {
            currentlyFollowing.add(user);
        }
    }
    public void addFollower(User user)
    {
        currentFollowers.add(user);
    }

    public List<String> getMessageList()
    {
        return messageList;
    }
        public void sendMessage(String message)
    {
        messageList.add(message);
        notifyObservers();
    }
    @Override
    public void accept(UserVisitor userVisitor)
    {
        userVisitor.visit(this);
    }
        public void notifyObservers()
    {
    }
    @Override
    public String toString()
    {
        return this.uuid.toString();
    }
}
