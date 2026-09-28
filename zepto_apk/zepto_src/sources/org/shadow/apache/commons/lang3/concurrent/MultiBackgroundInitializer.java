package org.shadow.apache.commons.lang3.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.shadow.apache.commons.lang3.concurrent.BackgroundInitializer;

/* loaded from: classes5.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f57753d;

    public static class MultiBackgroundInitializerResults {
    }

    public MultiBackgroundInitializer() {
        e(null);
        this.f57753d = new HashMap();
    }

    @Override // org.shadow.apache.commons.lang3.concurrent.BackgroundInitializer
    public final int c() {
        Iterator it = this.f57753d.values().iterator();
        int iC = 1;
        while (it.hasNext()) {
            iC += ((BackgroundInitializer) it.next()).c();
        }
        return iC;
    }

    @Override // org.shadow.apache.commons.lang3.concurrent.BackgroundInitializer
    public final Object d() {
        HashMap map;
        ExecutorService executorService;
        ExecutorService executorService2;
        boolean z;
        ExecutorService executorServiceNewFixedThreadPool;
        synchronized (this) {
            map = new HashMap(this.f57753d);
        }
        synchronized (this) {
            executorService = this.f57749b;
        }
        for (BackgroundInitializer backgroundInitializer : map.values()) {
            synchronized (backgroundInitializer) {
                executorService2 = backgroundInitializer.f57748a;
            }
            if (executorService2 == null) {
                backgroundInitializer.e(executorService);
            }
            synchronized (backgroundInitializer) {
                try {
                    synchronized (backgroundInitializer) {
                        z = backgroundInitializer.f57750c != null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                synchronized (backgroundInitializer) {
                    ExecutorService executorService3 = backgroundInitializer.f57748a;
                    backgroundInitializer.f57749b = executorService3;
                    if (executorService3 == null) {
                        executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(backgroundInitializer.c());
                        backgroundInitializer.f57749b = executorServiceNewFixedThreadPool;
                    } else {
                        executorServiceNewFixedThreadPool = null;
                    }
                    backgroundInitializer.f57750c = backgroundInitializer.f57749b.submit(new BackgroundInitializer.InitializationTask(executorServiceNewFixedThreadPool));
                }
            }
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            try {
                map2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).a());
            } catch (ConcurrentException e2) {
                map3.put(entry.getKey(), e2);
            }
        }
        return new MultiBackgroundInitializerResults();
    }
}
