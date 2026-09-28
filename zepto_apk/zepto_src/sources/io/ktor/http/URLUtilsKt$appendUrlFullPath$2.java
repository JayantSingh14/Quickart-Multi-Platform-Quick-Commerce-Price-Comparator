package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class URLUtilsKt$appendUrlFullPath$2 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final URLUtilsKt$appendUrlFullPath$2 f50259c = new URLUtilsKt$appendUrlFullPath$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Pair it = (Pair) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String str = (String) it.f53533a;
        Object obj2 = it.f53534b;
        if (obj2 == null) {
            return str;
        }
        return str + '=' + String.valueOf(obj2);
    }
}
