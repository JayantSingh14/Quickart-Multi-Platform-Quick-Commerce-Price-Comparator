package okhttp3;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Response implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Request f56350a;

    /* renamed from: b, reason: collision with root package name */
    public final Protocol f56351b;

    /* renamed from: c, reason: collision with root package name */
    public final String f56352c;

    /* renamed from: d, reason: collision with root package name */
    public final int f56353d;

    /* renamed from: e, reason: collision with root package name */
    public final Handshake f56354e;

    /* renamed from: f, reason: collision with root package name */
    public final Headers f56355f;

    /* renamed from: g, reason: collision with root package name */
    public final ResponseBody f56356g;

    /* renamed from: h, reason: collision with root package name */
    public final Response f56357h;

    /* renamed from: i, reason: collision with root package name */
    public final Response f56358i;

    /* renamed from: j, reason: collision with root package name */
    public final Response f56359j;

    /* renamed from: k, reason: collision with root package name */
    public final long f56360k;

    /* renamed from: l, reason: collision with root package name */
    public final long f56361l;

    /* renamed from: m, reason: collision with root package name */
    public final Exchange f56362m;
    public CacheControl n;

    @Metadata
    @SourceDebugExtension
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Request f56363a;

        /* renamed from: b, reason: collision with root package name */
        public Protocol f56364b;

        /* renamed from: d, reason: collision with root package name */
        public String f56366d;

        /* renamed from: e, reason: collision with root package name */
        public Handshake f56367e;

        /* renamed from: g, reason: collision with root package name */
        public ResponseBody f56369g;

        /* renamed from: h, reason: collision with root package name */
        public Response f56370h;

        /* renamed from: i, reason: collision with root package name */
        public Response f56371i;

        /* renamed from: j, reason: collision with root package name */
        public Response f56372j;

        /* renamed from: k, reason: collision with root package name */
        public long f56373k;

        /* renamed from: l, reason: collision with root package name */
        public long f56374l;

        /* renamed from: m, reason: collision with root package name */
        public Exchange f56375m;

        /* renamed from: c, reason: collision with root package name */
        public int f56365c = -1;

        /* renamed from: f, reason: collision with root package name */
        public Headers.Builder f56368f = new Headers.Builder();

        public static void b(Response response, String str) {
            if (response != null) {
                if (response.f56356g != null) {
                    throw new IllegalArgumentException(str.concat(".body != null").toString());
                }
                if (response.f56357h != null) {
                    throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
                }
                if (response.f56358i != null) {
                    throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
                }
                if (response.f56359j != null) {
                    throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                }
            }
        }

        public final Response a() {
            int i2 = this.f56365c;
            if (i2 < 0) {
                throw new IllegalStateException(("code < 0: " + this.f56365c).toString());
            }
            Request request = this.f56363a;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.f56364b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.f56366d;
            if (str != null) {
                return new Response(request, protocol, str, i2, this.f56367e, this.f56368f.e(), this.f56369g, this.f56370h, this.f56371i, this.f56372j, this.f56373k, this.f56374l, this.f56375m);
            }
            throw new IllegalStateException("message == null");
        }

        public final void c(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f56368f = headers.i();
        }
    }

    public Response(Request request, Protocol protocol, String message, int i2, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j2, long j3, Exchange exchange) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f56350a = request;
        this.f56351b = protocol;
        this.f56352c = message;
        this.f56353d = i2;
        this.f56354e = handshake;
        this.f56355f = headers;
        this.f56356g = responseBody;
        this.f56357h = response;
        this.f56358i = response2;
        this.f56359j = response3;
        this.f56360k = j2;
        this.f56361l = j3;
        this.f56362m = exchange;
    }

    public final CacheControl a() {
        CacheControl cacheControl = this.n;
        if (cacheControl != null) {
            return cacheControl;
        }
        int i2 = CacheControl.n;
        CacheControl cacheControlA = CacheControl.Companion.a(this.f56355f);
        this.n = cacheControlA;
        return cacheControlA;
    }

    public final String b(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        String strD = this.f56355f.d(name);
        return strD == null ? str : strD;
    }

    public final boolean c() {
        int i2 = this.f56353d;
        return 200 <= i2 && i2 < 300;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ResponseBody responseBody = this.f56356g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public final Builder e() {
        Intrinsics.checkNotNullParameter(this, "response");
        Builder builder = new Builder();
        builder.f56363a = this.f56350a;
        builder.f56364b = this.f56351b;
        builder.f56365c = this.f56353d;
        builder.f56366d = this.f56352c;
        builder.f56367e = this.f56354e;
        builder.f56368f = this.f56355f.i();
        builder.f56369g = this.f56356g;
        builder.f56370h = this.f56357h;
        builder.f56371i = this.f56358i;
        builder.f56372j = this.f56359j;
        builder.f56373k = this.f56360k;
        builder.f56374l = this.f56361l;
        builder.f56375m = this.f56362m;
        return builder;
    }

    public final String toString() {
        return "Response{protocol=" + this.f56351b + ", code=" + this.f56353d + ", message=" + this.f56352c + ", url=" + this.f56350a.f56331a + '}';
    }
}
