package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata
/* loaded from: classes.dex */
public final class EmptyHeaders implements Headers {

    /* renamed from: d, reason: collision with root package name */
    public static final EmptyHeaders f50185d = new EmptyHeaders();

    @Override // io.ktor.util.StringValues
    public final List a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final String b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(name, "name");
        a(name);
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        StringValues.DefaultImpls.a(this, body);
    }

    @Override // io.ktor.util.StringValues
    public final Set d() {
        return EmptySet.f53611a;
    }

    @Override // io.ktor.util.StringValues
    public final boolean e() {
        return true;
    }

    public final String toString() {
        return "Headers " + EmptySet.f53611a;
    }
}
