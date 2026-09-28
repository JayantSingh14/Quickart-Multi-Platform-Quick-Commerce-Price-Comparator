package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ParserDslKt {
    public static final OrGrammar a(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new OrGrammar(CollectionsKt.I(grammar, grammar2));
    }

    public static final SequenceGrammar b(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new SequenceGrammar(CollectionsKt.I(grammar, grammar2));
    }

    public static final SequenceGrammar c(Grammar grammar, String value) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return b(grammar, new StringGrammar(value));
    }
}
