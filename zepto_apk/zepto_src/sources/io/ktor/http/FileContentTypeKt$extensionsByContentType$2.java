package io.ktor.http;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: classes3.dex */
public final class FileContentTypeKt$extensionsByContentType$2 extends Lambda implements Function0<Map<ContentType, ? extends List<? extends String>>> {

    /* renamed from: c, reason: collision with root package name */
    public static final FileContentTypeKt$extensionsByContentType$2 f50190c = new FileContentTypeKt$extensionsByContentType$2(0);

    @Metadata
    /* renamed from: io.ktor.http.FileContentTypeKt$extensionsByContentType$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<Pair<? extends String, ? extends ContentType>, Pair<? extends ContentType, ? extends String>> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f50191c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            return new Pair((ContentType) pair.f53534b, (String) pair.f53533a);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return FileContentTypeKt.a(SequencesKt.m(CollectionsKt.n((List) MimesKt.f50232a.getValue()), AnonymousClass1.f50191c));
    }
}
