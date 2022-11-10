package com.example.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements UserElement{
    private UUID uuid;
    private String name;
    private List<User> userFollowers;
    private List<User> userFollowing;
    private List<String> messageList;

    public User(UUID uuid, String name)
    {
        this.uuid = uuid;
        this.name = name;
        userFollowers = new ArrayList<User>();
        userFollowing = new ArrayList<User>();
        userFollowers.add(this);
        userFollowing.add(this);
    }

    public void addFollower(User user)
    {
        userFollowing.add(user);
    }
    public void addFollowing(User user)
    {
        userFollowers.add(user);
    }
    public void followUser(UUID uuid)
    {

    }
//    public void notifyObservers()
//    {
//        for (Observer observer : userFollowing)
//            observer.update();
//    }
    public List<String> getMessageList()
    {
        return messageList;
    }
//    public void sendMessage(String message)
//    {
//        messageList.add(message);
//        notifyObservers();
//    }
    @Override
    public void accept(UserVisitor userVisitor)
    {
        userVisitor.visit(this);
    }
    @Override
    public String toString()
    {
        return this.uuid.toString();
    }
}
