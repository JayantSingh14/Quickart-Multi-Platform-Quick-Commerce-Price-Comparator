package io.ktor.http.auth;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
final class HttpAuthHeaderKt$unescaped$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MatchResult it = (MatchResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.X(1, it.getValue());
    }
}
