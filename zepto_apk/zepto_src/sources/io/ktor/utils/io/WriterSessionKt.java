package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class WriterSessionKt {
    public static final Object a(ByteWriteChannel byteWriteChannel, Buffer buffer, int i2, ContinuationImpl continuationImpl) {
        if (byteWriteChannel instanceof HasWriteSession) {
            ((HasWriteSession) byteWriteChannel).z(i2);
            return Unit.f53572a;
        }
        Object objB = b(byteWriteChannel, buffer, continuationImpl);
        return objB == CoroutineSingletons.f53689a ? objB : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.utils.io.ByteWriteChannel r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = (io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1) r0
            int r1 = r0.f51166c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51166c = r1
            goto L18
        L13:
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = new io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f51165b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51166c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r0.f51164a
            kotlin.ResultKt.b(r6)
            goto L46
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5 instanceof io.ktor.utils.io.core.internal.ChunkBuffer
            if (r6 == 0) goto L52
            r6 = r5
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            r0.f51164a = r6
            r0.f51166c = r3
            java.lang.Object r4 = r4.s(r5, r0)
            if (r4 != r1) goto L46
            return r1
        L46:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = (io.ktor.utils.io.core.internal.ChunkBuffer) r5
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.core.internal.ChunkBuffer.f51213i
            io.ktor.utils.io.core.DefaultBufferPool r4 = io.ktor.utils.io.core.BufferFactoryKt.f51186a
            r5.k(r4)
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L52:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Only ChunkBuffer instance is supported."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.b(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.core.Buffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Object c(ByteWriteChannel byteWriteChannel, int i2, ContinuationImpl continuationImpl) {
        WriterSuspendSession writerSuspendSessionY = byteWriteChannel instanceof HasWriteSession ? ((HasWriteSession) byteWriteChannel).y() : null;
        if (writerSuspendSessionY != null) {
            ChunkBuffer chunkBufferB = writerSuspendSessionY.b(i2);
            return chunkBufferB != null ? chunkBufferB : d(writerSuspendSessionY, i2, continuationImpl);
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        Object objS0 = BufferFactoryKt.f51186a.S0();
        ChunkBuffer chunkBuffer = (ChunkBuffer) objS0;
        chunkBuffer.f(chunkBuffer.f51185f - chunkBuffer.f51183d);
        chunkBuffer.e();
        return (Buffer) objS0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(io.ktor.utils.io.WriterSuspendSession r4, int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = (io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1) r0
            int r1 = r0.f51173d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51173d = r1
            goto L18
        L13:
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = new io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f51172c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51173d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.f51171b
            io.ktor.utils.io.WriterSuspendSession r4 = r0.f51170a
            kotlin.ResultKt.b(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r6)
            r0.f51170a = r4
            r0.f51171b = r5
            r0.f51173d = r3
            java.lang.Object r6 = r4.c(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.b(r5)
            if (r5 == 0) goto L4a
            return r5
        L4a:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.b(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.d(io.ktor.utils.io.WriterSuspendSession, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
