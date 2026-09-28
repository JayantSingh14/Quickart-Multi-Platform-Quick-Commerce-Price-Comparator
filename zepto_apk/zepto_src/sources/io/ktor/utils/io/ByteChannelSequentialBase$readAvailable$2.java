package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {486}, m = "readAvailable$ktor_io")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readAvailable$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50921a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50922b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50923c;

    /* renamed from: d, reason: collision with root package name */
    public int f50924d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readAvailable$2(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50923c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50922b = obj;
        this.f50924d |= Integer.MIN_VALUE;
        return this.f50923c.V(null, this);
    }
}
