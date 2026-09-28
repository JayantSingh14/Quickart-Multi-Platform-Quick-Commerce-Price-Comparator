package com.amazon.android.amazonpay.api;

import android.app.Activity;
import android.content.Intent;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKAuthRole;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKBrowsingRole;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayAuthorizationRequest;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonPay {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f14840a = Executors.newFixedThreadPool(2);

    /* renamed from: b, reason: collision with root package name */
    public static String f14841b = "";

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new c(0)));
    }

    public static final Intent a(AmazonPayAuthorizationRequest amazonPayAuthorizationRequest, Activity activity) {
        Intrinsics.checkNotNullParameter(amazonPayAuthorizationRequest, "amazonPayAuthorizationRequest");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String clientId = amazonPayAuthorizationRequest.getClientId();
        if (StringsKt.z(clientId)) {
            if (activity.getPackageName() != null) {
                clientId = activity.getPackageName();
                Intrinsics.checkNotNullExpressionValue(clientId, "context.packageName");
            } else {
                clientId = "UNKNOWN";
            }
        }
        d(activity, clientId);
        Object objNewInstance = Class.forName(b(activity, "ApaySDKAuthRole", "auth")).newInstance();
        Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.amazon.android.apay.commonlibrary.interfaces.internal.SDKAuthRole");
        return ((SDKAuthRole) objNewInstance).getAuthorizationIntent(amazonPayAuthorizationRequest, activity);
    }

    public static String b(Activity activity, String str, String str2) {
        int identifier = activity.getResources().getIdentifier(str, "string", activity.getPackageName());
        if (identifier == 0) {
            throw new AmazonPayError("SDK_ERROR", android.support.v4.media.b.D("Apay SDK dependency -", str2, " lib not found"));
        }
        String string = activity.getString(identifier);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    public static final Map c(AmazonPayTransactionRequest amazonPayTransactionRequest, Activity activity) {
        Object packageName;
        Intrinsics.checkNotNullParameter(amazonPayTransactionRequest, "amazonPayTransactionRequest");
        Intrinsics.checkNotNullParameter(activity, "activity");
        HashMap<String, Object> data = amazonPayTransactionRequest.getData();
        if (data == null || (packageName = data.get(MerchantConstants.MERCHANT_ID)) == null) {
            if (activity.getPackageName() != null) {
                packageName = activity.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            } else {
                packageName = "UNKNOWN";
            }
        }
        Intrinsics.checkNotNullExpressionValue(packageName, "amazonPayTransactionRequ…llbackMerchantId(context)");
        d(activity, packageName.toString());
        Object objNewInstance = Class.forName(b(activity, "ApaySDKBrowsingRole", "common")).newInstance();
        Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.amazon.android.apay.commonlibrary.interfaces.internal.SDKBrowsingRole");
        return ((SDKBrowsingRole) objNewInstance).getBrowsingIntent(amazonPayTransactionRequest, activity);
    }

    public static void d(Activity activity, String str) {
        if (!StringsKt.z(f14841b) || str == null || str.length() == 0) {
            return;
        }
        InstrumentUtil.initWithReset(activity, str);
        f14841b = str;
    }
}
