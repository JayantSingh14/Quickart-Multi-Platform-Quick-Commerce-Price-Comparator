package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes3.dex */
public final class AFb1gSDK {
    public final int AFAdRevenueData;

    @NotNull
    public final String getMonetizationNetwork;

    public AFb1gSDK(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.AFAdRevenueData = i2;
        this.getMonetizationNetwork = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFb1gSDK)) {
            return false;
        }
        AFb1gSDK aFb1gSDK = (AFb1gSDK) obj;
        return this.AFAdRevenueData == aFb1gSDK.AFAdRevenueData && Intrinsics.b(this.getMonetizationNetwork, aFb1gSDK.getMonetizationNetwork);
    }

    public final int hashCode() {
        return this.getMonetizationNetwork.hashCode() + (Integer.hashCode(this.AFAdRevenueData) * 31);
    }

    @NotNull
    public final String toString() {
        return "AppSetIdModel(scope=" + this.AFAdRevenueData + ", id=" + this.getMonetizationNetwork + ")";
    }
}
