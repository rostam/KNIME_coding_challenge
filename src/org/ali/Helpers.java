package org.ali;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Helpers {
//    public <T extends Number> List<T> negate(List<T> a) {
//        return a.stream().map(new Function<T, T>() {
//            @Override
//            public T apply(T t) {
//                if(t.getClass() == Integer.class) return (T) -t.intValue();
//                T tt = (T)-1;return t * -1;
//            }).collect(Collectors.toList());
//    }

    public static List<String> Capitalize(List<String> s) {
        return s.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("example1_strings.txt"));
        ArrayList<String> ls = new ArrayList<>();
        while(sc.hasNext()) {
            ls.add(sc.next());
        }
        for(String s : Capitalize(ls))
            System.out.println(s);

        System.out.println(new StringBuilder("hi hi").reverse());
    }
}
