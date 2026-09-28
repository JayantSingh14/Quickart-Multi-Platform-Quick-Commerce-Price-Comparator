package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final /* synthetic */ class zzews implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzews f30496a = new zzews();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzax zzaxVar = zztVar.o;
        synchronized (zzaxVar.f21505a) {
            str = zzaxVar.f21507c;
        }
        return new zzewu(str, zztVar.o.h());
    }
}
