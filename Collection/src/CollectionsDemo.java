

import java.util.*;

public class CollectionsDemo {
    public void collections() {
        System.out.println("-------------");
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);
        Collections.shuffle(list);
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

    }
}
