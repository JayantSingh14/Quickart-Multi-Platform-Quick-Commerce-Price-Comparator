package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes3.dex */
public final class OkHttpImagePipelineConfigFactory {
    public static final ImagePipelineConfig.Builder a(Context context, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        ImagePipelineConfig.DefaultImageRequestConfig defaultImageRequestConfig = ImagePipelineConfig.A;
        Intrinsics.checkNotNullParameter(context, "context");
        ImagePipelineConfig.Builder builder = new ImagePipelineConfig.Builder(context);
        builder.f17852f = new OkHttpNetworkFetcher(okHttpClient);
        return builder;
    }
}
