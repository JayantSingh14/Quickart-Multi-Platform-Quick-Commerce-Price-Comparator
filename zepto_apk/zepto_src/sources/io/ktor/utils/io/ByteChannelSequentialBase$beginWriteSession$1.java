package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class ByteChannelSequentialBase$beginWriteSession$1 implements WriterSuspendSession {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50905a;

    public ByteChannelSequentialBase$beginWriteSession$1(ByteChannelSequentialBase byteChannelSequentialBase) {
        this.f50905a = byteChannelSequentialBase;
    }

    @Override // io.ktor.utils.io.WriterSession
    public final void a(int i2) {
        this.f50905a.getClass();
        throw null;
    }

    @Override // io.ktor.utils.io.WriterSession
    public final ChunkBuffer b(int i2) {
        if (this.f50905a.T() == 0) {
            return null;
        }
        throw null;
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public final Object c(int i2, ContinuationImpl continuationImpl) {
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50905a;
        if (byteChannelSequentialBase.T() >= i2) {
            return Unit.f53572a;
        }
        Unit unitP = byteChannelSequentialBase.P(i2, continuationImpl);
        return unitP == CoroutineSingletons.f53689a ? unitP : Unit.f53572a;
    }
}
