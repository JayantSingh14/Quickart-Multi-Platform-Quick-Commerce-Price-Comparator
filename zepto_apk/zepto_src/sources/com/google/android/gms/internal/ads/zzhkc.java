package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes4.dex */
public final class zzhkc {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f33918a = new zzhkb();

    public static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        ((SecureRandom) f33918a.get()).nextBytes(bArr);
        return bArr;
    }
}
