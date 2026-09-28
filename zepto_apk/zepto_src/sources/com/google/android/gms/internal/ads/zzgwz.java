package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzgwz {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f33303a;

    static {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 < 10; i2++) {
            bArr[i2 + 48] = (byte) i2;
        }
        for (int i3 = 0; i3 < 26; i3++) {
            byte b2 = (byte) (i3 + 10);
            bArr[i3 + 65] = b2;
            bArr[i3 + 97] = b2;
        }
        f33303a = bArr;
    }
}
