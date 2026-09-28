package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43672a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f43673b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f43674c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.AnonymousClass1 f43675d;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.AnonymousClass1 anonymousClass1, int i2) {
        this.f43672a = i2;
        this.f43673b = delegatingScheduledExecutorService;
        this.f43674c = runnable;
        this.f43675d = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f43672a) {
            case 0:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f43673b;
                delegatingScheduledExecutorService.f43629a.execute(new c(this.f43674c, this.f43675d, 0));
                break;
            case 1:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = this.f43673b;
                delegatingScheduledExecutorService2.f43629a.execute(new c(this.f43674c, this.f43675d, 2));
                break;
            default:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService3 = this.f43673b;
                delegatingScheduledExecutorService3.f43629a.execute(new c(this.f43674c, this.f43675d, 1));
                break;
        }
    }
}
