package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzgyl {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f33375a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgtd f33376b;

    public /* synthetic */ zzgyl(zzgtd zzgtdVar, boolean z) {
        this.f33375a = z;
        this.f33376b = zzgtdVar;
    }

    public final ListenableFuture a(Callable callable, Executor executor) {
        zzgya zzgyaVar = new zzgya(this.f33376b, this.f33375a, false);
        zzgyaVar.p = new zzgxy(zzgyaVar, callable, executor);
        zzgyaVar.w();
        return zzgyaVar;
    }
}
