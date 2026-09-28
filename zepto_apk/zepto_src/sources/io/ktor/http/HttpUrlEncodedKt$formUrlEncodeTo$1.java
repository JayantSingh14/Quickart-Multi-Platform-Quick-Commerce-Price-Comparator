package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpUrlEncodedKt$formUrlEncodeTo$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        Pair it = (Pair) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String strF = CodecsKt.f((String) it.f53533a, true);
        Object obj2 = it.f53534b;
        if (obj2 == null) {
            return strF;
        }
        String strValueOf = String.valueOf(obj2);
        Intrinsics.checkNotNullParameter(strValueOf, "<this>");
        return strF + '=' + CodecsKt.f(strValueOf, true);
    }
}
