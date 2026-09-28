package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class XXHash64JNI extends XXHash64 {
    public static final XXHash64 INSTANCE = new XXHash64JNI();
    private static XXHash64 SAFE_INSTANCE;

    @Override // net.jpountz.xxhash.XXHash64
    public long hash(byte[] bArr, int i2, int i3, long j2) {
        SafeUtils.checkRange(bArr, i2, i3);
        return XXHashJNI.XXH64(bArr, i2, i3, j2);
    }

    @Override // net.jpountz.xxhash.XXHash64
    public long hash(ByteBuffer byteBuffer, int i2, int i3, long j2) {
        if (byteBuffer.isDirect()) {
            ByteBufferUtils.checkRange(byteBuffer, i2, i3);
            return XXHashJNI.XXH64BB(byteBuffer, i2, i3, j2);
        }
        if (byteBuffer.hasArray()) {
            return hash(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3, j2);
        }
        XXHash64 xXHash64Hash64 = SAFE_INSTANCE;
        if (xXHash64Hash64 == null) {
            xXHash64Hash64 = XXHashFactory.safeInstance().hash64();
            SAFE_INSTANCE = xXHash64Hash64;
        }
        return xXHash64Hash64.hash(byteBuffer, i2, i3, j2);
    }
}
