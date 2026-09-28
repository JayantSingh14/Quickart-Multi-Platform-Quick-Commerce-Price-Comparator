package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhkf {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33920a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f33921b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f33922c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f33923d;

    public zzhkf() {
        this.f33920a = new HashMap();
        this.f33921b = new HashMap();
        this.f33922c = new HashMap();
        this.f33923d = new HashMap();
    }

    public final void a(zzhig zzhigVar) throws GeneralSecurityException {
        zzhkh zzhkhVar = new zzhkh(zzhigVar.f33854a, zzhjz.class);
        HashMap map = this.f33920a;
        if (!map.containsKey(zzhkhVar)) {
            map.put(zzhkhVar, zzhigVar);
            return;
        }
        zzhig zzhigVar2 = (zzhig) map.get(zzhkhVar);
        if (!zzhigVar2.equals(zzhigVar) || !zzhigVar.equals(zzhigVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhkhVar.toString()));
        }
    }

    public final void b(zzhid zzhidVar) throws GeneralSecurityException {
        zzhidVar.getClass();
        zzhkg zzhkgVar = new zzhkg(zzhjz.class, zzhidVar.f33852a);
        HashMap map = this.f33921b;
        if (!map.containsKey(zzhkgVar)) {
            map.put(zzhkgVar, zzhidVar);
            return;
        }
        zzhid zzhidVar2 = (zzhid) map.get(zzhkgVar);
        if (!zzhidVar2.equals(zzhidVar) || !zzhidVar.equals(zzhidVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhkgVar.toString()));
        }
    }

    public final void c(zzhjl zzhjlVar) throws GeneralSecurityException {
        zzhkh zzhkhVar = new zzhkh(zzhjlVar.f33890a, zzhka.class);
        HashMap map = this.f33922c;
        if (!map.containsKey(zzhkhVar)) {
            map.put(zzhkhVar, zzhjlVar);
            return;
        }
        zzhjl zzhjlVar2 = (zzhjl) map.get(zzhkhVar);
        if (!zzhjlVar2.equals(zzhjlVar) || !zzhjlVar.equals(zzhjlVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhkhVar.toString()));
        }
    }

    public final void d(zzhji zzhjiVar) throws GeneralSecurityException {
        zzhjiVar.getClass();
        zzhkg zzhkgVar = new zzhkg(zzhka.class, zzhjiVar.f33888a);
        HashMap map = this.f33923d;
        if (!map.containsKey(zzhkgVar)) {
            map.put(zzhkgVar, zzhjiVar);
            return;
        }
        zzhji zzhjiVar2 = (zzhji) map.get(zzhkgVar);
        if (!zzhjiVar2.equals(zzhjiVar) || !zzhjiVar.equals(zzhjiVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhkgVar.toString()));
        }
    }

    public zzhkf(zzhki zzhkiVar) {
        this.f33920a = new HashMap(zzhkiVar.f33928a);
        this.f33921b = new HashMap(zzhkiVar.f33929b);
        this.f33922c = new HashMap(zzhkiVar.f33930c);
        this.f33923d = new HashMap(zzhkiVar.f33931d);
    }
}
