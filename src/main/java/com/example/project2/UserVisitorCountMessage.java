package com.example.project2;

public class UserVisitorCountMessage implements UserVisitor
{
    private int positiveMessages = 0;
    private int totalMessages = 0;
    private String[] positiveStrings = {"sheep", "good", "great", "excellent"};

    public void visit(User user)
    {
        positiveMessages = 0;
        totalMessages = 0;
        for(String string: user.getMessageList())
        {
            for (int i = 0; i < positiveStrings.length; i++)
            {
                if (string.toLowerCase().indexOf(positiveStrings[i]) != -1)
                {
                    positiveMessages++;
                    break;
                }
            }
            totalMessages++;
        }
    }
    public void visit(UserGroup userGroup){}

    public int getPositiveMessages(User user)
    {
        visit(user);
        return positiveMessages;
    }
    public int getTotalMessages(User user)
    {
        visit(user);
        return totalMessages;
    }
}
