package io.sentry.android.replay;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
final class DefaultReplayBreadcrumbConverter$snakeToCamelCase$1 extends Lambda implements Function1<MatchResult, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultReplayBreadcrumbConverter$snakeToCamelCase$1 f52405c = new DefaultReplayBreadcrumbConverter$snakeToCamelCase$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MatchResult it = (MatchResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String strValueOf = String.valueOf(StringsKt.A(it.getValue()));
        Intrinsics.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
}
