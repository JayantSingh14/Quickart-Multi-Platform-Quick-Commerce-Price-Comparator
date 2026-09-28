package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhjw {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33907a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f33908b;

    public /* synthetic */ zzhjw(zzhjt zzhjtVar) {
        this.f33907a = new HashMap(zzhjtVar.f33901a);
        this.f33908b = new HashMap(zzhjtVar.f33902b);
    }

    public final Object a(zzgzx zzgzxVar, Class cls) throws GeneralSecurityException {
        zzhju zzhjuVar = new zzhju(zzgzxVar.getClass(), cls);
        HashMap map = this.f33907a;
        if (map.containsKey(zzhjuVar)) {
            return ((zzhjs) map.get(zzhjuVar)).a(zzgzxVar);
        }
        String string = zzhjuVar.toString();
        throw new GeneralSecurityException(android.support.v4.media.b.s(new StringBuilder(string.length() + 102), "No PrimitiveConstructor for ", string, " available, see https://developers.google.com/tink/faq/registration_errors"));
    }

    public final Object b(zzhai zzhaiVar, zzhip zzhipVar, Class cls) throws GeneralSecurityException {
        HashMap map = this.f33908b;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzhjy zzhjyVar = (zzhjy) map.get(cls);
        return zzhjyVar.a(zzhaiVar, zzhipVar, new zzhjv(this, zzhjyVar));
    }
}
