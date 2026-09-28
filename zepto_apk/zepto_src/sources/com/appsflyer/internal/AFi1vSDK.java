package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class AFi1vSDK {

    @NonNull
    public final String AFAdRevenueData;

    @Nullable
    public final Throwable component1;

    @Nullable
    public final String component3;

    @Nullable
    public final AFi1ySDK component4;

    @Nullable
    public final String getCurrencyIso4217Code;
    public final long getMediationNetwork;
    public final int getMonetizationNetwork;
    public final long getRevenue;

    public AFi1vSDK(@Nullable String str, @NonNull String str2, long j2, long j3, int i2, @Nullable AFi1ySDK aFi1ySDK, @Nullable String str3, Throwable th) {
        this.getCurrencyIso4217Code = str;
        this.AFAdRevenueData = str2;
        this.getRevenue = j2;
        this.getMediationNetwork = j3;
        this.getMonetizationNetwork = i2;
        this.component4 = aFi1ySDK;
        this.component3 = str3;
        this.component1 = th;
    }
}
