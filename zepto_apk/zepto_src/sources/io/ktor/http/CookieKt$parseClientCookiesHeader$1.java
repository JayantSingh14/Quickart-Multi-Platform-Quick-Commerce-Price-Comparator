package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;

@Metadata
/* loaded from: classes3.dex */
final class CookieKt$parseClientCookiesHeader$1 extends Lambda implements Function1<MatchResult, Pair<? extends String, ? extends String>> {

    /* renamed from: c, reason: collision with root package name */
    public static final CookieKt$parseClientCookiesHeader$1 f50163c = new CookieKt$parseClientCookiesHeader$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str;
        String str2;
        MatchResult it = (MatchResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        MatchGroup matchGroupD = it.c().d(2);
        String str3 = "";
        if (matchGroupD == null || (str = matchGroupD.f53983a) == null) {
            str = "";
        }
        MatchGroup matchGroupD2 = it.c().d(4);
        if (matchGroupD2 != null && (str2 = matchGroupD2.f53983a) != null) {
            str3 = str2;
        }
        return new Pair(str, str3);
    }
}
