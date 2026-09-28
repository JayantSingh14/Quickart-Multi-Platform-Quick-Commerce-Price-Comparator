package com.google.android.gms.internal.pal;

import java.security.SecureRandom;

/* loaded from: classes4.dex */
public final class zzyq {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f38161a = new zzyp();

    public static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        ((SecureRandom) f38161a.get()).nextBytes(bArr);
        return bArr;
    }
}
