package com.appsflyer.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AFj1nSDK f15331b;

    public /* synthetic */ m(AFj1nSDK aFj1nSDK, int i2) {
        this.f15330a = i2;
        this.f15331b = aFj1nSDK;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15330a) {
            case 0:
                this.f15331b.areAllFieldsValid();
                break;
            case 1:
                this.f15331b.component1();
                break;
            default:
                this.f15331b.component4();
                break;
        }
    }
}
