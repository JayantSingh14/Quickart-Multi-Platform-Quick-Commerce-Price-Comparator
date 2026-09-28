package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteReadPacketExtensionsKt {
    public static final ByteReadPacket a(ByteBuffer bb, RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 release) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        Intrinsics.checkNotNullParameter(release, "release");
        SingleByteBufferPool pool = new SingleByteBufferPool(bb, release);
        ChunkBuffer head = (ChunkBuffer) pool.S0();
        head.f51183d = 0;
        head.f51181b = 0;
        head.f51182c = head.f51185f;
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return new ByteReadPacket(head, BuffersKt.d(head), pool);
    }
}
