package net.jpountz.util;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public enum UnsafeUtils {
    ;

    private static final long BYTE_ARRAY_OFFSET;
    private static final int BYTE_ARRAY_SCALE;
    private static final long INT_ARRAY_OFFSET;
    private static final int INT_ARRAY_SCALE;
    private static final long SHORT_ARRAY_OFFSET;
    private static final int SHORT_ARRAY_SCALE;
    private static final Unsafe UNSAFE;

    static {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe = (Unsafe) declaredField.get(null);
            UNSAFE = unsafe;
            BYTE_ARRAY_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            BYTE_ARRAY_SCALE = unsafe.arrayIndexScale(byte[].class);
            INT_ARRAY_OFFSET = unsafe.arrayBaseOffset(int[].class);
            INT_ARRAY_SCALE = unsafe.arrayIndexScale(int[].class);
            SHORT_ARRAY_OFFSET = unsafe.arrayBaseOffset(short[].class);
            SHORT_ARRAY_SCALE = unsafe.arrayIndexScale(short[].class);
        } catch (IllegalAccessException unused) {
            throw new ExceptionInInitializerError("Cannot access Unsafe");
        } catch (NoSuchFieldException unused2) {
            throw new ExceptionInInitializerError("Cannot access Unsafe");
        } catch (SecurityException unused3) {
            throw new ExceptionInInitializerError("Cannot access Unsafe");
        }
    }

    public static void checkLength(int i2) {
        SafeUtils.checkLength(i2);
    }

    public static void checkRange(byte[] bArr, int i2) {
        SafeUtils.checkRange(bArr, i2);
    }

    public static byte readByte(byte[] bArr, int i2) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_OFFSET + (BYTE_ARRAY_SCALE * i2));
    }

    public static int readInt(byte[] bArr, int i2) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_OFFSET + i2);
    }

    public static int readIntLE(byte[] bArr, int i2) {
        int i3 = readInt(bArr, i2);
        return Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN ? Integer.reverseBytes(i3) : i3;
    }

    public static long readLong(byte[] bArr, int i2) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_OFFSET + i2);
    }

    public static long readLongLE(byte[] bArr, int i2) {
        long j2 = readLong(bArr, i2);
        return Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN ? Long.reverseBytes(j2) : j2;
    }

    public static short readShort(byte[] bArr, int i2) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_OFFSET + i2);
    }

    public static int readShortLE(byte[] bArr, int i2) {
        short sReverseBytes = readShort(bArr, i2);
        if (Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        return sReverseBytes & 65535;
    }

    public static void writeByte(byte[] bArr, int i2, byte b2) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_OFFSET + (BYTE_ARRAY_SCALE * i2), b2);
    }

    public static void writeInt(byte[] bArr, int i2, int i3) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_OFFSET + i2, i3);
    }

    public static void writeLong(byte[] bArr, int i2, long j2) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_OFFSET + i2, j2);
    }

    public static void writeShort(byte[] bArr, int i2, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_OFFSET + i2, s);
    }

    public static void writeShortLE(byte[] bArr, int i2, int i3) {
        writeByte(bArr, i2, (byte) i3);
        writeByte(bArr, i2 + 1, (byte) (i3 >>> 8));
    }

    public static void checkRange(byte[] bArr, int i2, int i3) {
        SafeUtils.checkRange(bArr, i2, i3);
    }

    public static int readInt(int[] iArr, int i2) {
        return UNSAFE.getInt(iArr, INT_ARRAY_OFFSET + (INT_ARRAY_SCALE * i2));
    }

    public static int readShort(short[] sArr, int i2) {
        return UNSAFE.getShort(sArr, SHORT_ARRAY_OFFSET + (SHORT_ARRAY_SCALE * i2)) & 65535;
    }

    public static void writeByte(byte[] bArr, int i2, int i3) {
        writeByte(bArr, i2, (byte) i3);
    }

    public static void writeInt(int[] iArr, int i2, int i3) {
        UNSAFE.putInt(iArr, INT_ARRAY_OFFSET + (INT_ARRAY_SCALE * i2), i3);
    }

    public static void writeShort(short[] sArr, int i2, int i3) {
        UNSAFE.putShort(sArr, SHORT_ARRAY_OFFSET + (SHORT_ARRAY_SCALE * i2), (short) i3);
    }
}
