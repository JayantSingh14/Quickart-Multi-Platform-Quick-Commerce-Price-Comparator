package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class CookieDateParser$parse$3 extends Lambda implements Function1<Character, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final CookieDateParser$parse$3 f50150c = new CookieDateParser$parse$3(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(CookieUtilsKt.a(((Character) obj).charValue()));
    }
}
