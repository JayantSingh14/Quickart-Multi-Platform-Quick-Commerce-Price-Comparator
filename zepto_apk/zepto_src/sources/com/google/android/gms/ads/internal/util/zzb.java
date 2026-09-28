package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzgxi;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public abstract class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f21514a = new zza(this);

    public abstract void a();

    public ListenableFuture b() {
        return ((zzgxi) zzcdo.f25982a).submit(this.f21514a);
    }
}
