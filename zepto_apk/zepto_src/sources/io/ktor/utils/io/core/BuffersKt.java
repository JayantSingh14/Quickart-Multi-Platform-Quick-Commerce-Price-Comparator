package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BuffersKt {
    public static final ChunkBuffer a(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        ChunkBuffer chunkBufferH = chunkBuffer.h();
        ChunkBuffer chunkBufferI = chunkBuffer.i();
        if (chunkBufferI != null) {
            ChunkBuffer chunkBuffer2 = chunkBufferH;
            while (true) {
                ChunkBuffer chunkBufferH2 = chunkBufferI.h();
                chunkBuffer2.m(chunkBufferH2);
                chunkBufferI = chunkBufferI.i();
                if (chunkBufferI == null) {
                    break;
                }
                chunkBuffer2 = chunkBufferH2;
            }
        }
        return chunkBufferH;
    }

    public static final ChunkBuffer b(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer chunkBufferI = chunkBuffer.i();
            if (chunkBufferI == null) {
                return chunkBuffer;
            }
            chunkBuffer = chunkBufferI;
        }
    }

    public static final void c(ChunkBuffer chunkBuffer, ObjectPool pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer chunkBufferG = chunkBuffer.g();
            chunkBuffer.k(pool);
            chunkBuffer = chunkBufferG;
        }
    }

    public static final long d(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        long j2 = 0;
        do {
            j2 += chunkBuffer.f51182c - chunkBuffer.f51181b;
            chunkBuffer = chunkBuffer.i();
        } while (chunkBuffer != null);
        return j2;
    }
}
