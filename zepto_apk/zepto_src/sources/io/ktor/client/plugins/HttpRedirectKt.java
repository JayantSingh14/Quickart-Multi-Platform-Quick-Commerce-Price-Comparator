package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes.dex */
public final class HttpRedirectKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f49574a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f49575b;

    static {
        HttpMethod httpMethod = HttpMethod.f50205b;
        HttpMethod[] elements = {HttpMethod.f50205b, HttpMethod.f50207d};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f49574a = ArraysKt.H(elements);
        f49575b = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpRedirect");
    }

    public static final boolean a(HttpStatusCode httpStatusCode) {
        int i2 = httpStatusCode.f50229a;
        return i2 == HttpStatusCode.f50220d.f50229a || i2 == HttpStatusCode.f50221e.f50229a || i2 == HttpStatusCode.f50224h.f50229a || i2 == HttpStatusCode.f50225i.f50229a || i2 == HttpStatusCode.f50222f.f50229a;
    }
}
