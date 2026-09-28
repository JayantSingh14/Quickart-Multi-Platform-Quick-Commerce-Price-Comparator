package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {162}, m = "writeInt$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeInt$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51024a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51025b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51026c;

    /* renamed from: d, reason: collision with root package name */
    public int f51027d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeInt$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51026c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51025b = obj;
        this.f51027d |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.f0(this.f51026c, 0, this);
        return CoroutineSingletons.f53689a;
    }
}
