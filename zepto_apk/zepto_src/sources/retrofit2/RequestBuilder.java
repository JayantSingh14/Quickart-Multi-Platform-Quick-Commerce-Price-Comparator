package retrofit2;

import coil3.network.internal.UtilsKt;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* loaded from: classes.dex */
final class RequestBuilder {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f58184l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f58185m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f58186a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpUrl f58187b;

    /* renamed from: c, reason: collision with root package name */
    public String f58188c;

    /* renamed from: d, reason: collision with root package name */
    public HttpUrl.Builder f58189d;

    /* renamed from: e, reason: collision with root package name */
    public final Request.Builder f58190e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    public final Headers.Builder f58191f;

    /* renamed from: g, reason: collision with root package name */
    public MediaType f58192g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f58193h;

    /* renamed from: i, reason: collision with root package name */
    public final MultipartBody.Builder f58194i;

    /* renamed from: j, reason: collision with root package name */
    public final FormBody.Builder f58195j;

    /* renamed from: k, reason: collision with root package name */
    public RequestBody f58196k;

    /* loaded from: classes5.dex */
    public static class ContentTypeOverridingRequestBody extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        public final RequestBody f58197a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaType f58198b;

        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.f58197a = requestBody;
            this.f58198b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return this.f58197a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return this.f58198b;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) {
            this.f58197a.writeTo(bufferedSink);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f58186a = str;
        this.f58187b = httpUrl;
        this.f58188c = str2;
        this.f58192g = mediaType;
        this.f58193h = z;
        if (headers != null) {
            this.f58191f = headers.i();
        } else {
            this.f58191f = new Headers.Builder();
        }
        if (z2) {
            this.f58195j = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f58194i = builder;
            builder.d(MultipartBody.f56284f);
        }
    }

    public final void a(String str, String str2, boolean z) {
        if (UtilsKt.CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                Pattern pattern = MediaType.f56278d;
                this.f58192g = MediaType.Companion.a(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException(android.support.v4.media.b.C("Malformed content type: ", str2), e2);
            }
        }
        Headers.Builder builder = this.f58191f;
        if (z) {
            builder.d(str, str2);
        } else {
            builder.a(str, str2);
        }
    }

    public final void b(String name, String str, boolean z) {
        String str2 = this.f58188c;
        if (str2 != null) {
            HttpUrl httpUrl = this.f58187b;
            HttpUrl.Builder builderF = httpUrl.f(str2);
            this.f58189d = builderF;
            if (builderF == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl + ", Relative: " + this.f58188c);
            }
            this.f58188c = null;
        }
        if (z) {
            HttpUrl.Builder builder = this.f58189d;
            builder.getClass();
            Intrinsics.checkNotNullParameter(name, "encodedName");
            if (builder.f56275g == null) {
                builder.f56275g = new ArrayList();
            }
            ArrayList arrayList = builder.f56275g;
            Intrinsics.c(arrayList);
            arrayList.add(HttpUrl.Companion.a(0, 0, 211, name, " \"'<>#&="));
            ArrayList arrayList2 = builder.f56275g;
            Intrinsics.c(arrayList2);
            arrayList2.add(str != null ? HttpUrl.Companion.a(0, 0, 211, str, " \"'<>#&=") : null);
            return;
        }
        HttpUrl.Builder builder2 = this.f58189d;
        builder2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        if (builder2.f56275g == null) {
            builder2.f56275g = new ArrayList();
        }
        ArrayList arrayList3 = builder2.f56275g;
        Intrinsics.c(arrayList3);
        arrayList3.add(HttpUrl.Companion.a(0, 0, 219, name, " !\"#$&'(),/:;<=>?@[]\\^`{|}~"));
        ArrayList arrayList4 = builder2.f56275g;
        Intrinsics.c(arrayList4);
        arrayList4.add(str != null ? HttpUrl.Companion.a(0, 0, 219, str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~") : null);
    }
}
