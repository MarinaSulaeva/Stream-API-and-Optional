import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("Задание №1");
        List<String> testList = new ArrayList<>();
        testList.add("Тестовый текст");
        testList.add("Второй тестовый текст");
        testList.add("Пятый тестовый текст");
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            if (s2.length() > s1.length()) return -1;
            return 0;
        };
        BiConsumer<String, String> maxMinConsumer = (s1, s2) -> System.out.println("Минимальная строка: " + s1 + "\nМаксимальная строка: " + s2);
        findMinMax(testList.stream(), comparator, maxMinConsumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> comparator,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <T> temporaryList = stream
                .sorted(comparator)
                .collect(Collectors.toList());
        T max = temporaryList.get(temporaryList.size()-1);
        T min = temporaryList.get(0);
        minMaxConsumer.accept(min, max);

    }


    public static void task2() {
        System.out.println("Задание №2");
        List <Integer> integerList = List.of(1,6,8,9,20,45,61,5,31);
        printEvenNumbers(integerList);
    }

    public static void printEvenNumbers(List <Integer> integerList) {
        Predicate<Integer> predicate = integer -> (integer%2 == 0);
        integerList.stream()
                .filter(predicate)
                .forEach(System.out ::println);
    }
}