package com.phoenix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

@Metadata
/* loaded from: classes4.dex */
public final class PhoenixRequestBuilder {

    @Metadata
    public static final class Companion {
        public static Request a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Request.Builder builder = new Request.Builder();
            builder.i(url);
            return builder.b();
        }
    }
}
