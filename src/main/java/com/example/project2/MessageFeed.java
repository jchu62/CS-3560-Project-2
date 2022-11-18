package com.example.project2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
// this was probably never needed
public class MessageFeed implements Observer
{
    private List<String> messageFeed;
    private DefaultListModel messageFeedList;

    public MessageFeed()
    {
        messageFeed = new ArrayList<>();
        this.messageFeedList = new DefaultListModel();
//        followers = new ArrayList<>();
    }

    @Override
    public void update(String message, User user)
    {
        String newMessage = user.toString() + ": " + message;
        messageFeed.add(newMessage);
        messageFeedList.insertElementAt(newMessage, 0);
    }

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
