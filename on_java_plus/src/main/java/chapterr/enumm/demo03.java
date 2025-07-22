package chapterr.enumm;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Max
 * @description
 * @date 2025/7/4 10:49
 */
enum Explore { HERE , ThERE}

public class demo03 {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("Analyzing " + enumClass.getName());
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base :" + enumClass.getSuperclass());
        System.out.println("Methods");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println(
                "Explore.containsAll(enumMethods) ?" + exploreMethods.containsAll(enumMethods)
        );
        System.out.print("Explore.removeAll(enumMethods) :");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);


    }

}
