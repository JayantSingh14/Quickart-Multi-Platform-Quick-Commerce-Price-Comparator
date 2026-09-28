package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {168}, m = "writeLong$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeLong$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51028a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51029b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51030c;

    /* renamed from: d, reason: collision with root package name */
    public int f51031d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeLong$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51030c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51029b = obj;
        this.f51031d |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.g0(this.f51030c, 0L, this);
        return CoroutineSingletons.f53689a;
    }
}
