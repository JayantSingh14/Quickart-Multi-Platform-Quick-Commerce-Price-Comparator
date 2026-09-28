package com.appsflyer.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AFe1xSDK {

    @NotNull
    public final AFe1wSDK AFAdRevenueData;

    @NotNull
    public final String getMediationNetwork;

    @Nullable
    public final String getRevenue;

    public AFe1xSDK(@NotNull String str, @Nullable String str2, @NotNull AFe1wSDK aFe1wSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(aFe1wSDK, "");
        this.getMediationNetwork = str;
        this.getRevenue = str2;
        this.AFAdRevenueData = aFe1wSDK;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFe1xSDK)) {
            return false;
        }
        AFe1xSDK aFe1xSDK = (AFe1xSDK) obj;
        return Intrinsics.b(this.getMediationNetwork, aFe1xSDK.getMediationNetwork) && Intrinsics.b(this.getRevenue, aFe1xSDK.getRevenue) && this.AFAdRevenueData == aFe1xSDK.AFAdRevenueData;
    }

    public final int hashCode() {
        int iHashCode = this.getMediationNetwork.hashCode() * 31;
        String str = this.getRevenue;
        return this.AFAdRevenueData.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    @NotNull
    public final String toString() {
        String str = this.getMediationNetwork;
        String str2 = this.getRevenue;
        AFe1wSDK aFe1wSDK = this.AFAdRevenueData;
        StringBuilder sbV = androidx.fragment.app.e.v("HostMeta(name=", str, ", prefix=", str2, ", method=");
        sbV.append(aFe1wSDK);
        sbV.append(")");
        return sbV.toString();
    }
}
