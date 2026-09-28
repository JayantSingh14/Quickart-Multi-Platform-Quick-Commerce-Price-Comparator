package com.appsflyer.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15322a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AFd1uSDK f15323b;

    public /* synthetic */ i(AFd1uSDK aFd1uSDK, int i2) {
        this.f15322a = i2;
        this.f15323b = aFd1uSDK;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15322a) {
            case 0:
                AFd1uSDK.AFAdRevenueData(this.f15323b);
                break;
            case 1:
                AFd1uSDK.getMediationNetwork(this.f15323b);
                break;
            default:
                AFd1uSDK.getMonetizationNetwork(this.f15323b);
                break;
        }
    }
}
