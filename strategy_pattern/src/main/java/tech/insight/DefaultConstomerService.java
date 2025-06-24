package tech.insight;

import org.springframework.stereotype.Component;

/**
 * @author Max
 * @description
 * @date 2025/6/22 22:43
 */
@Component
public class DefaultConstomerService implements CoustomerService{
    @Override
    public String findCustomer() {
        return "默认处理器：无对应类型";
    }
}
