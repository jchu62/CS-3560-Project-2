package com.example.project2;
import java.util.List;

public class UserGroup implements UserElement
{
    private String groupName;
    private List<User> userList;
    private List<UserGroup> groupList;

    private long creationTime;

    public UserGroup(String groupName, long creationTime)
    {
        this.groupName = groupName;
        this.creationTime = creationTime;
    }

    @Override
    public void accept(UserVisitor userVisitor)
    {
        userVisitor.visit(this);
    }
    public void addGroupMember(User user)
    {
        userList.add(user);
    }
    public List<User> getGroupMembers()
    {
        return this.userList;
    }
    public String toString()
    {
        return this.groupName;
    }
    public long getCreationTime()
    {
        return this.creationTime;
    }
    public String getGroupName()
    {
        return this.groupName;
    }
}
