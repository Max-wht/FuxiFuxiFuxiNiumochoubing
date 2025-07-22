package chapterr.enumm;


import chapterr.enumm.utils.Enums;

/**
 * @author Max
 * @description
 * @date 2025/7/4 12:14
 */
interface Security{}

enum SecurityCategory{
    STOCK(SecurityCategory.Stock.class),
    BOND(SecurityCategory.Bond.class);

    Security[] values;

    enum Stock implements Security {
        SHORT, LONG, MARGIN
    }
    enum Bond implements Security {
        MUNICIPAL, JUNK
    }

    //为什么<? extends Security>会被认为是一个枚举类
    SecurityCategory (Class<? extends Security> clazz){
        if (!clazz.isEnum()) {
            System.out.println("bs");
        }
        values = clazz.getEnumConstants();
    }
    public Security randomSelection(){
        return Enums.ramdom(values);
    }

}
public class demo05 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (SecurityCategory s : SecurityCategory.values()){
                Security se = s.randomSelection();
                System.out.println(se.toString());
            }
        }
    }
}
