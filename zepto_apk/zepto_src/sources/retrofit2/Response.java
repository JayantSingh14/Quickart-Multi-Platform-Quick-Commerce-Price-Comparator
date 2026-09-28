package retrofit2;

import okhttp3.ResponseBody$Companion$asResponseBody$1;

/* loaded from: classes.dex */
public final class Response<T> {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.Response f58224a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f58225b;

    /* renamed from: c, reason: collision with root package name */
    public final ResponseBody$Companion$asResponseBody$1 f58226c;

    public Response(okhttp3.Response response, Object obj, ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1) {
        this.f58224a = response;
        this.f58225b = obj;
        this.f58226c = responseBody$Companion$asResponseBody$1;
    }

    public final String toString() {
        return this.f58224a.toString();
    }
}
