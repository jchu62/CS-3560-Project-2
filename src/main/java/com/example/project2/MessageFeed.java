package com.example.project2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
// this was probably never needed
public class MessageFeed implements Observer
{
    private List<String> messageFeed;
    private DefaultListModel messageFeedList;
//    private List<Observer> followers;

    public MessageFeed()
    {
        messageFeed = new ArrayList<>();
        this.messageFeedList = new DefaultListModel();
//        followers = new ArrayList<>();
    }

    @Override
    public void update(String message, User user)
    {
        messageFeed.add(user.toString() + ": " + message);
        messageFeedList.insertElementAt(message, 0);
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

    public DefaultListModel getMessageFeedList()
    {
        return messageFeedList;
    }
}
