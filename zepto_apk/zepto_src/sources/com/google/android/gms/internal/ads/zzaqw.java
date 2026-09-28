package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes4.dex */
public final class zzaqw extends Thread {

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f24183g = zzarw.f24246a;

    /* renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f24184a;

    /* renamed from: b, reason: collision with root package name */
    public final PriorityBlockingQueue f24185b;

    /* renamed from: c, reason: collision with root package name */
    public final zzasg f24186c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f24187d = false;

    /* renamed from: e, reason: collision with root package name */
    public final zzarx f24188e;

    /* renamed from: f, reason: collision with root package name */
    public final zzarb f24189f;

    public zzaqw(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, zzasg zzasgVar, zzarb zzarbVar) {
        this.f24184a = priorityBlockingQueue;
        this.f24185b = priorityBlockingQueue2;
        this.f24186c = zzasgVar;
        this.f24189f = zzarbVar;
        this.f24188e = new zzarx(this, priorityBlockingQueue2, zzarbVar);
    }

    public final void a() {
        zzark zzarkVar = (zzark) this.f24184a.take();
        zzarkVar.a("cache-queue-take");
        zzarkVar.c();
        try {
            synchronized (zzarkVar.f24217e) {
            }
            zzasg zzasgVar = this.f24186c;
            zzaqt zzaqtVarA = zzasgVar.a(zzarkVar.d());
            PriorityBlockingQueue priorityBlockingQueue = this.f24185b;
            zzarx zzarxVar = this.f24188e;
            if (zzaqtVarA == null) {
                zzarkVar.a("cache-miss");
                if (!zzarxVar.b(zzarkVar)) {
                    priorityBlockingQueue.put(zzarkVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzaqtVarA.f24177e < jCurrentTimeMillis) {
                    zzarkVar.a("cache-hit-expired");
                    zzarkVar.f24222j = zzaqtVarA;
                    if (!zzarxVar.b(zzarkVar)) {
                        priorityBlockingQueue.put(zzarkVar);
                    }
                } else {
                    zzarkVar.a("cache-hit");
                    byte[] bArr = zzaqtVarA.f24173a;
                    Map map = zzaqtVarA.f24179g;
                    zzarq zzarqVarI = zzarkVar.i(new zzarg(200, bArr, map, zzarg.a(map), false));
                    zzarkVar.a("cache-hit-parsed");
                    if (zzarqVarI.f24238c == null) {
                        long j2 = zzaqtVarA.f24178f;
                        zzarb zzarbVar = this.f24189f;
                        if (j2 < jCurrentTimeMillis) {
                            zzarkVar.a("cache-hit-refresh-needed");
                            zzarkVar.f24222j = zzaqtVarA;
                            zzarqVarI.f24239d = true;
                            if (zzarxVar.b(zzarkVar)) {
                                zzarbVar.a(zzarkVar, zzarqVarI, null);
                            } else {
                                zzarbVar.a(zzarkVar, zzarqVarI, new zzaqv(this, zzarkVar));
                            }
                        } else {
                            zzarbVar.a(zzarkVar, zzarqVarI, null);
                        }
                    } else {
                        zzarkVar.a("cache-parsing-failed");
                        String strD = zzarkVar.d();
                        synchronized (zzasgVar) {
                            try {
                                zzaqt zzaqtVarA2 = zzasgVar.a(strD);
                                if (zzaqtVarA2 != null) {
                                    zzaqtVarA2.f24178f = 0L;
                                    zzaqtVarA2.f24177e = 0L;
                                    zzasgVar.b(strD, zzaqtVarA2);
                                }
                            } finally {
                            }
                        }
                        zzarkVar.f24222j = null;
                        if (!zzarxVar.b(zzarkVar)) {
                            priorityBlockingQueue.put(zzarkVar);
                        }
                    }
                }
            }
            zzarkVar.c();
        } catch (Throwable th) {
            zzarkVar.c();
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        if (f24183g) {
            zzarw.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f24186c.c();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f24187d) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarw.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
