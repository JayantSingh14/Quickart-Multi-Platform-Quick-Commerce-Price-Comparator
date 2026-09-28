package com.facebook.react.devsupport;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18945a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogBoxModule f18946b;

    public /* synthetic */ k(LogBoxModule logBoxModule, int i2) {
        this.f18945a = i2;
        this.f18946b = logBoxModule;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18945a) {
            case 0:
                LogBoxModule.hide$lambda$1(this.f18946b);
                break;
            case 1:
                LogBoxModule.invalidate$lambda$2(this.f18946b);
                break;
            default:
                LogBoxModule.show$lambda$0(this.f18946b);
                break;
        }
    }
}
