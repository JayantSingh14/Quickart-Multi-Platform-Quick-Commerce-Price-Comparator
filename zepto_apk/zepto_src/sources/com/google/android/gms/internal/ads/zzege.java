package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzege {

    /* renamed from: a, reason: collision with root package name */
    public final zzbyw f29278a;

    public zzege(zzbyw zzbywVar) {
        this.f29278a = zzbywVar;
    }

    public final void a() {
        ListenableFuture listenableFutureA = this.f29278a.a();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.x8)).booleanValue()) {
            zzcdr.b(listenableFutureA, "persistFlags");
        } else {
            zzcdr.a(listenableFutureA, "persistFlags");
        }
    }
}
