package okhttp3.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

@Metadata
@JvmName
/* loaded from: classes3.dex */
public final class Internal {
    public static final String a(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.a(true);
    }
}
