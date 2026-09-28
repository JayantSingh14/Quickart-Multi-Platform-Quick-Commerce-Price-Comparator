package com.appsflyer.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AFi1xSDK {

    @NotNull
    public final String AFAdRevenueData;

    @NotNull
    public final String component2;

    @NotNull
    public List<String> getCurrencyIso4217Code;
    public long getMediationNetwork;
    public final int getMonetizationNetwork;
    public final float getRevenue;

    @JvmOverloads
    public AFi1xSDK(long j2, float f2, @NotNull List<String> list, int i2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getMediationNetwork = j2;
        this.getRevenue = f2;
        this.getCurrencyIso4217Code = list;
        this.getMonetizationNetwork = i2;
        this.AFAdRevenueData = str;
        this.component2 = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AFi1xSDK.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "");
        AFi1xSDK aFi1xSDK = (AFi1xSDK) obj;
        return this.getMediationNetwork == aFi1xSDK.getMediationNetwork && this.getRevenue == aFi1xSDK.getRevenue && Intrinsics.b(this.getCurrencyIso4217Code, aFi1xSDK.getCurrencyIso4217Code) && this.getMonetizationNetwork == aFi1xSDK.getMonetizationNetwork && Intrinsics.b(this.AFAdRevenueData, aFi1xSDK.AFAdRevenueData) && Intrinsics.b(this.component2, aFi1xSDK.component2);
    }

    @JvmName
    public final boolean getCurrencyIso4217Code() {
        return TimeUnit.SECONDS.toMillis(this.getMediationNetwork) > ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData().component3().AFAdRevenueData();
    }

    public final int hashCode() {
        return this.component2.hashCode() + ((this.AFAdRevenueData.hashCode() + ((androidx.fragment.app.e.f((Float.hashCode(this.getRevenue) + (Long.hashCode(this.getMediationNetwork) * 31)) * 31, 31, this.getCurrencyIso4217Code) + this.getMonetizationNetwork) * 31)) * 31);
    }
}
