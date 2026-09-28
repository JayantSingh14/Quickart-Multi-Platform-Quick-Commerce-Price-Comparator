package io.ktor.http;

import io.ktor.http.Parameters;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class EmptyParameters implements Parameters {

    /* renamed from: d, reason: collision with root package name */
    public static final EmptyParameters f50186d = new EmptyParameters();

    @Override // io.ktor.util.StringValues
    public final List a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final void c(Function2 function2) {
        Parameters.DefaultImpls.a(this, function2);
    }

    @Override // io.ktor.util.StringValues
    public final Set d() {
        return EmptySet.f53611a;
    }

    @Override // io.ktor.util.StringValues
    public final boolean e() {
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Parameters) && ((Parameters) obj).isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return true;
    }

    public final String toString() {
        return "Parameters " + EmptySet.f53611a;
    }
}
