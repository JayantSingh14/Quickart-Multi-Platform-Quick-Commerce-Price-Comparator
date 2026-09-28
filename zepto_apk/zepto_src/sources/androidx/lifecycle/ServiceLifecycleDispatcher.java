package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class ServiceLifecycleDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f4922a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f4923b;

    /* renamed from: c, reason: collision with root package name */
    public DispatchRunnable f4924c;

    @Metadata
    public static final class DispatchRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final LifecycleRegistry f4925a;

        /* renamed from: b, reason: collision with root package name */
        public final Lifecycle.Event f4926b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4927c;

        public DispatchRunnable(LifecycleRegistry registry, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            Intrinsics.checkNotNullParameter(event, "event");
            this.f4925a = registry;
            this.f4926b = event;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f4927c) {
                return;
            }
            this.f4925a.f(this.f4926b);
            this.f4927c = true;
        }
    }

    public ServiceLifecycleDispatcher(LifecycleService provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f4922a = new LifecycleRegistry(provider);
        this.f4923b = new Handler();
    }

    public final void a(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f4924c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f4922a, event);
        this.f4924c = dispatchRunnable2;
        this.f4923b.postAtFrontOfQueue(dispatchRunnable2);
    }
}
