package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class AtLeastOne extends Grammar implements SimpleGrammar {

    /* renamed from: a, reason: collision with root package name */
    public final Grammar f50304a;

    public AtLeastOne(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.f50304a = grammar;
    }

    @Override // io.ktor.http.parsing.SimpleGrammar
    public final Grammar b() {
        return this.f50304a;
    }
}
