package com.company;

import com.company.model.Node;
import com.company.model.Queue;
import com.company.model.Stack;

/**
 * 1、栈
 * a、特性：先进后出
 * b、分类：静态栈（数组实现）、动态栈（链表实现）
 * <p>
 * <p>
 * 2、队列
 * a、特性:先进先出
 * b、分类：静态队列(数组实现)、动态队列(链表实现)
 */
public class Main {

    public static void main(String[] args) {
        // 初始化栈（无元素）
        Stack stack = new Stack(new Node(), new Node());

        // 栈顶和栈底是同一指向
        stack.stackBottom = stack.stackTop;
        // 指向null
        stack.stackTop.next = null;

        pushStack(stack, 1);
        pushStack(stack, 2);
        pushStack(stack, 3);

        traverse(stack);

        boolean empty = isEmpty(stack);
        System.out.println(empty ? "该栈为null" : "该栈不为null");

        popStack(stack);

        clearStack(stack);
        popStack(stack);
        popStack(stack);
        popStack(stack);

        // 初始化队列
        // 此时队列为空，分配了6个长度给数组（只能装5个实际的数字，rear指向的是无效的位置）
        Queue queue = new Queue();
        queue.front = 0;
        queue.rear = 0;
        queue.arrays = new int[6];
        boolean full = isFull(queue);
        System.out.println(full ? "此时队列满了" : "此时队列没满");

        System.out.println(isEmptyQueue(queue) ? "此时队列空的" : "此时队列非空的");
        enQueue(queue, 1);
        enQueue(queue, 2);
        enQueue(queue, 3);
        enQueue(queue, 4);
        enQueue(queue, 5);
        enQueue(queue, 6);
        enQueue(queue, 7);

        traverseQueue(queue);

        System.out.println(isEmptyQueue(queue) ? "此时队列空的" : "此时队列非空的");

        outQueue(queue);
        outQueue(queue);
        outQueue(queue);

        clearQueue(queue);

        System.out.println(isEmptyQueue(queue) ? "此时队列空的" : "此时队列非空的");

        enQueue(queue, 55);
        traverseQueue(queue);

    }

    /*---------队列-----------*/

    /**
     * 清空队列
     *
     * @param queue
     */
    private static void clearQueue(Queue queue) {
        queue.front = 0;
        queue.rear = 0;
        queue.arrays = new int[queue.arrays.length];
    }

    private static void outQueue(Queue queue) {
        // 判断队列是否尾空
        if (!isEmptyQueue(queue)) {
            int value = queue.arrays[queue.front];
            System.out.println("出队的元素：" + value);
            // front 指针向后移动
            queue.front = (queue.front + 1) % queue.arrays.length;
        }
    }

    /**
     * 判断队列是否空，front 和 rear 指针相等，就是空了
     *
     * @param queue
     */
    private static boolean isEmptyQueue(Queue queue) {
        if (queue.front == queue.rear) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 遍历队列
     *
     * @param queue
     */
    private static void traverseQueue(Queue queue) {
        // front 的位置
        int i = queue.front;

        while (i != queue.rear) {
            System.out.println("queue:" + queue.arrays[i]);
            // 移动front
            i = (i + 1) % queue.arrays.length;
        }
    }

    /**
     * 入队
     *
     * @param queue
     */
    private static void enQueue(Queue queue, int value) {
        // 判断队列是否已满
        if (!isFull(queue)) {
            // 将新的元素插入到对尾中
            queue.arrays[queue.rear] = value;
            // rear 节点移动到新的无效元素位置上
            queue.rear = (queue.rear + 1) % queue.arrays.length;
        }
    }

    /**
     * 判断队列是否满了，front 和  rear指针紧挨着，就是满了
     *
     * @param queue
     * @return
     */
    private static boolean isFull(Queue queue) {
        if ((queue.rear + 1) % queue.arrays.length == queue.front) {
            return true;
        } else {
            return false;
        }
    }


    /*---------栈-----------*/

    /**
     * 进栈
     *
     * @param stack 栈
     * @param value 要进栈的元素
     */
    public static void pushStack(Stack stack, int value) {
        // 封装数据节点
        Node newNode = new Node(value);
        // 栈顶本来指向的节点交由新节点来指向
        newNode.next = stack.stackTop;
        // 栈顶指针指向新节点
        stack.stackTop = newNode;
    }

    /**
     * 遍历栈（只要栈顶指针不指向栈底指针就一直输出）
     *
     * @param stack
     */
    private static void traverse(Stack stack) {
        Node stackTop = stack.stackTop;
        while (stackTop != stack.stackBottom) {
            System.out.println("data:" + stackTop.data);
            stackTop = stackTop.next;
        }
    }

    /**
     * 判断该栈是否为空
     *
     * @param stack
     */
    private static boolean isEmpty(Stack stack) {
        if (stack.stackTop == stack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 出栈（将栈顶的指针指向下一个节点）
     *
     * @param stack
     */
    private static void popStack(Stack stack) {
        // 栈不为空才能出栈
        if (!isEmpty(stack)) {
            // 栈顶的元素
            Node top = stack.stackTop;
            // 栈顶指针指向下一个节点
            stack.stackTop = top.next;
            System.out.println("出栈的元素为:" + top.data);
        }
    }

    /**
     * 清空栈
     *
     * @param stack
     */
    private static void clearStack(Stack stack) {
        stack.stackTop = null;
        stack.stackBottom = stack.stackTop;
    }
}
