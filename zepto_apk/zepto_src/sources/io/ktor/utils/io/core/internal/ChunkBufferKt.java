package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ChunkBufferKt {
    public static final boolean a(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return chunkBuffer.j() == 1;
    }
}
