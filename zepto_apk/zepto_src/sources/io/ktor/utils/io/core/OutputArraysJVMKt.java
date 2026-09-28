package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OutputArraysJVMKt {
    public static final void a(BytePacketBuilder bytePacketBuilder, ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(bb, "bb");
        int iLimit = bb.limit();
        ChunkBuffer chunkBufferD = UnsafeKt.d(bytePacketBuilder, 1, null);
        while (true) {
            try {
                bb.limit(bb.position() + Math.min(bb.remaining(), chunkBufferD.f51184e - chunkBufferD.f51182c));
                BufferPrimitivesJvmKt.a(chunkBufferD, bb);
                bb.limit(iLimit);
                if (!bb.hasRemaining()) {
                    return;
                } else {
                    chunkBufferD = UnsafeKt.d(bytePacketBuilder, 1, chunkBufferD);
                }
            } finally {
                bytePacketBuilder.a();
            }
        }
    }
}
