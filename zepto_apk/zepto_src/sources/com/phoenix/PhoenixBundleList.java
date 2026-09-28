package com.phoenix;

import com.facebook.react.bridge.Promise;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixClientBuilder;
import com.phoenix.PhoenixLogger;
import com.phoenix.PhoenixRequestBuilder;
import com.phoenix.PhoenixUtils;
import in.juspay.hyperutil.constants.LogLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class PhoenixBundleList {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f46120a = new Companion();

    @Metadata
    public static final class Companion {
        public static final String a(int i2) throws Exception {
            OkHttpClient okHttpClientA = PhoenixClientBuilder.Companion.a();
            String str = Phoenix.f46111a;
            if (str == null) {
                Intrinsics.h(CLConstants.SALT_FIELD_APP_ID);
                throw null;
            }
            Request requestA = PhoenixRequestBuilder.Companion.a("https://api-gateway.zepto.co.in/Prod/api/v1/release/list?appId=" + str + "&jsVersion=" + i2);
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            String str2 = Phoenix.f46111a;
            if (str2 == null) {
                Intrinsics.h(CLConstants.SALT_FIELD_APP_ID);
                throw null;
            }
            jSONObject.put("app_id", str2);
            jSONObject.put("app_version", Phoenix.Companion.b().getPackageManager().getPackageInfo(Phoenix.Companion.b().getPackageName(), 0).versionName);
            jSONObject.put("js_version", i2);
            try {
                Response responseD = okHttpClientA.a(requestA).d();
                try {
                    System.currentTimeMillis();
                    if (!responseD.c()) {
                        PhoenixLogger.Companion.a("Bundle list API failed with code: " + responseD.f56353d);
                        responseD.close();
                        return null;
                    }
                    ResponseBody responseBody = responseD.f56356g;
                    if (responseBody == null) {
                        Intrinsics.checkNotNullParameter("Bundle list API response body is null", "data");
                        responseD.close();
                        return null;
                    }
                    String strR = responseBody.r();
                    PhoenixLogger.Companion.a("Bundle list API response: ".concat(strR));
                    responseD.close();
                    return strR;
                } finally {
                }
            } catch (Exception e2) {
                PhoenixLogger.Companion.a("Exception in fetchBundleListFromServer: " + e2.getMessage());
                PhoenixUtils.Companion.a(jSONObject, new Pair(LogLevel.EXCEPTION, String.valueOf(e2.getMessage())), new Pair("reason", "api_request_failed"));
                throw e2;
            }
        }

        public final synchronized void b(int i2, Promise promise) {
            Intrinsics.checkNotNullParameter(promise, "promise");
            BuildersKt.c(CoroutineScopeKt.a(Dispatchers.f54091a), null, new PhoenixBundleList$Companion$getBundleList$1(i2, promise, null), 3);
        }
    }
}
