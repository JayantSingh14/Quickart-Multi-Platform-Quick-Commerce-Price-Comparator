package com.appsflyer;

import com.appsflyer.internal.AFg1gSDK;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15293a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AFg1gSDK[] f15294b;

    public /* synthetic */ a(AFg1gSDK[] aFg1gSDKArr, int i2) {
        this.f15293a = i2;
        this.f15294b = aFg1gSDKArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15293a) {
            case 0:
                AFLogger.getMediationNetwork(this.f15294b);
                break;
            default:
                AFLogger.getCurrencyIso4217Code(this.f15294b);
                break;
        }
    }
}
