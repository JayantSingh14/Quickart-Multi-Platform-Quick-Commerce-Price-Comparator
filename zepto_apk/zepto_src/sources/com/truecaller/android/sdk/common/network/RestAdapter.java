package com.truecaller.android.sdk.common.network;

import androidx.annotation.RestrictTo;
import in.juspay.hypersdk.core.PaymentConstants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestrictTo
/* loaded from: classes4.dex */
public class RestAdapter {
    public static Object a(String str, Class cls, final String str2, final String str3, final String str4) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.b(str);
        builder.a(GsonConverterFactory.c());
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        builder2.a(new Interceptor() { // from class: com.truecaller.android.sdk.common.network.a
            @Override // okhttp3.Interceptor
            public final Response a(RealInterceptorChain realInterceptorChain) {
                Request.Builder builderB = realInterceptorChain.f56582e.b();
                builderB.a(PaymentConstants.SDK_VERSION, str2);
                builderB.a("sdkVariant", str3);
                builderB.a("sdkVariantVersion", str4);
                return realInterceptorChain.a(builderB.b());
            }
        });
        builder.f58236a = new OkHttpClient(builder2);
        return builder.c().b(cls);
    }
}
