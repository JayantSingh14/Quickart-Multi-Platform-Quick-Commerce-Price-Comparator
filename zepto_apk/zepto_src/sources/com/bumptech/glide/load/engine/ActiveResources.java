package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class ActiveResources {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f15860a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f15861b;

    /* renamed from: c, reason: collision with root package name */
    public final ReferenceQueue f15862c;

    /* renamed from: d, reason: collision with root package name */
    public Engine f15863d;

    /* renamed from: com.bumptech.glide.load.engine.ActiveResources$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                @Override // java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }, "glide-active-resources");
        }
    }

    @VisibleForTesting
    public interface DequeuedResourceCallback {
    }

    @VisibleForTesting
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final Key f15866a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f15867b;

        /* renamed from: c, reason: collision with root package name */
        public Resource f15868c;

        public ResourceWeakReference(Key key, EngineResource engineResource, ReferenceQueue referenceQueue) {
            super(engineResource, referenceQueue);
            Preconditions.c(key, "Argument must not be null");
            this.f15866a = key;
            boolean z = engineResource.f15993a;
            this.f15868c = null;
            this.f15867b = z;
        }
    }

    public ActiveResources() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new AnonymousClass1());
        this.f15861b = new HashMap();
        this.f15862c = new ReferenceQueue();
        this.f15860a = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public final void run() {
                ActiveResources activeResources = ActiveResources.this;
                activeResources.getClass();
                while (true) {
                    try {
                        activeResources.b((ResourceWeakReference) activeResources.f15862c.remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    public final synchronized void a(Key key, EngineResource engineResource) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f15861b.put(key, new ResourceWeakReference(key, engineResource, this.f15862c));
        if (resourceWeakReference != null) {
            resourceWeakReference.f15868c = null;
            resourceWeakReference.clear();
        }
    }

    public final void b(ResourceWeakReference resourceWeakReference) {
        Resource resource;
        synchronized (this) {
            this.f15861b.remove(resourceWeakReference.f15866a);
            if (resourceWeakReference.f15867b && (resource = resourceWeakReference.f15868c) != null) {
                this.f15863d.e(resourceWeakReference.f15866a, new EngineResource(resource, true, false, resourceWeakReference.f15866a, this.f15863d));
            }
        }
    }
}
