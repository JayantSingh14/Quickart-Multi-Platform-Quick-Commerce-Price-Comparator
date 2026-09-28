package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class j implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f43684b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f43685c;

    public /* synthetic */ j(Runnable runnable, Object obj, int i2) {
        this.f43683a = i2;
        this.f43684b = runnable;
        this.f43685c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f43683a) {
            case 0:
                this.f43684b.run();
                break;
            default:
                this.f43684b.run();
                break;
        }
        return this.f43685c;
    }
}
