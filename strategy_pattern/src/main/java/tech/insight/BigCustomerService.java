package tech.insight;

import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Max
 * @description
 * @date 2025/6/22 20:16
 */
@Component
@UserState(UserType.BIG)
public class BigCustomerService implements CoustomerService{
    @Override
    public String findCustomer() {
        System.out.println("大用户");
        return "大用户";
    }
}
