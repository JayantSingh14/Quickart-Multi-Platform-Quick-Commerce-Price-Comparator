package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzgza extends zzgyh implements zzgyv {

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledFuture f33393b;

    public zzgza(zzgxf zzgxfVar, ScheduledFuture scheduledFuture) {
        super(zzgxfVar);
        this.f33393b = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgyg, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean zCancel = this.f33372a.cancel(z);
        if (zCancel) {
            this.f33393b.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.f33393b.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f33393b.getDelay(timeUnit);
    }
}
