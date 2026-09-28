package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzelv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29682a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f29683b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f29684c;

    public zzelv(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f29682a = zzijfVar;
        this.f29683b = zzijhVar;
        this.f29684c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzelu((Context) this.f29682a.zzb(), (zzdlv) this.f29683b.f34899a, (Executor) this.f29684c.zzb());
    }
}
