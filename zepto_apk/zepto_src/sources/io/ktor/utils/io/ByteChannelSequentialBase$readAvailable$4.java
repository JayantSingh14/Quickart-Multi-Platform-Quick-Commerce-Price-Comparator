package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {530}, m = "readAvailable$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readAvailable$4 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50925a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50926b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50927c;

    /* renamed from: d, reason: collision with root package name */
    public int f50928d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readAvailable$4(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50927c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50926b = obj;
        this.f50928d |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.W(this.f50927c, null, 0, 0, this);
    }
}
