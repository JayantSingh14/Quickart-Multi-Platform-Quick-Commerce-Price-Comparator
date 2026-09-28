package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzqs {
    static {
        new zzqr();
        int i2 = zzwx.f38103a;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        zzlf.f(new zzqx());
        zzlf.e(new zzqr());
        if (zznb.a()) {
            return;
        }
        zzlf.e(new zzqh(zzrm.class, new zzqf(zzkq.class)));
        zzpp zzppVar = zzqo.f38030a;
        zzpj zzpjVar = zzpj.f37999b;
        zzpp zzppVar2 = zzqo.f38030a;
        synchronized (zzpjVar) {
            zzpv zzpvVar = new zzpv((zzqb) zzpjVar.f38000a.get());
            zzpvVar.d(zzppVar2);
            zzpjVar.f38000a.set(new zzqb(zzpvVar));
        }
        zzpm zzpmVar = zzqo.f38031b;
        synchronized (zzpjVar) {
            zzpv zzpvVar2 = new zzpv((zzqb) zzpjVar.f38000a.get());
            zzpvVar2.c(zzpmVar);
            zzpjVar.f38000a.set(new zzqb(zzpvVar2));
        }
        zzox zzoxVar = zzqo.f38032c;
        synchronized (zzpjVar) {
            zzpv zzpvVar3 = new zzpv((zzqb) zzpjVar.f38000a.get());
            zzpvVar3.b(zzoxVar);
            zzpjVar.f38000a.set(new zzqb(zzpvVar3));
        }
        zzou zzouVar = zzqo.f38033d;
        synchronized (zzpjVar) {
            zzpv zzpvVar4 = new zzpv((zzqb) zzpjVar.f38000a.get());
            zzpvVar4.a(zzouVar);
            zzpjVar.f38000a.set(new zzqb(zzpvVar4));
        }
    }
}
