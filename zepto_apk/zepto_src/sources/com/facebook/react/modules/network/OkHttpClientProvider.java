package com.facebook.react.modules.network;

import android.content.Context;
import android.os.Build;
import bridges.CommsModule;
import com.chuckerteam.chucker.api.ChuckerCollector;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.chuckerteam.chucker.api.RetentionManager;
import com.zeptoconsumerapp.NetworkLogger.NetworkEventListener;
import com.zeptoconsumerapp.NetworkLogger.UserAgentClientFactory;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.ZeptoDns;
import com.zeptoconsumerapp.modules.base.ExperimentKeys;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class OkHttpClientProvider {

    /* renamed from: a, reason: collision with root package name */
    public static OkHttpClient f19143a;

    /* renamed from: b, reason: collision with root package name */
    public static UserAgentClientFactory f19144b;

    public static OkHttpClient a() {
        UserAgentClientFactory userAgentClientFactory = f19144b;
        if (userAgentClientFactory == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.b(0L, timeUnit);
            builder.c(0L, timeUnit);
            builder.d(0L, timeUnit);
            ReactCookieJarContainer cookieJar = new ReactCookieJarContainer();
            Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
            builder.f56319j = cookieJar;
            return new OkHttpClient(builder);
        }
        EventListener.Factory factory = NetworkEventListener.f47527f;
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        String str = Utils.f47559a;
        Context context = userAgentClientFactory.f47535a;
        if ("true".equals(context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).getString("isChuckEnabled", "false"))) {
            ChuckerCollector chuckerCollector = new ChuckerCollector(context, RetentionManager.Period.f16637b);
            ChuckerInterceptor.Builder builder3 = new ChuckerInterceptor.Builder(context);
            builder3.c(chuckerCollector);
            builder3.a();
            builder2.a(builder3.b());
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            builder2.b(0L, timeUnit2);
            builder2.d(0L, timeUnit2);
            builder2.c(0L, TimeUnit.MINUTES);
        }
        ExperimentKeys[] experimentKeysArr = ExperimentKeys.f47618b;
        if (Utils.a(context, "alternate_dns") && Build.VERSION.SDK_INT >= 26) {
            ZeptoDns dns = new ZeptoDns();
            Intrinsics.checkNotNullParameter(dns, "dns");
            if (!dns.equals(builder2.f56321l)) {
                builder2.C = null;
            }
            builder2.f56321l = dns;
        }
        ReactCookieJarContainer cookieJar2 = new ReactCookieJarContainer();
        Intrinsics.checkNotNullParameter(cookieJar2, "cookieJar");
        builder2.f56319j = cookieJar2;
        EventListener.Factory eventListenerFactory = NetworkEventListener.f47527f;
        Intrinsics.checkNotNullParameter(eventListenerFactory, "eventListenerFactory");
        builder2.f56314e = eventListenerFactory;
        return new OkHttpClient(builder2);
    }

    public static OkHttpClient b() {
        if (f19143a == null) {
            f19143a = a();
        }
        return f19143a;
    }
}
