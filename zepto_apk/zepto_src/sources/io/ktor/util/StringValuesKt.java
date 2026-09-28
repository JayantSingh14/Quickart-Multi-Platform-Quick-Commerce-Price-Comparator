package io.ktor.util;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StringValuesKt {
    public static final void a(StringValuesBuilder stringValuesBuilder, StringValuesBuilder builder) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (Map.Entry entry : builder.d()) {
            stringValuesBuilder.b((List) entry.getValue(), (String) entry.getKey());
        }
    }
}
