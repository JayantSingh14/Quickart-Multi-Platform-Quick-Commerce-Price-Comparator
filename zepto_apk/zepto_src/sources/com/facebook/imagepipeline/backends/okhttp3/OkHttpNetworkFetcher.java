package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import androidx.constraintlayout.helper.widget.a;
import coil3.network.internal.UtilsKt;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f17703a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f17704b;

    /* renamed from: c, reason: collision with root package name */
    public final CacheControl f17705c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class OkHttpNetworkFetchState extends FetchState {

        /* renamed from: f, reason: collision with root package name */
        public long f17706f;

        /* renamed from: g, reason: collision with root package name */
        public long f17707g;

        /* renamed from: h, reason: collision with root package name */
        public long f17708h;
    }

    public OkHttpNetworkFetcher(OkHttpClient callFactory) {
        Intrinsics.checkNotNullParameter(callFactory, "okHttpClient");
        ExecutorService cancellationExecutor = callFactory.f56297a.a();
        Intrinsics.checkNotNullExpressionValue(cancellationExecutor, "executorService(...)");
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(cancellationExecutor, "cancellationExecutor");
        this.f17703a = callFactory;
        this.f17704b = cancellationExecutor;
        CacheControl.Builder builder = new CacheControl.Builder();
        builder.f56185b = true;
        this.f17705c = builder.a();
    }

    public static final void e(OkHttpNetworkFetcher okHttpNetworkFetcher, Call call, Exception exc, NetworkFetcher.Callback callback) {
        okHttpNetworkFetcher.getClass();
        if (call.s()) {
            callback.a();
        } else {
            callback.onFailure(exc);
        }
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public final Map b(FetchState fetchState, int i2) {
        OkHttpNetworkFetchState fetchState2 = (OkHttpNetworkFetchState) fetchState;
        Intrinsics.checkNotNullParameter(fetchState2, "fetchState");
        return MapsKt.h(new Pair("queue_time", String.valueOf(fetchState2.f17707g - fetchState2.f17706f)), new Pair("fetch_time", String.valueOf(fetchState2.f17708h - fetchState2.f17707g)), new Pair("total_time", String.valueOf(fetchState2.f17708h - fetchState2.f17706f)), new Pair("image_size", String.valueOf(i2)));
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public final FetchState c(Consumer consumer, ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerContext, "context");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public final void d(FetchState fetchState) {
        OkHttpNetworkFetchState fetchState2 = (OkHttpNetworkFetchState) fetchState;
        Intrinsics.checkNotNullParameter(fetchState2, "fetchState");
        fetchState2.f17708h = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(OkHttpNetworkFetchState fetchState, NetworkFetcher.Callback callback) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchState.f17706f = SystemClock.elapsedRealtime();
        Uri uriB = fetchState.b();
        Intrinsics.checkNotNullExpressionValue(uriB, "getUri(...)");
        try {
            Request.Builder builder = new Request.Builder();
            builder.i(uriB.toString());
            builder.f(UtilsKt.HTTP_METHOD_GET, null);
            CacheControl cacheControl = this.f17705c;
            if (cacheControl != null) {
                builder.c(cacheControl);
            }
            BytesRange bytesRange = fetchState.f18167b.D().f18356j;
            if (bytesRange != null) {
                Lazy lazy = BytesRange.f17773c;
                String str = String.format(null, "bytes=%s-%s", Arrays.copyOf(new Object[]{BytesRange.Companion.a(bytesRange.f17774a), BytesRange.Companion.a(bytesRange.f17775b)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                builder.a("Range", str);
            }
            Request requestB = builder.b();
            Intrinsics.checkNotNullExpressionValue(requestB, "build(...)");
            g(fetchState, callback, requestB);
        } catch (Exception e2) {
            callback.onFailure(e2);
        }
    }

    public final void g(final OkHttpNetworkFetchState fetchState, final NetworkFetcher.Callback callback, Request request) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(request, "request");
        final RealCall realCallA = this.f17703a.a(request);
        fetchState.f18167b.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$fetchWithRequest$1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                boolean zB = Intrinsics.b(Looper.myLooper(), Looper.getMainLooper());
                Call call = realCallA;
                if (zB) {
                    this.f17704b.execute(new a(call, 11));
                } else {
                    call.cancel();
                }
            }
        });
        realCallA.l0(new Callback() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$fetchWithRequest$2
            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException e2) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e2, "e");
                OkHttpNetworkFetcher.e(this, call, e2, callback);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState = fetchState;
                okHttpNetworkFetchState.f17707g = jElapsedRealtime;
                NetworkFetcher.Callback callback2 = callback;
                ResponseBody responseBody = response.f56356g;
                OkHttpNetworkFetcher okHttpNetworkFetcher = this;
                try {
                    if (responseBody == null) {
                        okHttpNetworkFetcher.getClass();
                        int i2 = OkHttpNetworkFetcherException.f17714a;
                        Intrinsics.checkNotNullParameter(response, "response");
                        OkHttpNetworkFetcher.e(okHttpNetworkFetcher, call, new IOException("Response body null: " + response, new OkHttpNetworkFetcherException()), callback2);
                        return;
                    }
                    try {
                        if (response.c()) {
                            Lazy lazy = BytesRange.f17773c;
                            Intrinsics.checkNotNullParameter("Content-Range", CLConstants.FIELD_PAY_INFO_NAME);
                            BytesRange bytesRangeB = BytesRange.Companion.b(response.b("Content-Range", null));
                            if (bytesRangeB != null && (bytesRangeB.f17774a != 0 || bytesRangeB.f17775b != Integer.MAX_VALUE)) {
                                okHttpNetworkFetchState.f18170e = bytesRangeB;
                                okHttpNetworkFetchState.f18169d = 8;
                            }
                            callback2.b(responseBody.a(), responseBody.e() < 0 ? 0 : (int) responseBody.e());
                        } else {
                            okHttpNetworkFetcher.getClass();
                            int i3 = OkHttpNetworkFetcherException.f17714a;
                            Intrinsics.checkNotNullParameter(response, "response");
                            OkHttpNetworkFetcher.e(okHttpNetworkFetcher, call, new IOException("Unexpected HTTP code " + response, new OkHttpNetworkFetcherException()), callback2);
                        }
                    } catch (Exception e2) {
                        OkHttpNetworkFetcher.e(okHttpNetworkFetcher, call, e2, callback2);
                    }
                    Unit unit = Unit.f53572a;
                    responseBody.close();
                } finally {
                }
            }
        });
    }
}
