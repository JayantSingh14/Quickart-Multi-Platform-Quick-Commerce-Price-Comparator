package io.ktor.util;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public class StringValuesSingleImpl implements StringValues {
    @Override // io.ktor.util.StringValues
    public final List a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        StringsKt.t(null, name, false);
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final String b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.t(name, null, false)) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(null);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        body.invoke(null, null);
    }

    @Override // io.ktor.util.StringValues
    public final Set d() {
        return SetsKt.e(new StringValuesSingleImpl$entries$1());
    }

    @Override // io.ktor.util.StringValues
    public final boolean e() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (stringValues.e()) {
            return false;
        }
        return Intrinsics.b(d(), stringValues.d());
    }

    public final int hashCode() {
        Set setD = d();
        return setD.hashCode() + (Boolean.hashCode(false) * 961);
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return false;
    }

    public String toString() {
        return "StringValues(case=true) " + d();
    }
}
