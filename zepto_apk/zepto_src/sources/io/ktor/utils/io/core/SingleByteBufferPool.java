package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.SingleInstancePool;
import io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class SingleByteBufferPool extends SingleInstancePool<ChunkBuffer> {

    /* renamed from: c, reason: collision with root package name */
    public final ByteBuffer f51211c;

    /* renamed from: d, reason: collision with root package name */
    public final RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 f51212d;

    public SingleByteBufferPool(ByteBuffer instance, RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 release) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(release, "release");
        this.f51211c = instance;
        this.f51212d = release;
    }

    @Override // io.ktor.utils.io.pool.SingleInstancePool
    public final void a(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.f51212d.invoke(this.f51211c);
    }

    @Override // io.ktor.utils.io.pool.SingleInstancePool
    public final Object b() {
        return BufferUtilsJvmKt.a(this.f51211c, this);
    }
}
