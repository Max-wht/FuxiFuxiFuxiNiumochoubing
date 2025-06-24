package tech.insight;

import org.springframework.stereotype.Component;

/**
 * @author Max
 * @description
 * @date 2025/6/22 20:16
 */
@Component
@UserState(UserType.NORMAL)
public class NormalCustomerService implements CoustomerService{
    @Override
    public String findCustomer() {
        System.out.println("普通用户");
        return "普通用户";
    }
}
