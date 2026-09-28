package com.zeptoconsumerapp.AppServiceStarter.network;

import in.juspay.hyper.constants.LogSubCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

@Metadata
/* loaded from: classes4.dex */
public final class AuthInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f47328a;

    public AuthInterceptor(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.f47328a = accessToken;
    }

    @Override // okhttp3.Interceptor
    public final Response a(RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderB = chain.f56582e.b();
        builderB.a("Authorization", "Bearer ".concat(this.f47328a));
        builderB.a("app_version", "26.1.3");
        builderB.a("platform", LogSubCategory.LifeCycle.ANDROID);
        return chain.a(builderB.b());
    }
}
