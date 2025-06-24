package tech.insight;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Max
 * @description
 * @date 2025/6/24 14:47
 */
public class BufferPool {

    private final int totalSize;
    private final int slot;
    private int freeSize;
    private final Deque<ByteBuffer> slotQueue = new ArrayDeque<>();
    public BufferPool (int  totalSize, int slot) {
        this.totalSize = totalSize;
        this.slot = slot;
        freeSize = totalSize;
    }
}
