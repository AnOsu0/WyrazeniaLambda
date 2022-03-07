package lesson1;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Functions {
    public static void main(String[] args) {
        String original = "   WIELKI NAPIS   ";
        Function<String,String> func = s -> s.toLowerCase().trim();
        String changed = func.apply(original);
        System.out.println(changed);

        Consumer<String> cons = s -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(s);
            }
        };

        cons.accept(original);

        int personAge = 20;
        Predicate<Integer> isAdult = i -> i>=18;
        boolean test = isAdult.test(personAge);
        System.out.println(test);


        String[] firstNames = {"Jan", "Karol", "Paweł"};
        String[] lastNames = {"Abacki", "Kowalski", "Zalewski"};
        int[] ages = {20,39,54};
        Random random = new Random();
        Supplier<Person> makePerson = () -> new Person(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)],ages[random.nextInt(ages.length)]);
        Person person = makePerson.get();
        System.out.println(person);

    }

//    static String lowerCaseTrim (String source){
//        return source.toLowerCase().trim();
//    }
}
