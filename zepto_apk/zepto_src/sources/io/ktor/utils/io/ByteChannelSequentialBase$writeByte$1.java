package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {150}, m = "writeByte$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeByte$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51002a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51003b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51004c;

    /* renamed from: d, reason: collision with root package name */
    public int f51005d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeByte$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51004c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51003b = obj;
        this.f51005d |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.c0(this.f51004c, (byte) 0, this);
        return CoroutineSingletons.f53689a;
    }
}
