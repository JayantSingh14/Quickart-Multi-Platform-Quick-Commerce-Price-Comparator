package io.ktor.utils.io.nio;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelAsInput extends Input {
    @Override // io.ktor.utils.io.core.Input
    public final void a() {
        throw null;
    }

    @Override // io.ktor.utils.io.core.Input
    public final int r(ByteBuffer destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        MemoryJvmKt.c(destination, i2, i3);
        throw null;
    }
}
