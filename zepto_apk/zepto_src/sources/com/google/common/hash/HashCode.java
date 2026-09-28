package com.google.common.hash;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class HashCode {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f43206a = "0123456789abcdef".toCharArray();

    /* loaded from: classes4.dex */
    public static final class BytesHashCode extends HashCode implements Serializable {
        @Override // com.google.common.hash.HashCode
        public final byte[] a() {
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public final int b() {
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public final long c() {
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public final int d() {
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public final boolean e(HashCode hashCode) {
            throw null;
        }

        @Override // com.google.common.hash.HashCode
        public final byte[] f() {
            return null;
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public final int f43207b;

        public IntHashCode(int i2) {
            this.f43207b = i2;
        }

        @Override // com.google.common.hash.HashCode
        public final byte[] a() {
            int i2 = this.f43207b;
            return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public final int b() {
            return this.f43207b;
        }

        @Override // com.google.common.hash.HashCode
        public final long c() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public final int d() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public final boolean e(HashCode hashCode) {
            return this.f43207b == hashCode.b();
        }
    }

    /* loaded from: classes4.dex */
    public static final class LongHashCode extends HashCode implements Serializable {
        @Override // com.google.common.hash.HashCode
        public final byte[] a() {
            return new byte[]{(byte) 0, (byte) (0 >> 8), (byte) (0 >> 16), (byte) (0 >> 24), (byte) (0 >> 32), (byte) (0 >> 40), (byte) (0 >> 48), (byte) (0 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public final int b() {
            return (int) 0;
        }

        @Override // com.google.common.hash.HashCode
        public final long c() {
            return 0L;
        }

        @Override // com.google.common.hash.HashCode
        public final int d() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public final boolean e(HashCode hashCode) {
            return 0 == hashCode.c();
        }
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public abstract boolean e(HashCode hashCode);

    public final boolean equals(Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        return d() == hashCode.d() && e(hashCode);
    }

    public byte[] f() {
        return a();
    }

    public final int hashCode() {
        if (d() >= 32) {
            return b();
        }
        byte[] bArrF = f();
        int i2 = bArrF[0] & 255;
        for (int i3 = 1; i3 < bArrF.length; i3++) {
            i2 |= (bArrF[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    public final String toString() {
        byte[] bArrF = f();
        StringBuilder sb = new StringBuilder(bArrF.length * 2);
        for (byte b2 : bArrF) {
            char[] cArr = f43206a;
            sb.append(cArr[(b2 >> 4) & 15]);
            sb.append(cArr[b2 & 15]);
        }
        return sb.toString();
    }
}
