package io.ktor.client.plugins.cache;

import coil3.network.internal.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpCacheKt$mergedHeadersLookup$1 extends Lambda implements Function1<String, String> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OutgoingContent f49733c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FunctionReferenceImpl f49734d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FunctionReferenceImpl f49735e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpCacheKt$mergedHeadersLookup$1(OutgoingContent outgoingContent, Function1 function1, Function1 function12) {
        super(1);
        this.f49733c = outgoingContent;
        this.f49734d = (FunctionReferenceImpl) function1;
        this.f49735e = (FunctionReferenceImpl) function12;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.FunctionReferenceImpl] */
    /* JADX WARN: Type inference failed for: r8v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String string;
        String string2;
        String header = (String) obj;
        Intrinsics.checkNotNullParameter(header, "header");
        List list = HttpHeaders.f50204a;
        boolean zB = Intrinsics.b(header, "Content-Length");
        OutgoingContent outgoingContent = this.f49733c;
        if (zB) {
            Long lA = outgoingContent.a();
            return (lA == null || (string2 = lA.toString()) == null) ? "" : string2;
        }
        if (Intrinsics.b(header, UtilsKt.CONTENT_TYPE)) {
            ContentType contentTypeB = outgoingContent.b();
            return (contentTypeB == null || (string = contentTypeB.toString()) == null) ? "" : string;
        }
        if (!Intrinsics.b(header, "User-Agent")) {
            List listA = outgoingContent.c().a(header);
            if (listA == null && (listA = (List) this.f49735e.invoke(header)) == null) {
                listA = EmptyList.f53609a;
            }
            return CollectionsKt.E(listA, ";", null, null, null, 62);
        }
        String strB = outgoingContent.c().b("User-Agent");
        if (strB != null) {
            return strB;
        }
        String str = (String) this.f49734d.invoke("User-Agent");
        if (str != null) {
            return str;
        }
        Set set = io.ktor.client.engine.UtilsKt.f49359a;
        return "Ktor client";
    }
}
