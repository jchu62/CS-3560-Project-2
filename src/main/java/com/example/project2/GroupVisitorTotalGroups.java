package com.example.project2;

public class GroupVisitorTotalGroups implements UserVisitor
{
    private int totalGroups = 0;
    public void visit(User user){}
    public void visit(UserGroup userGroup)
    {
        totalGroups++;
    }
}
