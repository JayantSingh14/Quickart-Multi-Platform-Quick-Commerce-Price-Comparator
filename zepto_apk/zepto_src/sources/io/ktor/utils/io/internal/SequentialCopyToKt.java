package io.ktor.utils.io.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class SequentialCopyToKt {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r7 == 0) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Long a(io.ktor.utils.io.ByteChannelSequentialBase r11, io.ktor.utils.io.ByteChannelSequentialBase r12, long r13, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1
            if (r0 == 0) goto L13
            r0 = r15
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1) r0
            int r1 = r0.f51278f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51278f = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f51277e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f51278f
            r2 = 0
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L83
            if (r1 == r4) goto L66
            r11 = 2
            if (r1 == r11) goto L41
            r11 = 3
            if (r1 != r11) goto L39
            long r11 = r0.f51276d
            long r13 = r0.f51275c
            io.ktor.utils.io.ByteChannelSequentialBase r1 = r0.f51274b
            io.ktor.utils.io.ByteChannelSequentialBase r6 = r0.f51273a
            kotlin.ResultKt.b(r15)
            r7 = r2
            goto L57
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            long r11 = r0.f51276d
            long r13 = r0.f51275c
            io.ktor.utils.io.ByteChannelSequentialBase r1 = r0.f51274b
            io.ktor.utils.io.ByteChannelSequentialBase r6 = r0.f51273a
            kotlin.ResultKt.b(r15)
            java.lang.Number r15 = (java.lang.Number) r15
            long r7 = r15.longValue()
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 != 0) goto L57
            goto La2
        L57:
            long r11 = r11 - r7
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 > 0) goto L62
            r9 = r11
            r11 = r6
            r6 = r13
            r13 = r9
            r12 = r1
            goto L9c
        L62:
            r1.getClass()
            throw r5
        L66:
            long r11 = r0.f51276d
            long r13 = r0.f51275c
            io.ktor.utils.io.ByteChannelSequentialBase r1 = r0.f51274b
            io.ktor.utils.io.ByteChannelSequentialBase r0 = r0.f51273a
            kotlin.ResultKt.b(r15)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L7a
            goto La2
        L7a:
            r0.getClass()
            java.lang.String r11 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r11)
            throw r5
        L83:
            kotlin.ResultKt.b(r15)
            if (r11 == r12) goto Lb7
            java.lang.Throwable r15 = r11.a()
            if (r15 == 0) goto L9b
            java.lang.Throwable r11 = r11.a()
            r12.d(r11)
            java.lang.Long r11 = new java.lang.Long
            r11.<init>(r2)
            return r11
        L9b:
            r6 = r13
        L9c:
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 > 0) goto La9
            r11 = r13
            r13 = r6
        La2:
            long r13 = r13 - r11
            java.lang.Long r11 = new java.lang.Long
            r11.<init>(r13)
            return r11
        La9:
            r0.f51273a = r11
            r0.f51274b = r12
            r0.f51275c = r6
            r0.f51276d = r13
            r0.f51278f = r4
            r11.getClass()
            throw r5
        Lb7:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Failed requirement."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.a(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Long");
    }
}
