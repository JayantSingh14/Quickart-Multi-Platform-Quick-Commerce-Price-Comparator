package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ParametersImpl extends StringValuesImpl implements Parameters {
    public ParametersImpl() {
        this(MapsKt.c());
    }

    @Override // io.ktor.util.StringValuesImpl
    public final String toString() {
        return "Parameters " + d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParametersImpl(Map values) {
        super(values, true);
        Intrinsics.checkNotNullParameter(values, "values");
    }
}
