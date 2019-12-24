package playground;

import playground.pojo.GenericClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class PlayWithFI {
    public static void main(String args[]){
        //               Functional interfaces

        //Supplier<T>    /    public T get();
        Supplier<GenericClass> s1 = () ->
            new GenericClass("a1","a2");

        System.out.println(s1.get());

        Supplier<ArrayList<GenericClass>> s2 = ArrayList::new;
        System.out.println(s2.get());

        //Consumer<T>    /    public void accept(T t)
        //BiConsumer<T, U>    /    public void accept(T t, U u)
        Consumer<GenericClass> c1 = System.out::println;
        c1.accept(s1.get());

        Map<String, GenericClass> m1 = new HashMap<>();
        BiConsumer<String, GenericClass> bc1 = m1::put;
        bc1.accept("gc1", s1.get());
        System.out.println(m1);

        // Predicate<T>   /     public boolean test(T t)
        // BiPredicate<T, U>   /     public boolean test(T t, U u)
        Predicate<ArrayList<GenericClass>> p1 = ArrayList::isEmpty;
        Predicate p2 = s1.get()::equals;
        System.out.println(p1.test(s2.get()));

        BiPredicate<String, String> bp1 = String::startsWith;
        System.out.println(bp1.test("123456","124"));

        //Function<T, R>    /     public R apply(T t)
        //BiFunction<T, U, R>    /     public R apply(T t, U u)
        Function<String, Integer> f1 = String::length;
        System.out.println("string length: " + f1.apply("crimson"));

        BiFunction<String,String,String> bf1 = String::concat;
        System.out.println(bf1.apply("crimson", " flower"));

        //UnaryOperator<T, T>    /    public T apply(T t);
        //BinaryOperator<T, T>    /    public T apply(T t, T t);
        UnaryOperator<String> uo1 = String::toUpperCase;
        System.out.println(uo1.apply("hey"));

        BinaryOperator<Integer> bo1 = Integer::max;
        System.out.println(bo1.apply(5,9));

    }
}
