package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AFj1fSDK {

    @NotNull
    public static final AFa1vSDK AFAdRevenueData = new AFa1vSDK(null);

    @JvmField
    @NotNull
    public static final String areAllFieldsValid;

    @JvmField
    @NotNull
    public static final String component1;

    @JvmField
    @NotNull
    public static final String component2;

    @JvmField
    @NotNull
    public static final String component3;

    @JvmField
    @NotNull
    public static final String component4;

    @JvmField
    @NotNull
    public static final String getCurrencyIso4217Code;

    @JvmField
    @NotNull
    public static final String getMediationNetwork;

    @JvmField
    @NotNull
    public static final String getRevenue;

    @NotNull
    private static final String toString;

    @NotNull
    public final AFk1xSDK getMonetizationNetwork;

    @NotNull
    private final AFc1pSDK hashCode;

    @Metadata
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String strK = android.support.v4.media.b.k(AFa1tSDK.getRevenue, "/androidevent?app_id=");
        toString = strK;
        getRevenue = android.support.v4.media.b.C("https://%sattr.%s/api/v", strK);
        getCurrencyIso4217Code = "https://%sadrevenue.%s/api/v2/generic/v6.17.0/android?app_id=";
        getMediationNetwork = android.support.v4.media.b.C("https://%sconversions.%s/api/v", strK);
        component1 = android.support.v4.media.b.C("https://%slaunches.%s/api/v", strK);
        component2 = android.support.v4.media.b.C("https://%sinapps.%s/api/v", strK);
        areAllFieldsValid = android.support.v4.media.b.C("https://%sregister.%s/api/v", strK);
        component3 = android.support.v4.media.b.C("https://%svalidate.%s/api/v", strK);
        component4 = "https://%smonitorsdk.%s/api/remote-debug/v2.0?app_id=";
    }

    @JvmOverloads
    private AFj1fSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFk1xSDK aFk1xSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFk1xSDK, "");
        this.hashCode = aFc1pSDK;
        this.getMonetizationNetwork = aFk1xSDK;
    }

    @NotNull
    public static String getCurrencyIso4217Code() {
        return "https://privacy-sandbox.appsflyersdk.com/api/trigger";
    }

    @NotNull
    public final String AFAdRevenueData(@Nullable String str, @Nullable String str2) {
        String packageName = this.hashCode.getRevenue.getMonetizationNetwork.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        String strComponent2 = this.hashCode.component2();
        if (strComponent2 != null && !StringsKt.z(strComponent2)) {
            strComponent2 = android.support.v4.media.b.C("-", StringsKt.b0(strComponent2).toString());
        }
        if (strComponent2 == null) {
            strComponent2 = "";
        }
        String string = StringsKt.b0(strComponent2).toString();
        Uri.Builder builderAppendPath = Uri.parse(this.getMonetizationNetwork.AFAdRevenueData("https://%sdlsdk.%s/v1.0/android/")).buildUpon().appendPath(packageName + string);
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "");
        if (str == null || str2 == null) {
            String str3 = str == null ? "devKey" : "timestamp";
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, str3.concat(" is null at attempt to generate ddl event url"), new IllegalStateException(str3.concat(" is null")), true, false, false, true);
        } else {
            builderAppendPath.appendQueryParameter("af_sig", AFj1cSDK.getRevenue(str2.concat(str), str));
        }
        String string2 = builderAppendPath.appendQueryParameter("sdk_version", AFa1tSDK.getRevenue).build().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }

    public final String getRevenue(String str, boolean z) {
        if (z) {
            return str;
        }
        String strComponent2 = this.hashCode.component2();
        String strConcat = strComponent2 != null ? "&channel=".concat(strComponent2) : null;
        if (strConcat == null) {
            strConcat = "";
        }
        return android.support.v4.media.b.k(str, strConcat);
    }

    public final String getCurrencyIso4217Code(String str) {
        return android.support.v4.media.b.k(str, this.hashCode.getRevenue.getMonetizationNetwork.getPackageName());
    }

    public /* synthetic */ AFj1fSDK(AFc1pSDK aFc1pSDK, AFk1xSDK aFk1xSDK, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1pSDK, (i2 & 2) != 0 ? new AFk1zSDK() : aFk1xSDK);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AFj1fSDK(@NotNull AFc1pSDK aFc1pSDK) {
        this(aFc1pSDK, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
    }

    public static String AFAdRevenueData(String str, boolean z) {
        return android.support.v4.media.b.k(str, !z ? "&buildnumber=6.17.0" : "");
    }
}
