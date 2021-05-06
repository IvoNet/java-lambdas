package nl.ordina.predicate;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateExample {


    public static void main(final String[] args) {
        final List<String> words = List.of("bicycle",
                                           "tree",
                                           "monkey",
                                           "nut",
                                           "knife",
                                           "iterator",
                                           "doggy",
                                           "cat",
                                           "Java",
                                           "friend",
                                           "summer");

        final BiPredicate<String, Integer> pred = (s, len) -> s.length() == len;

        words.stream()
             .filter(s -> pred.test(s, 3))
             .forEach(System.out::println);


    }


}
