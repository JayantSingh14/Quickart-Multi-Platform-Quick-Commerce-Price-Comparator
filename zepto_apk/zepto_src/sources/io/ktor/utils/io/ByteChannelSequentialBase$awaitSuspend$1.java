package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {611}, m = "awaitSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$awaitSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50901a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50902b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50903c;

    /* renamed from: d, reason: collision with root package name */
    public int f50904d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$awaitSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50903c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50902b = obj;
        this.f50904d |= Integer.MIN_VALUE;
        this.f50903c.Q(0, this);
        return CoroutineSingletons.f53689a;
    }
}
