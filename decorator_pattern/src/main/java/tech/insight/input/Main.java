package tech.insight.input;

import java.util.HashSet;

/**
 * @author Max
 * @description
 * @date 2025/6/17 19:13
 */
public class Main {
    public static void main(String[] args) {

        HistorySet<String> set = new HistorySet<>(new HashSet<>());
        HistorySet<String> strings = new HistorySet<>(set);
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.remove("1");
        System.out.println(strings);
    }
}
