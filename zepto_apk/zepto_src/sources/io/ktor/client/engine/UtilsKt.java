package io.ktor.client.engine;

import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f49359a;

    static {
        List list = HttpHeaders.f50204a;
        String[] elements = {"Date", "Expires", "Last-Modified", "If-Modified-Since", "If-Unmodified-Since"};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f49359a = ArraysKt.H(elements);
    }

    public static final void a(final HeadersImpl requestHeaders, final OutgoingContent content, final Function2 block) {
        String strB;
        String strB2;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(block, "block");
        Function1<HeadersBuilder, Unit> block2 = new Function1<HeadersBuilder, Unit>() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HeadersBuilder buildHeaders = (HeadersBuilder) obj;
                Intrinsics.checkNotNullParameter(buildHeaders, "$this$buildHeaders");
                buildHeaders.e(requestHeaders);
                buildHeaders.e(content.c());
                return Unit.f53572a;
            }
        };
        Intrinsics.checkNotNullParameter(block2, "block");
        HeadersBuilder headersBuilder = new HeadersBuilder(true);
        block2.invoke(headersBuilder);
        headersBuilder.l().c(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String key = (String) obj;
                List values = (List) obj2;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(values, "values");
                List list = HttpHeaders.f50204a;
                if (!"Content-Length".equals(key) && !coil3.network.internal.UtilsKt.CONTENT_TYPE.equals(key)) {
                    boolean zContains = UtilsKt.f49359a.contains(key);
                    Function2 function2 = block;
                    if (zContains) {
                        Iterator it = values.iterator();
                        while (it.hasNext()) {
                            function2.invoke(key, (String) it.next());
                        }
                    } else {
                        function2.invoke(key, CollectionsKt.E(values, "Cookie".equals(key) ? "; " : ",", null, null, null, 62));
                    }
                }
                return Unit.f53572a;
            }
        });
        List list = HttpHeaders.f50204a;
        if (requestHeaders.b("User-Agent") == null && content.c().b("User-Agent") == null) {
            boolean z = PlatformUtils.f50503a;
            block.invoke("User-Agent", "Ktor client");
        }
        ContentType contentTypeB = content.b();
        if ((contentTypeB == null || (strB = contentTypeB.toString()) == null) && (strB = content.c().b(coil3.network.internal.UtilsKt.CONTENT_TYPE)) == null) {
            strB = requestHeaders.b(coil3.network.internal.UtilsKt.CONTENT_TYPE);
        }
        Long lA = content.a();
        if ((lA == null || (strB2 = lA.toString()) == null) && (strB2 = content.c().b("Content-Length")) == null) {
            strB2 = requestHeaders.b("Content-Length");
        }
        if (strB != null) {
            block.invoke(coil3.network.internal.UtilsKt.CONTENT_TYPE, strB);
        }
        if (strB2 != null) {
            block.invoke("Content-Length", strB2);
        }
    }
}
