package com.example.project2;
import java.util.List;

public class UserGroup implements UserElement
{
    private String groupName;
    private List<User> userList;

    @Override
    public void accept(UserVisitor userVisitor)
    {
        userVisitor.visit(this);
    }
    public void addGroupMember(User user)
    {
        userList.add(user);
    }
}
