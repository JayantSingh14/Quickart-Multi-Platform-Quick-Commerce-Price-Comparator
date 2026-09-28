package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzcsj implements zzbde {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f27058a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f27059b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f27060c;

    /* renamed from: d, reason: collision with root package name */
    public long f27061d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f27062e = -1;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f27063f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f27064g = false;

    public zzcsj(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.f27058a = scheduledExecutorService;
        this.f27059b = clock;
        com.google.android.gms.ads.internal.zzt.C.f21683g.b(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void j1(boolean z) {
        ScheduledFuture scheduledFuture;
        if (z) {
            synchronized (this) {
                try {
                    if (this.f27064g) {
                        if (this.f27062e > 0 && (scheduledFuture = this.f27060c) != null && scheduledFuture.isCancelled()) {
                            this.f27060c = this.f27058a.schedule(this.f27063f, this.f27062e, TimeUnit.MILLISECONDS);
                        }
                        this.f27064g = false;
                        return;
                    }
                    return;
                } finally {
                }
            }
        }
        synchronized (this) {
            try {
                if (this.f27064g) {
                    return;
                }
                ScheduledFuture scheduledFuture2 = this.f27060c;
                if (scheduledFuture2 == null || scheduledFuture2.isDone()) {
                    this.f27062e = -1L;
                } else {
                    this.f27060c.cancel(true);
                    this.f27062e = this.f27061d - this.f27059b.elapsedRealtime();
                }
                this.f27064g = true;
            } finally {
            }
        }
    }
}
