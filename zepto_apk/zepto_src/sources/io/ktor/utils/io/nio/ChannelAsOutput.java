package io.ktor.utils.io.nio;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class ChannelAsOutput extends Output {
    @Override // io.ktor.utils.io.core.Output
    public final void s() {
        throw null;
    }

    @Override // io.ktor.utils.io.core.Output
    public final void x(ByteBuffer source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (MemoryJvmKt.c(source, i2, i3).hasRemaining()) {
            throw null;
        }
    }
}
