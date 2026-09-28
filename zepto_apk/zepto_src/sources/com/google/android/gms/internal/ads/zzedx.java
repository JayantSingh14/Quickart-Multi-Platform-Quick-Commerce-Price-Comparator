package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzedx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f29162a;

    public zzedx(zzclp zzclpVar) {
        this.f29162a = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzedw zzb() {
        Context contextA = this.f29162a.a();
        zzedw zzedwVar = new zzedw();
        zzedwVar.f29161h = 1;
        zzedwVar.f29153f = new zzbyc(contextA, com.google.android.gms.ads.internal.zzt.C.t.a(), zzedwVar, zzedwVar);
        return zzedwVar;
    }
}
