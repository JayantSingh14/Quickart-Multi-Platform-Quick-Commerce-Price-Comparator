package com.amazon.android.apay.commonlibrary.commonlib.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.media3.datasource.b;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionMetadataRequest;
import com.amazon.android.apay.commonlibrary.interfaces.model.AppDetails;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

@Metadata
/* loaded from: classes3.dex */
public final class PaymentMetaDataManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public AppConfigManager f14869a = new AppConfigManager();

    @Metadata
    public static final class a extends Lambda implements Function0<Boolean> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return Boolean.valueOf(PaymentMetaDataManager.this.a());
        }
    }

    public static final String a(PaymentMetaDataManager this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.getClass();
        String string = activity.getSharedPreferences("AMAZON_DEVICE_DETAILS_FILE", 0).getString("AMAZON_DEVICE_DETAILS", null);
        if (string == null) {
            return "{}";
        }
        String string2 = ((JsonObject) new Gson().d(JsonObject.class, string)).k("responseValue").toString();
        Intrinsics.checkNotNullExpressionValue(string2, "Gson().fromJson(deviceDe…NSE_VALUE_KEY).toString()");
        Object objD = new Gson().d(JsonObject.class, this$0.a(string2, 0));
        Intrinsics.checkNotNullExpressionValue(objD, "Gson().fromJson(deviceDe…, JsonObject::class.java)");
        JsonObject jsonObject = (JsonObject) objD;
        jsonObject.getClass();
        jsonObject.j("isStale", new JsonPrimitive("true"));
        String string3 = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "deviceDetailsJSON.toString()");
        return string3;
    }

    public final String b(Activity activity, AmazonPayTransactionMetadataRequest amazonPayTransactionMetadataRequest) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("upi://pay"));
        intent.addCategory("android.intent.category.BROWSABLE");
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        JsonElement jsonElementM = gson.m(a(activity, intent));
        jsonElementM.getClass();
        if (!(jsonElementM instanceof JsonArray)) {
            throw new IllegalStateException("Not a JSON Array: " + jsonElementM);
        }
        jsonObject.j("appDetails", (JsonArray) jsonElementM);
        jsonObject.j("deviceDetails", (JsonElement) gson.d(JsonElement.class, a(activity, amazonPayTransactionMetadataRequest)));
        String strI = new Gson().i(jsonObject);
        Intrinsics.checkNotNullExpressionValue(strI, "Gson().toJson(resultJson)");
        return strI;
    }

    @NotNull
    public final String getPaymentMetaData(@NotNull AmazonPayTransactionMetadataRequest amazonPayTransactionMetaDataRequest, @NotNull Activity activity) throws JSONException {
        Activity activity2;
        String str;
        Intrinsics.checkNotNullParameter(amazonPayTransactionMetaDataRequest, "amazonPayTransactionMetaDataRequest");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            String strB = b(activity, amazonPayTransactionMetaDataRequest);
            Charset charset = Charsets.UTF_8;
            byte[] bytes = strB.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] encodedBytes = Base64.encode(bytes, 11);
            Intrinsics.checkNotNullExpressionValue(encodedBytes, "encodedBytes");
            str = new String(encodedBytes, charset);
            activity2 = activity;
        } catch (Exception e2) {
            e = e2;
            activity2 = activity;
        }
        try {
            InstrumentUtil.addMetricEvent$default("paymentMetaDataFetched", "PaymentMetaData", activity2, (String) null, (String) null, 24, (Object) null);
            return str;
        } catch (Exception e3) {
            e = e3;
            Exception exc = e;
            InstrumentUtil.addMetricEvent("paymentMetadataException", "PaymentMetaData", activity2, "420", ExceptionsKt.b(exc));
            exc.toString();
            return "";
        }
    }

    public final boolean a() {
        Future future;
        return com.amazon.android.apay.commonlibrary.commonlib.service.a.f14872d && (future = com.amazon.android.apay.commonlibrary.commonlib.service.a.f14873e) != null && future.isDone();
    }

    public final List<AppDetails> a(Activity activity, Intent intent) throws JSONException {
        try {
            AppConfigManager appConfigManager = this.f14869a;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            int i2 = appConfigManager.getConfigData(applicationContext, "UNKNOWN").getInt("maxSizeOfAppDetailsList");
            if (i2 == 0) {
                return EmptyList.f53609a;
            }
            com.amazon.android.apay.commonlibrary.commonlib.utils.a.f14878a.getClass();
            return CollectionsKt.Z(com.amazon.android.apay.commonlibrary.commonlib.utils.a.a(activity, intent), i2);
        } catch (Exception e2) {
            e2.toString();
            InstrumentUtil.addMetricEvent("getAppDetailsException", "PaymentMetaData", activity, "420", ExceptionsKt.b(e2));
            return new ArrayList();
        }
    }

    public final String a(Activity activity, AmazonPayTransactionMetadataRequest amazonPayTransactionMetadataRequest) throws ExecutionException, JSONException, InterruptedException {
        try {
            if (!BoundServiceManager.Companion.isMshopInstalled()) {
                InstrumentUtil.addMetricEvent$default("PaymentMetaData", "getDeviceDetailsMshopNotInstalled", activity, (String) null, (String) null, 24, (Object) null);
                return "{}";
            }
            Future<String> futureA = a(activity);
            AppConfigManager appConfigManager = this.f14869a;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            String strA = a(activity, appConfigManager.getConfigData(applicationContext, (amazonPayTransactionMetadataRequest.getData() == null || !amazonPayTransactionMetadataRequest.getData().containsKey(MerchantConstants.MERCHANT_ID)) ? null : (String) amazonPayTransactionMetadataRequest.getData().get(MerchantConstants.MERCHANT_ID)).getLong("timeOutInMillisForDeviceDetails"));
            if (strA != null) {
                InstrumentUtil.addMetricEvent$default("PaymentMetaData", "getDeviceDetailsReady", activity, (String) null, (String) null, 24, (Object) null);
                return strA;
            }
            if (futureA == null) {
                return "{}";
            }
            String deviceDetails = futureA.get();
            InstrumentUtil.addMetricEvent$default("PaymentMetaData", "deviceDetailsReturnedFromPersistentStorage", activity, (String) null, (String) null, 24, (Object) null);
            Intrinsics.checkNotNullExpressionValue(deviceDetails, "deviceDetails");
            return deviceDetails;
        } catch (Exception e2) {
            e2.toString();
            InstrumentUtil.addMetricEvent("getDeviceDetailsException", "PaymentMetaData", activity, "420", ExceptionsKt.b(e2));
            return "{}";
        }
    }

    public final Future<String> a(Activity activity) {
        try {
            return Executors.newSingleThreadExecutor().submit(new b(2, this, activity));
        } catch (Exception e2) {
            e2.toString();
            return null;
        }
    }

    public final String a(Activity activity, long j2) throws JSONException, InterruptedException {
        try {
            a operation = new a();
            Intrinsics.checkNotNullParameter(operation, "operation");
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - jCurrentTimeMillis < j2 && !((Boolean) operation.invoke()).booleanValue()) {
                Thread.sleep(10L);
            }
        } catch (InterruptedException e2) {
            e2.toString();
            InstrumentUtil.addMetricEvent$default("PaymentMetaData", "boundServiceConnectionInterrupted", activity, (String) null, (String) null, 24, (Object) null);
        }
        if (!a()) {
            InstrumentUtil.addMetricEvent$default("PaymentMetaData", "getDeviceDetailsNotReady", activity, (String) null, (String) null, 24, (Object) null);
            return null;
        }
        Future future = com.amazon.android.apay.commonlibrary.commonlib.service.a.f14873e;
        Intrinsics.c(future);
        String str = (String) future.get();
        InstrumentUtil.addMetricEvent$default("PaymentMetaData", "getDeviceDetailsReady", activity, (String) null, (String) null, 24, (Object) null);
        String string = ((JsonObject) new Gson().d(JsonObject.class, str)).k("responseValue").toString();
        Intrinsics.checkNotNullExpressionValue(string, "Gson().fromJson(boundSer…NSE_VALUE_KEY).toString()");
        return a(string, 0);
    }

    public final String a(String str, int i2) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encodedBytes = Base64.decode(bytes, i2);
        Intrinsics.checkNotNullExpressionValue(encodedBytes, "encodedBytes");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(encodedBytes, UTF_8);
    }
}
