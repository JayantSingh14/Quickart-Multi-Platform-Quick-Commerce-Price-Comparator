package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash64;

/* loaded from: classes3.dex */
final class StreamingXXHash64JNI extends StreamingXXHash64 {
    private long state;

    public static class Factory implements StreamingXXHash64.Factory {
        public static final StreamingXXHash64.Factory INSTANCE = new Factory();

        @Override // net.jpountz.xxhash.StreamingXXHash64.Factory
        public StreamingXXHash64 newStreamingHash(long j2) {
            return new StreamingXXHash64JNI(j2);
        }
    }

    public StreamingXXHash64JNI(long j2) {
        super(j2);
        this.state = XXHashJNI.XXH64_init(j2);
    }

    private void checkState() {
        if (this.state == 0) {
            throw new AssertionError("Already finalized");
        }
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.state != 0) {
            super.close();
            XXHashJNI.XXH64_free(this.state);
            this.state = 0L;
        }
    }

    public synchronized void finalize() throws Throwable {
        super.finalize();
        long j2 = this.state;
        if (j2 != 0) {
            XXHashJNI.XXH64_free(j2);
            this.state = 0L;
        }
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public synchronized long getValue() {
        checkState();
        return XXHashJNI.XXH64_digest(this.state);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public synchronized void reset() {
        checkState();
        XXHashJNI.XXH64_free(this.state);
        this.state = XXHashJNI.XXH64_init(this.seed);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public synchronized void update(byte[] bArr, int i2, int i3) {
        checkState();
        XXHashJNI.XXH64_update(this.state, bArr, i2, i3);
    }
}
