package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes4.dex */
public final class zzare extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f24200a;

    /* renamed from: b, reason: collision with root package name */
    public final zzarz f24201b;

    /* renamed from: c, reason: collision with root package name */
    public final zzasg f24202c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f24203d = false;

    /* renamed from: e, reason: collision with root package name */
    public final zzarb f24204e;

    public zzare(PriorityBlockingQueue priorityBlockingQueue, zzarz zzarzVar, zzasg zzasgVar, zzarb zzarbVar) {
        this.f24200a = priorityBlockingQueue;
        this.f24201b = zzarzVar;
        this.f24202c = zzasgVar;
        this.f24204e = zzarbVar;
    }

    public final void a() {
        zzarb zzarbVar = this.f24204e;
        zzark zzarkVar = (zzark) this.f24200a.take();
        SystemClock.elapsedRealtime();
        zzarkVar.c();
        try {
            try {
                zzarkVar.a("network-queue-take");
                synchronized (zzarkVar.f24217e) {
                }
                TrafficStats.setThreadStatsTag(zzarkVar.f24216d);
                zzarg zzargVarA = this.f24201b.a(zzarkVar);
                zzarkVar.a("network-http-complete");
                if (zzargVarA.f24209e && zzarkVar.h()) {
                    zzarkVar.b("not-modified");
                    zzarkVar.p();
                } else {
                    zzarq zzarqVarI = zzarkVar.i(zzargVarA);
                    zzarkVar.a("network-parse-complete");
                    zzaqt zzaqtVar = zzarqVarI.f24237b;
                    if (zzaqtVar != null) {
                        this.f24202c.b(zzarkVar.d(), zzaqtVar);
                        zzarkVar.a("network-cache-written");
                    }
                    synchronized (zzarkVar.f24217e) {
                        zzarkVar.f24221i = true;
                    }
                    zzarbVar.a(zzarkVar, zzarqVarI, null);
                    zzarkVar.n(zzarqVarI);
                }
            } catch (zzart e2) {
                SystemClock.elapsedRealtime();
                zzarbVar.getClass();
                zzarkVar.a("post-error");
                ((zzaqz) zzarbVar.f24197a).f24192a.post(new zzara(zzarkVar, new zzarq(e2), null));
                zzarkVar.p();
            } catch (Exception e3) {
                Log.e("Volley", zzarw.d("Unhandled exception %s", e3.toString()), e3);
                zzart zzartVar = new zzart(e3);
                SystemClock.elapsedRealtime();
                zzarbVar.getClass();
                zzarkVar.a("post-error");
                ((zzaqz) zzarbVar.f24197a).f24192a.post(new zzara(zzarkVar, new zzarq(zzartVar), null));
                zzarkVar.p();
            }
            zzarkVar.c();
        } catch (Throwable th) {
            zzarkVar.c();
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f24203d) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarw.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
