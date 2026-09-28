package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzhje {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhje f33884b = (zzhje) zzhkk.a(zzhjd.f33883a);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f33885a = new AtomicReference(new zzhki(new zzhkf()));

    public final synchronized void a(zzhig zzhigVar) {
        AtomicReference atomicReference = this.f33885a;
        zzhkf zzhkfVar = new zzhkf((zzhki) atomicReference.get());
        zzhkfVar.a(zzhigVar);
        atomicReference.set(new zzhki(zzhkfVar));
    }

    public final synchronized void b(zzhid zzhidVar) {
        AtomicReference atomicReference = this.f33885a;
        zzhkf zzhkfVar = new zzhkf((zzhki) atomicReference.get());
        zzhkfVar.b(zzhidVar);
        atomicReference.set(new zzhki(zzhkfVar));
    }

    public final synchronized void c(zzhjl zzhjlVar) {
        AtomicReference atomicReference = this.f33885a;
        zzhkf zzhkfVar = new zzhkf((zzhki) atomicReference.get());
        zzhkfVar.c(zzhjlVar);
        atomicReference.set(new zzhki(zzhkfVar));
    }

    public final synchronized void d(zzhji zzhjiVar) {
        AtomicReference atomicReference = this.f33885a;
        zzhkf zzhkfVar = new zzhkf((zzhki) atomicReference.get());
        zzhkfVar.d(zzhjiVar);
        atomicReference.set(new zzhki(zzhkfVar));
    }

    public final zzgzx e(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhki zzhkiVar = (zzhki) this.f33885a.get();
        zzhkiVar.getClass();
        zzhkg zzhkgVar = new zzhkg(zzhjz.class, zzhjzVar.f33910b);
        HashMap map = zzhkiVar.f33929b;
        if (map.containsKey(zzhkgVar)) {
            return ((zzhid) map.get(zzhkgVar)).a(zzhjzVar);
        }
        String string = zzhkgVar.toString();
        throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(string.length() + 47), "No Key Parser for requested key type ", string, " available"));
    }

    public final zzhke f(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhki zzhkiVar = (zzhki) this.f33885a.get();
        zzhkiVar.getClass();
        zzhkh zzhkhVar = new zzhkh(zzgzxVar.getClass(), zzhjz.class);
        HashMap map = zzhkiVar.f33928a;
        if (map.containsKey(zzhkhVar)) {
            return ((zzhig) map.get(zzhkhVar)).a(zzgzxVar);
        }
        String string = zzhkhVar.toString();
        throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(string.length() + 32), "No Key serializer for ", string, " available"));
    }

    public final zzhan g(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhki zzhkiVar = (zzhki) this.f33885a.get();
        zzhkiVar.getClass();
        zzhkg zzhkgVar = new zzhkg(zzhka.class, zzhkaVar.f33916a);
        HashMap map = zzhkiVar.f33931d;
        if (map.containsKey(zzhkgVar)) {
            return ((zzhji) map.get(zzhkgVar)).a(zzhkaVar);
        }
        String string = zzhkgVar.toString();
        throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(string.length() + 54), "No Parameters Parser for requested key type ", string, " available"));
    }

    public final zzhke h(zzhan zzhanVar) throws GeneralSecurityException {
        zzhki zzhkiVar = (zzhki) this.f33885a.get();
        zzhkiVar.getClass();
        zzhkh zzhkhVar = new zzhkh(zzhanVar.getClass(), zzhka.class);
        HashMap map = zzhkiVar.f33930c;
        if (map.containsKey(zzhkhVar)) {
            return ((zzhjl) map.get(zzhkhVar)).a(zzhanVar);
        }
        String string = zzhkhVar.toString();
        throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(string.length() + 39), "No Key Format serializer for ", string, " available"));
    }
}
