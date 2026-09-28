package io.ktor.http.parsing.regex;

import io.ktor.http.parsing.Parser;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RegexParser implements Parser {

    /* renamed from: a, reason: collision with root package name */
    public final Regex f50312a;

    public RegexParser(Regex expression, LinkedHashMap indexes) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        this.f50312a = expression;
    }
}
