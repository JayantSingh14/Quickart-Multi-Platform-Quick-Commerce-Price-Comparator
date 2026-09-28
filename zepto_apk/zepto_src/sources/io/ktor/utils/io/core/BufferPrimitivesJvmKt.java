package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BufferPrimitivesJvmKt {
    public static final void a(ChunkBuffer chunkBuffer, ByteBuffer source) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        ByteBuffer byteBuffer = chunkBuffer.f51180a;
        int i2 = chunkBuffer.f51182c;
        int i3 = chunkBuffer.f51184e - i2;
        if (i3 < iRemaining) {
            throw new InsufficientSpaceException("buffer content", iRemaining, i3);
        }
        MemoryJvmKt.b(source, byteBuffer, i2);
        chunkBuffer.a(iRemaining);
    }
}
