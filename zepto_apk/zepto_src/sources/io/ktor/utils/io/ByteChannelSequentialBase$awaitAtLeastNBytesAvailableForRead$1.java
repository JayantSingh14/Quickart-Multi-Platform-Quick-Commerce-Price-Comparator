package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {88}, m = "awaitAtLeastNBytesAvailableForRead$ktor_io")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50891a;

    /* renamed from: b, reason: collision with root package name */
    public int f50892b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50893c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50894d;

    /* renamed from: e, reason: collision with root package name */
    public int f50895e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50894d = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50893c = obj;
        this.f50895e |= Integer.MIN_VALUE;
        return this.f50894d.O(0, this);
    }
}
