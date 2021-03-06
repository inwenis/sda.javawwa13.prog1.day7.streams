import java.util.*;
import java.util.stream.Collectors;
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

        OptionalDouble optionalAverage = getAverage(integers);
        System.out.println("Exercise 3");
        optionalAverage.ifPresent(System.out::println);

        List<String> strings = Arrays.asList("aaa", "bbb", "xXx", "a-a", "aaaa");
        List<String> upperCase = toUpper(strings);
        System.out.println("Exercise 4");
        upperCase.forEach(System.out::println);

        System.out.println("Exercise 5");
        strings
                .stream()
                .filter(x -> x.startsWith("a") && x.length() == 3)
                .forEach(System.out::println);

        String concat = concat(integers);
        System.out.println("Exercise 6 - concat ints");
        System.out.println(concat);

        concat = concat2(integers);
        System.out.println("Exercise 7 - concat ints with odd/even check");
        System.out.println(concat);

        System.out.println("Exercise 8 - reverse string");
        System.out.println(reverse("aaaXXX"));

        System.out.println("Exercise 9 - dividable by 3");
        List<Integer> dividableBy = dividableBy3(Arrays.asList(1,2,3,100,111));
        dividableBy.forEach(System.out::println);

        System.out.println("Exercise 10 - sum numbers greater than 10");
        int sum = sumGreaterThan10(integers);
        System.out.println(sum);

        List<String> names = Arrays.asList("ola", "ala", "Ola", "Filip"
        ,"filip");
        List<String> distinctUpperCaseNames = distinctUpperCase(names);
        System.out.println("Exercise 11 - upper case unique names");
        distinctUpperCaseNames.forEach(System.out::println);

        System.out.println("Exercise 11 - upper case unique names with limit");
        names = Arrays.asList("ola", "ala", "Ola", "Filip"
                ,"filip", "kasia", "basia", "olek", "maja", "agata",
                "kai", "stefan", "zbyszek");
        distinctUpperCaseNames = distinctUpperCaseLimit(names);
        distinctUpperCaseNames.forEach(System.out::println);
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

    // Exercise 3
    private static OptionalDouble getAverage(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    // Exercise 4
    private static List<String> toUpper(List<String> strings) {
        return strings
                .stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());
    }

    // Exercise 6
    private static String concat(List<Integer> integers) {
        return integers
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    // Exercise 7
    private static String concat2(List<Integer> integers) {
        return integers
                .stream()
                .map(x -> (x % 2 == 0 ? "e" : "o") + x.toString())
                .collect(Collectors.joining(",", "[", "]"));
    }

    // Exercise 7 v2
    private static String concat2_2(List<Integer> integers) {
        return integers
                .stream()
                .map(x -> x % 2 == 0 ? "e" + x.toString() : "o" + x.toString())
                .collect(Collectors.joining(",", "[", "]"));
    }

    // Exercise 7 v3
    private static String concat2_3(List<Integer> integers) {
        return integers
                .stream()
                .map(x -> {
                    if (x % 2 == 0) {
                        return "e" + x.toString();
                    } else {
                        return "o" + x.toString();
                    }
                })
                .collect(Collectors.joining(",", "[", "]"));
    }

    // Exercise 8
    private static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }

    // Exercise 9
    private static List<Integer> dividableBy3(List<Integer> ints) {
        return ints
                .stream()
                .filter(x -> x % 3 == 0)
                .collect(Collectors.toList());
    }

    // Exercise 10
    private static int sumGreaterThan10(List<Integer> integers) {
        return integers
                .stream()
                .filter(x -> x > 10)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Exercise 11
    private static List<String> distinctUpperCase(List<String> names) {
        return names
                .stream()
                .map(x -> x.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> distinctUpperCaseLimit(List<String> names) {
        return names
                .stream()
                .map(x -> x.toUpperCase())
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }
}
