package com.appsflyer.internal;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes3.dex */
public final class AFf1aSDK {

    @JvmField
    public final long AFAdRevenueData;

    @JvmField
    public final boolean getMediationNetwork;

    @JvmField
    @NotNull
    public final String getRevenue;

    public AFf1aSDK(@NotNull String str, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getRevenue = str;
        this.AFAdRevenueData = j2;
        this.getMediationNetwork = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFf1aSDK)) {
            return false;
        }
        AFf1aSDK aFf1aSDK = (AFf1aSDK) obj;
        return Intrinsics.b(this.getRevenue, aFf1aSDK.getRevenue) && this.AFAdRevenueData == aFf1aSDK.AFAdRevenueData && this.getMediationNetwork == aFf1aSDK.getMediationNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iD = android.support.v4.media.a.d(this.getRevenue.hashCode() * 31, 31, this.AFAdRevenueData);
        boolean z = this.getMediationNetwork;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return iD + i2;
    }

    @NotNull
    public final String toString() {
        return "AFUninstallToken(token=" + this.getRevenue + ", receivedTime=" + this.AFAdRevenueData + ", isQueued=" + this.getMediationNetwork + ")";
    }
}
