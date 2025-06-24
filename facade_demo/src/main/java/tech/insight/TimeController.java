package tech.insight;

import org.springframework.web.bind.annotation.*;
import tech.insight.plugin.MyPlugin;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Max
 * @description
 * @date 2025/6/22 17:12
 */

@RestController
@RequestMapping()
public class TimeController {

    MyPlugin myPlugin;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/time")
    public String getTime() {
        if (myPlugin != null) {
            myPlugin.beforeGetTime();
        } else {
            System.out.println("No plugin loaded");
        }
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    @PostMapping("loadPlugin")
    public String loadPlugin(@RequestBody String path) {
        File jarFile = new File(path.substring(1, path.length() - 1));
        System.out.println(path);
        try (URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toPath().toUri().toURL()});
             InputStream nameFileInputStream = classLoader.getResourceAsStream("pluginName.plug")) {
            byte[] bytes = nameFileInputStream.readAllBytes();
            String myPluginFillName = new String(bytes);
            Class<?> clazz = classLoader.loadClass(myPluginFillName.trim());
            Constructor<?> constructor = clazz.getConstructor();
            myPlugin = (MyPlugin) constructor.newInstance();
            return "success"+ clazz.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
