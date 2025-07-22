package tech.insight;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * @author Max
 * @description :Spring应用上下文类，用于管理Bean的生命周期和依赖注入
 * @date 2025/6/27 19:28
 */
public class ApplicaitonContext {

    public ApplicaitonContext(String scanPackagePath) {
        init(scanPackagePath);
    }


    public void createBean() {

    }

    private List<Class<?>> scanPackage(String scanPackagePath) throws IOException {
        // 扫描指定包路径下的类
        URL resource = this.getClass().getResource(scanPackagePath.replace(".", File.separator));
        Path path = Path.of(resource.getPath());
        Files.walkFileTree(path, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                Path absolutePath = file.toAbsolutePath();
                if(absolutePath.toString().endsWith(".class")) {
                    String className = absolutePath.toString()
                            .replace(path.toString() + File.separator, "")
                            .replace(File.separator, ".")
                            .replace(".class", "");
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void getBean() {

    }

    private void init(String scanPackagePath) {

    }
}
