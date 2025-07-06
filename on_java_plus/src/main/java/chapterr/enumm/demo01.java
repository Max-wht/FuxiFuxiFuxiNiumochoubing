package chapterr.enumm;

/**
 * @author Max
 * @description
 * @date 2025/7/4 10:06
 */
enum CharacterType { A , B , C }

public class demo01 {
    //ENUM 基本方法 valueOf() -> 获取当前枚举类的名字
    public static void main(String[] args) {
        for (CharacterType type : CharacterType.values()) {
            // 输出枚举类型的名称和序号
            System.out.println( type + " ordinal: " + type.ordinal() + " name: " + type.name());
            // 比较枚举类型的序号
            System.out.println( type.compareTo(CharacterType.B) );
            System.out.println("****************");
        }

        for (String s : "A B C".split(" ")) {
            CharacterType type =
                    CharacterType.valueOf(CharacterType.class,s); // 将字符串转换为枚举类型
            System.out.println("CharacterType.valueOf: " + type);
        }

    }
}
