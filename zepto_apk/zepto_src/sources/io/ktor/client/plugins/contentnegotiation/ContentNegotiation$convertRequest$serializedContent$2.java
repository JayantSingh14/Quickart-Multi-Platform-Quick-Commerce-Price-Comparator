package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ContentNegotiation$convertRequest$serializedContent$2 extends Lambda implements Function1<ContentNegotiation.Config.ConverterRegistration, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final ContentNegotiation$convertRequest$serializedContent$2 f49871c = new ContentNegotiation$convertRequest$serializedContent$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ContentNegotiation.Config.ConverterRegistration it = (ContentNegotiation.Config.ConverterRegistration) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.f49851a.toString();
    }
}
