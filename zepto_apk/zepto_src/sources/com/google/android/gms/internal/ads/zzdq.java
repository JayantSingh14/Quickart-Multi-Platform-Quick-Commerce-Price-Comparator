package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class zzdq {

    /* renamed from: a, reason: collision with root package name */
    public boolean f28219a;

    public zzdq() {
        throw null;
    }

    public final synchronized boolean a() {
        if (this.f28219a) {
            return false;
        }
        this.f28219a = true;
        notifyAll();
        return true;
    }

    public final synchronized void b() {
        boolean z = false;
        while (!this.f28219a) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean c(long j2) {
        if (j2 > 0) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = j2 + jElapsedRealtime;
                if (j3 < jElapsedRealtime) {
                    b();
                } else {
                    boolean z = false;
                    while (!this.f28219a && jElapsedRealtime < j3) {
                        try {
                            wait(j3 - jElapsedRealtime);
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f28219a;
    }
}
