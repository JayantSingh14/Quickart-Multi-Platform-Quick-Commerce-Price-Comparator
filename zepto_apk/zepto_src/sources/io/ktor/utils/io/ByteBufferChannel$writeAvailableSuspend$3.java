package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1080, 1082, 1084}, m = "writeAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeAvailableSuspend$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50797a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f50798b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50799c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50800d;

    /* renamed from: e, reason: collision with root package name */
    public int f50801e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeAvailableSuspend$3(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        super(continuation);
        this.f50800d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50799c = obj;
        this.f50801e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50800d.T0(null, this);
    }
}
