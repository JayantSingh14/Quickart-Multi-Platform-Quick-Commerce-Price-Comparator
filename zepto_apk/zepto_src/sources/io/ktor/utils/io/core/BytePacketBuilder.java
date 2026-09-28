package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class BytePacketBuilder extends Output {
    public BytePacketBuilder() {
        this(0);
    }

    public final ByteReadPacket V() {
        int iA = A();
        ChunkBuffer chunkBufferN = N();
        return chunkBufferN == null ? ByteReadPacket.f51189h : new ByteReadPacket(chunkBufferN, iA, this.f51202a);
    }

    @Override // io.ktor.utils.io.core.Output, java.lang.Appendable
    public final Appendable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: b */
    public final Output append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: c */
    public final Output append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: e */
    public final Output append(CharSequence charSequence, int i2, int i3) {
        Output outputE = super.append(charSequence, i2, i3);
        Intrinsics.d(outputE, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) outputE;
    }

    @Override // io.ktor.utils.io.core.Output
    public final void s() {
    }

    public final String toString() {
        return "BytePacketBuilder[0x" + hashCode() + ']';
    }

    @Override // io.ktor.utils.io.core.Output
    public final void x(ByteBuffer source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BytePacketBuilder(int i2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        DefaultBufferPool pool = BufferFactoryKt.f51186a;
        Intrinsics.checkNotNullParameter(pool, "pool");
        super(pool);
    }

    @Override // io.ktor.utils.io.core.Output, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // io.ktor.utils.io.core.Output, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) {
        Output outputE = super.append(charSequence, i2, i3);
        Intrinsics.d(outputE, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) outputE;
    }
}
