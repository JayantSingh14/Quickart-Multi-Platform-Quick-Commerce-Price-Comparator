package in.juspay.hyperapay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import androidx.media3.common.util.e;
import com.amazon.android.amazonpay.api.AmazonPay;
import com.amazon.android.amazonpay.api.a;
import com.amazon.android.amazonpay.api.b;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKPaymentMetadataRole;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayAuthorizationRequest;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionMetadataRequest;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.FragmentHooks;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

@Metadata
/* loaded from: classes4.dex */
public final class APayBridge extends HyperBridge {

    @Nullable
    private String amazonLinkCallback;

    @Nullable
    private String amazonPayProcessCallback;
    private int amazonProcessChargeCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APayBridge(@NotNull BridgeComponents bridgeComponents) {
        super(bridgeComponents);
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.amazonLinkCallback = "";
        this.amazonPayProcessCallback = "";
        this.amazonProcessChargeCode = 112;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void amazonPayInit$lambda$0(APayBridge this$0) {
        String packageName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Context context = this$0.getBridgeComponents().getContext();
            ExecutorService executorService = AmazonPay.f14840a;
            Intrinsics.checkNotNullParameter(context, "context");
            if (context.getPackageName() != null) {
                packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            } else {
                packageName = "UNKNOWN";
            }
            InstrumentUtil.init(context, packageName);
            AmazonPay.f14840a.submit(new a(context, 0));
        } catch (Exception e2) {
            this$0.getBridgeComponents().getTrackerInterface().trackAndLogException(this$0.getInterfaceName(), "action", "system", Labels.SDK.AMAZON_UTILS, "amazonPayInit exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAmazonpayPaymentMetadata$lambda$6(String str, APayBridge this$0, String str2) throws IllegalAccessException, InstantiationException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null) {
            str = "";
        }
        Activity activity = this$0.getBridgeComponents().getActivity();
        Unit unit = null;
        if (activity != null) {
            HashMap map = new HashMap();
            map.put(MerchantConstants.MERCHANT_ID, str);
            AmazonPayTransactionMetadataRequest amazonPayTransactionMetadataRequest = new AmazonPayTransactionMetadataRequest(map);
            ExecutorService executorService = AmazonPay.f14840a;
            Intrinsics.checkNotNullParameter(amazonPayTransactionMetadataRequest, "amazonPayTransactionMetadataRequest");
            Intrinsics.checkNotNullParameter(activity, "activity");
            HashMap<String, Object> data = amazonPayTransactionMetadataRequest.getData();
            Object obj = data != null ? data.get(MerchantConstants.MERCHANT_ID) : null;
            String string = obj != null ? obj.toString() : null;
            if (string == null) {
                string = "";
            }
            AmazonPay.d(activity, string);
            AmazonPay.f14840a.submit(new b(activity, 0));
            Object objNewInstance = Class.forName(AmazonPay.b(activity, "ApaySDKPaymentMetadataRole", "common")).newInstance();
            Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.amazon.android.apay.commonlibrary.interfaces.internal.SDKPaymentMetadataRole");
            this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str2, ((SDKPaymentMetadataRole) objNewInstance).fetchPaymentMetadata(amazonPayTransactionMetadataRequest, activity));
            unit = Unit.f53572a;
        }
        if (unit == null) {
            this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str2, "");
        }
    }

    @JavascriptInterface
    public final void amazonPayInit() {
        ExecutorManager.runOnBackgroundThread(new com.swmansion.gesturehandler.react.b(this, 6));
    }

    @JavascriptInterface
    public final void amazonPayProcessCharge(@Nullable String str, @Nullable String str2, @Nullable String str3) throws JSONException {
        if (str2 == null) {
            str2 = "";
        }
        try {
            this.amazonPayProcessCallback = str3;
            Activity activity = getBridgeComponents().getActivity();
            if (activity == null) {
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str3, "{}");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "amazonPayProcessCharge");
            jSONObject.put("url", str);
            jSONObject.put("seller_id", str2);
            getBridgeComponents().getTrackerInterface().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "third_party_sdk", Labels.SDK.AMAZON_UTILS, jSONObject.toString());
            if (str == null) {
                AnonymousClass2 anonymousClass2 = new Function0() { // from class: in.juspay.hyperapay.APayBridge.amazonPayProcessCharge.2
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Void invoke() throws Exception {
                        throw new Exception("Url provided is null");
                    }
                };
                return;
            }
            HashMap map = new HashMap();
            map.put(MerchantConstants.MERCHANT_ID, str2);
            Map mapC = AmazonPay.c(new AmazonPayTransactionRequest(str, map), activity);
            FragmentHooks fragmentHooks = getBridgeComponents().getFragmentHooks();
            Object obj = mapC.get("Intent");
            Intrinsics.d(obj, "null cannot be cast to non-null type android.content.Intent");
            fragmentHooks.startActivityForResult((Intent) obj, this.amazonProcessChargeCode, (Bundle) mapC.get("Options"));
        } catch (Exception e2) {
            getBridgeComponents().getTrackerInterface().trackAndLogException(getInterfaceName(), LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "Process Charge Exception", e2);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("signature", "");
                jSONObject2.put(CLConstants.OTP_STATUS, "");
                jSONObject2.put("transactionId", "");
                jSONObject2.put("verificationOperationName", "");
                jSONObject2.put("verificationParameters", "");
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str3, jSONObject2.toString());
            } catch (Exception e3) {
                getBridgeComponents().getTrackerInterface().trackAndLogException(getInterfaceName(), LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "JSON Exception", e3);
            }
        }
    }

    @JavascriptInterface
    public final boolean checkAmazonApiKey() throws IOException {
        try {
            String[] list = getBridgeComponents().getContext().getResources().getAssets().list("");
            if (list != null) {
                return CollectionsKt.I(Arrays.copyOf(list, list.length)).contains("api_key.txt");
            }
            return false;
        } catch (IOException e2) {
            getBridgeComponents().getTrackerInterface().trackAndLogException(getInterfaceName(), LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "Check Api Key Exception", e2);
            return false;
        }
    }

    @JavascriptInterface
    public final boolean checkAmazonSdk() {
        if (!checkAmazonApiKey()) {
            return false;
        }
        try {
            ExecutorService executorService = AmazonPay.f14840a;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public final void duiAmazonLinkStatus(@Nullable String str) {
        getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.amazonLinkCallback, str);
    }

    @JavascriptInterface
    public final void getAmazonpayPaymentMetadata(@Nullable String str, @Nullable String str2) {
        ExecutorManager.runOnBackgroundThread(new e(str, this, str2, 17));
    }

    @JavascriptInterface
    public final void linkAmazonPay(@Nullable String str, @Nullable String str2, @Nullable String str3) throws JSONException {
        this.amazonLinkCallback = str2;
        if (str == null) {
            str = "";
        }
        APayUtils aPayUtils = APayUtils.INSTANCE;
        String codeVerifier$hyper_apay_release = aPayUtils.getCodeVerifier$hyper_apay_release();
        Activity activity = getBridgeComponents().getActivity();
        if (activity == null) {
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str3, "Activity Context is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "linkAmazonPay");
            jSONObject.put("seller_id", str);
            getBridgeComponents().getTrackerInterface().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "third_party_sdk", Labels.SDK.AMAZON_UTILS, jSONObject.toString());
            getBridgeComponents().getFragmentHooks().startActivityForResult(AmazonPay.a(new AmazonPayAuthorizationRequest(str, aPayUtils.generateCodeChallenge$hyper_apay_release(codeVerifier$hyper_apay_release)), activity), WKSRecord.Service.SUNRPC, null);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str3, codeVerifier$hyper_apay_release);
        } catch (Exception e2) {
            getBridgeComponents().getTrackerInterface().trackAndLogException(getInterfaceName(), LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "Error linking amazon pay", e2);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str2, e2.toString());
        }
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) throws JSONException {
        if (i2 != this.amazonProcessChargeCode) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("signature", intent != null ? intent.getStringExtra("signature") : null);
        jSONObject.put(CLConstants.OTP_STATUS, intent != null ? intent.getStringExtra(CLConstants.OTP_STATUS) : null);
        jSONObject.put("transactionId", intent != null ? intent.getStringExtra("transactionId") : null);
        jSONObject.put("description", intent != null ? intent.getStringExtra("description") : null);
        jSONObject.put("orderCurrency", intent != null ? intent.getStringExtra("orderTotalAmount") : null);
        getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.amazonPayProcessCallback, jSONObject.toString());
        return true;
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public void terminate() {
    }

    @JavascriptInterface
    public final void checkAmazonSdk(@Nullable String str) {
        getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, String.valueOf(checkAmazonSdk()));
    }
}
