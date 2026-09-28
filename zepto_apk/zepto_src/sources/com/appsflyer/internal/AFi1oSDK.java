package com.appsflyer.internal;

import android.app.Activity;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class AFi1oSDK implements AFi1kSDK {

    @Nullable
    private String getRevenue;

    private static String AFAdRevenueData(Activity activity) {
        Uri uriJ_ = AFb1rSDK.j_(activity != null ? activity.getIntent() : null);
        String string = uriJ_ != null ? uriJ_.toString() : null;
        if (string == null) {
            string = "";
        }
        if (getRevenue(string)) {
            return null;
        }
        return string;
    }

    private static boolean getRevenue(String str) {
        return StringsKt.O(str, "android-app://", false);
    }

    @Override // com.appsflyer.internal.AFi1kSDK
    @Nullable
    public final String getCurrencyIso4217Code(@Nullable Activity activity) {
        String str = this.getRevenue;
        this.getRevenue = null;
        return (str == null || str.length() == 0) ? AFAdRevenueData(activity) : str;
    }

    @Override // com.appsflyer.internal.AFi1kSDK
    public final void getMediationNetwork(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        String str = this.getRevenue;
        if (str == null || str.length() == 0) {
            this.getRevenue = AFAdRevenueData(activity);
        }
    }

    @Override // com.appsflyer.internal.AFi1kSDK
    @NotNull
    public final String getMonetizationNetwork(@Nullable Activity activity) {
        Uri referrer = (activity == null || activity.getIntent() == null) ? null : activity.getReferrer();
        String string = referrer != null ? referrer.toString() : null;
        return string == null ? "" : string;
    }
}
