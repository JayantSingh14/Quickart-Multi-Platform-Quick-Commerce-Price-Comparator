package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteBuffersKt {
    public static final void a(ByteReadPacket byteReadPacket, ByteBuffer dst) throws EOFException {
        ChunkBuffer chunkBufferN;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        while (true) {
            if (!dst.hasRemaining() || (chunkBufferN = byteReadPacket.N()) == null) {
                break;
            }
            int iRemaining = dst.remaining();
            int i2 = chunkBufferN.f51182c - chunkBufferN.f51181b;
            if (iRemaining < i2) {
                BufferUtilsJvmKt.c(chunkBufferN, dst, iRemaining);
                byteReadPacket.f51197d = chunkBufferN.f51181b;
                break;
            } else {
                BufferUtilsJvmKt.c(chunkBufferN, dst, i2);
                byteReadPacket.j0(chunkBufferN);
            }
        }
        if (dst.hasRemaining()) {
            throw new EOFException("Not enough data in packet to fill buffer: " + dst.remaining() + " more bytes required");
        }
    }
}
