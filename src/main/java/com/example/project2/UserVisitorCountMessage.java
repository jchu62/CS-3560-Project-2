package com.example.project2;

public class UserVisitorCountMessage implements UserVisitor
{
    private int positiveMessages = 0;
    private String[] positiveStrings = {"Sheep", "Good", "Great", "Excellent", "sheep", "good", "great", "excellent"};

    public void visit(User user)
    {
        for(String string: user.getMessageList())
        {
            
        }
    }
    public void visit(UserGroup userGroup)
    {

    }
}
