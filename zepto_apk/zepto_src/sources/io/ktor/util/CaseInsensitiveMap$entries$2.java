package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class CaseInsensitiveMap$entries$2 extends Lambda implements Function1<Map.Entry<String, Object>, Map.Entry<CaseInsensitiveString, Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final CaseInsensitiveMap$entries$2 f50440c = new CaseInsensitiveMap$entries$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map.Entry $receiver = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        return new Entry(TextKt.a((String) $receiver.getKey()), $receiver.getValue());
    }
}
