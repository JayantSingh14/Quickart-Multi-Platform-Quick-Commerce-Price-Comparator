package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class CaseInsensitiveMap$entries$1 extends Lambda implements Function1<Map.Entry<CaseInsensitiveString, Object>, Map.Entry<String, Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final CaseInsensitiveMap$entries$1 f50439c = new CaseInsensitiveMap$entries$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Map.Entry $receiver = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        return new Entry(((CaseInsensitiveString) $receiver.getKey()).f50444a, $receiver.getValue());
    }
}
