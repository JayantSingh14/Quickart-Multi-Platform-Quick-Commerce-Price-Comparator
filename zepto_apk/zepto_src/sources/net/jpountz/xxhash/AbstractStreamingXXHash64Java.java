package net.jpountz.xxhash;

/* loaded from: classes.dex */
abstract class AbstractStreamingXXHash64Java extends StreamingXXHash64 {
    int memSize;
    final byte[] memory;
    long totalLen;
    long v1;
    long v2;
    long v3;
    long v4;

    public AbstractStreamingXXHash64Java(long j2) {
        super(j2);
        this.memory = new byte[32];
        reset();
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public void reset() {
        long j2 = this.seed;
        this.v1 = 6983438078262162902L + j2;
        this.v2 = (-4417276706812531889L) + j2;
        this.v3 = j2;
        this.v4 = j2 - (-7046029288634856825L);
        this.totalLen = 0L;
        this.memSize = 0;
    }
}
