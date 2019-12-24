package playground;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PlayWithStreams {
    public static void main(String[] args){
        //Terminal operations
        // ------------- count - does not terminate
        Stream<String> primates = Stream.of("monkey", "bonobo", "gorilla");
        System.out.println("primates nr: " + primates.count() + "\n");

        // -------------- min/max - does not terminate
        Optional<String> minPrimate = Stream.of("monkey", "bonobo", "gorilla").min((s1,s2) -> s1.length() - s2.length());
        //if(minPrimate.isPresent()) System.out.println(minPrimate.get());
        minPrimate.ifPresent(System.out::println);
        System.out.println("\n");

        //empty stream -> min does not execute
        Optional<?> emptyStream = Stream.empty().min((s1,s2) -> 0);
        System.out.println("is present: " + emptyStream.isPresent() + "\n");

        // -------------- findAny/findFirst - terminates
        Stream<String> infiniteStream = Stream.generate(() -> "chimp");
        infiniteStream.findAny().ifPresent(System.out::println);
        System.out.println("\n");

        // -------------- anyMatch - terminates - ; noneMatch; allMatch
        List<String> stuff = Arrays.asList("1234", "boat", "umbrella");
        Stream<String> infiniteStream2 = Stream.generate(() -> "r2-d2");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println("any starts with letter " + stuff.stream().anyMatch(pred));
        System.out.println("none starts with letter " + stuff.stream().noneMatch(pred));
        System.out.println("all start with letter " + stuff.stream().allMatch(pred));
        // noneMatch; allMatch do not terminate an infinite stream
        System.out.println("any starts with letter " + infiniteStream2.anyMatch(pred) + "\n");

        // -------------- forEach - does not temrinate
        stuff.forEach(System.out::println);
        System.out.println("cu lambda");
        stuff.forEach(s -> System.out.println(s));
        System.out.println("\n");

        // -------------- reduce - does not terminate
        Stream<String> wolf = Stream.of("w", "o", "l", "f");
        String word = wolf.reduce("", (s,c) -> s+c); //method reference: String::concat

        Stream<Integer> intStream = Stream.of(3,5,6);
        int result = intStream.reduce(1, (a,b) -> a*b);
        System.out.println(result);

        // -------------- collect - does not terminate
        Stream<String> wolf2 = Stream.of("w", "o", "l", "f");
        StringBuilder word2 = wolf2.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("collect result: "+ word2 + "\n");


        // Intermediate operations
        // -------------- filter & peek
        Stream<String> intermediateExample = Stream.of("sonic", "mario", "yoshi", "zelda", "yuumi");
        long count = intermediateExample
                .filter(x -> x.startsWith("y"))
                .peek(System.out::println).count();
        System.out.println("count: " + count + "\n");

        // -------------- distinct
        Stream<String> intermediateExample2 = Stream.of("sonic", "mario", "yoshi", "zelda", "yuumi", "zelda");
        intermediateExample2
                .distinct()
                .forEach(System.out::println);
        System.out.println("\n");

        // -------------- limit & skip
        Stream<Integer> infiniteStream3 = Stream.iterate(1, n -> n+1);
        infiniteStream3
                .skip(5)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("\n");

        // -------------- map String to Integer
        Stream<String> intermediateExample3 = Stream.of("sonic", "mario", "yoshi", "zelda", "yuumi", "rin");
        intermediateExample3
                .map(String::length)
                .forEach(System.out::println);
        System.out.println("\n");

        // -------------- flatMap
        List<String> zero = Arrays.asList("");
        List<String> one = Arrays.asList("bonobo1");
        List<String> two = Arrays.asList("bonobo2","bonobo3");
        Stream<List<String>> intermediateExample4 = Stream.of(zero, one, two);
        intermediateExample4
                .flatMap(l -> l.stream())
                .forEach(System.out::println);
        System.out.println("\n");

        // -------------- sorted
        Stream<String> intermediateExample5 = Stream.of("sonic", "mario", "yoshi", "zelda", "yuumi", "rin");
        intermediateExample5
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("\n");


    }
}
