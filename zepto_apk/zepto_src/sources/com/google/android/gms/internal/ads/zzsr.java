package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes4.dex */
final class zzsr {

    /* renamed from: a, reason: collision with root package name */
    public Exception f35536a;

    /* renamed from: b, reason: collision with root package name */
    public long f35537b = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public long f35538c = -9223372036854775807L;

    public final void a(Exception exc) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f35536a == null) {
            this.f35536a = exc;
        }
        if (this.f35537b == -9223372036854775807L && zzss.X.get() <= 0) {
            this.f35537b = 200 + jElapsedRealtime;
        }
        long j2 = this.f35537b;
        if (j2 == -9223372036854775807L || jElapsedRealtime < j2) {
            this.f35538c = jElapsedRealtime + 50;
            return;
        }
        Exception exc2 = this.f35536a;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = this.f35536a;
        this.f35536a = null;
        this.f35537b = -9223372036854775807L;
        this.f35538c = -9223372036854775807L;
        throw exc3;
    }
}
