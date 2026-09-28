package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash32;

/* loaded from: classes3.dex */
final class StreamingXXHash32JNI extends StreamingXXHash32 {
    private long state;

    public static class Factory implements StreamingXXHash32.Factory {
        public static final StreamingXXHash32.Factory INSTANCE = new Factory();

        @Override // net.jpountz.xxhash.StreamingXXHash32.Factory
        public StreamingXXHash32 newStreamingHash(int i2) {
            return new StreamingXXHash32JNI(i2);
        }
    }

    public StreamingXXHash32JNI(int i2) {
        super(i2);
        this.state = XXHashJNI.XXH32_init(i2);
    }

    private void checkState() {
        if (this.state == 0) {
            throw new AssertionError("Already finalized");
        }
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.state != 0) {
            super.close();
            XXHashJNI.XXH32_free(this.state);
            this.state = 0L;
        }
    }

    public synchronized void finalize() throws Throwable {
        super.finalize();
        long j2 = this.state;
        if (j2 != 0) {
            XXHashJNI.XXH32_free(j2);
            this.state = 0L;
        }
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public synchronized int getValue() {
        checkState();
        return XXHashJNI.XXH32_digest(this.state);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public synchronized void reset() {
        checkState();
        XXHashJNI.XXH32_free(this.state);
        this.state = XXHashJNI.XXH32_init(this.seed);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public synchronized void update(byte[] bArr, int i2, int i3) {
        checkState();
        XXHashJNI.XXH32_update(this.state, bArr, i2, i3);
    }
}
