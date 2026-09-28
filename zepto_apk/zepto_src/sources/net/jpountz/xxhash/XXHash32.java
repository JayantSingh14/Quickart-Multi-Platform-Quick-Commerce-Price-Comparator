package net.jpountz.xxhash;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class XXHash32 {
    public final int hash(ByteBuffer byteBuffer, int i2) {
        int iHash = hash(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), i2);
        byteBuffer.position(byteBuffer.limit());
        return iHash;
    }

    public abstract int hash(ByteBuffer byteBuffer, int i2, int i3, int i4);

    public abstract int hash(byte[] bArr, int i2, int i3, int i4);

    public String toString() {
        return getClass().getSimpleName();
    }
}
