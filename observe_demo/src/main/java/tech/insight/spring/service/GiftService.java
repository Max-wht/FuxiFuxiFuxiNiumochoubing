package tech.insight.spring.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tech.insight.spring.event.RegisterEvent;

/**
 * @author Max
 * @description
 * @date 2025/6/23 19:26
 */
@Service
public class GiftService{

    @EventListener
    public void onRegisterEvent(RegisterEvent  event){
        String user = event.getUser();
        System.out.println("GiftService.onRegisterEvent user:" + user);
    }
}
