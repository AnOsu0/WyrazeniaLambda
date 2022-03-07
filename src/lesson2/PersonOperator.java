package lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class PersonOperator {
    public static void main(String[] args) {

        String[] firstNames = {"Jan", "Karol", "Paweł","Andrzej"};
        String[] lastNames = {"Abacki", "Kowalski", "Zalewski", "Korzeniewski"};
        int[] ages = {17,39,54, 66};
        Random random = new Random();
        Supplier<Person> makePerson = () ->
                new Person(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)],ages[random.nextInt(ages.length)]);

        List<Person> people = supplierList(makePerson,10);
//        people.add(new Person("Jan", "Kowalski", 42));
//        people.add(new Person("Kasia", "Kruczkowska", 22));
//        people.add(new Person("Piotr", "Adamiak", 15));
//        people.add(new Person("Jan", "Zawadzki", 17));
//        people.add(new Person("Krzysztof", "Wojtyniak", 16));
//        people.add(new Person("Agnieszka", "Zagumna", 18));
//        people.add(new Person("Basia", "Cyniczna", 28));

            Consumer<Person> changeAge = p -> p.setAge(p.getAge()+1);
            Consumer<Person> printPeople = p -> System.out.println(p);
        System.out.println(">>> people");
        consumeList(people,printPeople);
        System.out.println(">>> people age + 1");
        consumeList(people,changeAge);
        consumeList(people,printPeople);


        List<Person> adults = predicateList(people, p -> p.getAge()>18);
        System.out.println(">>adults");
        consumeList(adults,printPeople);
        List<Person> jan = predicateList(people,p -> p.getFirstName().equals("Jan"));
        System.out.println(">>Janowie");
        consumeList(jan,printPeople);
        List<String> firstNames1 = functionList(people, p -> p.getFirstName());
        System.out.println(">> Imiona");
        consumeList(firstNames1,s -> System.out.println(s));


    }


    private static<T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private static <T> List<T> predicateList (List<T> list, Predicate<T> predicate ){
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t))
                newList.add(t);
        }
        return newList;
    }

    private static <T,R> List<R> functionList (List<T> list, Function<T,R> func){
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(func.apply(t));
        }
        return newList;
    }

    private static <T> List<T> supplierList (Supplier<T> supplier, int elements){
        List<T> newList = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            newList.add(supplier.get());
        }
        return newList;
    }
}
