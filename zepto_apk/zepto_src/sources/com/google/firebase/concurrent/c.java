package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43663a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f43664b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.AnonymousClass1 f43665c;

    public /* synthetic */ c(Object obj, DelegatingScheduledFuture.AnonymousClass1 anonymousClass1, int i2) {
        this.f43663a = i2;
        this.f43664b = obj;
        this.f43665c = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f43663a) {
            case 0:
                try {
                    ((Runnable) this.f43664b).run();
                    return;
                } catch (Exception e2) {
                    this.f43665c.b(e2);
                    throw e2;
                }
            case 1:
                try {
                    ((Runnable) this.f43664b).run();
                    return;
                } catch (Exception e3) {
                    this.f43665c.b(e3);
                    return;
                }
            case 2:
                Runnable runnable = (Runnable) this.f43664b;
                DelegatingScheduledFuture.AnonymousClass1 anonymousClass1 = this.f43665c;
                try {
                    runnable.run();
                    anonymousClass1.a(null);
                    return;
                } catch (Exception e4) {
                    anonymousClass1.b(e4);
                    return;
                }
            default:
                Callable callable = (Callable) this.f43664b;
                DelegatingScheduledFuture.AnonymousClass1 anonymousClass12 = this.f43665c;
                try {
                    anonymousClass12.a(callable.call());
                    return;
                } catch (Exception e5) {
                    anonymousClass12.b(e5);
                    return;
                }
        }
    }
}
