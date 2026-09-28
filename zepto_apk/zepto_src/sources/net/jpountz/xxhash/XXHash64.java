package net.jpountz.xxhash;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class XXHash64 {
    public abstract long hash(ByteBuffer byteBuffer, int i2, int i3, long j2);

    public final long hash(ByteBuffer byteBuffer, long j2) {
        long jHash = hash(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), j2);
        byteBuffer.position(byteBuffer.limit());
        return jHash;
    }

    public abstract long hash(byte[] bArr, int i2, int i3, long j2);

    public String toString() {
        return getClass().getSimpleName();
    }
}
