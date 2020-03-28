package com.sunpeifu.study.data_structure.queue;

/**
 * 作者:  daike
 * 日期:  2020/3/23
 * 描述:
 */
public class MyNode<E> {

    // Node中的成员,首个
    transient Node<E> first;

    transient Node<E> last;

    // 队列中的数量
    int count;

    // 队列中的最大数量
    int capacity = 10;



    public boolean add(E e){
        // 首次添加在队列的尾部追加,先存储尾部元素
        if (count >capacity){
            // 超过队列的最大长度,不允许添加
            return false;
        }
        // 创建一个新的元素
        Node<E> newNode = new Node<>(e);

        // 在队列尾部进行追加

        // 先定义临时变量接收尾部信息
        Node temp = last;
        // 现在队列最后的元素就是我们新加进来的节点
        newNode.prev = temp;
        last = newNode;

        temp.next = newNode;
        // 如果首位为空,则直接首节点为新数组
        if (null== first){
            first = newNode;
        } else {
            // 首位不为空
            first.next= newNode;
        }







        return true;





    }

    // 定义一个内部类
    static final class Node<E> {

        // 定义构造方法传入
        Node(E x) {
            item = x;
        }


        // 元素
        E item;

        // 当前元素之前的元素
        Node<E> prev;

        // 当前元素之后的元素

        Node<E> next;
    }
}
