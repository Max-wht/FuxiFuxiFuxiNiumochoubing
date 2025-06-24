package tech.insight.set;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Max
 * @description
 * @date 2025/6/17 20:02
 */
public class RecodingFileInputStream extends InputStream {

    private final FileInputStream fis;

    private int recodedCount;

    public RecodingFileInputStream(FileInputStream fis) {
        this.fis = fis;
        recodedCount = 0;
    }

    @Override
    public int read() throws IOException {
        int i = fis.read();
        if (i != -1)
            recodedCount++;
        return i;
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    public int getRecodedCount() {
        return recodedCount;
    }
}
