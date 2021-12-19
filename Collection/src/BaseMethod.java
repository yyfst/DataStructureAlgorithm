import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class BaseMethod {
    public void add() {

    }

    public void foreach() {
        Collection<Integer> collection=new ArrayList<>();
        collection.add(100);
        collection.add(101);
        collection.add(102);
        for (Integer data:collection) {
            System.out.println(data.intValue());
        }
    }

    // 泛型通配符，只能用于传递参数，不能用于参数定义
    public void printCollection(Collection<?>collection) {
        Iterator<?> iterator=collection.iterator();
        while (iterator.hasNext()){
            Object object=iterator.next();
            System.out.println(object);
        }
    }

    /**
     * 泛型限定：
     *  上限限定: ? extends E 代表使用的泛型只能是E的子类或本身
     *  下限限定：? super E 代表使用的泛型只能是E的父类或本身
     */
    public void demoExtends(Collection<? extends Number> collection) {
        Iterator<?> iterator=collection.iterator();
        while (iterator.hasNext()){
            Object object=iterator.next();
            System.out.println(object);
        }
    }

    public void demoSuper(Collection<? super Number> collection) {
        Iterator<?> iterator=collection.iterator();
        while (iterator.hasNext()){
            Object object=iterator.next();
            System.out.println(object);
        }
    }
}
