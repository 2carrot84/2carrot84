package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eguns on 2017. 4. 23..
 */
public class SortClass {
    public static void bubbleSort(int[] numbers) {
        boolean numbersSwitched;

        do {
            numbersSwitched = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                // 오름차순
                if(numbers[i + 1] < numbers[i]) {
                    int tmp = numbers[i+1];

                    numbers[i+1] = numbers[i];
                    numbers[i] = tmp;

                    numbersSwitched = true;
                }
            }
        } while (numbersSwitched);
    }

    public static List<Integer> insertSort(final List<Integer> numbers) {
        final List<Integer> sortedList = new LinkedList<>();

        orginalList:
        for (Integer number : numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                // 내림차순
                if(number > sortedList.get(i)) {
                    sortedList.add(i, number);
                    continue orginalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }

        return sortedList;
    }

    public static List<Integer> quickSort(List<Integer> numbers) {
        if(numbers.size() < 2) {
            return numbers;
        }

        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            }
            else {
                higher.add(numbers.get(i));
            }
        }

        final List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));

        return sorted;
    }
}