package net.jpountz.xxhash;

/* loaded from: classes.dex */
abstract class AbstractStreamingXXHash32Java extends StreamingXXHash32 {
    int memSize;
    final byte[] memory;
    long totalLen;
    int v1;
    int v2;
    int v3;
    int v4;

    public AbstractStreamingXXHash32Java(int i2) {
        super(i2);
        this.memory = new byte[16];
        reset();
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public void reset() {
        int i2 = this.seed;
        this.v1 = 606290984 + i2;
        this.v2 = (-2048144777) + i2;
        this.v3 = i2;
        this.v4 = i2 - (-1640531535);
        this.totalLen = 0L;
        this.memSize = 0;
    }
}
