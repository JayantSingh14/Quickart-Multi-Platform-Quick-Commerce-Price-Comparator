package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {37, Type.A6, 39}, m = "putGzipHeader")
/* loaded from: classes3.dex */
final class DeflaterKt$putGzipHeader$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteWriteChannel f50467a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50468b;

    /* renamed from: c, reason: collision with root package name */
    public int f50469c;

    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            r7.f50468b = r8
            int r8 = r7.f50469c
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r8 | r0
            r7.f50469c = r8
            r8 = 0
            boolean r0 = r7 instanceof io.ktor.util.DeflaterKt$putGzipHeader$1
            if (r0 == 0) goto L1b
            int r0 = r7.f50469c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L1b
            int r0 = r0 - r1
            r7.f50469c = r0
            r0 = r7
            goto L20
        L1b:
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = new io.ktor.util.DeflaterKt$putGzipHeader$1
            r0.<init>(r7)
        L20:
            java.lang.Object r1 = r0.f50468b
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f50469c
            r4 = 3
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L49
            if (r3 == r6) goto L43
            if (r3 == r5) goto L3d
            if (r3 != r4) goto L35
            kotlin.ResultKt.b(r1)
            goto L79
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            io.ktor.utils.io.ByteWriteChannel r8 = r0.f50467a
            kotlin.ResultKt.b(r1)
            goto L6b
        L43:
            io.ktor.utils.io.ByteWriteChannel r8 = r0.f50467a
            kotlin.ResultKt.b(r1)
            goto L5e
        L49:
            kotlin.ResultKt.b(r1)
            r1 = -29921(0xffffffffffff8b1f, float:NaN)
            short r1 = (short) r1
            short r1 = java.lang.Short.reverseBytes(r1)
            r0.f50467a = r8
            r0.f50469c = r6
            java.lang.Object r1 = r8.e(r1, r0)
            if (r1 != r2) goto L5e
            goto L7b
        L5e:
            r0.f50467a = r8
            r0.f50469c = r5
            r1 = 8
            java.lang.Object r1 = r8.f(r1, r0)
            if (r1 != r2) goto L6b
            goto L7b
        L6b:
            byte[] r1 = io.ktor.util.DeflaterKt.f50449a
            r3 = 0
            r0.f50467a = r3
            r0.f50469c = r4
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelKt.b(r8, r1, r0)
            if (r8 != r2) goto L79
            goto L7b
        L79:
            kotlin.Unit r2 = kotlin.Unit.f53572a
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt$putGzipHeader$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
