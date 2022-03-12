package nl.ordina.predicate;

import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate in general meaning is a statement about something that is either true or false.
 * In programming, predicates represent single argument functions that return a boolean value.
 *
 * cd src/main/java
 * javac nl/ordina/Sample002Predicate.java
 * javap -v nl/ordina/Sample002Predicate.class
 */

class BiggerThanFive implements Predicate<Integer> {

    @Override
    public boolean test(final Integer integer) {
        return integer > 5;
    }
}

class EvenNumber implements Predicate<Integer> {

    @Override
    public boolean test(final Integer integer) {
        return integer % 2 == 0;
    }
}

public class PredicateExample {

    //make anonymous inner class to show what it will become...
    //use the javac to show anonymous vs lambda
    private static final Predicate<Integer> smallerThanThirty = value -> value < 30;

    public static void main(final String[] args) {

        final List<Integer> nums = List.of(48, 2, 3, 1, 5, 6, 7, 8, 9, 12);

        nums.stream()
            .filter(new BiggerThanFive()) //.and(new EvenNumber()).and(integer -> integer < 30))
            .filter(new EvenNumber())
            .filter(smallerThanThirty)
            .forEach(System.out::println);
    }
}
