package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzcdr {
    public static void a(ListenableFuture listenableFuture, String str) {
        zzcdp zzcdpVar = new zzcdp(str);
        listenableFuture.q(new zzgyk(listenableFuture, zzcdpVar), zzcdo.f25988g);
    }

    public static void b(ListenableFuture listenableFuture, String str) {
        zzcdq zzcdqVar = new zzcdq(str);
        listenableFuture.q(new zzgyk(listenableFuture, zzcdqVar), zzcdo.f25988g);
    }
}
