package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class i implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43681a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f43682b;

    public /* synthetic */ i(Runnable runnable, int i2) {
        this.f43681a = i2;
        this.f43682b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f43681a) {
            case 0:
                this.f43682b.run();
                break;
            default:
                this.f43682b.run();
                break;
        }
        return null;
    }
}
