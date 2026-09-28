package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzczv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzczt f27527a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f27528b;

    public zzczv(zzczt zzcztVar, zzclp zzclpVar) {
        this.f27527a = zzcztVar;
        this.f27528b = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        this.f27528b.a();
        Context context = this.f27527a.f27518a;
        zzijo.a(context);
        return context;
    }
}
