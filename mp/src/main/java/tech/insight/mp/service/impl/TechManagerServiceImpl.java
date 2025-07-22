package tech.insight.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.insight.mp.entity.TechManager;
import tech.insight.mp.mapper.TechManagerMapper;
import tech.insight.mp.service.TechManagerService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 技术经理人服务实现类
 */
@Slf4j
@Service
public class TechManagerServiceImpl extends ServiceImpl<TechManagerMapper, TechManager> implements TechManagerService {
    @Override
    public String importFromExcel(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return "文件为空，无法导入";
        }
        String fileName = file.getOriginalFilename();
        if (fileName == null || (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls"))) {
            return "文件格式不正确，请上传Excel文件(.xlsx或.xls)";
        }
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook;
            if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = WorkbookFactory.create(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            List<TechManager> techManagers = new ArrayList<>();
            int successCount = 0;
            int errorCount = 0;
            // 从第二行开始读取数据（第一行是标题）
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                try {
                    TechManager techManager = parseRow(row);
                    if (techManager != null) {
                        techManagers.add(techManager);
                        successCount++;
                    } else {
                        errorCount++;
                    }
                } catch (Exception e) {
                    log.error("解析第{}行数据时出错: {}", i + 1, e.getMessage());
                    errorCount++;
                }
            }
            // 批量保存数据
            if (!techManagers.isEmpty()) {
                boolean saveResult = saveBatch(techManagers);
                if (saveResult) {
                    return String.format("导入完成！成功导入%d条数据，失败%d条数据", successCount, errorCount);
                } else {
                    return "数据保存失败;";
                }
            } else {
                return "没有有效数据需要导入;";
            }
        } catch (IOException e) {
            log.error("读取Excel文件失败", e);
            return "读取文件失败: " + e.getMessage();
        } catch (Exception e) {
            log.error("导入Excel文件时发生错误", e);
            return "导入失败: " + e.getMessage();
        }
    }

    @Override
    public boolean saveBatch(List<TechManager> techManagers) {
        if (techManagers == null || techManagers.isEmpty()) {
            return false;
        }
        return super.saveBatch(techManagers);
    }

    /**
     * 解析Excel行数据
     * @param row Excel行
     * @return TechManager对象
     */
    private TechManager parseRow(Row row) {
        TechManager techManager = new TechManager();
        // 读取序号（第一列），通常不导入数据库
        // Cell idCell = row.getCell(0);

        // 读取姓名（第二列）
        Cell nameCell = row.getCell(1);
        if (nameCell != null) {
            String name = getCellValueAsString(nameCell);
            if (name != null && !name.trim().isEmpty()) {
                techManager.setName(name.trim());
            }
        }
        // 读取电子邮箱（第三列）
        Cell emailCell = row.getCell(2);
        if (emailCell != null) {
            String email = getCellValueAsString(emailCell);
            if (email != null && !email.trim().isEmpty()) {
                techManager.setEmail(email.trim());
            }
        }
        // 读取专业（第四列）
        Cell majorCell = row.getCell(3);
        if (majorCell != null) {
            String major = getCellValueAsString(majorCell);
            if (major != null && !major.trim().isEmpty()) {
                techManager.setMajor(major.trim());
            }
        }
        // 读取擅长领域（第五列）
        Cell areaCell = row.getCell(4);
        if (areaCell != null) {
            String area = getCellValueAsString(areaCell);
            if (area != null && !area.trim().isEmpty()) {
                techManager.setArea(area.trim());
            }
        }
        // 至少要有姓名才能算有效数据
        if (techManager.getName() != null && !techManager.getName().isEmpty()) {
            return techManager;
        }
        return null;
    }

    /**
     * 获取单元格值作为字符串
     * @param cell 单元格
     * @return 字符串值
     */
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == (long) numericValue) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return String.valueOf(numericValue);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
} 