package io.ktor.client.call;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class SavedCallKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.call.HttpClientCall r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.client.call.SavedCallKt$save$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.call.SavedCallKt$save$1 r0 = (io.ktor.client.call.SavedCallKt$save$1) r0
            int r1 = r0.f49315c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49315c = r1
            goto L18
        L13:
            io.ktor.client.call.SavedCallKt$save$1 r0 = new io.ktor.client.call.SavedCallKt$save$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f49314b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49315c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.client.call.HttpClientCall r4 = r0.f49313a
            kotlin.ResultKt.b(r5)
            goto L4c
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            io.ktor.client.statement.HttpResponse r5 = r4.e()
            io.ktor.utils.io.ByteReadChannel r5 = r5.a()
            r0.f49313a = r4
            r0.f49315c = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r5.n(r2, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            byte[] r5 = io.ktor.utils.io.core.StringsKt.c(r5)
            io.ktor.client.call.SavedHttpCall r0 = new io.ktor.client.call.SavedHttpCall
            io.ktor.client.HttpClient r1 = r4.f49302a
            io.ktor.client.request.HttpRequest r2 = r4.d()
            io.ktor.client.statement.HttpResponse r4 = r4.e()
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.SavedCallKt.a(io.ktor.client.call.HttpClientCall, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
