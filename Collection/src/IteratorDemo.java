import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// 迭代器学习
public class IteratorDemo {
    public void iterator() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(100);
        collection.add(1000);
        collection.add(10000);
        // 获取迭代器实现类对象
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            int e = iterator.next();
            System.out.println("e: " + e);
        }

        // 没有元素会抛出异常：NoSuchElementException
        iterator.next();

    }
}
