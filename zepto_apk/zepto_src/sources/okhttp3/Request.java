package okhttp3;

import android.support.v4.media.b;
import coil3.network.internal.UtilsKt;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Request {

    /* renamed from: a, reason: collision with root package name */
    public final HttpUrl f56331a;

    /* renamed from: b, reason: collision with root package name */
    public final String f56332b;

    /* renamed from: c, reason: collision with root package name */
    public final Headers f56333c;

    /* renamed from: d, reason: collision with root package name */
    public final RequestBody f56334d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f56335e;

    /* renamed from: f, reason: collision with root package name */
    public CacheControl f56336f;

    @Metadata
    @SourceDebugExtension
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public HttpUrl f56337a;

        /* renamed from: d, reason: collision with root package name */
        public RequestBody f56340d;

        /* renamed from: e, reason: collision with root package name */
        public LinkedHashMap f56341e = new LinkedHashMap();

        /* renamed from: b, reason: collision with root package name */
        public String f56338b = UtilsKt.HTTP_METHOD_GET;

        /* renamed from: c, reason: collision with root package name */
        public Headers.Builder f56339c = new Headers.Builder();

        public final void a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f56339c.a(name, value);
        }

        public final Request b() {
            Map mapUnmodifiableMap;
            HttpUrl httpUrl = this.f56337a;
            if (httpUrl == null) {
                throw new IllegalStateException("url == null");
            }
            String str = this.f56338b;
            Headers headersE = this.f56339c.e();
            RequestBody requestBody = this.f56340d;
            LinkedHashMap linkedHashMap = this.f56341e;
            byte[] bArr = Util.f56394a;
            Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
            if (linkedHashMap.isEmpty()) {
                mapUnmodifiableMap = MapsKt.c();
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
                Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
            }
            return new Request(httpUrl, str, headersE, requestBody, mapUnmodifiableMap);
        }

        public final void c(CacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            if (string.length() == 0) {
                g(UtilsKt.CACHE_CONTROL);
            } else {
                d(UtilsKt.CACHE_CONTROL, string);
            }
        }

        public final void d(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f56339c.h(name, value);
        }

        public final void e(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f56339c = headers.i();
        }

        public final void f(String method, RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                Intrinsics.checkNotNullParameter(method, "method");
                if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT")) {
                    throw new IllegalArgumentException(b.D("method ", method, " must have a request body.").toString());
                }
            } else if (!HttpMethod.b(method)) {
                throw new IllegalArgumentException(b.D("method ", method, " must not have a request body.").toString());
            }
            this.f56338b = method;
            this.f56340d = requestBody;
        }

        public final void g(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f56339c.g(name);
        }

        public final void h(Class type, Object obj) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (obj == null) {
                this.f56341e.remove(type);
                return;
            }
            if (this.f56341e.isEmpty()) {
                this.f56341e = new LinkedHashMap();
            }
            LinkedHashMap linkedHashMap = this.f56341e;
            Object objCast = type.cast(obj);
            Intrinsics.c(objCast);
            linkedHashMap.put(type, objCast);
        }

        public final void i(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (StringsKt.O(url, "ws:", true)) {
                StringBuilder sb = new StringBuilder("http:");
                String strSubstring = url.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                url = sb.toString();
            } else if (StringsKt.O(url, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder("https:");
                String strSubstring2 = url.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                url = sb2.toString();
            }
            HttpUrl url2 = HttpUrl.Companion.c(url);
            Intrinsics.checkNotNullParameter(url2, "url");
            this.f56337a = url2;
        }

        public final void j(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
            HttpUrl url2 = HttpUrl.Companion.c(string);
            Intrinsics.checkNotNullParameter(url2, "url");
            this.f56337a = url2;
        }
    }

    public Request(HttpUrl url, String method, Headers headers, RequestBody requestBody, Map tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f56331a = url;
        this.f56332b = method;
        this.f56333c = headers;
        this.f56334d = requestBody;
        this.f56335e = tags;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f56333c.d(name);
    }

    public final Builder b() {
        Intrinsics.checkNotNullParameter(this, "request");
        Builder builder = new Builder();
        builder.f56341e = new LinkedHashMap();
        builder.f56337a = this.f56331a;
        builder.f56338b = this.f56332b;
        builder.f56340d = this.f56334d;
        Map map = this.f56335e;
        builder.f56341e = map.isEmpty() ? new LinkedHashMap() : MapsKt.n(map);
        builder.f56339c = this.f56333c.i();
        return builder;
    }

    public final Object c(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.f56335e.get(type));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f56332b);
        sb.append(", url=");
        sb.append(this.f56331a);
        Headers headers = this.f56333c;
        if (headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (Pair<? extends String, ? extends String> pair : headers) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String str = (String) pair2.f53533a;
                String str2 = (String) pair2.f53534b;
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i2 = i3;
            }
            sb.append(']');
        }
        Map map = this.f56335e;
        if (!map.isEmpty()) {
            sb.append(", tags=");
            sb.append(map);
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
