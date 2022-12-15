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
    private long creationTime;
    private long lastUpdateTime;

    public User(UUID uuid, String name, long creationTime)
    {
        this.id = uuid.toString();
        this.name = name;
        this.creationTime = creationTime;
        this.lastUpdateTime = creationTime;
        currentFollowers = new ArrayList<>();
        currentlyFollowing = new ArrayList<>();
        messageList = new ArrayList<>();
        messageFeed = new MessageFeed();
        this.addObserver(messageFeed);
        currentlyFollowing.add(this);
    }

    public void follow(User user)
    {
        if (!currentlyFollowing.contains(user))
        {
            user.addObserver(messageFeed);
            currentlyFollowing.add(user);
            for (String string : user.getMessageList())
            {
                messageFeed.update(string, user);
            }
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
        return uuid.equals(this.id);
    }

    public String[] getMessageList()
    {
        String[] stringArray = new String[messageList.size()];
        for (int i = 0; i < messageList.size(); i++)
        {
            stringArray[i] = messageList.get(i);
        }
        return stringArray;
    }

    public String[] getFollowerList()
    {
        String [] stringArray = new String[currentlyFollowing.size()];
        for (int i = 0; i < currentlyFollowing.size(); i++)
        {
            stringArray[i] = currentlyFollowing.get(i).toString();
        }
        return stringArray;
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

    public String[] getMessageFeed()
    {
        String[] array = new String[messageFeed.getMessageAmount()];
        for (int i = 0; i < this.messageFeed.getMessageAmount(); i++)
        {
            array[i] = messageFeed.getMessage(i);
        }
        return array;
    }

    public MessageFeed getMessageFeedClass()
    {
        return messageFeed;
    }

    public long getCreationTime()
    {
        return creationTime;
    }

    public long getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long updateTime)
    {
        lastUpdateTime = updateTime;
    }
}
