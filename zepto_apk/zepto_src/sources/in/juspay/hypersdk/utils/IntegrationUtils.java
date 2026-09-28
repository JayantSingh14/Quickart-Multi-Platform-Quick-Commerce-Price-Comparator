package in.juspay.hypersdk.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.SdkInfo;

/* loaded from: classes4.dex */
public class IntegrationUtils {
    public static String getAppName(@NonNull Context context) {
        return context.getString(R.string.godel_app_name);
    }

    public static String getAssetAarVersion(@NonNull Context context, @Nullable String str) {
        return (!JuspayCoreLib.isMultiClientIntegration() || str == null) ? getVersion(context, PaymentConstants.ASSET_AAR_VERSION) : getVersion(context, "asset_aar_version_".concat(str));
    }

    public static String getGodelBuildVersion(@NonNull Context context) {
        return getVersion(context, PaymentConstants.GODEL_BUILD_VERSION);
    }

    public static String getGodelVersion(@NonNull Context context) {
        return getVersion(context, PaymentConstants.GODEL_VERSION);
    }

    public static SdkInfo getSdkInfo(@NonNull Context context) {
        return new SdkInfo(getAppName(context), getGodelVersion(context), isSdkDebuggable(context), usesLocalAssets(context));
    }

    public static String getSdkVersion(@NonNull Context context) {
        return getSdkVersion(context, "-");
    }

    private static String getVersion(@NonNull Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        return identifier == 0 ? "undefined" : context.getString(identifier);
    }

    private static boolean isSdkDebuggable(@NonNull Context context) {
        return context.getResources().getBoolean(R.bool.godel_debuggable);
    }

    private static boolean usesLocalAssets(@NonNull Context context) {
        return context.getResources().getBoolean(R.bool.use_local_assets);
    }

    public static String getSdkVersion(@NonNull Context context, @NonNull String str) {
        StringBuilder sb = new StringBuilder(getGodelVersion(context));
        if (context.getResources().getBoolean(context.getResources().getIdentifier("use_rc", "bool", context.getPackageName()))) {
            sb.append(str);
            sb.append(getGodelBuildVersion(context));
        }
        return sb.toString();
    }
}
