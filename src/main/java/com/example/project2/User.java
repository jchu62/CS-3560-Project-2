package com.example.project2;

import java.util.List;
import java.util.UUID;

public class User
{
    private UUID uuid;
    private List<UUID> userFollowers;
    private List<UUID> userFollowing;
    private List<String> messageList;
}
