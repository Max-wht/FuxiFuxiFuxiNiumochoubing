package tech.insight.mp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.insight.mp.service.TechManagerService;

@RestController
@RequestMapping("/techManager")
@RequiredArgsConstructor
public class TechManagerController {
    @Autowired
    private final TechManagerService techManagerService;

    /**
     * Excel导入接口
     */
    @PostMapping("/importExcel")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        return techManagerService.importFromExcel(file);
    }
} 