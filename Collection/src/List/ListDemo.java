package List;

import java.util.ArrayList;
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

        list.set(1,999);
        return list;
    }


}
