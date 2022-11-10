package com.example.project2;
import java.util.List;

public class UserGroup implements UserElement
{
    private List<User> userList;

    @Override
    public void accept(UserVisitor userVisitor)
    {
        userVisitor.visit(this);
    }
}
