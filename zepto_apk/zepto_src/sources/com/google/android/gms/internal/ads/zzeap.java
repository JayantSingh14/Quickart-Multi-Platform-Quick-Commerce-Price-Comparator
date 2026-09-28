package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzeap implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f28960a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclq f28961b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28962c;

    public zzeap(zzclp zzclpVar, zzclq zzclqVar, zzijf zzijfVar) {
        this.f28960a = zzclpVar;
        this.f28961b = zzclqVar;
        this.f28962c = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f28960a.a();
        WeakReference weakReference = this.f28961b.f26521a.f26512d;
        zzijo.a(weakReference);
        zzeav zzeavVar = (zzeav) this.f28962c.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzebh(contextA, weakReference, zzeavVar, zzgywVar);
    }
}
