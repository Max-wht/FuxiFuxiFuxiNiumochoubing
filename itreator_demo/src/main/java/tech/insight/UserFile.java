package tech.insight;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:09
 */
public class UserFile implements Iterable<User>{

    private final File file;

    public UserFile(File file) {
        this.file = file;
    }

    @Override
    public Iterator<User> iterator() {
        return new UserFileIterator();
    }

    class UserFileIterator implements Iterator<User> {

        List<User> userList = loadUsersFromFile(file);

        int cursor = 0;

        private List<User> loadUsersFromFile(File file) {
            try {
                return Files.readAllLines(file.toPath()).stream().map(line -> {
                    line = line.substring(1, line.length() - 1);
                    String[] split = line.split(",");
                    return new User(split[0], Integer.parseInt(split[1]));
                }).collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor != userList.size();
        }

        @Override
        public User next() {
            if (cursor >= userList.size()) {
                throw new RuntimeException("no more user");
            }
            int currentCursor = cursor;
            cursor++;
            return userList.get(currentCursor);
        }
    }
}
