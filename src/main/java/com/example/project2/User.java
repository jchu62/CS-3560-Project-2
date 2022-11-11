package com.example.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements UserElement{
//    private String userGroup;
    private final UUID uuid;
    private final String name;
    private final List<User> currentFollowers;
    private final List<User> currentlyFollowing;
    private List<String> messageList;
    private List<String> messageFeed;

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

    public UUID getUUID()
    {
        return this.uuid;
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
    public void receiveMessage(String message)
    {
        messageFeed.add(message);
    }
//    public void joinUserGroup(UserGroup userGroup)
//    {
//        userGroup.addGroupMember(this);
//        this.userGroup = userGroup.toString();
//    }
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
        return this.name.toString();
    }


}
