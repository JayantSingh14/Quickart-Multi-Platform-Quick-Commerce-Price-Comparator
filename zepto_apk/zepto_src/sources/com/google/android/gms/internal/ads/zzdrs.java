package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes4.dex */
public final class zzdrs implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzije f28373a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdoe f28374b;

    public zzdrs(zzije zzijeVar, zzdoe zzdoeVar) {
        this.f28373a = zzijeVar;
        this.f28374b = zzdoeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        View view;
        zzdnh zzdnhVar = (zzdnh) this.f28373a.zzb();
        zzdnm zzdnmVarA = this.f28374b.a();
        zzdrr zzdrrVar = new zzdrr();
        synchronized (zzdnmVarA) {
            view = zzdnmVarA.o;
        }
        zzdrrVar.f28368a = view;
        zzdrrVar.f28369b = zzdnmVarA.r();
        zzdrrVar.f28370c = zzdnhVar;
        zzdrrVar.f28371d = false;
        zzdrrVar.f28372e = false;
        if (zzdnmVarA.h() != null) {
            zzdnmVarA.h().o0(zzdrrVar);
        }
        return zzdrrVar;
    }
}
