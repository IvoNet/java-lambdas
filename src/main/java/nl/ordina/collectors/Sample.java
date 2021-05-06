package nl.ordina.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * public interface Collector<T, A, R> {
 * Supplier<A> supplier();
 * BiConsumer<A, T> accumulator();
 * Function<A, R> finisher();
 * BinaryOperator<A> combiner();
 * Set<Characteristics> characteristics();
 * }
 * T is the type of items in the stream to be collected
 * A is the type of the accumulator
 * R is the type of the result returned by the collector
 */



public class Sample {

    public static void main(String[] args) {
        //toList
        final List<Integer> numbers = IntStream.range(1, 25)
                                               .boxed()
                                               .collect(toList());
        System.out.println("numbers = " + numbers);


        //toMap
        final Map<String, Integer> map = IntStream.range(1, 25)
                                                  .boxed()
                                                  .collect(toMap(o -> String.format("KEY%s", o),
                                                                 integer -> integer));
        System.out.println("map = " + map);

        //joining
        final String numberStr = IntStream.range(1, 25)
                                          .boxed()
                                          .map(String::valueOf)
                                          .collect(joining("/", "pre-", "-post"));

        System.out.println("numberStr = " + numberStr);


        //counting
        final Long total = IntStream.range(1, 2222)
                                    .boxed()
                                    .collect(counting());  //can be done even shorter!

        System.out.println("total = " + total);


        //summary
        final IntSummaryStatistics summary = IntStream.range(1, 2222)
                                                      .boxed()
                                                      .collect(summarizingInt(Integer::intValue));

        System.out.println("summary.getSum() = " + summary.getSum());
        System.out.println("summary.getMax() = " + summary.getMax());
        System.out.println("summary.getMin() = " + summary.getMin());
        System.out.println("summary.getCount() = " + summary.getCount());
        System.out.println("summary.getAverage() = " + summary.getAverage());

        //groupby
        final Map<Boolean, List<Integer>> grouped = IntStream.range(1, 42)
                                                             .boxed()
                                                             .collect(groupingBy(integer -> (integer < 10 || integer > 20),
                                                                                 toList()));
        System.out.println("grouped inclusive = " + grouped.get(true));
        System.out.println("grouped exclusive = " + grouped.get(false));



    }

}
