package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes4.dex */
final class zzarx implements zzarj {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f24248a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final zzaqw f24249b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue f24250c;

    /* renamed from: d, reason: collision with root package name */
    public final zzarb f24251d;

    public zzarx(zzaqw zzaqwVar, PriorityBlockingQueue priorityBlockingQueue, zzarb zzarbVar) {
        this.f24251d = zzarbVar;
        this.f24249b = zzaqwVar;
        this.f24250c = priorityBlockingQueue;
    }

    public final synchronized void a(zzark zzarkVar) {
        try {
            HashMap map = this.f24248a;
            String strD = zzarkVar.d();
            List list = (List) map.remove(strD);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (zzarw.f24246a) {
                zzarw.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strD);
            }
            zzark zzarkVar2 = (zzark) list.remove(0);
            map.put(strD, list);
            synchronized (zzarkVar2.f24217e) {
                zzarkVar2.f24223k = this;
            }
            try {
                this.f24250c.put(zzarkVar2);
            } catch (InterruptedException e2) {
                zzarw.c("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                zzaqw zzaqwVar = this.f24249b;
                zzaqwVar.f24187d = true;
                zzaqwVar.interrupt();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b(zzark zzarkVar) {
        try {
            HashMap map = this.f24248a;
            String strD = zzarkVar.d();
            if (!map.containsKey(strD)) {
                map.put(strD, null);
                synchronized (zzarkVar.f24217e) {
                    zzarkVar.f24223k = this;
                }
                if (zzarw.f24246a) {
                    zzarw.b("new request, sending to network %s", strD);
                }
                return false;
            }
            List arrayList = (List) map.get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            zzarkVar.a("waiting-for-response");
            arrayList.add(zzarkVar);
            map.put(strD, arrayList);
            if (zzarw.f24246a) {
                zzarw.b("Request for cacheKey=%s is in flight, putting on hold.", strD);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
