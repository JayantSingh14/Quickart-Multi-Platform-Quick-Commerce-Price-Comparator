package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.Native;

/* loaded from: classes3.dex */
enum XXHashJNI {
    ;

    static {
        Native.load();
        init();
    }

    public static native int XXH32(byte[] bArr, int i2, int i3, int i4);

    public static native int XXH32BB(ByteBuffer byteBuffer, int i2, int i3, int i4);

    public static native int XXH32_digest(long j2);

    public static native void XXH32_free(long j2);

    public static native long XXH32_init(int i2);

    public static native void XXH32_update(long j2, byte[] bArr, int i2, int i3);

    public static native long XXH64(byte[] bArr, int i2, int i3, long j2);

    public static native long XXH64BB(ByteBuffer byteBuffer, int i2, int i3, long j2);

    public static native long XXH64_digest(long j2);

    public static native void XXH64_free(long j2);

    public static native long XXH64_init(long j2);

    public static native void XXH64_update(long j2, byte[] bArr, int i2, int i3);

    private static native void init();
}
