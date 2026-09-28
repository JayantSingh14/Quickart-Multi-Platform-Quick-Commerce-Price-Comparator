package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final class zzeui {

    /* renamed from: a, reason: collision with root package name */
    public final ListenableFuture f30345a;

    /* renamed from: b, reason: collision with root package name */
    public final long f30346b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f30347c;

    public zzeui(ListenableFuture listenableFuture, long j2, Clock clock) {
        this.f30345a = listenableFuture;
        this.f30347c = clock;
        this.f30346b = clock.elapsedRealtime() + j2;
    }
}
