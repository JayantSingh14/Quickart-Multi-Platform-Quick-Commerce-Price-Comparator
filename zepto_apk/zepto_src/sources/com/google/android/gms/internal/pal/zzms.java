package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;

/* loaded from: classes4.dex */
abstract class zzms {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f37932a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37933b;

    public zzms(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f37932a = zzmo.c(bArr);
        this.f37933b = i2;
    }

    public abstract int a();

    public abstract int[] b(int i2, int[] iArr);

    public final ByteBuffer c(int i2, byte[] bArr) {
        int[] iArrB = b(i2, zzmo.c(bArr));
        int[] iArr = (int[]) iArrB.clone();
        zzmo.b(iArr);
        for (int i3 = 0; i3 < 16; i3++) {
            iArrB[i3] = iArrB[i3] + iArr[i3];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrB, 0, 16);
        return byteBufferOrder;
    }
}
