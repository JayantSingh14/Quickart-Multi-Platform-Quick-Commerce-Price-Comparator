package com.appsflyer.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15332a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AFj1sSDK f15333b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f15334c;

    public /* synthetic */ n(AFj1sSDK aFj1sSDK, Runnable runnable, int i2) {
        this.f15332a = i2;
        this.f15333b = aFj1sSDK;
        this.f15334c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15332a) {
            case 0:
                this.f15333b.getCurrencyIso4217Code(this.f15334c);
                break;
            case 1:
                this.f15333b.component2(this.f15334c);
                break;
            default:
                this.f15333b.getMonetizationNetwork(this.f15334c);
                break;
        }
    }
}
