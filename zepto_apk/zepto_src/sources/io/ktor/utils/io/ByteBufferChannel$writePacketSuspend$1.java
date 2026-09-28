package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacket;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1742, 1744}, m = "writePacketSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writePacketSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50843a;

    /* renamed from: b, reason: collision with root package name */
    public ByteReadPacket f50844b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50845c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50846d;

    /* renamed from: e, reason: collision with root package name */
    public int f50847e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writePacketSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50846d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50845c = obj;
        this.f50847e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50846d.b1(null, this);
    }
}
