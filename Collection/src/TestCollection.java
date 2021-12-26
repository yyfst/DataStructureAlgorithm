import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class TestCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        boolean isAdded = collection.add(100);
        collection.add(111);
        System.out.println(collection);
        System.out.println(isAdded);

        boolean isDel = collection.remove(1000);
        System.out.println(isDel);
        System.out.println(Arrays.toString(collection.toArray()));

        IteratorDemo iteratorDemo = new IteratorDemo();
        try {
            iteratorDemo.iterator();
        }catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }

        BaseMethod baseMethod = new BaseMethod();
        baseMethod.foreach();
        System.out.println("------------");
        baseMethod.printCollection(collection);

        ListDemo listDemo = new ListDemo();
        listDemo.linkedListDemo();

        CollectionsDemo collectionsDemo = new CollectionsDemo();
        collectionsDemo.collections();

    }
}
