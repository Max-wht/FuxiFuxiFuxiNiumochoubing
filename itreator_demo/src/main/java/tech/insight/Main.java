package tech.insight;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Max
 * @description 提取demo.user文件中的对象
 * @date 2025/6/18 19:27
 */
public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\JavaWeb\\FuxiFuxiFuxiNiumochoubing\\itreator_demo\\demo.user");
        UserFile userFile = new UserFile(file);
        for (User user : userFile) {
            System.out.println(user);
        }
    }
}
