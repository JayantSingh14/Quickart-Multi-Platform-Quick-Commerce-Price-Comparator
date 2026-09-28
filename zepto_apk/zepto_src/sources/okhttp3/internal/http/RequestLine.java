package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata
/* loaded from: classes.dex */
public final class RequestLine {
    public static String a(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD == null) {
            return strB;
        }
        return strB + '?' + strD;
    }
}
