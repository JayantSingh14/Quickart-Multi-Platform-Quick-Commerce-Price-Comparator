package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class CaseInsensitiveMap$keys$2 extends Lambda implements Function1<String, CaseInsensitiveString> {

    /* renamed from: c, reason: collision with root package name */
    public static final CaseInsensitiveMap$keys$2 f50442c = new CaseInsensitiveMap$keys$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String $receiver = (String) obj;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        return TextKt.a($receiver);
    }
}
