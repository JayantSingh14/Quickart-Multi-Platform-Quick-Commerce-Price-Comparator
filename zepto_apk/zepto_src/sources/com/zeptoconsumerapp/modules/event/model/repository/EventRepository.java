package com.zeptoconsumerapp.modules.event.model.repository;

import com.facebook.react.modules.network.OkHttpClientProvider;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.modules.base.NetworkModule;
import com.zeptoconsumerapp.modules.event.model.api.EventApi;
import com.zeptoconsumerapp.modules.event.model.api.EventRequestType;
import com.zeptoconsumerapp.modules.event.model.entity.Event;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class EventRepository implements BaseRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f47645b = new Companion();

    /* renamed from: c, reason: collision with root package name */
    public static volatile EventRepository f47646c;

    /* renamed from: a, reason: collision with root package name */
    public final EventApi f47647a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public EventRepository() {
        NetworkModule.Companion companion = NetworkModule.f47623a;
        if (NetworkModule.f47624b == null) {
            synchronized (companion) {
                if (NetworkModule.f47624b == null) {
                    NetworkModule.f47624b = new NetworkModule();
                }
            }
        }
        Intrinsics.checkNotNullParameter(BuildConfig.EVENT_SERVICE_BASE_URL, "baseUrl");
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.b(BuildConfig.EVENT_SERVICE_BASE_URL);
        OkHttpClient.Builder builderC = OkHttpClientProvider.b().c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builderC.b(10L, timeUnit);
        builderC.c(10L, timeUnit);
        builderC.d(10L, timeUnit);
        builder.f58236a = new OkHttpClient(builderC);
        builder.a(GsonConverterFactory.c());
        Retrofit retrofitC = builder.c();
        Intrinsics.checkNotNullExpressionValue(retrofitC, "build(...)");
        Object objB = retrofitC.b(EventApi.class);
        Intrinsics.checkNotNullExpressionValue(objB, "create(...)");
        this.f47647a = (EventApi) objB;
    }

    @Override // com.zeptoconsumerapp.modules.event.model.repository.BaseRepository
    public final void a(String eventName, Map properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        EventRequestType eventRequestType = new EventRequestType(CollectionsKt.H(new Event(eventName, properties)));
        Timber.d("EventRepository").d(BuildConfig.EVENT_SERVICE_BASE_URL, new Object[0]);
        this.f47647a.a(eventRequestType).N(new EventRepository$publishEvent$1());
    }
}
