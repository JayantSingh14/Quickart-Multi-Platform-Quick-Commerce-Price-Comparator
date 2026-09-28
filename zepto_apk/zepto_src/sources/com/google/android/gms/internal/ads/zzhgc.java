package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;

/* loaded from: classes4.dex */
abstract class zzhgc {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f33750a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33751b;

    public zzhgc(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f33750a = zzhga.c(bArr);
        this.f33751b = i2;
    }

    public abstract int[] a(int i2, int[] iArr);

    public abstract int b();

    public final ByteBuffer c(int i2, byte[] bArr) {
        int[] iArrA = a(i2, zzhga.c(bArr));
        int[] iArr = (int[]) iArrA.clone();
        zzhga.a(iArr);
        for (int i3 = 0; i3 < 16; i3++) {
            iArrA[i3] = iArrA[i3] + iArr[i3];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrA, 0, 16);
        return byteBufferOrder;
    }
}
