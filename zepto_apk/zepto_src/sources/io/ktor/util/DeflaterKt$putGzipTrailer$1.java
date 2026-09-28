package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {43, 44}, m = "putGzipTrailer")
/* loaded from: classes3.dex */
final class DeflaterKt$putGzipTrailer$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteWriteChannel f50470a;

    /* renamed from: b, reason: collision with root package name */
    public Deflater f50471b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50472c;

    /* renamed from: d, reason: collision with root package name */
    public int f50473d;

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f50472c = r9
            int r9 = r8.f50473d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 | r0
            r8.f50473d = r9
            r9 = 0
            boolean r0 = r8 instanceof io.ktor.util.DeflaterKt$putGzipTrailer$1
            if (r0 == 0) goto L1b
            int r0 = r8.f50473d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L1b
            int r0 = r0 - r1
            r8.f50473d = r0
            r0 = r8
            goto L20
        L1b:
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = new io.ktor.util.DeflaterKt$putGzipTrailer$1
            r0.<init>(r8)
        L20:
            java.lang.Object r1 = r0.f50472c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f50473d
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L44
            if (r3 == r5) goto L3a
            if (r3 != r4) goto L32
            kotlin.ResultKt.b(r1)
            goto L74
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.util.zip.Deflater r9 = r0.f50471b
            io.ktor.utils.io.ByteWriteChannel r3 = r0.f50470a
            kotlin.ResultKt.b(r1)
            r1 = r9
            r9 = r3
            goto L5e
        L44:
            kotlin.ResultKt.b(r1)
            long r6 = r9.getValue()
            int r1 = (int) r6
            int r1 = java.lang.Integer.reverseBytes(r1)
            r0.f50470a = r9
            r0.f50471b = r9
            r0.f50473d = r5
            java.lang.Object r1 = r9.H(r1, r0)
            if (r1 != r2) goto L5d
            goto L76
        L5d:
            r1 = r9
        L5e:
            int r1 = r1.getTotalIn()
            int r1 = java.lang.Integer.reverseBytes(r1)
            r3 = 0
            r0.f50470a = r3
            r0.f50471b = r3
            r0.f50473d = r4
            java.lang.Object r9 = r9.H(r1, r0)
            if (r9 != r2) goto L74
            goto L76
        L74:
            kotlin.Unit r2 = kotlin.Unit.f53572a
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt$putGzipTrailer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
