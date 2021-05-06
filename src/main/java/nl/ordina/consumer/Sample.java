package nl.ordina.consumer;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Sample {
    public static void main(final String[] args) {
        final List<Integer> numbers = IntStream.range(1, 25)
                                               .boxed()
                                               .collect(toList());


        //External iterator
        //1. first we need to know what we are going to iterate over
        //2. then we need to instantiate a variable to count / index
        //3. then we have to find out to what size / length we need to iterate
        //   is that inclusive ("<=") or exclusive ("<")?
        //4. then we have to add 1 to every iteration
        //5. then in the loop we need to call the accessor method "get" so we
        //   have to know what method to call
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //External iterator
        //Better / easier because we do not have to do as much administrative work
        //1. Still ask not command though
        for (final Integer number : numbers) {
            System.out.println(number);
        }

        //Internal iterator
        //we are commanding the object to do it for itself
        //we do not need to know the implementation logic as that is the objects responsibility
        //The consumer is an anonymous class though and ugly as sin and in the end more code
        //then the former two examples...
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(final Integer integer) {
                System.out.println(integer);
            }
        });

        //Internal Iterator
        //The Consumer is a FunctionalInterface and the forEach needs a Consumer to work
        //This can be infered within lambda's by the compiler with the arrow notation
        //by adhering to the Consumer interface by providing one parameter and providing the accept logic
        //it will be able to infer the consumer from it.
        numbers.forEach((Integer integer) -> System.out.println(integer));

        //type inference in lambda expressions
        //As the 'numbers' is actially a List of Integers there can be nothing else in there
        //So the type reference can also be removed
        numbers.forEach((integer) -> System.out.println(integer));

        //parentheses are optional for single param lambdas
        numbers.forEach(integer -> System.out.println(integer));

        //method reference
        //as the integer in the example above will only be passed through and no other operations
        //are performed on it it can be done even shorter by method reference.
        //This is only possible if you do not want to manipulate the input
        numbers.forEach(System.out::println);


        //How about multiple params
        System.out.println(numbers.stream()
                                  .reduce(0, new BinaryOperator<Integer>() {
                                      @Override
                                      public Integer apply(final Integer integer,
                                                           final Integer integer2) {
                                          return integer + integer2;
                                      }
                                  }));

        // reduce it to a lambda expression
        System.out.println(numbers.stream()
                                  .reduce(0, (total, e) -> total + e));

        //reduce it to method reference
        System.out.println(numbers.stream()
                                  .reduce(0, Integer::sum));
    }
}
