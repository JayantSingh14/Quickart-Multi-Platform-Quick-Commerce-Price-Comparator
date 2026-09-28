package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BufferAppendKt {
    public static final int a(ChunkBuffer chunkBuffer, ChunkBuffer other, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(other.f51182c - other.f51181b, i2);
        int i3 = chunkBuffer.f51184e;
        int i4 = chunkBuffer.f51182c;
        int i5 = i3 - i4;
        if (i5 <= iMin) {
            int i6 = chunkBuffer.f51185f;
            if ((i6 - i3) + i5 < iMin) {
                throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
            }
            if ((i4 + iMin) - i3 > 0) {
                chunkBuffer.f51184e = i6;
            }
        }
        Memory.b(other.f51180a, other.f51181b, iMin, chunkBuffer.f51180a, i4);
        other.c(iMin);
        chunkBuffer.a(iMin);
        return iMin;
    }

    public static final void b(ChunkBuffer chunkBuffer, ChunkBuffer other) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i2 = other.f51182c;
        int i3 = other.f51181b;
        int i4 = i2 - i3;
        int i5 = chunkBuffer.f51181b;
        if (i5 < i4) {
            throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
        }
        int i6 = i5 - i4;
        Memory.b(other.f51180a, i3, i4, chunkBuffer.f51180a, i6);
        other.c(i4);
        chunkBuffer.d(i6);
    }
}
