package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class Symbol {

    /* renamed from: a, reason: collision with root package name */
    public final String f50568a;

    public Symbol(String symbol) {
        Intrinsics.checkNotNullParameter(symbol, "symbol");
        this.f50568a = symbol;
    }

    public final String toString() {
        return this.f50568a;
    }
}
