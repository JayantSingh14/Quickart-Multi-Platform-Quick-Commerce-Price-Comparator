package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Nullsafe
/* loaded from: classes.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {

    /* renamed from: a, reason: collision with root package name */
    public final int f18171a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f18172b;

    /* renamed from: c, reason: collision with root package name */
    public final RealtimeSinceBootClock f18173c;

    /* loaded from: classes3.dex */
    public static class HttpUrlConnectionNetworkFetchState extends FetchState {

        /* renamed from: f, reason: collision with root package name */
        public long f18179f;

        /* renamed from: g, reason: collision with root package name */
        public long f18180g;

        /* renamed from: h, reason: collision with root package name */
        public long f18181h;

        public HttpUrlConnectionNetworkFetchState(Consumer consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(RealtimeSinceBootClock.get());
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public final void a(FetchState fetchState, final NetworkFetcher.Callback callback) {
        final HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState = (HttpUrlConnectionNetworkFetchState) fetchState;
        httpUrlConnectionNetworkFetchState.f18179f = this.f18173c.now();
        final Future<?> futureSubmit = this.f18172b.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r0v8, types: [com.facebook.imagepipeline.producers.NetworkFetchProducer$1] */
            /* JADX WARN: Type inference failed for: r3v0, types: [java.io.InputStream, java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r3v5 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.lang.Throwable {
                /*
                    r7 = this;
                    com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState r0 = r2
                    com.facebook.imagepipeline.producers.NetworkFetcher$Callback r1 = r3
                    com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher r2 = com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.this
                    r2.getClass()
                    r3 = 0
                    android.net.Uri r4 = r0.b()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
                    r5 = 5
                    java.net.HttpURLConnection r4 = r2.e(r4, r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
                    com.facebook.common.time.RealtimeSinceBootClock r2 = r2.f18173c     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    long r5 = r2.now()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    r0.f18180g = r5     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    if (r4 == 0) goto L2d
                    java.io.InputStream r3 = r4.getInputStream()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    r0 = r1
                    com.facebook.imagepipeline.producers.NetworkFetchProducer$1 r0 = (com.facebook.imagepipeline.producers.NetworkFetchProducer.AnonymousClass1) r0     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    r2 = -1
                    r0.b(r3, r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
                    goto L2d
                L29:
                    r0 = move-exception
                    goto L4b
                L2b:
                    r0 = move-exception
                    goto L3d
                L2d:
                    if (r3 == 0) goto L32
                    r3.close()     // Catch: java.io.IOException -> L32
                L32:
                    if (r4 == 0) goto L4a
                L34:
                    r4.disconnect()
                    goto L4a
                L38:
                    r0 = move-exception
                    r4 = r3
                    goto L4b
                L3b:
                    r0 = move-exception
                    r4 = r3
                L3d:
                    com.facebook.imagepipeline.producers.NetworkFetchProducer$1 r1 = (com.facebook.imagepipeline.producers.NetworkFetchProducer.AnonymousClass1) r1     // Catch: java.lang.Throwable -> L29
                    r1.onFailure(r0)     // Catch: java.lang.Throwable -> L29
                    if (r3 == 0) goto L47
                    r3.close()     // Catch: java.io.IOException -> L47
                L47:
                    if (r4 == 0) goto L4a
                    goto L34
                L4a:
                    return
                L4b:
                    if (r3 == 0) goto L50
                    r3.close()     // Catch: java.io.IOException -> L50
                L50:
                    if (r4 == 0) goto L55
                    r4.disconnect()
                L55:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.AnonymousClass1.run():void");
            }
        });
        httpUrlConnectionNetworkFetchState.a().b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                if (futureSubmit.cancel(false)) {
                    callback.a();
                }
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public final Map b(FetchState fetchState, int i2) {
        HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState = (HttpUrlConnectionNetworkFetchState) fetchState;
        HashMap map = new HashMap(4);
        map.put("queue_time", Long.toString(httpUrlConnectionNetworkFetchState.f18180g - httpUrlConnectionNetworkFetchState.f18179f));
        map.put("fetch_time", Long.toString(httpUrlConnectionNetworkFetchState.f18181h - httpUrlConnectionNetworkFetchState.f18180g));
        map.put("total_time", Long.toString(httpUrlConnectionNetworkFetchState.f18181h - httpUrlConnectionNetworkFetchState.f18179f));
        map.put("image_size", Integer.toString(i2));
        return map;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public final FetchState c(Consumer consumer, ProducerContext producerContext) {
        return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public final void d(FetchState fetchState) {
        ((HttpUrlConnectionNetworkFetchState) fetchState).f18181h = this.f18173c.now();
    }

    public final HttpURLConnection e(Uri uri, int i2) throws IOException {
        String str;
        HttpURLConnection httpURLConnection = (HttpURLConnection) UriUtil.g(uri).openConnection();
        httpURLConnection.setConnectTimeout(this.f18171a);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return httpURLConnection;
        }
        if (responseCode != 307 && responseCode != 308) {
            switch (responseCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    httpURLConnection.disconnect();
                    throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
            }
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        Uri uri2 = headerField == null ? null : Uri.parse(headerField);
        String scheme = uri.getScheme();
        if (i2 > 0 && uri2 != null && !Objects.a(uri2.getScheme(), scheme)) {
            return e(uri2, i2 - 1);
        }
        if (i2 == 0) {
            String string = uri.toString();
            Locale.getDefault();
            str = "URL " + string + " follows too many redirects";
        } else {
            str = String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
        }
        throw new IOException(str);
    }

    public HttpUrlConnectionNetworkFetcher(int i2) {
        this(RealtimeSinceBootClock.get());
        this.f18171a = i2;
    }

    public HttpUrlConnectionNetworkFetcher(RealtimeSinceBootClock realtimeSinceBootClock) {
        this.f18172b = Executors.newFixedThreadPool(3);
        this.f18173c = realtimeSinceBootClock;
    }
}
