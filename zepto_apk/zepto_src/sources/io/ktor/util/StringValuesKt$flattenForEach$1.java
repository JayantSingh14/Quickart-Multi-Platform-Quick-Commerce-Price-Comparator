package io.ktor.util;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class StringValuesKt$flattenForEach$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String name = (String) obj;
        List items = (List) obj2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator it = items.iterator();
        if (!it.hasNext()) {
            return Unit.f53572a;
        }
        throw null;
    }
}
