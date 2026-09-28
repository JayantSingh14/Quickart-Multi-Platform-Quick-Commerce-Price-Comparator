package io.ktor.http;

import io.ktor.util.CaseInsensitiveMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FileContentTypeKt$contentTypesByExtensions$2 extends Lambda implements Function0<Map<String, List<? extends ContentType>>> {

    /* renamed from: c, reason: collision with root package name */
    public static final FileContentTypeKt$contentTypesByExtensions$2 f50189c = new FileContentTypeKt$contentTypesByExtensions$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CaseInsensitiveMap caseInsensitiveMap = new CaseInsensitiveMap();
        caseInsensitiveMap.putAll(FileContentTypeKt.a(CollectionsKt.n((List) MimesKt.f50232a.getValue())));
        return caseInsensitiveMap;
    }
}
