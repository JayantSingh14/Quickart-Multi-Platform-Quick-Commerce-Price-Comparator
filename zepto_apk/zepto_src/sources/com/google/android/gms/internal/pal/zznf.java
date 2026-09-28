package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zznf {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37940a;

    static {
        new zzne();
        f37940a = "type.googleapis.com/google.crypto.tink.AesSivKey";
        int i2 = zzwx.f38103a;
        try {
            zzlf.f(new zznh());
            if (zznb.a()) {
                return;
            }
            zzlf.e(new zzne());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
