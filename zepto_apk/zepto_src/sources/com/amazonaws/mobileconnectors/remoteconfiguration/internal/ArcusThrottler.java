package com.amazonaws.mobileconnectors.remoteconfiguration.internal;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class ArcusThrottler {
    public static final int CAUSE_FAILED_SYNC = 20;
    public static final int CAUSE_NONE = 0;
    public static final int CAUSE_SUCCESSFUL_SYNC = 10;
    public static final int CAUSE_THROTTLED_SYNC = 30;

    /* renamed from: a, reason: collision with root package name */
    public long f15261a;

    /* renamed from: b, reason: collision with root package name */
    public int f15262b;

    /* renamed from: c, reason: collision with root package name */
    public int f15263c = 0;

    public long a() {
        long j2 = 1000 << (this.f15262b + 1);
        if (j2 <= 0 || j2 > 900000) {
            return 900000L;
        }
        return j2;
    }

    public int getCause() {
        return this.f15263c;
    }

    public long getTimeToNextSyncInMS() {
        return Math.max(0L, this.f15261a - SystemClock.elapsedRealtime());
    }

    public boolean isSyncAllowedRightNow() {
        return getTimeToNextSyncInMS() == 0;
    }

    public void updateSyncTimeAfterFailure() {
        if (a() < 900000) {
            this.f15262b++;
        }
        this.f15261a = SystemClock.elapsedRealtime() + ((long) (Math.random() * a()));
        this.f15263c = 20;
    }

    public void updateSyncTimeAfterSuccess() {
        this.f15262b = 0;
        this.f15261a = SystemClock.elapsedRealtime() + 900000;
        this.f15263c = 10;
    }

    public void updateSyncTimeAfterThrottle(long j2) {
        if (j2 <= 0) {
            j2 = 900000;
        }
        this.f15262b = 0;
        this.f15261a = Math.min(j2, 900000L) + SystemClock.elapsedRealtime() + ((long) (Math.random() * 5000.0d));
        this.f15263c = 30;
    }
}
