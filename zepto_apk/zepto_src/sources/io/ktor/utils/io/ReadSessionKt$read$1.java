package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", l = {24, 28, 31}, m = "read")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ReadSessionKt$read$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f51153a;

    /* renamed from: b, reason: collision with root package name */
    public Buffer f51154b;

    /* renamed from: c, reason: collision with root package name */
    public int f51155c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f51156d;

    /* renamed from: e, reason: collision with root package name */
    public int f51157e;

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(1:(1:(1:(2:7|8)(2:9|35))(5:10|38|11|27|28))(1:15))(3:16|(1:19)|34)|20|(1:22)|36|23|(3:26|27|28)|34) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
    
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0096, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            r12.f51156d = r13
            int r0 = r12.f51157e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r12.f51157e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == 0) goto L45
            if (r0 == r6) goto L39
            if (r0 == r5) goto L2a
            if (r0 == r4) goto L21
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L21:
            java.lang.Object r0 = r12.f51153a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r13)
            goto La5
        L2a:
            int r0 = r12.f51155c
            io.ktor.utils.io.core.Buffer r5 = r12.f51154b
            java.lang.Object r6 = r12.f51153a
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L36
            goto L8e
        L36:
            r13 = move-exception
            r0 = r13
            goto L98
        L39:
            io.ktor.utils.io.core.Buffer r0 = r12.f51154b
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            java.lang.Object r6 = r12.f51153a
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.b(r13)
            goto L57
        L45:
            kotlin.ResultKt.b(r13)
            r12.f51153a = r2
            r12.f51154b = r2
            r12.f51157e = r6
            java.lang.Object r13 = io.ktor.utils.io.ReadSessionKt.b(r2, r3, r12)
            if (r13 != r1) goto L55
            goto La4
        L55:
            r0 = r2
            r6 = r0
        L57:
            io.ktor.utils.io.core.Buffer r13 = (io.ktor.utils.io.core.Buffer) r13
            if (r13 != 0) goto L5d
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = io.ktor.utils.io.core.internal.ChunkBuffer.f51216l
        L5d:
            java.nio.ByteBuffer r7 = r13.f51180a     // Catch: java.lang.Throwable -> L96
            io.ktor.utils.io.bits.Memory r8 = new io.ktor.utils.io.bits.Memory     // Catch: java.lang.Throwable -> L96
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L96
            int r7 = r13.f51181b     // Catch: java.lang.Throwable -> L96
            long r9 = (long) r7     // Catch: java.lang.Throwable -> L96
            java.lang.Long r7 = new java.lang.Long     // Catch: java.lang.Throwable -> L96
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L96
            int r9 = r13.f51182c     // Catch: java.lang.Throwable -> L96
            long r9 = (long) r9     // Catch: java.lang.Throwable -> L96
            java.lang.Long r11 = new java.lang.Long     // Catch: java.lang.Throwable -> L96
            r11.<init>(r9)     // Catch: java.lang.Throwable -> L96
            java.lang.Object r0 = r0.invoke(r8, r7, r11)     // Catch: java.lang.Throwable -> L96
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L96
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L96
            r12.f51153a = r6     // Catch: java.lang.Throwable -> L96
            r12.f51154b = r13     // Catch: java.lang.Throwable -> L96
            r12.f51155c = r0     // Catch: java.lang.Throwable -> L96
            r12.f51157e = r5     // Catch: java.lang.Throwable -> L96
            java.lang.Object r5 = io.ktor.utils.io.ReadSessionKt.a(r6, r13, r0, r12)     // Catch: java.lang.Throwable -> L96
            if (r5 != r1) goto L8d
            goto La4
        L8d:
            r5 = r13
        L8e:
            java.lang.Integer r13 = new java.lang.Integer     // Catch: java.lang.Throwable -> L36
            r13.<init>(r0)     // Catch: java.lang.Throwable -> L36
            return r13
        L94:
            r5 = r13
            goto L98
        L96:
            r0 = move-exception
            goto L94
        L98:
            r12.f51153a = r0
            r12.f51154b = r2
            r12.f51157e = r4
            java.lang.Object r13 = io.ktor.utils.io.ReadSessionKt.a(r6, r5, r3, r12)
            if (r13 != r1) goto La5
        La4:
            return r1
        La5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt$read$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
