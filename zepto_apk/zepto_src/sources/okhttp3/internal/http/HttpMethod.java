package okhttp3.internal.http;

import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpMethod {
    public static boolean a(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return Intrinsics.b(method, "POST") || Intrinsics.b(method, "PATCH") || Intrinsics.b(method, "PUT") || Intrinsics.b(method, "DELETE") || Intrinsics.b(method, "MOVE");
    }

    public static final boolean b(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return (Intrinsics.b(method, UtilsKt.HTTP_METHOD_GET) || Intrinsics.b(method, "HEAD")) ? false : true;
    }
}
