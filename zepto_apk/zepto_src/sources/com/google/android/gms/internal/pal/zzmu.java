package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
abstract class zzmu {

    /* renamed from: a, reason: collision with root package name */
    public final zzms f37934a;

    /* renamed from: b, reason: collision with root package name */
    public final zzms f37935b;

    public zzmu(byte[] bArr) throws GeneralSecurityException {
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.f37934a = a(1, bArr);
        this.f37935b = a(0, bArr);
    }

    public abstract zzms a(int i2, byte[] bArr);

    public final void b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        zzms zzmsVar = this.f37934a;
        zzmsVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr2);
        if (bArr.length != zzmsVar.a()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zzmsVar.a());
        }
        int iRemaining = byteBufferWrap.remaining();
        int i2 = iRemaining / 64;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            ByteBuffer byteBufferC = zzmsVar.c(zzmsVar.f37933b + i4, bArr);
            if (i4 == i2) {
                zzxo.a(byteBuffer, byteBufferWrap, byteBufferC, iRemaining % 64);
            } else {
                zzxo.a(byteBuffer, byteBufferWrap, byteBufferC, 64);
            }
        }
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        byte[] bArr4 = new byte[32];
        this.f37935b.c(0, bArr).get(bArr4);
        int iRemaining2 = byteBuffer.remaining();
        int i5 = iRemaining2 % 16;
        int i6 = i5 == 0 ? iRemaining2 : (iRemaining2 + 16) - i5;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i6 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr3);
        byteBufferOrder.position(0);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i6);
        byteBufferOrder.putLong(0L);
        byteBufferOrder.putLong(iRemaining2);
        byte[] bArrArray = byteBufferOrder.array();
        long jA = zzmx.a(0, bArr4) & 67108863;
        long jA2 = (zzmx.a(3, bArr4) >> 2) & 67108611;
        int i7 = 6;
        long jA3 = (zzmx.a(6, bArr4) >> 4) & 67092735;
        long jA4 = (zzmx.a(9, bArr4) >> 6) & 66076671;
        long jA5 = (zzmx.a(12, bArr4) >> 8) & 1048575;
        long j2 = jA2 * 5;
        long j3 = jA3 * 5;
        long j4 = jA4 * 5;
        long j5 = jA5 * 5;
        int i8 = 17;
        byte[] bArr5 = new byte[17];
        int i9 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        while (true) {
            int length = bArrArray.length;
            if (i9 >= length) {
                long j11 = j6 + (j7 >> 26);
                long j12 = j11 & 67108863;
                long j13 = j8 + (j11 >> 26);
                long j14 = j13 & 67108863;
                long j15 = j9 + (j13 >> 26);
                long j16 = j15 & 67108863;
                long j17 = ((j15 >> 26) * 5) + j10;
                long j18 = j17 & 67108863;
                long j19 = (j7 & 67108863) + (j17 >> 26);
                long j20 = j18 + 5;
                long j21 = j19 + (j20 >> 26);
                long j22 = j12 + (j21 >> 26);
                long j23 = j14 + (j22 >> 26);
                long j24 = (j16 + (j23 >> 26)) - 67108864;
                long j25 = j24 >> 63;
                long j26 = ~j25;
                long j27 = (j19 & j25) | (j21 & 67108863 & j26);
                long j28 = (j12 & j25) | (j22 & 67108863 & j26);
                long j29 = (j14 & j25) | (j23 & 67108863 & j26);
                long jA6 = zzmx.a(16, bArr4) + (((j18 & j25) | (j20 & 67108863 & j26) | (j27 << 26)) & 4294967295L);
                long jA7 = zzmx.a(20, bArr4) + (((j27 >> i7) | (j28 << 20)) & 4294967295L) + (jA6 >> 32);
                long jA8 = zzmx.a(24, bArr4) + (((j28 >> 12) | (j29 << 14)) & 4294967295L) + (jA7 >> 32);
                long jA9 = zzmx.a(28, bArr4);
                byte[] bArr6 = new byte[16];
                zzmx.b(bArr6, 0, jA6 & 4294967295L);
                zzmx.b(bArr6, 4, jA7 & 4294967295L);
                zzmx.b(bArr6, 8, jA8 & 4294967295L);
                zzmx.b(bArr6, 12, ((((j29 >> 18) | (((j16 & j25) | (j24 & j26)) << 8)) & 4294967295L) + jA9 + (jA8 >> 32)) & 4294967295L);
                byteBuffer.limit(byteBuffer.limit() + 16);
                byteBuffer.put(bArr6);
                return;
            }
            int iMin = Math.min(16, length - i9);
            System.arraycopy(bArrArray, i9, bArr5, 0, iMin);
            bArr5[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr5, iMin + 1, i8, (byte) 0);
            }
            long jA10 = j10 + (zzmx.a(0, bArr5) & 67108863);
            long jA11 = j7 + ((zzmx.a(3, bArr5) >> 2) & 67108863);
            long jA12 = j6 + ((zzmx.a(i7, bArr5) >> 4) & 67108863);
            long jA13 = j8 + ((zzmx.a(9, bArr5) >> i7) & 67108863);
            long j30 = jA2;
            long jA14 = j9 + (((zzmx.a(12, bArr5) >> 8) & 67108863) | (bArr5[16] << 24));
            long j31 = (jA14 * j2) + (jA13 * j3) + (jA12 * j4) + (jA11 * j5) + (jA10 * jA);
            long j32 = (jA14 * j3) + (jA13 * j4) + (jA12 * j5) + (jA11 * jA) + (jA10 * j30) + (j31 >> 26);
            long j33 = (jA14 * j4) + (jA13 * j5) + (jA12 * jA) + (jA11 * j30) + (jA10 * jA3) + (j32 >> 26);
            long j34 = (jA14 * j5) + (jA13 * jA) + (jA12 * j30) + (jA11 * jA3) + (jA10 * jA4) + (j33 >> 26);
            long j35 = jA14 * jA;
            long j36 = j35 + (jA13 * j30) + (jA12 * jA3) + (jA11 * jA4) + (jA10 * jA5) + (j34 >> 26);
            long j37 = ((j36 >> 26) * 5) + (j31 & 67108863);
            j10 = j37 & 67108863;
            j7 = (j32 & 67108863) + (j37 >> 26);
            i9 += 16;
            j9 = j36 & 67108863;
            i7 = i7;
            jA2 = j30;
            j8 = j34 & 67108863;
            j6 = j33 & 67108863;
            i8 = 17;
        }
    }
}
