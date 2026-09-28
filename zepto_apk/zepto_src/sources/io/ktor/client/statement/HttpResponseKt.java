package io.ktor.client.statement;

import io.ktor.client.request.HttpRequest;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpResponseKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.statement.HttpResponse r5, java.nio.charset.Charset r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws io.ktor.http.BadContentTypeFormatException {
        /*
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt$bodyAsText$1) r0
            int r1 = r0.f50068c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50068c = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f50067b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50068c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.nio.charset.CharsetDecoder r5 = r0.f50066a
            kotlin.ResultKt.b(r7)
            goto L83
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            io.ktor.http.Headers r7 = r5.getHeaders()
            java.util.List r2 = io.ktor.http.HttpHeaders.f50204a
            java.lang.String r2 = "Content-Type"
            java.lang.String r7 = r7.b(r2)
            r2 = 0
            if (r7 == 0) goto L52
            io.ktor.http.ContentType r4 = io.ktor.http.ContentType.f50126e
            io.ktor.http.ContentType r7 = io.ktor.http.ContentType.Companion.a(r7)
            goto L53
        L52:
            r7 = r2
        L53:
            if (r7 == 0) goto L59
            java.nio.charset.Charset r2 = io.ktor.http.ContentTypesKt.a(r7)
        L59:
            if (r2 != 0) goto L5c
            goto L5d
        L5c:
            r6 = r2
        L5d:
            java.nio.charset.CharsetDecoder r6 = r6.newDecoder()
            io.ktor.client.call.HttpClientCall r5 = r5.o1()
            java.lang.Class<io.ktor.utils.io.core.ByteReadPacket> r7 = io.ktor.utils.io.core.ByteReadPacket.class
            kotlin.jvm.internal.TypeReference r2 = kotlin.jvm.internal.Reflection.c(r7)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.d(r2)
            kotlin.jvm.internal.ClassReference r7 = kotlin.jvm.internal.Reflection.a(r7)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.a(r4, r7, r2)
            r0.f50066a = r6
            r0.f50068c = r3
            java.lang.Object r7 = r5.a(r7, r0)
            if (r7 != r1) goto L82
            return r1
        L82:
            r5 = r6
        L83:
            if (r7 == 0) goto L91
            io.ktor.utils.io.core.ByteReadPacket r7 = (io.ktor.utils.io.core.ByteReadPacket) r7
            java.lang.String r6 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = io.ktor.utils.io.charsets.EncodingKt.a(r5, r7)
            return r5
        L91:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.core.ByteReadPacket"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.a(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void c(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        CoroutineContext.Element element = httpResponse.r().get(Job.Key.f54121a);
        Intrinsics.c(element);
        ((CompletableJob) element).complete();
    }

    public static final HttpRequest d(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.o1().d();
    }
}
