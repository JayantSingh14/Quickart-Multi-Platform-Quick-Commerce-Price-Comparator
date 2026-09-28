package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ByteReadPacket extends Input {

    /* renamed from: h, reason: collision with root package name */
    public static final ByteReadPacket f51189h = new ByteReadPacket(ChunkBuffer.f51216l, 0, ChunkBuffer.f51215k);

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer head, long j2, ObjectPool pool) {
        super(head, j2, pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (this.f51200g) {
            return;
        }
        this.f51200g = true;
    }

    @Override // io.ktor.utils.io.core.Input
    public final void a() {
    }

    @Override // io.ktor.utils.io.core.Input
    public final ChunkBuffer l() {
        return null;
    }

    @Override // io.ktor.utils.io.core.Input
    public final int r(ByteBuffer destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return 0;
    }

    public final String toString() {
        return "ByteReadPacket[" + hashCode() + ']';
    }
}
