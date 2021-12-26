import java.util.HashSet;
import java.util.Set;

/**
 * 不允许重复元素
 * 没有索引
 * 无序集合，存储与取出顺序不一致
 */
public class SetDemo {

    /**
     * HashSet
     * 底层实现原理： 哈希表，查询速度快， 哈希表=数组+红黑树
     * 非线程同步
     * 重写了hashCode和equals方法，保证元素唯一
     *
     *
     * 1.add元素时会判断hash code是否一致，
     * 2.has code不一致直接放入，一致则调用equals
     * 3.如果相等就不再放入；不相等，放入
     */
    public void hashSetDemo() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(111);

    }

    /**
     * LinkedHashSet 继承了HashSet
     * 底层实现原理：哈希表+链表
     * 元素有序，不受重复写入影响，重复写入仍然保持第一次写入的顺序
     */
    public void linkedHashSetDemo() {

    }

    public void treeSetDemo() {

    }
}
