package com.appsflyer.internal;

import com.appsflyer.internal.AFd1vSDK;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements AFd1vSDK.AFa1ySDK, AFf1mSDK {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AFa1tSDK f15311a;

    public /* synthetic */ b(AFa1tSDK aFa1tSDK) {
        this.f15311a = aFa1tSDK;
    }

    @Override // com.appsflyer.internal.AFd1vSDK.AFa1ySDK
    public void onConfigurationChanged(boolean z) {
        this.f15311a.getMonetizationNetwork(z);
    }

    @Override // com.appsflyer.internal.AFf1mSDK
    public void onRemoteConfigUpdateFinished(AFf1nSDK aFf1nSDK) {
        this.f15311a.getCurrencyIso4217Code(aFf1nSDK);
    }
}
