package org.xbill.DNS;

import lombok.Generated;

/* loaded from: classes5.dex */
final class Utils {
    @Generated
    private Utils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isUInt16(int i2) {
        return i2 >= 0 && i2 <= 65535;
    }

    public static boolean isUInt32(long j2) {
        return j2 >= 0 && j2 <= 4294967295L;
    }

    public static boolean isUInt8(int i2) {
        return i2 >= 0 && i2 <= 255;
    }

    public static boolean isUInt16(long j2) {
        return j2 >= 0 && j2 <= 65535;
    }

    public static boolean isUInt8(long j2) {
        return j2 >= 0 && j2 <= 255;
    }
}
