package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhjt {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33901a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f33902b;

    public /* synthetic */ zzhjt(zzhjw zzhjwVar) {
        this.f33901a = new HashMap(zzhjwVar.f33907a);
        this.f33902b = new HashMap(zzhjwVar.f33908b);
    }

    public final void a(zzhjs zzhjsVar) throws GeneralSecurityException {
        if (zzhjsVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzhju zzhjuVar = new zzhju(zzhjsVar.f33899a, zzhjsVar.f33900b);
        HashMap map = this.f33901a;
        if (!map.containsKey(zzhjuVar)) {
            map.put(zzhjuVar, zzhjsVar);
            return;
        }
        zzhjs zzhjsVar2 = (zzhjs) map.get(zzhjuVar);
        if (!zzhjsVar2.equals(zzhjsVar) || !zzhjsVar.equals(zzhjsVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzhjuVar.toString()));
        }
    }

    public final void b(zzhjy zzhjyVar) throws GeneralSecurityException {
        Class clsZza = zzhjyVar.zza();
        HashMap map = this.f33902b;
        if (!map.containsKey(clsZza)) {
            map.put(clsZza, zzhjyVar);
            return;
        }
        zzhjy zzhjyVar2 = (zzhjy) map.get(clsZza);
        if (!zzhjyVar2.equals(zzhjyVar) || !zzhjyVar.equals(zzhjyVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZza.toString()));
        }
    }

    public /* synthetic */ zzhjt() {
        this.f33901a = new HashMap();
        this.f33902b = new HashMap();
    }
}
