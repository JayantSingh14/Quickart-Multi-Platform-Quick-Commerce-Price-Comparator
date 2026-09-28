package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f43659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f43660c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f43661d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f43662e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j2, TimeUnit timeUnit, int i2) {
        this.f43658a = i2;
        this.f43659b = delegatingScheduledExecutorService;
        this.f43662e = obj;
        this.f43660c = j2;
        this.f43661d = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture a(final DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
        switch (this.f43658a) {
            case 0:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f43659b;
                return delegatingScheduledExecutorService.f43630b.schedule(new e(delegatingScheduledExecutorService, (Runnable) this.f43662e, anonymousClass1, 1), this.f43660c, this.f43661d);
            default:
                final DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = this.f43659b;
                final Callable callable = (Callable) this.f43662e;
                return delegatingScheduledExecutorService2.f43630b.schedule(new Callable() { // from class: com.google.firebase.concurrent.f
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        DelegatingScheduledExecutorService delegatingScheduledExecutorService3 = delegatingScheduledExecutorService2;
                        return delegatingScheduledExecutorService3.f43629a.submit(new c(callable, anonymousClass1, 3));
                    }
                }, this.f43660c, this.f43661d);
        }
    }
}
