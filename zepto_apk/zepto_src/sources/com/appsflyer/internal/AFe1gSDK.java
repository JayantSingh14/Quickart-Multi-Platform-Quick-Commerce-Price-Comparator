package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.CallSuper;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class AFe1gSDK extends AFe1dSDK<String> {

    @NotNull
    private final AFe1mSDK component2;

    @NotNull
    private final AFc1pSDK copy;

    @NotNull
    private final AFc1qSDK copydefault;

    @NotNull
    private final Map<String, Object> equals;

    @NotNull
    private final AFg1qSDK hashCode;

    @NotNull
    private final AFf1dSDK toString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1gSDK(@NotNull AFe1mSDK aFe1mSDK, @NotNull AFe1mSDK[] aFe1mSDKArr, @NotNull AFc1dSDK aFc1dSDK, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
        super(aFe1mSDK, aFe1mSDKArr, aFc1dSDK, null);
        Intrinsics.checkNotNullParameter(aFe1mSDK, "");
        Intrinsics.checkNotNullParameter(aFe1mSDKArr, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.component2 = aFe1mSDK;
        this.equals = map;
        AFc1pSDK revenue = aFc1dSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        this.copy = revenue;
        AFc1qSDK aFc1qSDKComponent2 = aFc1dSDK.component2();
        Intrinsics.checkNotNullExpressionValue(aFc1qSDKComponent2, "");
        this.copydefault = aFc1qSDKComponent2;
        AFg1qSDK aFg1qSDKComponent3 = aFc1dSDK.component3();
        Intrinsics.checkNotNullExpressionValue(aFg1qSDKComponent3, "");
        this.hashCode = aFg1qSDKComponent3;
        AFf1dSDK aFf1dSDKAfErrorLog = aFc1dSDK.afErrorLog();
        Intrinsics.checkNotNullExpressionValue(aFf1dSDKAfErrorLog, "");
        this.toString = aFf1dSDKAfErrorLog;
    }

    @Nullable
    public abstract AFd1nSDK<String> AFAdRevenueData(@NotNull Map<String, Object> map, @NotNull String str, @Nullable String str2);

    @Nullable
    public String AFAdRevenueData(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    public boolean component1() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1dSDK
    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1dSDK
    public final boolean copydefault() {
        return true;
    }

    @CallSuper
    public void getMediationNetwork(@NotNull Map<String, Object> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("app_id", this.copy.getRevenue.getMonetizationNetwork.getPackageName());
        String currencyIso4217Code = AFc1pSDK.getCurrencyIso4217Code();
        if (currencyIso4217Code != null) {
            map.put("cuid", currencyIso4217Code);
        }
        Context context = this.copy.getRevenue.getMonetizationNetwork;
        map.put("app_version_name", AFj1iSDK.getMediationNetwork(context, context.getPackageName()));
        if (component1()) {
            map.put("event_timestamp", Long.valueOf(this.hashCode.AFAdRevenueData()));
        }
        if (str != null) {
            map.put("billing_lib_version", str);
        }
    }

    @Nullable
    public String getMonetizationNetwork(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    @Override // com.appsflyer.internal.AFe1dSDK
    @Nullable
    public final AFd1nSDK<String> getRevenue(@NotNull String str) throws JSONException {
        AFd1cSDK aFd1cSDK;
        Intrinsics.checkNotNullParameter(str, "");
        Map<String, Object> mapN = MapsKt.n(this.equals);
        String strAFAdRevenueData = AFAdRevenueData(mapN);
        String monetizationNetwork = getMonetizationNetwork(mapN);
        Map<String, Object> mapN2 = MapsKt.n(mapN);
        getMediationNetwork(mapN2, strAFAdRevenueData);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strAFAdRevenueData2 = this.copy.AFAdRevenueData();
        if (strAFAdRevenueData2 != null && !StringsKt.z(strAFAdRevenueData2)) {
            linkedHashMap.put("advertising_id", strAFAdRevenueData2);
        }
        AFb1mSDK mediationNetwork = AFb1jSDK.getMediationNetwork(this.copy.getRevenue.getMonetizationNetwork);
        String str2 = null;
        String str3 = mediationNetwork != null ? mediationNetwork.getMonetizationNetwork : null;
        if (str3 != null && !StringsKt.z(str3)) {
            linkedHashMap.put("oaid", str3);
        }
        AFb1mSDK aFb1mSDKK_ = AFb1jSDK.k_(this.copy.getRevenue.getMonetizationNetwork.getContentResolver());
        String str4 = aFb1mSDKK_ != null ? aFb1mSDKK_.getMonetizationNetwork : null;
        if (str4 != null && !StringsKt.z(str4)) {
            linkedHashMap.put("amazon_aid", str4);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            mapN2.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        } else {
            AFf1gSDK aFf1gSDK = ((AFe1dSDK) this).component3;
            String str5 = (String) AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFf1gSDK, this.copydefault}, -1198101809, 1198101809, System.identityHashCode(aFf1gSDK));
            if (str5 != null && !StringsKt.z(str5)) {
                linkedHashMap.put("imei", str5);
            }
        }
        String revenue = AFb1iSDK.getRevenue(this.copy.getMonetizationNetwork);
        if (revenue == null) {
            revenue = "";
        }
        linkedHashMap.put("appsflyer_id", revenue);
        linkedHashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        linkedHashMap.put("sdk_version", "6.17.0");
        if (monetizationNetwork != null && !StringsKt.z(monetizationNetwork)) {
            linkedHashMap.put("sdk_connector_version", monetizationNetwork);
        }
        mapN2.put("device_data", linkedHashMap);
        this.toString.AFAdRevenueData(mapN2, this.component2);
        AFd1nSDK<String> aFd1nSDKAFAdRevenueData = AFAdRevenueData(mapN2, str, strAFAdRevenueData);
        if (aFd1nSDKAFAdRevenueData != null && (aFd1cSDK = aFd1nSDKAFAdRevenueData.getRevenue) != null) {
            str2 = aFd1cSDK.getMonetizationNetwork;
        }
        if (str2 != null) {
            JSONObject jSONObject = new JSONObject(mapN2);
            AFh1ySDK.getCurrencyIso4217Code(toString() + ": preparing data: ", jSONObject);
            AFd1pSDK aFd1pSDK = ((AFe1dSDK) this).areAllFieldsValid;
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "");
            aFd1pSDK.getCurrencyIso4217Code(str2, string);
        }
        return aFd1nSDKAFAdRevenueData;
    }
}
