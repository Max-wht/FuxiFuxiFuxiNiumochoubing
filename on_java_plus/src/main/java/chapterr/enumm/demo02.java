package chapterr.enumm;

/**
 * @author Max
 * @description
 * @date 2025/7/4 10:20
 */

enum OnWitch {
    WEST("西方"),
    EAST("东方"),
    SOUTH("南方"),
    NORTH("北方");
    private String description;
    OnWitch(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
public class demo02 {
    public static void main(String[] args) {
        for (OnWitch with : OnWitch.values()) {
            // 输出枚举类型的名称和序号
            System.out.println(with + " ordinal: " + with.ordinal() + " name: " + with.name());
            // 比较枚举类型的序号
            System.out.println(with.compareTo(OnWitch.EAST));
            // 输出描述信息
            System.out.println("Description: " + with.getDescription());
        }
    }

}
