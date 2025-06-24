package tech.insight.chain;

import tech.insight.chain.annotation.Length;
import tech.insight.chain.annotation.Max;
import tech.insight.chain.annotation.Min;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:06
 */
public class User {

    @Length(4)
    private final String name;
    @Max(100)
    @Min(0)
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
