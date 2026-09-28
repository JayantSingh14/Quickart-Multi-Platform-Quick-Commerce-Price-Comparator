package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjf f38733a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzay f38734b;

    public zzax(zzay zzayVar, zzjf zzjfVar) {
        this.f38733a = zzjfVar;
        Objects.requireNonNull(zzayVar);
        this.f38734b = zzayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjf zzjfVar = this.f38733a;
        zzjfVar.d();
        if (zzae.a()) {
            zzjfVar.c().p(this);
            return;
        }
        zzay zzayVar = this.f38734b;
        boolean z = zzayVar.f38738c != 0;
        zzayVar.f38738c = 0L;
        if (z) {
            zzayVar.a();
        }
    }
}
