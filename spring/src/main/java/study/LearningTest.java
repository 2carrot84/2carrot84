package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eguns on 2017. 4. 23..
 */
public class LearningTest {
    @Test
    public void sortInts() {
        // Comparator 객체가 없는 구현체는 타입을 자연스선 순서로 정렬
        final int[] numbers = {-3, -5, 1, 7, 4, -2};
        final int[] expected = {-5, -3, -2, 1, 4, 7};

        Arrays.sort(numbers);
        Assert.assertArrayEquals(expected, numbers);
    }

    @Test
    public void sortObjects() {
        // Comparable 인터페이스 구현
        final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
        final String[] expected = {"abc", "x", "y", "z", "zazzy", "zzz"};

        Arrays.sort(strings);
        Assert.assertArrayEquals(expected, strings);
    }

    @Test
    public void customSorting() {
        final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
        final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Assert.assertEquals(expected, numbers);
    }

    @Test(expected = ClassCastException.class)
    public void sortObjectNotComparableClass() {
        FruitNotComparable[] fruits = new FruitNotComparable[3];

        fruits[0] = new FruitNotComparable("Apple", 10);
        fruits[1] = new FruitNotComparable("Pineapple", 30);
        fruits[2] = new FruitNotComparable("Banana", 20);

        Arrays.sort(fruits);
    }

    @Test
    public void sortObjectComparableClass() {
        Fruit[] fruits = new Fruit[3];

        fruits[0] = new Fruit("Apple", 10);
        fruits[1] = new Fruit("Pineapple", 30);
        fruits[2] = new Fruit("Banana", 20);

        Arrays.sort(fruits);
        Arrays.stream(fruits).forEach(System.out::println);
    }

    @Test
    public void bubbleSorting() {
        final int[] numbers = {-3, -5, 1, 7, 4, -2};
        final int[] expected = {-5, -3, -2, 1, 4, 7};

        SortClass.bubbleSort(numbers);

        Assert.assertArrayEquals(expected, numbers);
    }

    @Test
    public void insertSorting() {
        List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
        final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);

        numbers = SortClass.insertSort(numbers);

        Assert.assertEquals(expected, numbers);
    }

    @Test
    public void quickSorting() {
        List<Integer> numbers = Arrays.asList(4, 8, 1, 6, 3, 5, 7);
        final List<Integer> expected = Arrays.asList(1, 3, 4, 5, 6, 7, 8);

        numbers = SortClass.quickSort(numbers);

        Assert.assertEquals(expected, numbers);
    }

    @Test
    public void queueInsertion() {
        final Queue<String> queue = new LinkedList<>();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        Assert.assertEquals("first", queue.remove());
        Assert.assertEquals("second", queue.remove());
        Assert.assertEquals("third", queue.peek());
        Assert.assertEquals("third", queue.remove());
    }

    @Test
    public void overWriteKey() {
        final Map<String, String> preferences = new HashMap<>();
        preferences.put("like", "jacuzzi");
        preferences.put("dislike", "steam room");

        Assert.assertEquals("jacuzzi", preferences.get("like"));

        preferences.put("like", "sauna");

        Assert.assertEquals("sauna", preferences.get("like"));


    }

    @Test
    public void treeMapTraversal() {
        final Map<Integer, String> counts = new TreeMap<>();

        counts.put(4, "four");
        counts.put(1, "one");
        counts.put(3, "three");
        counts.put(2, "two");

        final Iterator<Integer> keys = counts.keySet().iterator();

        Assert.assertEquals(Integer.valueOf(1), keys.next());
        Assert.assertEquals(Integer.valueOf(2), keys.next());
        Assert.assertEquals(Integer.valueOf(4), keys.next());
        Assert.assertEquals(Integer.valueOf(3), keys.next());

    }

    @Test
    public void setExample() {
        final Set<String> set = new HashSet<>();

        set.add("hello");
        set.add("welcome");
        set.add("goodbye");
        set.add("bye");
        set.add("hello");

        Assert.assertEquals(4, set.size());

        final List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("welcome");
        list.add("goodbye");
        list.add("bye");
        list.add("hello");

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void legalBuild() {
        final Pet.Builder builder = new Pet.Builder();
        final Pet pet = builder.withPetName("Squidge").withOwnerName("Simon Smith").build();

        Assert.assertEquals("Simon Smith", pet.getOwnerName());
    }

}
