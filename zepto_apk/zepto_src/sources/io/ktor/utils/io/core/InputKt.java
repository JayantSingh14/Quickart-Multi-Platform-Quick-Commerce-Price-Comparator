package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InputKt {
    public static final void a(ByteReadPacket byteReadPacket) {
        ChunkBuffer chunkBufferN;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        long j2 = Long.MAX_VALUE;
        byteReadPacket.getClass();
        if (Long.MAX_VALUE <= 0) {
            return;
        }
        while (j2 != 0 && (chunkBufferN = byteReadPacket.N()) != null) {
            int iMin = (int) Math.min(chunkBufferN.f51182c - chunkBufferN.f51181b, j2);
            chunkBufferN.c(iMin);
            byteReadPacket.f51197d += iMin;
            if (chunkBufferN.f51182c - chunkBufferN.f51181b == 0) {
                byteReadPacket.j0(chunkBufferN);
            }
            j2 -= iMin;
        }
    }
}
