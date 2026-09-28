package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes4.dex */
public final class zznn {

    /* renamed from: a, reason: collision with root package name */
    public static final zzwx f37945a;

    static {
        new zznm();
        new zznk();
        f37945a = zzwx.p();
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        zzlf.f(new zznp());
        zzlf.f(new zzns());
        zzli.a();
        if (zznb.a()) {
            return;
        }
        zzlf.c(new zznk(), new zznm());
        zzlf.c(new zzoi(), new zzok());
    }
}
