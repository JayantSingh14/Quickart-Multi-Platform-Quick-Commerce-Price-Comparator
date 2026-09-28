package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1871}, m = "awaitAtLeastSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$awaitAtLeastSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50618a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50619b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50620c;

    /* renamed from: d, reason: collision with root package name */
    public int f50621d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$awaitAtLeastSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50620c = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50619b = obj;
        this.f50621d |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50620c.Q(0, this);
    }
}
