package com.example.project2;
import java.util.List;

public class UserGroup implements UserElement
{
    private String groupName;
    private List<User> userList;
    private List<UserGroup> groupList;

    public UserGroup(String groupName)
    {
        this.groupName = groupName;
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
}
