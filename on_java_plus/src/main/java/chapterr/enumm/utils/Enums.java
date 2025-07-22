package chapterr.enumm.utils;

import java.util.Random;

/**
 * @author Max
 * @description
 * @date 2025/7/4 11:54
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T ramdom(Class<T> ec) {
        return ramdom(ec.getEnumConstants());
    }
    public static <T> T ramdom(T[] t) {
        return t[rand.nextInt(t.length)];
    }
}
