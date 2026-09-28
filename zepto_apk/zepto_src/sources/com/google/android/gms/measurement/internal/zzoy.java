package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzoy implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39574a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzpf f39575b;

    public zzoy(zzpf zzpfVar, zzr zzrVar) {
        this.f39574a = zzrVar;
        Objects.requireNonNull(zzpfVar);
        this.f39575b = zzpfVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzr zzrVar = this.f39574a;
        String str = (String) Preconditions.checkNotNull(zzrVar.f39648a);
        zzpf zzpfVar = this.f39575b;
        zzjk zzjkVarA = zzpfVar.a(str);
        zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
        if (zzjkVarA.i(zzjjVar) && zzjk.c(100, zzrVar.s).i(zzjjVar)) {
            return zzpfVar.a0(zzrVar).E();
        }
        zzpfVar.b().n.a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
