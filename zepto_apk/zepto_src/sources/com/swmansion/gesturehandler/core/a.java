package com.swmansion.gesturehandler.core;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46801a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GestureHandler f46802b;

    public /* synthetic */ a(int i2, GestureHandler gestureHandler) {
        this.f46801a = i2;
        this.f46802b = gestureHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f46801a) {
            case 0:
                this.f46802b.e();
                break;
            default:
                this.f46802b.e();
                break;
        }
    }
}
