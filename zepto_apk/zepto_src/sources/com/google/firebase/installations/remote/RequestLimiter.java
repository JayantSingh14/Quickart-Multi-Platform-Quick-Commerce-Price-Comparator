package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
class RequestLimiter {

    /* renamed from: d, reason: collision with root package name */
    public static final long f44646d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    public static final long f44647e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final Utils f44648a;

    /* renamed from: b, reason: collision with root package name */
    public long f44649b;

    /* renamed from: c, reason: collision with root package name */
    public int f44650c;

    public RequestLimiter() {
        if (SystemClock.f44655a == null) {
            Pattern pattern = Utils.f44591c;
            SystemClock.f44655a = new SystemClock();
        }
        SystemClock systemClock = SystemClock.f44655a;
        if (Utils.f44592d == null) {
            Utils.f44592d = new Utils(systemClock);
        }
        this.f44648a = Utils.f44592d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f44650c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            com.google.firebase.installations.Utils r0 = r4.f44648a     // Catch: java.lang.Throwable -> L19
            com.google.firebase.installations.time.SystemClock r0 = r0.f44593a     // Catch: java.lang.Throwable -> L19
            r0.getClass()     // Catch: java.lang.Throwable -> L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            long r2 = r4.f44649b     // Catch: java.lang.Throwable -> L19
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L17
            goto L1b
        L17:
            r0 = 0
            goto L1c
        L19:
            r0 = move-exception
            goto L1e
        L1b:
            r0 = 1
        L1c:
            monitor-exit(r4)
            return r0
        L1e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.RequestLimiter.a():boolean");
    }

    public final synchronized void b(int i2) {
        long jMin;
        if ((i2 >= 200 && i2 < 300) || i2 == 401 || i2 == 404) {
            synchronized (this) {
                this.f44650c = 0;
            }
            return;
        }
        this.f44650c++;
        synchronized (this) {
            if (i2 == 429 || (i2 >= 500 && i2 < 600)) {
                double dPow = Math.pow(2.0d, this.f44650c);
                this.f44648a.getClass();
                jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f44647e);
            } else {
                jMin = f44646d;
            }
            this.f44648a.f44593a.getClass();
            this.f44649b = System.currentTimeMillis() + jMin;
        }
        return;
    }
}
