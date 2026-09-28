package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.os.SystemClock;
import coil3.network.internal.UtilsKt;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReactOkHttpNetworkFetcher extends OkHttpNetworkFetcher {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ImageCacheControl.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ImageCacheControl imageCacheControl = ImageCacheControl.f19112a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ImageCacheControl imageCacheControl2 = ImageCacheControl.f19112a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ImageCacheControl imageCacheControl3 = ImageCacheControl.f19112a;
                iArr[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactOkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        super(okHttpClient);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
    }

    @Override // com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    /* renamed from: f */
    public final void a(OkHttpNetworkFetcher.OkHttpNetworkFetchState fetchState, NetworkFetcher.Callback callback) {
        HashMap map;
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchState.f17706f = SystemClock.elapsedRealtime();
        Uri uriB = fetchState.b();
        Intrinsics.checkNotNullExpressionValue(uriB, "getUri(...)");
        CacheControl.Builder builder = new CacheControl.Builder();
        ProducerContext producerContext = fetchState.f18167b;
        if (producerContext.D() instanceof ReactNetworkImageRequest) {
            ImageRequest imageRequestD = producerContext.D();
            Intrinsics.d(imageRequestD, "null cannot be cast to non-null type com.facebook.react.modules.fresco.ReactNetworkImageRequest");
            ReactNetworkImageRequest reactNetworkImageRequest = (ReactNetworkImageRequest) imageRequestD;
            ReadableMap readableMap = reactNetworkImageRequest.s;
            if (readableMap == null) {
                map = null;
            } else {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
                map = new HashMap();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    String string = readableMap.getString(strNextKey);
                    if (string != null) {
                        map.put(strNextKey, string);
                    }
                }
            }
            int iOrdinal = reactNetworkImageRequest.t.ordinal();
            if (iOrdinal == 0) {
                builder.f56185b = true;
            } else if (iOrdinal == 1) {
                builder.f56185b = true;
                builder.f56184a = true;
            } else if (iOrdinal == 2) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.b();
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                builder.f56187d = true;
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                builder.b();
            }
        } else {
            builder.f56185b = true;
            map = null;
        }
        Headers headersJ = map == null ? Headers.j(Collections.EMPTY_MAP) : Headers.j(map);
        Request.Builder builder2 = new Request.Builder();
        builder2.e(headersJ);
        builder2.c(builder.a());
        String string2 = uriB.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        builder2.i(string2);
        builder2.f(UtilsKt.HTTP_METHOD_GET, null);
        g(fetchState, callback, builder2.b());
    }
}
