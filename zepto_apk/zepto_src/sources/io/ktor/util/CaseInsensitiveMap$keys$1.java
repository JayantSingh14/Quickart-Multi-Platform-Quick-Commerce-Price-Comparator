package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class CaseInsensitiveMap$keys$1 extends Lambda implements Function1<CaseInsensitiveString, String> {

    /* renamed from: c, reason: collision with root package name */
    public static final CaseInsensitiveMap$keys$1 f50441c = new CaseInsensitiveMap$keys$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CaseInsensitiveString $receiver = (CaseInsensitiveString) obj;
        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
        return $receiver.f50444a;
    }
}
