package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {820}, m = "peekTo-lBXzO7A")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$peekTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.LongRef f50910a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50911b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50912c;

    /* renamed from: d, reason: collision with root package name */
    public int f50913d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$peekTo$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50912c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50911b = obj;
        this.f50913d |= Integer.MIN_VALUE;
        return this.f50912c.i(null, 0L, 0L, 0L, this);
    }
}
