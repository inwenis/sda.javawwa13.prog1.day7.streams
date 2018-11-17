import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        OptionalInt max = getMax(IntStream.range(1, 10).toArray());
        System.out.println("Exercise 1");
        max.ifPresent(System.out::println);

        List<Integer> integers = Arrays.asList(1, 2, 100, 34, 10);
        Optional<Integer> maxInteger = getMax3(integers);
        System.out.println("Exercise 2");
        maxInteger.ifPresent(System.out::println);

    }

    // Exercise 1
    private static OptionalInt getMax(int[] ints) {
        return Arrays.stream(ints)
                .max();
    }

    // Exercise 2
    private static OptionalInt getMax(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    // Exercise 2 v2
    private static Optional<Integer> getMax2(List<Integer> integers) {
        return integers
                .stream()
                .max(Integer::compareTo);
    }

    // Exercise 2 v3
    private static Optional<Integer> getMax3(List<Integer> integers) {
        return integers
                .stream()
                .max((a, b) -> a - b);
    }

    // Exercise 2 v4
    private static Optional<Integer> getMax4(List<Integer> integers) {
        return integers
                .stream()
                .max((a, b) -> a.compareTo(b));
    }

}
