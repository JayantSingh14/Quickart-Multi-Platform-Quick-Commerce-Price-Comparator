package io.ktor.utils.io;

import android.support.v4.media.b;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReadSessionKt {
    public static final Object a(ByteReadChannel byteReadChannel, Buffer buffer, int i2, ContinuationImpl continuationImpl) {
        if (i2 < 0) {
            throw new IllegalStateException(b.f(i2, "bytesRead shouldn't be negative: ").toString());
        }
        boolean z = byteReadChannel instanceof HasReadSession;
        SuspendableReadSession suspendableReadSessionA = z ? ((HasReadSession) byteReadChannel).A() : null;
        if (suspendableReadSessionA != null) {
            suspendableReadSessionA.B(i2);
            if (z) {
                ((HasReadSession) byteReadChannel).G();
            }
            return Unit.f53572a;
        }
        if (!(buffer instanceof ChunkBuffer) || buffer == ChunkBuffer.f51216l) {
            return Unit.f53572a;
        }
        ((ChunkBuffer) buffer).k(BufferFactoryKt.f51186a);
        Object objD = byteReadChannel.D(i2, continuationImpl);
        return objD == CoroutineSingletons.f53689a ? objD : Unit.f53572a;
    }

    public static final Object b(ByteReadChannel byteReadChannel, int i2, ContinuationImpl continuationImpl) {
        SuspendableReadSession suspendableReadSessionA = byteReadChannel instanceof SuspendableReadSession ? (SuspendableReadSession) byteReadChannel : byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).A() : null;
        if (suspendableReadSessionA == null) {
            return c(byteReadChannel, i2, continuationImpl);
        }
        ChunkBuffer chunkBufferB = suspendableReadSessionA.b(i2 <= 8 ? i2 : 8);
        return chunkBufferB != null ? chunkBufferB : d(suspendableReadSessionA, i2, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.utils.io.ByteReadChannel r13, int r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            if (r0 == 0) goto L14
            r0 = r15
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r0 = (io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1) r0
            int r1 = r0.f51160c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f51160c = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r0 = new io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r15 = r9.f51159b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r9.f51160c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = r9.f51158a
            kotlin.ResultKt.b(r15)
            goto L5d
        L2b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L33:
            kotlin.ResultKt.b(r15)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r15 = io.ktor.utils.io.core.internal.ChunkBuffer.f51213i
            io.ktor.utils.io.core.DefaultBufferPool r15 = io.ktor.utils.io.core.BufferFactoryKt.f51186a
            java.lang.Object r15 = r15.S0()
            io.ktor.utils.io.core.internal.ChunkBuffer r15 = (io.ktor.utils.io.core.internal.ChunkBuffer) r15
            r1 = r2
            java.nio.ByteBuffer r2 = r15.f51180a
            int r3 = r15.f51182c
            r5 = r3
            long r3 = (long) r5
            long r6 = (long) r14
            int r14 = r15.f51184e
            int r14 = r14 - r5
            long r10 = (long) r14
            r9.f51158a = r15
            r9.f51160c = r1
            r1 = r13
            r5 = r6
            r7 = r10
            java.lang.Object r13 = r1.i(r2, r3, r5, r7, r9)
            if (r13 != r0) goto L5a
            return r0
        L5a:
            r12 = r15
            r15 = r13
            r13 = r12
        L5d:
            java.lang.Number r15 = (java.lang.Number) r15
            long r14 = r15.longValue()
            int r14 = (int) r14
            r13.a(r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.c(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(io.ktor.utils.io.SuspendableReadSession r4, int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = (io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1) r0
            int r1 = r0.f51163c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51163c = r1
            goto L18
        L13:
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = new io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f51162b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51163c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.SuspendableReadSession r4 = r0.f51161a
            kotlin.ResultKt.b(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            r0.f51161a = r4
            r0.f51163c = r3
            java.lang.Object r5 = r4.c(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.b(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.d(io.ktor.utils.io.SuspendableReadSession, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
