package com.appsflyer.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AFb1lSDK f15317b;

    public /* synthetic */ e(AFb1lSDK aFb1lSDK, int i2) {
        this.f15316a = i2;
        this.f15317b = aFb1lSDK;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15316a) {
            case 0:
                AFb1lSDK.getRevenue(this.f15317b);
                break;
            default:
                AFb1lSDK.AFAdRevenueData(this.f15317b);
                break;
        }
    }
}
