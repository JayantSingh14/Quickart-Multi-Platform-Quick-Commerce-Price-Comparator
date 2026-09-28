package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzarn {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f24225a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f24226b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue f24227c;

    /* renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue f24228d;

    /* renamed from: e, reason: collision with root package name */
    public final zzasg f24229e;

    /* renamed from: f, reason: collision with root package name */
    public final zzarz f24230f;

    /* renamed from: g, reason: collision with root package name */
    public final zzare[] f24231g;

    /* renamed from: h, reason: collision with root package name */
    public zzaqw f24232h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f24233i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f24234j;

    /* renamed from: k, reason: collision with root package name */
    public final zzarb f24235k;

    public zzarn(zzasg zzasgVar, zzarz zzarzVar) {
        zzarb zzarbVar = new zzarb(new Handler(Looper.getMainLooper()));
        this.f24225a = new AtomicInteger();
        this.f24226b = new HashSet();
        this.f24227c = new PriorityBlockingQueue();
        this.f24228d = new PriorityBlockingQueue();
        this.f24233i = new ArrayList();
        this.f24234j = new ArrayList();
        this.f24229e = zzasgVar;
        this.f24230f = zzarzVar;
        this.f24231g = new zzare[4];
        this.f24235k = zzarbVar;
    }

    public final void a() {
        zzaqw zzaqwVar = this.f24232h;
        if (zzaqwVar != null) {
            zzaqwVar.f24187d = true;
            zzaqwVar.interrupt();
        }
        zzare[] zzareVarArr = this.f24231g;
        for (int i2 = 0; i2 < 4; i2++) {
            zzare zzareVar = zzareVarArr[i2];
            if (zzareVar != null) {
                zzareVar.f24203d = true;
                zzareVar.interrupt();
            }
        }
        PriorityBlockingQueue priorityBlockingQueue = this.f24227c;
        PriorityBlockingQueue priorityBlockingQueue2 = this.f24228d;
        zzasg zzasgVar = this.f24229e;
        zzarb zzarbVar = this.f24235k;
        zzaqw zzaqwVar2 = new zzaqw(priorityBlockingQueue, priorityBlockingQueue2, zzasgVar, zzarbVar);
        this.f24232h = zzaqwVar2;
        zzaqwVar2.start();
        for (int i3 = 0; i3 < 4; i3++) {
            zzare zzareVar2 = new zzare(priorityBlockingQueue2, this.f24230f, zzasgVar, zzarbVar);
            zzareVarArr[i3] = zzareVar2;
            zzareVar2.start();
        }
    }

    public final void b(zzark zzarkVar) {
        zzarkVar.f24220h = this;
        HashSet hashSet = this.f24226b;
        synchronized (hashSet) {
            hashSet.add(zzarkVar);
        }
        zzarkVar.f24219g = Integer.valueOf(this.f24225a.incrementAndGet());
        zzarkVar.a("add-to-queue");
        c();
        this.f24227c.add(zzarkVar);
    }

    public final void c() {
        ArrayList arrayList = this.f24234j;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzarl) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
