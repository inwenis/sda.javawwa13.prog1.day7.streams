import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        OptionalInt max = getMax(IntStream.range(1, 10).toArray());
        max.ifPresent(System.out::println);
    }

    private static OptionalInt getMax(int[] ints) {
        return Arrays.stream(ints)
                .max();
    }
}
