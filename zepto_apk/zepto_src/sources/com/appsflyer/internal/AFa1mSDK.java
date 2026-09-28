package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AFa1mSDK {

    @Nullable
    public final DeepLink getCurrencyIso4217Code;
    private final boolean getRevenue;

    public AFa1mSDK(boolean z, @Nullable DeepLink deepLink) {
        this.getRevenue = z;
        this.getCurrencyIso4217Code = deepLink;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFa1mSDK)) {
            return false;
        }
        AFa1mSDK aFa1mSDK = (AFa1mSDK) obj;
        return this.getRevenue == aFa1mSDK.getRevenue && Intrinsics.b(this.getCurrencyIso4217Code, aFa1mSDK.getCurrencyIso4217Code);
    }

    @JvmName
    public final boolean getRevenue() {
        return this.getRevenue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.getRevenue;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        DeepLink deepLink = this.getCurrencyIso4217Code;
        return i2 + (deepLink == null ? 0 : deepLink.hashCode());
    }

    @NotNull
    public final String toString() {
        return "DdlResponse(secondPing=" + this.getRevenue + ", deepLink=" + this.getCurrencyIso4217Code + ")";
    }

    public /* synthetic */ AFa1mSDK(boolean z, DeepLink deepLink, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? null : deepLink);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AFa1mSDK() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }
}
