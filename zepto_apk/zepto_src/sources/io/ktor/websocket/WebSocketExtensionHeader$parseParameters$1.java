package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
final class WebSocketExtensionHeader$parseParameters$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends String>> {

    /* renamed from: c, reason: collision with root package name */
    public static final WebSocketExtensionHeader$parseParameters$1 f51516c = new WebSocketExtensionHeader$parseParameters$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int iW = StringsKt.w(it, '=', 0, 6);
        String strSubstring = "";
        if (iW < 0) {
            return new Pair(it, "");
        }
        IntRange range = RangesKt.f(0, iW);
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String strSubstring2 = it.substring(range.f53838a, range.f53839b + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        int i2 = iW + 1;
        if (i2 < it.length()) {
            strSubstring = it.substring(i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        return new Pair(strSubstring2, strSubstring);
    }
}
