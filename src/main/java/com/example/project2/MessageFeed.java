package com.example.project2;

import java.util.ArrayList;
import java.util.List;

public class MessageFeed implements Observer
{
    private List<String> messageFeed;
    private List<Observer> followers;

    public MessageFeed()
    {
        messageFeed = new ArrayList<>();
        followers = new ArrayList<>();
    }

    @Override
    public void update(String message, User user)
    {
        messageFeed.add(user.toString() + ": " + message);
//        user.notifyObservers();
    }

//    public void addObserver(Observer observer)
//    {
//        if (!followers.contains(observer))
//        {
//            followers.add(observer);
//        }
//    }

    public int getMessageAmount()
    {
        return messageFeed.size();
    }

    public String getMessage(int element)
    {
        return messageFeed.get(element);
    }
}
