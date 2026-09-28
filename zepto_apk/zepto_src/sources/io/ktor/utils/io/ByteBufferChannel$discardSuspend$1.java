package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1702}, m = "discardSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$discardSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50640a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.LongRef f50641b;

    /* renamed from: c, reason: collision with root package name */
    public long f50642c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50643d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50644e;

    /* renamed from: f, reason: collision with root package name */
    public int f50645f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$discardSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50644e = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50643d = obj;
        this.f50645f |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50644e.Y(0L, 0L, this);
    }
}
