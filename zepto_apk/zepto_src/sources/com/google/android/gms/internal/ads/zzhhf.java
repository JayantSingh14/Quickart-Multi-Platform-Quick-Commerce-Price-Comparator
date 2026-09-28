package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Security;

/* loaded from: classes4.dex */
public final class zzhhf {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f33795a = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};

    public static Provider a() {
        String[] strArr = f33795a;
        for (int i2 = 0; i2 < 3; i2++) {
            Provider provider = Security.getProvider(strArr[i2]);
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }
}
