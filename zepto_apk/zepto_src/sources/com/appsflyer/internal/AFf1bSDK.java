package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class AFf1bSDK implements AFf1cSDK {

    @NotNull
    private final AppsFlyerProperties AFAdRevenueData;

    @NotNull
    private final Context getMonetizationNetwork;

    public AFf1bSDK(@NotNull Context context, @NotNull AppsFlyerProperties appsFlyerProperties) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        this.getMonetizationNetwork = context;
        this.AFAdRevenueData = appsFlyerProperties;
    }

    @Override // com.appsflyer.internal.AFf1cSDK
    @Nullable
    public final AFg1zSDK getMediationNetwork() {
        String string;
        if (!Boolean.parseBoolean(this.AFAdRevenueData.getString(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION))) {
            return null;
        }
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getMonetizationNetwork);
            int i2 = defaultSharedPreferences.getInt("IABTCF_gdprApplies", -1);
            int i3 = defaultSharedPreferences.getInt("IABTCF_CmpSdkID", -1);
            int i4 = defaultSharedPreferences.getInt("IABTCF_PolicyVersion", -1);
            int i5 = defaultSharedPreferences.getInt("IABTCF_CmpSdkVersion", -1);
            String str = "";
            if (i2 == 1 && (string = defaultSharedPreferences.getString("IABTCF_TCString", "")) != null) {
                Intrinsics.checkNotNullExpressionValue(string, "");
                str = string;
            }
            return new AFg1zSDK(i4, i2, i3, i5, str);
        } catch (Exception e2) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DMA, "TCF data collection exception", e2, false, false, false, false, 120, null);
            return null;
        }
    }
}
