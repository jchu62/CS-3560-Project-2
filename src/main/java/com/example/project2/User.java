package com.example.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements UserElement{
    private final String id;
    private final String name;
    private final List<Observer> currentFollowers;
    private final List<User> currentlyFollowing;
    private List<String> messageList;
    private MessageFeed messageFeed;

    public User(UUID uuid, String name)
    {
        this.id = uuid.toString();
        this.name = name;
        currentFollowers = new ArrayList<Observer>();
        currentlyFollowing = new ArrayList<User>();
        messageList = new ArrayList<String>();
        messageFeed = new MessageFeed();
        this.addObserver(messageFeed);
        currentlyFollowing.add(this);
    }

    public void follow(User user)
    {
        user.addObserver(messageFeed);
        currentlyFollowing.add(user);
        for (String string : user.getMessageList())
        {
            messageFeed.update(string, user);
        }
    }

    public void addObserver (Observer observer)
    {
        if (!currentFollowers.contains(observer))
        {
            currentFollowers.add(observer);
        }
    }

    public String getID()
    {
        return this.id;
    }

    public boolean verifyID(String uuid)
    {
        return uuid==this.id;
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
        for (Observer observers : currentFollowers)
        {
            observers.update(messageList.get(messageList.size()-1), this);
        }
    }
    @Override
    public String toString()
    {
        return this.name;
    }


}
