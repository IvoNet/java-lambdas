package nl.ordina.supplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Sample {
    public static void main(String[] args) {
        final Supplier<String> localDateTimeSupplier = () -> DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                                                      .format(LocalDateTime.now());



        System.out.println(localDateTimeSupplier.get());

    }

}
