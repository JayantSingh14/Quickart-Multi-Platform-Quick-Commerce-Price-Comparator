package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StringGrammar extends Grammar {

    /* renamed from: a, reason: collision with root package name */
    public final String f50309a;

    public StringGrammar(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f50309a = value;
    }
}
