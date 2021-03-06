package com.datastructure.demo.algo.queue;

/**
 * @Description: 基于数组的动态顺序队列
 * @Author: Webb Dong
 * @CreateDate: 2019/02/26 17:44
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/26 17:44
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ArrayDilatationQueue<T> {

    /**
     * 元素
     */
    private T[] elements;

    /**
     * 队列大小
     */
    private int capacity;

    /**
     * 头下标
     */
    private int head;

    /**
     * 尾下标
     */
    private int tail;

    public ArrayDilatationQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(T data) {
        if (tail == capacity) {
            if (head == 0) {
                // 队列已满
                return false;
            }
            // 搬移整理数据，整体移动到队列的最前端
            for (int i = head; i < tail; i++) {
                this.elements[i - head] = this.elements[i];
            }
            // 重新更新head和tail
            tail -= head;
            head = 0;
        }
        this.elements[tail++] = data;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            // 队列已空
            return null;
        }
        return this.elements[head++];
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(this.elements[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDilatationQueue<Integer> queue = new ArrayDilatationQueue<>(5);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);

        queue.printAll();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();

        queue.enqueue(1000);
        queue.enqueue(2000);
        queue.enqueue(3000);
        queue.enqueue(4000);
        queue.enqueue(5000);
        queue.enqueue(6000);
        queue.enqueue(7000);
        queue.printAll();

        System.out.println("-------------------------------------------");
        Integer data = queue.dequeue();
        while (data != null) {
            System.out.print(data + ", ");
            data = queue.dequeue();
        }
        System.out.println();
        System.out.println("-------------------------------------------");

        queue.enqueue(10000);
        queue.enqueue(20000);
        queue.enqueue(30000);
        queue.enqueue(40000);
        queue.enqueue(50000);
        queue.enqueue(60000);
        queue.enqueue(70000);
        queue.printAll();
    }

}
