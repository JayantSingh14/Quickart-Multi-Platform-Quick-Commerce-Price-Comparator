package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OutputKt {
    public static final void a(Buffer src, int i2) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        UnsafeKt.d(null, 1, null);
        throw null;
    }

    public static final void b(Output output, byte[] src, int i2, int i3) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferD = UnsafeKt.d(output, 1, null);
        while (true) {
            try {
                int iMin = Math.min(i3, chunkBufferD.f51184e - chunkBufferD.f51182c);
                BufferPrimitivesKt.b(chunkBufferD, src, i2, iMin);
                i2 += iMin;
                i3 -= iMin;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferD = UnsafeKt.d(output, 1, chunkBufferD);
                }
            } finally {
                output.a();
            }
        }
    }
}
