package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfmd {

    /* renamed from: a, reason: collision with root package name */
    public final zzfmo f31388a;

    /* renamed from: b, reason: collision with root package name */
    public final List f31389b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfmm f31390c;

    public /* synthetic */ zzfmd(zzfmm zzfmmVar, zzfmo zzfmoVar, List list) {
        Objects.requireNonNull(zzfmmVar);
        this.f31390c = zzfmmVar;
        this.f31388a = zzfmoVar;
        this.f31389b = list;
    }

    public final zzfml a(Callable callable) {
        zzgvs zzgvsVar = zzgtd.f33183b;
        List list = this.f31389b;
        list.getClass();
        zzgyl zzgylVar = new zzgyl(zzgtd.r(list), true);
        ListenableFuture listenableFutureA = zzgylVar.a(zzfmc.f31387a, zzcdo.f25988g);
        zzfmm zzfmmVar = this.f31390c;
        return new zzfml(zzfmmVar, this.f31388a, null, listenableFutureA, list, zzgylVar.a(callable, zzfmmVar.f31405a));
    }
}
