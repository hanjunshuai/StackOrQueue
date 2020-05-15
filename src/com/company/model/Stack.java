package com.company.model;

public class Stack {
    // 栈顶
    public Node stackTop;
    // 栈底
    public Node stackBottom;

    public Stack(Node stackTop, Node stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    public Stack() {
    }


}
