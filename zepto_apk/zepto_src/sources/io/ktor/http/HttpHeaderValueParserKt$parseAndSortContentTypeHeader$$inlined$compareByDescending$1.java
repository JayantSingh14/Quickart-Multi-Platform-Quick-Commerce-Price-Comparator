package io.ktor.http;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$compareByDescending$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.a(Double.valueOf(((HeaderValue) obj2).f50194c), Double.valueOf(((HeaderValue) obj).f50194c));
    }
}
