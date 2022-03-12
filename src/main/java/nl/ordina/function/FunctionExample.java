package nl.ordina.function;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@AllArgsConstructor
class Person {
    private String firstname;
    private String surname;
    private Integer age;

}

@FunctionalInterface
interface AgeRetriever {
    Integer age(final Person person);
}

public class FunctionExample {

    private static Integer retrieveAge(final Person person) {
        return person.getAge();
    }

    public static void main(final String[] args) {

        final Person ron = new Person("Ron", "Ronson", 24);
        final Person jan = new Person("Jan", "Janson", 65);
        final Person niels = new Person("Niels", "Holgerson", 28);
        final Person kate = new Person("Kate", "Daniels", 18);
        final Person renesme = new Person("Renesme", "Cullins", 18);

        final List<Person> persons = List.of(ron, jan, niels, kate, renesme);

        final Function<Person, Integer> age = person -> person.getAge();

        final Function<Person, Integer> age2 = Person::getAge;

        final AgeRetriever leeftijd = Person::getAge;

        //Used as inline function
        System.out.println(age.apply(kate));
        System.out.println(age2.apply(kate));
        System.out.println(leeftijd.age(renesme));

        //In lambda for
        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(final Person person) {
                System.out.println(age.apply(person));
            }
        });

        //single method
        persons.forEach(person -> retrieveAge(person));

        //single method
        persons.forEach(FunctionExample::retrieveAge);

        //Function
        persons.forEach(age::apply);

        //In Lambda stream
        //1. map accepts a Function... What does map do?
        //2. then do the print
        persons.stream()
               .map(age)
               .forEach(System.out::println);



    }
}
