package io.ktor.utils.io;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {585}, m = "readFullySuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readFullySuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50704a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f50705b;

    /* renamed from: c, reason: collision with root package name */
    public int f50706c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50707d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50708e;

    /* renamed from: f, reason: collision with root package name */
    public int f50709f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readFullySuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50708e = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50707d = obj;
        this.f50709f |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50708e.p0(null, 0, this);
    }
}
