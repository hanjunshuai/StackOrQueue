package com.company.model;

public class Queue {
    // 数组
    public int[] arrays;

    // 指向第一个有效的元素
    public int front;
    // 指向有效数据的下一个元素（即指向无效的数据）
    public int rear;

    // 1、rear 并不指向最后一个有效的元素,在循环队列中这样设计是非常方便的。这样设计可以分清队头和队尾（不然循环队列不断入队或出队，位置是变化很快的）
    // 2、由于是循环队列，所以front 和 rear 值会经常变动，我们得把 front 和 rear 的值限定在一个范围内，不然会超出队列的长度。
    // rear = （rear+1）% 数组长度
}
