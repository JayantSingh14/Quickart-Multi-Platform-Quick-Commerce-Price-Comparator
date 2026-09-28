package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzgbl implements zzgbj {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f32223a;

    /* renamed from: b, reason: collision with root package name */
    public final PriorityQueue f32224b = new PriorityQueue();

    public zzgbl(Executor executor) {
        this.f32223a = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzgbj
    public final void a(long j2, Runnable runnable) {
        if (j2 <= 0) {
            this.f32223a.execute(runnable);
            return;
        }
        zzgbn zzgbnVar = new zzgbn(System.currentTimeMillis() + j2, runnable);
        PriorityQueue priorityQueue = this.f32224b;
        synchronized (priorityQueue) {
            priorityQueue.add(zzgbnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbj
    public final void zzb() {
        PriorityQueue priorityQueue = this.f32224b;
        synchronized (priorityQueue) {
            try {
                if (priorityQueue.isEmpty()) {
                    return;
                }
                PriorityQueue priorityQueue2 = new PriorityQueue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (zzgbn zzgbnVar = (zzgbn) priorityQueue.peek(); zzgbnVar != null && zzgbnVar.f32228b <= jCurrentTimeMillis; zzgbnVar = (zzgbn) priorityQueue.peek()) {
                    priorityQueue2.add(zzgbnVar);
                }
                Iterator it = priorityQueue2.iterator();
                while (it.hasNext()) {
                    try {
                        this.f32223a.execute(((zzgbn) it.next()).f32227a);
                    } catch (RuntimeException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
