package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes3.dex */
public final class AFg1zSDK {
    final int AFAdRevenueData;
    final int getCurrencyIso4217Code;

    @NotNull
    final String getMediationNetwork;
    final int getMonetizationNetwork;
    final int getRevenue;

    public AFg1zSDK(int i2, int i3, int i4, int i5, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getMonetizationNetwork = i2;
        this.getCurrencyIso4217Code = i3;
        this.getRevenue = i4;
        this.AFAdRevenueData = i5;
        this.getMediationNetwork = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFg1zSDK)) {
            return false;
        }
        AFg1zSDK aFg1zSDK = (AFg1zSDK) obj;
        return this.getMonetizationNetwork == aFg1zSDK.getMonetizationNetwork && this.getCurrencyIso4217Code == aFg1zSDK.getCurrencyIso4217Code && this.getRevenue == aFg1zSDK.getRevenue && this.AFAdRevenueData == aFg1zSDK.AFAdRevenueData && Intrinsics.b(this.getMediationNetwork, aFg1zSDK.getMediationNetwork);
    }

    public final int hashCode() {
        return this.getMediationNetwork.hashCode() + android.support.v4.media.a.b(this.AFAdRevenueData, android.support.v4.media.a.b(this.getRevenue, android.support.v4.media.a.b(this.getCurrencyIso4217Code, Integer.hashCode(this.getMonetizationNetwork) * 31, 31), 31), 31);
    }

    @NotNull
    public final String toString() {
        int i2 = this.getMonetizationNetwork;
        int i3 = this.getCurrencyIso4217Code;
        int i4 = this.getRevenue;
        int i5 = this.AFAdRevenueData;
        String str = this.getMediationNetwork;
        StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "CmpTcfData(policyVersion=", ", gdprApplies=", ", cmpSdkId=");
        android.support.v4.media.a.q(i4, i5, ", cmpSdkVersion=", ", tcString=", sbT);
        return android.support.v4.media.b.r(sbT, str, ")");
    }
}
