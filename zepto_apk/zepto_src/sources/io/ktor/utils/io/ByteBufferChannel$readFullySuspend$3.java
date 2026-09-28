package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {622}, m = "readFullySuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readFullySuspend$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50712a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50713b;

    /* renamed from: c, reason: collision with root package name */
    public int f50714c;

    /* renamed from: d, reason: collision with root package name */
    public int f50715d;

    /* renamed from: e, reason: collision with root package name */
    public int f50716e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50717f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50718g;

    /* renamed from: h, reason: collision with root package name */
    public int f50719h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readFullySuspend$3(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50718g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50717f = obj;
        this.f50719h |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50718g.q0(null, 0, 0, this);
    }
}
