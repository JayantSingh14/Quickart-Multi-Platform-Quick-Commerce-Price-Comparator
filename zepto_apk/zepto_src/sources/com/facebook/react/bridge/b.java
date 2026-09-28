package com.facebook.react.bridge;

import com.facebook.react.bridge.CatalystInstanceImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18679a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CatalystInstanceImpl f18680b;

    public /* synthetic */ b(CatalystInstanceImpl catalystInstanceImpl, int i2) {
        this.f18679a = i2;
        this.f18680b = catalystInstanceImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18679a) {
            case 0:
                CatalystInstanceImpl.InstanceCallback.lambda$onBatchComplete$0(this.f18680b);
                break;
            case 1:
                this.f18680b.lambda$incrementPendingJSCalls$4();
                break;
            case 2:
                this.f18680b.lambda$initialize$3();
                break;
            default:
                this.f18680b.lambda$decrementPendingJSCalls$5();
                break;
        }
    }
}
