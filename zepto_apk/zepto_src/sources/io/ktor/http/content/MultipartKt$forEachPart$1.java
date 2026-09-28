package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", l = {128, WKSRecord.Service.PWDGEN}, m = "forEachPart")
/* loaded from: classes3.dex */
final class MultipartKt$forEachPart$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MultiPartData f50287a;

    /* renamed from: b, reason: collision with root package name */
    public Function2 f50288b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50289c;

    /* renamed from: d, reason: collision with root package name */
    public int f50290d;

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:11:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            r7.f50289c = r8
            int r0 = r7.f50290d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r7.f50290d = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L32
            if (r0 == r4) goto L28
            if (r0 != r3) goto L20
            kotlin.jvm.functions.Function2 r0 = r7.f50288b
            io.ktor.http.content.MultiPartData r5 = r7.f50287a
            kotlin.ResultKt.b(r8)
            r8 = r5
            r5 = r0
            r0 = r7
            goto L38
        L20:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L28:
            kotlin.jvm.functions.Function2 r0 = r7.f50288b
            io.ktor.http.content.MultiPartData r5 = r7.f50287a
            kotlin.ResultKt.b(r8)
            r6 = r5
            r5 = r7
            goto L46
        L32:
            kotlin.ResultKt.b(r8)
            r0 = r7
            r8 = r2
            r5 = r8
        L38:
            r0.f50287a = r8
            r0.f50288b = r5
            r0.f50290d = r4
            r8.getClass()
            r6 = r5
            r5 = r0
            r0 = r6
            r6 = r8
            r8 = r2
        L46:
            io.ktor.http.content.PartData r8 = (io.ktor.http.content.PartData) r8
            if (r8 != 0) goto L4d
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L4d:
            r5.f50287a = r6
            r5.f50288b = r0
            r5.f50290d = r3
            java.lang.Object r8 = r0.invoke(r8, r5)
            if (r8 != r1) goto L5a
            return r1
        L5a:
            r8 = r5
            r5 = r0
            r0 = r8
            r8 = r6
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.MultipartKt$forEachPart$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
