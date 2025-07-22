package chapterr.enumm;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Max
 * @description
 * @date 2025/7/4 11:36
 */
enum CartoonCharactor implements Supplier<CartoonCharactor> {
    SLAPPY,
    SPANKY,
    PUNCHY,
    SILLY;

    private Random random = new Random(47);
    @Override
    public CartoonCharactor get() {
        return CartoonCharactor.values()[random.nextInt(values().length)];
    }
}

public class demo04 {
    public static <T> void printNext(Supplier<T> rg) {
        System.out.println(rg.get());
    }

    public static void main(String[] args) {
        CartoonCharactor c = CartoonCharactor.SLAPPY;
        for (int i = 0; i < 10; i++) {
            printNext(c);
        }
    }
}
