package tech.insight.set;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Max
 * @description
 * @date 2025/6/17 19:48
 */
public class BufferedFileInputStream extends InputStream {

    private final byte[] buffer = new byte[1024];

    private final FileInputStream fis;

    private int position = -1;

    private int capacity = -1;

    public BufferedFileInputStream(FileInputStream fis) {
        this.fis = fis;
    }

    @Override
    public int read() throws IOException {
        if(buffCanRead()){
            return readFromBuffer();
        }
        refreshBuffer();
        if(!buffCanRead()){
            return -1;
        }
        return readFromBuffer();
    }

    private int readFromBuffer() {
        return buffer[position++] & 0xFF;
    }

    private void refreshBuffer() throws IOException {
        capacity = fis.read(buffer);
        position = 0;
    }

    private boolean buffCanRead() {
        if(capacity == -1)
            return false;
        if(position == capacity)
            return false;
        return true;
    }

    @Override
    public void close() throws IOException {
        fis.close();
    }
}
