package com.google.android.gms.internal.auth;

import android.util.Base64;

/* loaded from: classes4.dex */
public final class zzhz implements zzhx {
    static {
        zzcz zzczVarA = new zzcz(zzcr.a(), false, false).a();
        zzcz zzczVar = new zzcz(zzczVarA.f36315a, zzczVarA.f36317c, true);
        new zzcx(zzczVar, Double.valueOf(0.0d));
        zzczVar.c(true);
        zzczVar.b(20L);
        zzczVar.b(0L);
        try {
            new zzcy(zzczVar, zzhs.h(Base64.decode("ChNjb20uYW5kcm9pZC52ZW5kaW5nCiBjb20uZ29vZ2xlLmFuZHJvaWQuYXBwcy5tZWV0aW5ncwohY29tLmdvb2dsZS5hbmRyb2lkLmFwcHMubWVzc2FnaW5n", 3)));
            zzczVar.c(true);
            zzczVar.b(20L);
            zzczVar.b(20L);
            zzczVar.c(false);
            zzczVar.c(false);
            zzczVar.b(120L);
            zzczVar.c(true);
            new zzcx(zzczVar, Double.valueOf(0.0d));
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }
}
