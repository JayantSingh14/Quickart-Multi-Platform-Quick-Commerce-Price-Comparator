package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzeoa implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29939a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29940b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f29941c;

    public zzeoa(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f29939a = zzijfVar;
        this.f29940b = zzijfVar2;
        this.f29941c = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzenz((Context) this.f29939a.zzb(), (Executor) this.f29940b.zzb(), (zzdtj) this.f29941c.f34899a);
    }
}
