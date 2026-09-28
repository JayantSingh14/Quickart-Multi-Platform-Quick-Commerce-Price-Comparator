package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.SuspendableReadSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReadSessionImpl implements SuspendableReadSession {

    /* renamed from: b, reason: collision with root package name */
    public final ByteBufferChannel f51250b;

    /* renamed from: c, reason: collision with root package name */
    public int f51251c;

    /* renamed from: d, reason: collision with root package name */
    public ChunkBuffer f51252d;

    public ReadSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f51250b = channel;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        this.f51252d = ChunkBuffer.f51216l;
    }

    @Override // io.ktor.utils.io.ReadSession
    public final int B(int i2) {
        a(ChunkBuffer.f51216l);
        ByteBufferChannel byteBufferChannel = this.f51250b;
        int iMin = Math.min(byteBufferChannel.g(), i2);
        byteBufferChannel.B(iMin);
        return iMin;
    }

    public final void a(ChunkBuffer chunkBuffer) {
        int i2 = this.f51251c;
        ChunkBuffer chunkBuffer2 = this.f51252d;
        int i3 = i2 - (chunkBuffer2.f51182c - chunkBuffer2.f51181b);
        if (i3 > 0) {
            this.f51250b.B(i3);
        }
        this.f51252d = chunkBuffer;
        this.f51251c = chunkBuffer.f51182c - chunkBuffer.f51181b;
    }

    @Override // io.ktor.utils.io.ReadSession
    public final ChunkBuffer b(int i2) {
        ByteBuffer byteBufferC = this.f51250b.c(0, i2);
        if (byteBufferC == null) {
            return null;
        }
        ChunkBuffer chunkBufferA = BufferUtilsJvmKt.a(byteBufferC, null);
        chunkBufferA.f51183d = 0;
        chunkBufferA.f51181b = 0;
        chunkBufferA.f51182c = chunkBufferA.f51185f;
        a(chunkBufferA);
        return chunkBufferA;
    }

    @Override // io.ktor.utils.io.SuspendableReadSession
    public final Object c(int i2, ContinuationImpl continuationImpl) {
        a(ChunkBuffer.f51216l);
        return this.f51250b.b(i2, continuationImpl);
    }
}
