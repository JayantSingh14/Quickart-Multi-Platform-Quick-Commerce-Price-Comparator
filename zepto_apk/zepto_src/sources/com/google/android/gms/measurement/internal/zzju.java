package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzju implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzli f39221a;

    public zzju(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.f39221a = zzliVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zzhy zzhyVar = this.f39221a.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(runnable);
    }
}
