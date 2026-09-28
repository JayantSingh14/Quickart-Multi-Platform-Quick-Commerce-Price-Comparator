package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzgbo implements zzgbj {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f32229a = Executors.newSingleThreadScheduledExecutor();

    @Override // com.google.android.gms.internal.ads.zzgbj
    public final void a(long j2, Runnable runnable) {
        this.f32229a.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzgbj
    public final void zzb() {
    }
}
