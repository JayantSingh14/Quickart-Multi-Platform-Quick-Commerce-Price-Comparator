package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {544, 548}, m = "readFully$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readFully$6 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50945a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50946b;

    /* renamed from: c, reason: collision with root package name */
    public int f50947c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50948d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50949e;

    /* renamed from: f, reason: collision with root package name */
    public int f50950f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readFully$6(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50949e = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50948d = obj;
        this.f50950f |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.X(this.f50949e, null, 0, this);
    }
}
