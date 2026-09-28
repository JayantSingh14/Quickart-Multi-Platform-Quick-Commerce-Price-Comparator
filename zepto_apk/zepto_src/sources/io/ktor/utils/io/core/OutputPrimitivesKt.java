package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OutputPrimitivesKt {
    public static final void a(BytePacketBuilder bytePacketBuilder, short s) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        int i2 = bytePacketBuilder.f51206e;
        if (bytePacketBuilder.f51207f - i2 > 2) {
            bytePacketBuilder.f51206e = i2 + 2;
            bytePacketBuilder.f51205d.putShort(i2, s);
            return;
        }
        ChunkBuffer chunkBufferD = bytePacketBuilder.D(2);
        Intrinsics.checkNotNullParameter(chunkBufferD, "<this>");
        int i3 = chunkBufferD.f51182c;
        int i4 = chunkBufferD.f51184e - i3;
        if (i4 < 2) {
            throw new InsufficientSpaceException("short integer", 2, i4);
        }
        chunkBufferD.f51180a.putShort(i3, s);
        chunkBufferD.a(2);
        bytePacketBuilder.a();
    }
}
