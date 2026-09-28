package coil3.decode;

import androidx.core.util.Pools;
import bridges.CommsModule;
import coil3.decode.BlackholeDecoder;
import coil3.disk.UtilsKt;
import coil3.network.CacheStrategy;
import com.chuckerteam.chucker.internal.support.JsonConverter;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionViewModelFactory;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.falcon.FalconConfig;
import com.falcon.base.NetworkModule;
import com.falcon.event.model.api.EventApi;
import com.google.gson.FormattingStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.AppServiceStarter.api.OrderCleanupApiService;
import com.zeptoconsumerapp.AppServiceStarter.api.POIACleanupApiService;
import com.zeptoconsumerapp.AppServiceStarter.network.AuthInterceptor;
import com.zeptoconsumerapp.AppServiceStarter.network.OrderCleanupRetrofitClient;
import com.zeptoconsumerapp.AppServiceStarter.network.POIACleanupRetrofitClient;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.DynamicFeatures.EventLogger;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharDirectionality;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13864a;

    public /* synthetic */ b(int i2) {
        this.f13864a = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i2 = 0;
        switch (this.f13864a) {
            case 0:
                return BlackholeDecoder.Factory.EMPTY_IMAGE;
            case 1:
                return UtilsKt.instance_delegate$lambda$0();
            case 2:
                return CacheStrategy.DEFAULT;
            case 3:
                Lazy lazy = JsonConverter.f16772a;
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.f45250j = false;
                FormattingStyle formattingStyle = FormattingStyle.f45221e;
                Objects.requireNonNull(formattingStyle);
                gsonBuilder.f45251k = formattingStyle;
                return gsonBuilder.a();
            case 4:
                Object value = JsonConverter.f16772a.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                Gson gson = (Gson) value;
                gson.getClass();
                GsonBuilder gsonBuilder2 = new GsonBuilder(gson);
                gsonBuilder2.f45247g = true;
                return gsonBuilder2.a();
            case 5:
                return new TransactionViewModelFactory(i2);
            case 6:
                return new TransactionViewModelFactory(i2);
            case 7:
                return new ImageFormatChecker();
            case 8:
                Lazy lazy2 = BytesRange.f17773c;
                return Pattern.compile("[-/ ]");
            case 9:
                Lazy lazy3 = BitmapUtil.f18392a;
                return new Pools.SynchronizedPool(12);
            case 10:
                if (FalconConfig.f20434b == null) {
                    throw new IllegalStateException("FalconConfig is not initialized. Call FalconConfig.init() first.");
                }
                NetworkModule.Companion companion = NetworkModule.f20436a;
                if (NetworkModule.f20437b == null) {
                    synchronized (companion) {
                        if (NetworkModule.f20437b == null) {
                            NetworkModule.f20437b = new NetworkModule();
                        }
                    }
                }
                Intrinsics.checkNotNullParameter(BuildConfig.EVENT_SERVICE_BASE_URL, "baseUrl");
                Retrofit.Builder builder = new Retrofit.Builder();
                builder.b(BuildConfig.EVENT_SERVICE_BASE_URL);
                OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
                builder2.a(new com.falcon.base.a());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder2.b(10L, timeUnit);
                builder2.c(10L, timeUnit);
                builder2.d(10L, timeUnit);
                builder.f58236a = new OkHttpClient(builder2);
                builder.a(GsonConverterFactory.c());
                Retrofit retrofitC = builder.c();
                Intrinsics.checkNotNullExpressionValue(retrofitC, "build(...)");
                return (EventApi) retrofitC.b(EventApi.class);
            case 11:
                String str = OrderCleanupRetrofitClient.f47329a;
                Retrofit.Builder builder3 = new Retrofit.Builder();
                builder3.b(BuildConfig.KONG_API_GATEWAY_URL);
                builder3.a(GsonConverterFactory.c());
                OkHttpClient.Builder builderC = OkHttpClientProvider.b().c();
                builderC.a(new AuthInterceptor(OrderCleanupRetrofitClient.f47329a));
                builder3.f58236a = new OkHttpClient(builderC);
                Retrofit retrofitC2 = builder3.c();
                Intrinsics.checkNotNullExpressionValue(retrofitC2, "build(...)");
                return (OrderCleanupApiService) retrofitC2.b(OrderCleanupApiService.class);
            case 12:
                String str2 = POIACleanupRetrofitClient.f47331a;
                Retrofit.Builder builder4 = new Retrofit.Builder();
                builder4.b(BuildConfig.KONG_API_GATEWAY_URL);
                builder4.a(GsonConverterFactory.c());
                OkHttpClient.Builder builderC2 = OkHttpClientProvider.b().c();
                builderC2.a(new AuthInterceptor(POIACleanupRetrofitClient.f47331a));
                builder4.f58236a = new OkHttpClient(builderC2);
                Retrofit retrofitC3 = builder4.c();
                Intrinsics.checkNotNullExpressionValue(retrofitC3, "build(...)");
                return (POIACleanupApiService) retrofitC3.b(POIACleanupApiService.class);
            case 13:
                MediaType mediaType = EventLogger.f47406a;
                OkHttpClient.Builder builder5 = new OkHttpClient.Builder();
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                builder5.b(30L, timeUnit2);
                builder5.c(30L, timeUnit2);
                builder5.d(30L, timeUnit2);
                return new OkHttpClient(builder5);
            case 14:
                if (MMKV.getRootDir() == null) {
                    MMKV.initialize(ContextProvider.f47615b.a().a());
                }
                return MMKV.defaultMMKV();
            case 15:
                return ContextProvider.f47615b.a().a().getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            default:
                List list = CharDirectionality.f53954e;
                int iF = MapsKt.f(CollectionsKt.r(list, 10));
                if (iF < 16) {
                    iF = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
                Iterator it = ((AbstractList) list).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    linkedHashMap.put(Integer.valueOf(((CharDirectionality) next).f53955a), next);
                }
                return linkedHashMap;
        }
    }
}
