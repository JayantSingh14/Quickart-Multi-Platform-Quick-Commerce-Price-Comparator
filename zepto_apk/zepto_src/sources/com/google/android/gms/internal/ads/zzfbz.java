package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfbz implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f30828a;

    public zzfbz(ScheduledExecutorService scheduledExecutorService) {
        this.f30828a = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.i(zzgym.g(zzgym.a(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S4)).longValue(), TimeUnit.MILLISECONDS, this.f30828a), zzfby.f30827a, zzcdo.f25982a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 49;
    }
}
