package okhttp3.internal.http;

import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final CookieJar f56571a;

    public BridgeInterceptor(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f56571a = cookieJar;
    }

    @Override // okhttp3.Interceptor
    public final Response a(RealInterceptorChain chain) throws IOException, NumberFormatException {
        boolean z;
        ResponseBody responseBody;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.f56582e;
        Request.Builder builderB = request.b();
        RequestBody requestBody = request.f56334d;
        if (requestBody != null) {
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                builderB.d(UtilsKt.CONTENT_TYPE, mediaTypeContentType.f56280a);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                builderB.d("Content-Length", String.valueOf(jContentLength));
                builderB.g("Transfer-Encoding");
            } else {
                builderB.d("Transfer-Encoding", "chunked");
                builderB.g("Content-Length");
            }
        }
        String strA = request.a("Host");
        int i2 = 0;
        HttpUrl httpUrl = request.f56331a;
        if (strA == null) {
            builderB.d("Host", Util.x(httpUrl, false));
        }
        if (request.a("Connection") == null) {
            builderB.d("Connection", "Keep-Alive");
        }
        if (request.a("Accept-Encoding") == null && request.a("Range") == null) {
            builderB.d("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        CookieJar cookieJar = this.f56571a;
        List listB = cookieJar.b(httpUrl);
        if (!listB.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listB) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                Cookie cookie = (Cookie) obj;
                if (i2 > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.f56225a);
                sb.append('=');
                sb.append(cookie.f56226b);
                i2 = i3;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            builderB.d("Cookie", string);
        }
        if (request.a("User-Agent") == null) {
            builderB.d("User-Agent", "okhttp/4.12.0");
        }
        Response responseA = chain.a(builderB.b());
        Headers headers = responseA.f56355f;
        HttpHeaders.d(cookieJar, httpUrl, headers);
        Response.Builder builderE = responseA.e();
        Intrinsics.checkNotNullParameter(request, "request");
        builderE.f56363a = request;
        if (z && "gzip".equalsIgnoreCase(responseA.b("Content-Encoding", null)) && HttpHeaders.a(responseA) && (responseBody = responseA.f56356g) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.source());
            Headers.Builder builderI = headers.i();
            builderI.g("Content-Encoding");
            builderI.g("Content-Length");
            builderE.c(builderI.e());
            builderE.f56369g = new RealResponseBody(responseA.b(UtilsKt.CONTENT_TYPE, null), -1L, Okio.d(gzipSource));
        }
        return builderE.a();
    }
}
