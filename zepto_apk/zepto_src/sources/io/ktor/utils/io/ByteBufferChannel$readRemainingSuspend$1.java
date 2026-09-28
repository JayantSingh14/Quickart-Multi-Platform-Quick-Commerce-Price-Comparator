package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2093}, m = "readRemainingSuspend")
/* loaded from: classes.dex */
final class ByteBufferChannel$readRemainingSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50737a;

    /* renamed from: b, reason: collision with root package name */
    public BytePacketBuilder f50738b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.LongRef f50739c;

    /* renamed from: d, reason: collision with root package name */
    public Output f50740d;

    /* renamed from: e, reason: collision with root package name */
    public ChunkBuffer f50741e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50742f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50743g;

    /* renamed from: h, reason: collision with root package name */
    public int f50744h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readRemainingSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50743g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50742f = obj;
        this.f50744h |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50743g.s0(0L, this);
    }
}
