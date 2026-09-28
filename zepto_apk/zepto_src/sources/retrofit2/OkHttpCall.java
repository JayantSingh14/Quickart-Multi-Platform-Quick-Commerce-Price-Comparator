package retrofit2;

import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSource;
import retrofit2.RequestBuilder;

/* loaded from: classes.dex */
final class OkHttpCall<T> implements Call<T> {

    /* renamed from: a, reason: collision with root package name */
    public final RequestFactory f58116a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f58117b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f58118c;

    /* renamed from: d, reason: collision with root package name */
    public final Call.Factory f58119d;

    /* renamed from: e, reason: collision with root package name */
    public final Converter f58120e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f58121f;

    /* renamed from: g, reason: collision with root package name */
    public okhttp3.Call f58122g;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f58123h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f58124i;

    public static final class ExceptionCatchingResponseBody extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        public final ResponseBody f58127b;

        /* renamed from: c, reason: collision with root package name */
        public final RealBufferedSource f58128c;

        /* renamed from: d, reason: collision with root package name */
        public IOException f58129d;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.f58127b = responseBody;
            this.f58128c = Okio.d(new ForwardingSource(responseBody.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // okio.ForwardingSource, okio.Source
                public final long read(Buffer buffer, long j2) throws IOException {
                    try {
                        return super.read(buffer, j2);
                    } catch (IOException e2) {
                        ExceptionCatchingResponseBody.this.f58129d = e2;
                        throw e2;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f58127b.close();
        }

        @Override // okhttp3.ResponseBody
        public final long e() {
            return this.f58127b.e();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType l() {
            return this.f58127b.l();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.f58128c;
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        public final MediaType f58131b;

        /* renamed from: c, reason: collision with root package name */
        public final long f58132c;

        public NoContentResponseBody(MediaType mediaType, long j2) {
            this.f58131b = mediaType;
            this.f58132c = j2;
        }

        @Override // okhttp3.ResponseBody
        public final long e() {
            return this.f58132c;
        }

        @Override // okhttp3.ResponseBody
        public final MediaType l() {
            return this.f58131b;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object obj, Object[] objArr, Call.Factory factory, Converter converter) {
        this.f58116a = requestFactory;
        this.f58117b = obj;
        this.f58118c = objArr;
        this.f58119d = factory;
        this.f58120e = converter;
    }

    @Override // retrofit2.Call
    public final void N(final Callback callback) {
        okhttp3.Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.f58124i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f58124i = true;
                call = this.f58122g;
                th = this.f58123h;
                if (call == null && th == null) {
                    try {
                        okhttp3.Call callA = a();
                        this.f58122g = callA;
                        call = callA;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.n(th);
                        this.f58123h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.a(this, th);
            return;
        }
        if (this.f58121f) {
            call.cancel();
        }
        call.l0(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            @Override // okhttp3.Callback
            public final void onFailure(okhttp3.Call call2, IOException iOException) {
                try {
                    callback.a(OkHttpCall.this, iOException);
                } catch (Throwable th4) {
                    Utils.n(th4);
                    th4.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public final void onResponse(okhttp3.Call call2, okhttp3.Response response) {
                Callback callback2 = callback;
                OkHttpCall okHttpCall = OkHttpCall.this;
                try {
                    try {
                        callback2.b(okHttpCall, okHttpCall.c(response));
                    } catch (Throwable th4) {
                        Utils.n(th4);
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    Utils.n(th5);
                    try {
                        callback2.a(okHttpCall, th5);
                    } catch (Throwable th6) {
                        Utils.n(th6);
                        th6.printStackTrace();
                    }
                }
            }
        });
    }

    public final okhttp3.Call a() {
        HttpUrl url;
        RequestFactory requestFactory = this.f58116a;
        requestFactory.getClass();
        Object[] objArr = this.f58118c;
        int length = objArr.length;
        ParameterHandler[] parameterHandlerArr = requestFactory.f58209k;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException(android.support.v4.media.b.o(android.support.v4.media.b.u(length, "Argument count (", ") doesn't match expected count ("), parameterHandlerArr.length, ")"));
        }
        RequestBuilder requestBuilder = new RequestBuilder(requestFactory.f58202d, requestFactory.f58201c, requestFactory.f58203e, requestFactory.f58204f, requestFactory.f58205g, requestFactory.f58206h, requestFactory.f58207i, requestFactory.f58208j);
        if (requestFactory.f58210l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
            parameterHandlerArr[i2].a(requestBuilder, objArr[i2]);
        }
        HttpUrl.Builder builder = requestBuilder.f58189d;
        if (builder != null) {
            url = builder.a();
        } else {
            String str = requestBuilder.f58188c;
            HttpUrl httpUrl = requestBuilder.f58187b;
            url = httpUrl.h(str);
            if (url == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl + ", Relative: " + requestBuilder.f58188c);
            }
        }
        RequestBody contentTypeOverridingRequestBody = requestBuilder.f58196k;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = requestBuilder.f58195j;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.c();
            } else {
                MultipartBody.Builder builder3 = requestBuilder.f58194i;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.c();
                } else if (requestBuilder.f58193h) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = requestBuilder.f58192g;
        Headers.Builder builder4 = requestBuilder.f58191f;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new RequestBuilder.ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                builder4.a(UtilsKt.CONTENT_TYPE, mediaType.f56280a);
            }
        }
        Request.Builder builder5 = requestBuilder.f58190e;
        builder5.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        builder5.f56337a = url;
        builder5.e(builder4.e());
        builder5.f(requestBuilder.f58186a, contentTypeOverridingRequestBody);
        builder5.h(Invocation.class, new Invocation(requestFactory.f58199a, this.f58117b, requestFactory.f58200b, arrayList));
        return this.f58119d.a(builder5.b());
    }

    public final okhttp3.Call b() throws IOException {
        okhttp3.Call call = this.f58122g;
        if (call != null) {
            return call;
        }
        Throwable th = this.f58123h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            okhttp3.Call callA = a();
            this.f58122g = callA;
            return callA;
        } catch (IOException | Error | RuntimeException e2) {
            Utils.n(e2);
            this.f58123h = e2;
            throw e2;
        }
    }

    public final Response c(okhttp3.Response response) throws IOException {
        Response.Builder builderE = response.e();
        ResponseBody responseBody = response.f56356g;
        builderE.f56369g = new NoContentResponseBody(responseBody.l(), responseBody.e());
        okhttp3.Response responseA = builderE.a();
        int i2 = responseA.f56353d;
        if (i2 < 200 || i2 >= 300) {
            try {
                Buffer content = new Buffer();
                responseBody.source().F1(content);
                MediaType mediaTypeL = responseBody.l();
                long jE = responseBody.e();
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(content, "<this>");
                ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = new ResponseBody$Companion$asResponseBody$1(mediaTypeL, jE, content);
                if (responseA.c()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new Response(responseA, null, responseBody$Companion$asResponseBody$1);
            } finally {
                responseBody.close();
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            if (responseA.c()) {
                return new Response(responseA, null, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(responseBody);
        try {
            Object objA = this.f58120e.a(exceptionCatchingResponseBody);
            if (responseA.c()) {
                return new Response(responseA, objA, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e2) {
            IOException iOException = exceptionCatchingResponseBody.f58129d;
            if (iOException == null) {
                throw e2;
            }
            throw iOException;
        }
    }

    @Override // retrofit2.Call
    public final void cancel() {
        okhttp3.Call call;
        this.f58121f = true;
        synchronized (this) {
            call = this.f58122g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public final Object clone() {
        return new OkHttpCall(this.f58116a, this.f58117b, this.f58118c, this.f58119d, this.f58120e);
    }

    @Override // retrofit2.Call
    public final synchronized Request r() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return b().r();
    }

    @Override // retrofit2.Call
    public final boolean s() {
        boolean z = true;
        if (this.f58121f) {
            return true;
        }
        synchronized (this) {
            try {
                okhttp3.Call call = this.f58122g;
                if (call == null || !call.s()) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public final Call clone() {
        return new OkHttpCall(this.f58116a, this.f58117b, this.f58118c, this.f58119d, this.f58120e);
    }
}
