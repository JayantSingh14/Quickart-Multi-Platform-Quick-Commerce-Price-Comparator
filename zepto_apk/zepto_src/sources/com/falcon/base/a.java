package com.falcon.base;

import coil3.network.internal.UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response a(RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.f56582e;
        Request.Builder builderB = request.b();
        builderB.d(UtilsKt.CONTENT_TYPE, "application/json");
        builderB.d("Accept", "application/json");
        builderB.f(request.f56332b, request.f56334d);
        return chain.a(builderB.b());
    }
}
