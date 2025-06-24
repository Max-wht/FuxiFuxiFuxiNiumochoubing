package tech.insight.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Max
 * @description
 * @date 2025/6/17 20:10
 */

@RestController
@RequestMapping("/api")
public class MyController {

    @PostMapping
    public Map<String, Object> getData(@RequestBody Map<String, Object> json) {
        return json;
    }
}
