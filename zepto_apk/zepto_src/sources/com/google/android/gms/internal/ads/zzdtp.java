package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes4.dex */
final class zzdtp implements com.google.android.gms.ads.internal.zzn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdua f28530a;

    public zzdtp(zzdua zzduaVar) {
        Objects.requireNonNull(zzduaVar);
        this.f28530a = zzduaVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void D0() {
        zzddl zzddlVar = this.f28530a.f28561g;
        synchronized (zzddlVar) {
            try {
                if (zzddlVar.f27642i) {
                    return;
                }
                ScheduledFuture scheduledFuture = zzddlVar.f27643j;
                if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                    zzddlVar.f27640g = -1L;
                } else {
                    zzddlVar.f27643j.cancel(false);
                    zzddlVar.f27640g = zzddlVar.f27638e - zzddlVar.f27636c.elapsedRealtime();
                }
                ScheduledFuture scheduledFuture2 = zzddlVar.f27644k;
                if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                    zzddlVar.f27641h = -1L;
                } else {
                    zzddlVar.f27644k.cancel(false);
                    zzddlVar.f27641h = zzddlVar.f27639f - zzddlVar.f27636c.elapsedRealtime();
                }
                zzddlVar.f27642i = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void v0() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        zzddl zzddlVar = this.f28530a.f28561g;
        synchronized (zzddlVar) {
            try {
                if (zzddlVar.f27642i) {
                    if (zzddlVar.f27640g > 0 && (scheduledFuture2 = zzddlVar.f27643j) != null && scheduledFuture2.isCancelled()) {
                        zzddlVar.z0(zzddlVar.f27640g);
                    }
                    if (zzddlVar.f27641h > 0 && (scheduledFuture = zzddlVar.f27644k) != null && scheduledFuture.isCancelled()) {
                        zzddlVar.A0(zzddlVar.f27641h);
                    }
                    zzddlVar.f27642i = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
