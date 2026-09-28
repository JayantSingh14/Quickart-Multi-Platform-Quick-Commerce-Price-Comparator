package io.ktor.http;

import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpMethod {

    /* renamed from: b, reason: collision with root package name */
    public static final HttpMethod f50205b;

    /* renamed from: c, reason: collision with root package name */
    public static final HttpMethod f50206c;

    /* renamed from: d, reason: collision with root package name */
    public static final HttpMethod f50207d;

    /* renamed from: e, reason: collision with root package name */
    public static final List f50208e;

    /* renamed from: a, reason: collision with root package name */
    public final String f50209a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        HttpMethod httpMethod = new HttpMethod(UtilsKt.HTTP_METHOD_GET);
        f50205b = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        f50206c = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        f50207d = httpMethod6;
        f50208e = CollectionsKt.I(httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, new HttpMethod("OPTIONS"));
    }

    public HttpMethod(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f50209a = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpMethod) && Intrinsics.b(this.f50209a, ((HttpMethod) obj).f50209a);
    }

    public final int hashCode() {
        return this.f50209a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("HttpMethod(value="), this.f50209a, ')');
    }
}
