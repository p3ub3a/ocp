package playground;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Set<Number> numbers = new HashSet<>();

        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(null);
        numbers.add(new Integer(86));
        numbers.add(309L);
//        numbers.add(39L);
        Iterator iter = numbers.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        Main main = new Main();
        TreeSet<Main> tree = new TreeSet<>();



        Optional <Double> o1 = Optional.of(14.5);
        o1.orElseGet(Math::random);
        o1.orElseThrow(IllegalStateException::new);
    }
}
