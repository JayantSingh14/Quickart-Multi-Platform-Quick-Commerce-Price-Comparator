package com.zeptonow.horizon.network;

import android.content.Context;
import com.zeptonow.horizon.utils.SerializationUtilsKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.Json;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes.dex */
public final class HttpClientFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Context f48101a;

    public HttpClientFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48101a = context;
    }

    public final HttpClient a() {
        Object systemService = this.f48101a.getSystemService("HORIZON_OKHTTP_INSTANCE");
        final OkHttpClient okHttpClient = systemService instanceof OkHttpClient ? (OkHttpClient) systemService : null;
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient(new OkHttpClient.Builder());
        }
        return HttpClientKt.a(new Function1<HttpClientConfig<OkHttpConfig>, Unit>() { // from class: com.zeptonow.horizon.network.HttpClientFactory$create$1

            @Metadata
            /* renamed from: com.zeptonow.horizon.network.HttpClientFactory$create$1$2, reason: invalid class name */
            final class AnonymousClass2 extends Lambda implements Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final AnonymousClass2 f48104c = new AnonymousClass2(1);

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    HttpTimeout.HttpTimeoutCapabilityConfiguration install = (HttpTimeout.HttpTimeoutCapabilityConfiguration) obj;
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    install.getClass();
                    HttpTimeout.HttpTimeoutCapabilityConfiguration.a(15000L);
                    install.f49647a = 15000L;
                    return Unit.f53572a;
                }
            }

            @Metadata
            /* renamed from: com.zeptonow.horizon.network.HttpClientFactory$create$1$3, reason: invalid class name */
            final class AnonymousClass3 extends Lambda implements Function1<ContentNegotiation.Config, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final AnonymousClass3 f48105c = new AnonymousClass3(1);

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ContentNegotiation.Config install = (ContentNegotiation.Config) obj;
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    Json format = SerializationUtilsKt.f48279b;
                    int i2 = JsonSupportKt.f50385a;
                    ContentType contentType = ContentType.Application.f50129a;
                    Intrinsics.checkNotNullParameter(install, "<this>");
                    Intrinsics.checkNotNullParameter(format, "json");
                    Intrinsics.checkNotNullParameter(contentType, "contentType");
                    Intrinsics.checkNotNullParameter(install, "<this>");
                    Intrinsics.checkNotNullParameter(contentType, "contentType");
                    Intrinsics.checkNotNullParameter(format, "format");
                    Configuration.DefaultImpls.a(install, contentType, new KotlinxSerializationConverter(format));
                    return Unit.f53572a;
                }
            }

            @Metadata
            /* renamed from: com.zeptonow.horizon.network.HttpClientFactory$create$1$4, reason: invalid class name */
            final class AnonymousClass4 extends Lambda implements Function1<DefaultRequest.DefaultRequestBuilder, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final AnonymousClass4 f48106c = new AnonymousClass4(1);

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DefaultRequest.DefaultRequestBuilder install = (DefaultRequest.DefaultRequestBuilder) obj;
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    List list = HttpHeaders.f50204a;
                    ContentType contentType = ContentType.Application.f50129a;
                    UtilsKt.a(install, coil3.network.internal.UtilsKt.CONTENT_TYPE, contentType);
                    UtilsKt.a(install, "Accept", contentType);
                    return Unit.f53572a;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HttpClientConfig HttpClient = (HttpClientConfig) obj;
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                final OkHttpClient okHttpClient2 = okHttpClient;
                HttpClient.a(new Function1<OkHttpConfig, Unit>() { // from class: com.zeptonow.horizon.network.HttpClientFactory$create$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        OkHttpConfig engine = (OkHttpConfig) obj2;
                        Intrinsics.checkNotNullParameter(engine, "$this$engine");
                        engine.f49369b = okHttpClient2;
                        return Unit.f53572a;
                    }
                });
                HttpClient.b(HttpTimeout.f49642d, AnonymousClass2.f48104c);
                HttpClient.b(ContentNegotiation.f49845c, AnonymousClass3.f48105c);
                HttpClient.b(DefaultRequest.f49455b, AnonymousClass4.f48106c);
                return Unit.f53572a;
            }
        });
    }
}
