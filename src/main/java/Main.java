import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        OptionalInt max = getMax(IntStream.range(1, 10).toArray());
        System.out.println("Exercise 1");
        max.ifPresent(System.out::println);

        List<Integer> integers = Arrays.asList(1, 2, 100, 34, 10);
        OptionalInt maxInteger = getMax(integers);
        System.out.println("Exercise 2");
        maxInteger.ifPresent(System.out::println);

    }

    private static OptionalInt getMax(int[] ints) {
        return Arrays.stream(ints)
                .max();
    }

    private static OptionalInt getMax(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .max();
    }

}
