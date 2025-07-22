package chapterr.enumm;

import chapterr.enumm.utils.Enums;

/**
 * @author Max :qqq
 * @description
 * @date 2025/7/4 10:06
 */
enum CharacterType { A , B , C }

public class demo01{
    //ENUM 基本方法 valueOf() -> 根据传入的String 返回和String匹配的枚举类
    public static void main(String[] args) {

        for (CharacterType type : CharacterType.values()) {
            // 输出枚举类型的名称和序号
            System.out.println( type + " ordinal: " + type.ordinal() + " name: " + type.name());
            // 比较枚举类型的序号
            System.out.println( type.compareTo(CharacterType.B) );
        }
        System.out.println("****************");

        for (String s : "A B C".split(" ")) {
            CharacterType type =
                    CharacterType.valueOf(CharacterType.class,s); // 将字符串转换为枚举类型
            System.out.println("CharacterType.valueOf: " + type);
        }
        System.out.println("****************");

        for (CharacterType type : CharacterType.values()) {
            System.out.println("DeclaringClass is " + type.getDeclaringClass());
            System.out.println("Class is" + type.getClass());
            System.out.println("ordinal is " + type.ordinal());
            System.out.println("hashCode is " + type.hashCode());
            System.out.println("getClass is " + type.getClass());
            System.out.println("--------------------");
        }
        System.out.println("****************");

        for (int i = 0; i < 4; i++) {
            System.out.println(Enums.ramdom(CharacterType.class) + " ");
        }
    }
}
