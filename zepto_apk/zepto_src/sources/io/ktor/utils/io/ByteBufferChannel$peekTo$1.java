package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2374}, m = "peekTo-lBXzO7A$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$peekTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f50656a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50657b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50658c;

    /* renamed from: d, reason: collision with root package name */
    public int f50659d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$peekTo$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50658c = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50657b = obj;
        this.f50659d |= Integer.MIN_VALUE;
        return ByteBufferChannel.d0(this.f50658c, null, 0L, 0L, 0L, this);
    }
}
