package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AFd1mSDK extends AFd1zSDK {

    @NotNull
    private final AFd1gSDK areAllFieldsValid;
    private final boolean getMediationNetwork;

    @NotNull
    public AFc1pSDK getRevenue;

    public /* synthetic */ AFd1mSDK(AFc1pSDK aFc1pSDK, byte[] bArr, Map map, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1pSDK, bArr, (i3 & 4) != 0 ? null : map, (i3 & 8) != 0 ? 2000 : i2);
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    @JvmName
    @NotNull
    public final String getCurrencyIso4217Code() {
        AFj1fSDK aFj1fSDK = new AFj1fSDK(this.getRevenue, null, 2, null);
        return aFj1fSDK.getCurrencyIso4217Code(aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.component4));
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    @JvmName
    public final boolean getMediationNetwork() {
        return this.getMediationNetwork;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    @JvmName
    @NotNull
    public final AFd1gSDK getRevenue() {
        return this.areAllFieldsValid;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    private AFd1mSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull byte[] bArr, @Nullable Map<String, String> map, int i2) {
        super(bArr, map, i2);
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        this.getRevenue = aFc1pSDK;
        this.areAllFieldsValid = AFd1gSDK.OCTET_STREAM;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    @NotNull
    public final String getCurrencyIso4217Code(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return "[RD]: " + str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AFd1mSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull byte[] bArr) {
        this(aFc1pSDK, bArr, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(bArr, "");
    }
}
