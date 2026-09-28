package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class XXHash32JNI extends XXHash32 {
    public static final XXHash32 INSTANCE = new XXHash32JNI();
    private static XXHash32 SAFE_INSTANCE;

    @Override // net.jpountz.xxhash.XXHash32
    public int hash(byte[] bArr, int i2, int i3, int i4) {
        SafeUtils.checkRange(bArr, i2, i3);
        return XXHashJNI.XXH32(bArr, i2, i3, i4);
    }

    @Override // net.jpountz.xxhash.XXHash32
    public int hash(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        if (byteBuffer.isDirect()) {
            ByteBufferUtils.checkRange(byteBuffer, i2, i3);
            return XXHashJNI.XXH32BB(byteBuffer, i2, i3, i4);
        }
        if (byteBuffer.hasArray()) {
            return hash(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3, i4);
        }
        XXHash32 xXHash32Hash32 = SAFE_INSTANCE;
        if (xXHash32Hash32 == null) {
            xXHash32Hash32 = XXHashFactory.safeInstance().hash32();
            SAFE_INSTANCE = xXHash32Hash32;
        }
        return xXHash32Hash32.hash(byteBuffer, i2, i3, i4);
    }
}
