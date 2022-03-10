package Example1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Example {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = makeList(() -> random.nextInt(1,100),10);
        consumeList(numbers, i -> System.out.print(i + " "));
        List<Integer> odd = predictList(numbers, i -> i % 2 != 0);
        System.out.println("\nLiczby niepodzielne przez 2");
        consumeList(odd,i -> System.out.print(i + " "));


    }

    private static <T> List<T> makeList (Supplier<T> sup, int elements){
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            result.add(sup.get());
        }
        return result;
    }

    private static <T> void  consumeList (List<T> list,Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private static <T> List<T> predictList (List<T> list, Predicate<T> predicate){
        ArrayList<T> result = new ArrayList<>();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.test(next)) {
                result.add(next);
            }
        }
        return result;
    }
}
