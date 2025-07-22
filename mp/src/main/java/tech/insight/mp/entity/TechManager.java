package tech.insight.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 技术经理人实体类
 */
@Data
@TableName("tech_manager")
public class TechManager {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 邮件
     */
    private String email;
    
    /**
     * 专业领域
     */
    private String major;
    
    /**
     * 擅长领域
     */
    private String area;
} 