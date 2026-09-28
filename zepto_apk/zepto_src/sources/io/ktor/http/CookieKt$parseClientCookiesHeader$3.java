package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
final class CookieKt$parseClientCookiesHeader$3 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Pair<? extends String, ? extends String>> {

    /* renamed from: c, reason: collision with root package name */
    public static final CookieKt$parseClientCookiesHeader$3 f50165c = new CookieKt$parseClientCookiesHeader$3(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Pair cookie = (Pair) obj;
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        if (StringsKt.O((String) cookie.f53534b, "\"", false)) {
            String str = (String) cookie.f53534b;
            if (StringsKt.r(str, "\"", false)) {
                return new Pair(cookie.f53533a, StringsKt.H(str, "\""));
            }
        }
        return cookie;
    }
}
