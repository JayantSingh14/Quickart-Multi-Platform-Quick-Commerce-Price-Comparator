package net.jpountz.xxhash;

import android.support.v4.media.b;
import java.io.Closeable;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public abstract class StreamingXXHash32 implements Closeable, AutoCloseable {
    final int seed;

    /* loaded from: classes3.dex */
    public interface Factory {
        StreamingXXHash32 newStreamingHash(int i2);
    }

    public StreamingXXHash32(int i2) {
        this.seed = i2;
    }

    public final Checksum asChecksum() {
        return new Checksum() { // from class: net.jpountz.xxhash.StreamingXXHash32.1
            @Override // java.util.zip.Checksum
            public long getValue() {
                return StreamingXXHash32.this.getValue() & 268435455;
            }

            @Override // java.util.zip.Checksum
            public void reset() {
                StreamingXXHash32.this.reset();
            }

            public String toString() {
                return StreamingXXHash32.this.toString();
            }

            @Override // java.util.zip.Checksum
            public void update(int i2) {
                StreamingXXHash32.this.update(new byte[]{(byte) i2}, 0, 1);
            }

            @Override // java.util.zip.Checksum
            public void update(byte[] bArr, int i2, int i3) {
                StreamingXXHash32.this.update(bArr, i2, i3);
            }
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public abstract int getValue();

    public abstract void reset();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(seed=");
        return b.o(sb, this.seed, ")");
    }

    public abstract void update(byte[] bArr, int i2, int i3);
}
