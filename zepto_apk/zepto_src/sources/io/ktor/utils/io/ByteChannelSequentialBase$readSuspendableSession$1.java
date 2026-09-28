package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {704}, m = "readSuspendableSession$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readSuspendableSession$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50981a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50982b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50983c;

    /* renamed from: d, reason: collision with root package name */
    public int f50984d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readSuspendableSession$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50983c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50982b = obj;
        this.f50984d |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.Z(this.f50983c, null, this);
    }
}
