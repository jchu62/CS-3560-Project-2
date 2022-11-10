package com.example.project2;

import java.util.List;
import java.util.UUID;

public class User {
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
    public void sendMessage(String message)
    {
        messageList.add(message);
        notifyObservers();
    }
}
