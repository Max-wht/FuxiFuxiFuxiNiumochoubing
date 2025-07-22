package tech.insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Max
 * @description
 * @date 2025/6/22 20:15
 */

@RestController
public class CoustomerController {

    @Autowired
    private DefaultConstomerService defaultConstomerService;

    private Map<UserType,CoustomerService> coustomerServiceMap;


    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable("recharge") int recharge){
        UserType userType = UserType.matches(recharge);
        return coustomerServiceMap.getOrDefault(userType,defaultConstomerService).findCustomer();
    }

    //自动注入所有Coustomer策略
    @Autowired
    public void setCoustmerServiceMap(List<CoustomerService> coustomerServices){
        this.coustomerServiceMap = coustomerServices.stream()
                .filter(coustomerService -> coustomerService.getClass().isAnnotationPresent(UserState.class))
                .collect(Collectors.toMap(this::findUserType, Function.identity()));
    }

    private UserType findUserType(CoustomerService coustomerService){
        return coustomerService.getClass().getAnnotation(UserState.class).value();
    }
}
