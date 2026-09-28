package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43666a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f43667b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f43668c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f43669d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f43670e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f43671f;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, long j3, TimeUnit timeUnit, int i2) {
        this.f43666a = i2;
        this.f43667b = delegatingScheduledExecutorService;
        this.f43668c = runnable;
        this.f43669d = j2;
        this.f43670e = j3;
        this.f43671f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture a(DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
        switch (this.f43666a) {
            case 0:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f43667b;
                return delegatingScheduledExecutorService.f43630b.scheduleAtFixedRate(new e(delegatingScheduledExecutorService, this.f43668c, anonymousClass1, 0), this.f43669d, this.f43670e, this.f43671f);
            default:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = this.f43667b;
                return delegatingScheduledExecutorService2.f43630b.scheduleWithFixedDelay(new e(delegatingScheduledExecutorService2, this.f43668c, anonymousClass1, 2), this.f43669d, this.f43670e, this.f43671f);
        }
    }
}
