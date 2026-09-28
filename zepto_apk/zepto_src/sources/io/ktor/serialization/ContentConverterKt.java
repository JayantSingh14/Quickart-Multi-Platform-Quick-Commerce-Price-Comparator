package io.ktor.serialization;

import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ContentConverterKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.util.ArrayList r5, final io.ktor.utils.io.ByteReadChannel r6, final io.ktor.util.reflect.TypeInfo r7, final java.nio.charset.Charset r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws io.ktor.serialization.ContentConvertException {
        /*
            boolean r0 = r9 instanceof io.ktor.serialization.ContentConverterKt$deserialize$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = (io.ktor.serialization.ContentConverterKt$deserialize$1) r0
            int r1 = r0.f50329d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50329d = r1
            goto L18
        L13:
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = new io.ktor.serialization.ContentConverterKt$deserialize$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f50328c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50329d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            io.ktor.util.reflect.TypeInfo r7 = r0.f50327b
            io.ktor.utils.io.ByteReadChannel r6 = r0.f50326a
            kotlin.ResultKt.b(r9)
            goto L53
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 r9 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3
            r9.<init>(r5)
            io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1 r5 = new io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1
            r5.<init>()
            io.ktor.serialization.ContentConverterKt$deserialize$result$2 r8 = new io.ktor.serialization.ContentConverterKt$deserialize$result$2
            r8.<init>(r6, r4)
            r0.f50326a = r6
            r0.f50327b = r7
            r0.f50329d = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.k(r5, r8, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            if (r9 != 0) goto L7d
            boolean r5 = r6.K()
            if (r5 != 0) goto L5c
            return r6
        L5c:
            kotlin.jvm.internal.TypeReference r5 = r7.f50604c
            if (r5 == 0) goto L69
            boolean r5 = r5.a()
            if (r5 != r3) goto L69
            io.ktor.http.content.NullBody r5 = io.ktor.http.content.NullBody.f50295a
            return r5
        L69:
            io.ktor.serialization.ContentConvertException r5 = new io.ktor.serialization.ContentConvertException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "No suitable converter found for "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r4)
            throw r5
        L7d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.ContentConverterKt.a(java.util.ArrayList, io.ktor.utils.io.ByteReadChannel, io.ktor.util.reflect.TypeInfo, java.nio.charset.Charset, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Charset b(Headers headers) {
        Charset charsetForName;
        Charset defaultCharset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        List list = HttpHeaders.f50204a;
        Iterator it = CollectionsKt.Y(new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.a(Double.valueOf(((HeaderValue) obj2).f50194c), Double.valueOf(((HeaderValue) obj).f50194c));
            }
        }, HttpHeaderValueParserKt.a(headers.b("Accept-Charset"))).iterator();
        while (true) {
            if (!it.hasNext()) {
                charsetForName = null;
                break;
            }
            String str = ((HeaderValue) it.next()).f50192a;
            if (Intrinsics.b(str, "*")) {
                charsetForName = defaultCharset;
                break;
            }
            if (Charset.isSupported(str)) {
                charsetForName = Charset.forName(str);
                break;
            }
        }
        return charsetForName == null ? defaultCharset : charsetForName;
    }
}
