package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final long f43337a;

    static {
        new UnsignedLong(0L);
        new UnsignedLong(1L);
        new UnsignedLong(-1L);
    }

    public UnsignedLong(long j2) {
        this.f43337a = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(UnsignedLong unsignedLong) {
        UnsignedLong unsignedLong2 = unsignedLong;
        unsignedLong2.getClass();
        return UnsignedLongs.a(this.f43337a, unsignedLong2.f43337a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        long j2 = this.f43337a;
        return j2 >= 0 ? j2 : ((j2 >>> 1) | (j2 & 1)) * 2.0d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.f43337a == ((UnsignedLong) obj).f43337a;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        long j2 = this.f43337a;
        return j2 >= 0 ? j2 : ((j2 >>> 1) | (j2 & 1)) * 2.0f;
    }

    public final int hashCode() {
        return Longs.a(this.f43337a);
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) this.f43337a;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.f43337a;
    }

    public final String toString() {
        long j2 = this.f43337a;
        if (j2 == 0) {
            return "0";
        }
        if (j2 > 0) {
            return Long.toString(j2, 10);
        }
        char[] cArr = new char[64];
        long j3 = (j2 >>> 1) / 5;
        long j4 = 10;
        int i2 = 63;
        cArr[63] = Character.forDigit((int) (j2 - (j3 * j4)), 10);
        while (j3 > 0) {
            i2--;
            cArr[i2] = Character.forDigit((int) (j3 % j4), 10);
            j3 /= j4;
        }
        return new String(cArr, i2, 64 - i2);
    }
}
