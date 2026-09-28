package net.jpountz.xxhash;

import android.support.v4.media.b;
import java.io.Closeable;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public abstract class StreamingXXHash64 implements Closeable, AutoCloseable {
    final long seed;

    /* loaded from: classes3.dex */
    public interface Factory {
        StreamingXXHash64 newStreamingHash(long j2);
    }

    public StreamingXXHash64(long j2) {
        this.seed = j2;
    }

    public final Checksum asChecksum() {
        return new Checksum() { // from class: net.jpountz.xxhash.StreamingXXHash64.1
            @Override // java.util.zip.Checksum
            public long getValue() {
                return StreamingXXHash64.this.getValue();
            }

            @Override // java.util.zip.Checksum
            public void reset() {
                StreamingXXHash64.this.reset();
            }

            public String toString() {
                return StreamingXXHash64.this.toString();
            }

            @Override // java.util.zip.Checksum
            public void update(int i2) {
                StreamingXXHash64.this.update(new byte[]{(byte) i2}, 0, 1);
            }

            @Override // java.util.zip.Checksum
            public void update(byte[] bArr, int i2, int i3) {
                StreamingXXHash64.this.update(bArr, i2, i3);
            }
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public abstract long getValue();

    public abstract void reset();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(seed=");
        return b.p(sb, this.seed, ")");
    }

    public abstract void update(byte[] bArr, int i2, int i3);
}
