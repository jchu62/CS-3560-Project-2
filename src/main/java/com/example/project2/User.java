package com.example.project2;

import java.util.List;
import java.util.UUID;

public class User implements UserElement{
    private UUID uuid;
    private String name;
    private List<Observer> userFollowers;
    private List<Observer> userFollowing;
    private List<String> messageList;

    public User(UUID uuid, String name)
    {
        this.uuid = uuid;
        this.name = name;
    }

    public void addFollower(Observer user)
    {
        userFollowing.add(user);
    }
    public void notifyObservers()
    {
        for (Observer observer : userFollowing)
            observer.update();
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
}
