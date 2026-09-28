package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public abstract class zzfmm {

    /* renamed from: d, reason: collision with root package name */
    public static final ListenableFuture f31404d = zzgyq.f33377b;

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f31405a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f31406b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfmn f31407c;

    public zzfmm(zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, zzfmn zzfmnVar) {
        this.f31405a = zzgywVar;
        this.f31406b = scheduledExecutorService;
        this.f31407c = zzfmnVar;
    }

    public final zzfml a(ListenableFuture listenableFuture, Object obj) {
        return new zzfml(this, obj, null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture);
    }

    public abstract String b(Object obj);
}
