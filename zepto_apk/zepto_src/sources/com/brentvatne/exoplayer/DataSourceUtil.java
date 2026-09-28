package com.brentvatne.exoplayer;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.AssetDataSource;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes3.dex */
public final class DataSourceUtil {

    /* renamed from: a, reason: collision with root package name */
    public static DefaultDataSource.Factory f15523a;

    /* renamed from: b, reason: collision with root package name */
    public static OkHttpDataSource.Factory f15524b;

    /* renamed from: c, reason: collision with root package name */
    public static String f15525c;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.brentvatne.exoplayer.b] */
    public static final b a(ReactContext reactContext, Uri uri) throws IOException {
        DataSpec dataSpec = new DataSpec(uri);
        Intrinsics.c(reactContext);
        final AssetDataSource assetDataSource = new AssetDataSource(reactContext);
        assetDataSource.j(dataSpec);
        return new DataSource.Factory() { // from class: com.brentvatne.exoplayer.b
            @Override // androidx.media3.datasource.DataSource.Factory
            public final DataSource a() {
                return assetDataSource;
            }
        };
    }

    public static OkHttpDataSource.Factory b(ReactContext reactContext, DefaultBandwidthMeter defaultBandwidthMeter, HashMap map) {
        OkHttpClient okHttpClientB = OkHttpClientProvider.b();
        CookieJar cookieJar = okHttpClientB.f56306j;
        Intrinsics.d(cookieJar, "null cannot be cast to non-null type com.facebook.react.modules.network.CookieJarContainer");
        ((CookieJarContainer) cookieJar).c(new JavaNetCookieJar(new ForwardingCookieHandler(reactContext)));
        OkHttpDataSource.Factory factory = new OkHttpDataSource.Factory(okHttpClientB);
        factory.f6055d = defaultBandwidthMeter;
        Intrinsics.checkNotNullExpressionValue(factory, "setTransferListener(...)");
        if (map == null) {
            factory.f6054c = e(reactContext);
            return factory;
        }
        HttpDataSource.RequestProperties requestProperties = factory.f6052a;
        synchronized (requestProperties) {
            requestProperties.f5903b = null;
            requestProperties.f5902a.clear();
            requestProperties.f5902a.putAll(map);
        }
        if (!map.containsKey("User-Agent")) {
            factory.f6054c = e(reactContext);
        }
        return factory;
    }

    public static final DataSource.Factory c(ReactContext context, DefaultBandwidthMeter defaultBandwidthMeter, HashMap map) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f15523a == null || (map != null && !map.isEmpty())) {
            f15523a = new DefaultDataSource.Factory(context, b(context, defaultBandwidthMeter, map));
        }
        DefaultDataSource.Factory factory = f15523a;
        Intrinsics.d(factory, "null cannot be cast to non-null type androidx.media3.datasource.DataSource.Factory");
        return factory;
    }

    public static final HttpDataSource.Factory d(ReactContext context, DefaultBandwidthMeter defaultBandwidthMeter, HashMap map) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f15524b == null || (map != null && !map.isEmpty())) {
            f15524b = b(context, defaultBandwidthMeter, map);
        }
        OkHttpDataSource.Factory factory = f15524b;
        Intrinsics.d(factory, "null cannot be cast to non-null type androidx.media3.datasource.HttpDataSource.Factory");
        return factory;
    }

    public static String e(ReactContext reactContext) {
        String str;
        if (f15525c == null) {
            String packageName = reactContext.getPackageName();
            int i2 = Util.f5744a;
            try {
                str = reactContext.getPackageManager().getPackageInfo(reactContext.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "?";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append("/");
            sb.append(str);
            sb.append(" (Linux;Android ");
            f15525c = android.support.v4.media.b.r(sb, Build.VERSION.RELEASE, ") AndroidXMedia3/1.4.1");
        }
        String str2 = f15525c;
        Intrinsics.d(str2, "null cannot be cast to non-null type kotlin.String");
        return str2;
    }
}
