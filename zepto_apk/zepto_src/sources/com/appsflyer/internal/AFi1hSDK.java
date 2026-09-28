package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class AFi1hSDK {
    public final long AFAdRevenueData;

    @Nullable
    public final String getCurrencyIso4217Code;

    @Nullable
    public final String getMonetizationNetwork;
    public final long getRevenue;

    public AFi1hSDK(long j2, long j3, @Nullable String str, @Nullable String str2) {
        this.AFAdRevenueData = j2;
        this.getRevenue = j3;
        this.getCurrencyIso4217Code = str;
        this.getMonetizationNetwork = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFi1hSDK)) {
            return false;
        }
        AFi1hSDK aFi1hSDK = (AFi1hSDK) obj;
        return this.AFAdRevenueData == aFi1hSDK.AFAdRevenueData && this.getRevenue == aFi1hSDK.getRevenue && Intrinsics.b(this.getCurrencyIso4217Code, aFi1hSDK.getCurrencyIso4217Code) && Intrinsics.b(this.getMonetizationNetwork, aFi1hSDK.getMonetizationNetwork);
    }

    public final int hashCode() {
        int iD = android.support.v4.media.a.d(Long.hashCode(this.AFAdRevenueData) * 31, 31, this.getRevenue);
        String str = this.getCurrencyIso4217Code;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.getMonetizationNetwork;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public final String toString() {
        long j2 = this.AFAdRevenueData;
        long j3 = this.getRevenue;
        String str = this.getCurrencyIso4217Code;
        String str2 = this.getMonetizationNetwork;
        StringBuilder sbV = android.support.v4.media.b.v(j2, "PlayIntegrityApiData(piaTimestamp=", ", ttrMillis=");
        sbV.append(j3);
        sbV.append(", piaToken=");
        sbV.append(str);
        return android.support.v4.media.b.s(sbV, ", errorCode=", str2, ")");
    }
}
