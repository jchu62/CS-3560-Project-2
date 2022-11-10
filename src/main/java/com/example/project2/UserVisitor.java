package com.example.project2;

public interface UserVisitor {
    void visit(User user);
    void visit(UserGroup userGroup);
}
