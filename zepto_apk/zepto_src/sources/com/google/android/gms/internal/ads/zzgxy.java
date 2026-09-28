package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzgxy extends zzgxz {

    /* renamed from: e, reason: collision with root package name */
    public final Callable f33359e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgya f33360f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgxy(zzgya zzgyaVar, Callable callable, Executor executor) {
        super(zzgyaVar, executor);
        this.f33360f = zzgyaVar;
        this.f33359e = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final Object a() {
        return this.f33359e.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String c() {
        return this.f33359e.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final void h(Object obj) {
        this.f33360f.c(obj);
    }
}
