package tech.insight.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import tech.insight.mp.entity.TechManager;

import java.util.List;

/**
 * 技术经理人服务接口
 */
public interface TechManagerService extends IService<TechManager> {
    
    /**
     * 从Excel文件导入数据
     * @param file Excel文件
     * @return 导入结果
     */
    String importFromExcel(MultipartFile file);
    
    /**
     * 批量保存数据
     * @param techManagers 数据列表
     * @return 保存结果
     */
    boolean saveBatch(List<TechManager> techManagers);
} 