package io.ktor.utils.io;

import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class ByteReadChannelJVMKt {
    public static final Object a(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j2, ContinuationImpl continuationImpl) {
        if (byteReadChannel != byteWriteChannel) {
            return j2 == 0 ? new Long(0L) : ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) ? ((ByteBufferChannel) byteWriteChannel).W((ByteBufferChannel) byteReadChannel, j2, continuationImpl) : ((byteReadChannel instanceof ByteChannelSequentialBase) && (byteWriteChannel instanceof ByteChannelSequentialBase)) ? SequentialCopyToKt.a((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, Long.MAX_VALUE, continuationImpl) : b(byteReadChannel, byteWriteChannel, j2, continuationImpl);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d A[Catch: all -> 0x00dc, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00dc, blocks: (B:38:0x00d2, B:40:0x00d8, B:26:0x007d), top: B:59:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x0038, B:30:0x00a7, B:32:0x00b0, B:47:0x00eb, B:21:0x0057), top: B:55:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c7 -> B:15:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.utils.io.ByteReadChannel r19, io.ktor.utils.io.ByteWriteChannel r20, long r21, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.b(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
