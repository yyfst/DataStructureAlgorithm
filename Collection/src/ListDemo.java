import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 有序，出入顺序一样
 * 有索引
 * 允许重复
 */
public class ListDemo {
    public List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(8);

        list.set(1, 999);
        return list;
    }

    /**
     * ArrayList
     * 底层实现原理： 可变数组
     * 非线程同步
     */
    public void arrayListDemo() {

    }

    /**
     * LinkedList
     * 底层实现原理： 链表
     * 非线程安全
     * <p>
     * 使用特有方法，不要用多态
     */
    public void linkedListDemo() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(100);
        linkedList.add(200);
        linkedList.add(300);

        // first
        linkedList.addFirst(400);
        // last
        linkedList.addLast(500);

        // 返回第一个元素, 没有则返回null
        Integer peek = linkedList.peek();

        // 没有会抛异常
        int first = linkedList.getFirst();

        // 移除第一个并返回, 没有则抛异常
        int pop = linkedList.pop();
        System.out.println("pop: " + pop);


        System.out.println("------------");
        System.out.println(linkedList);


        // pop 移除第一个
    }

    /**
     * Vector
     * 底层实现原理： 数组
     * 线程同步
     */
    public void vectorDemo() {
        // addElement

        // elements()

        // 迭代器
    }


}
