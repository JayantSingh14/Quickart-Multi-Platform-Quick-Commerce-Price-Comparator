package com.facebook.react.bridge;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CatalystInstanceImpl f18678b;

    public /* synthetic */ a(CatalystInstanceImpl catalystInstanceImpl, int i2) {
        this.f18677a = i2;
        this.f18678b = catalystInstanceImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18677a) {
            case 0:
                this.f18678b.lambda$destroy$2();
                break;
            case 1:
                this.f18678b.lambda$destroy$1();
                break;
            case 2:
                this.f18678b.lambda$onNativeException$6();
                break;
            default:
                this.f18678b.lambda$destroy$0();
                break;
        }
    }
}
