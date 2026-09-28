package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DeflaterKt {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f50449a = new byte[7];

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.utils.io.ByteWriteChannel r6, java.util.zip.Deflater r7, java.nio.ByteBuffer r8, kotlin.jvm.functions.Function0 r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt$deflateWhile$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = (io.ktor.util.DeflaterKt$deflateWhile$1) r0
            int r1 = r0.f50466f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50466f = r1
            goto L18
        L13:
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = new io.ktor.util.DeflaterKt$deflateWhile$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f50465e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50466f
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            kotlin.jvm.functions.Function0 r6 = r0.f50464d
            java.nio.ByteBuffer r7 = r0.f50463c
            java.util.zip.Deflater r8 = r0.f50462b
            io.ktor.utils.io.ByteWriteChannel r9 = r0.f50461a
            kotlin.ResultKt.b(r10)
            r5 = r9
            r9 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r5
            goto L40
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.b(r10)
        L40:
            java.lang.Object r10 = r9.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L86
            r8.clear()
            boolean r10 = r8.hasRemaining()
            if (r10 == 0) goto L72
            byte[] r10 = r8.array()
            int r2 = r8.arrayOffset()
            int r4 = r8.position()
            int r4 = r4 + r2
            int r2 = r8.remaining()
            int r10 = r7.deflate(r10, r4, r2)
            int r2 = r8.position()
            int r2 = r2 + r10
            r8.position(r2)
        L72:
            r8.flip()
            r0.f50461a = r6
            r0.f50462b = r7
            r0.f50463c = r8
            r0.f50464d = r9
            r0.f50466f = r3
            java.lang.Object r10 = r6.r(r8, r0)
            if (r10 != r1) goto L40
            return r1
        L86:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.a(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Deflater, java.nio.ByteBuffer, kotlin.jvm.functions.Function0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
