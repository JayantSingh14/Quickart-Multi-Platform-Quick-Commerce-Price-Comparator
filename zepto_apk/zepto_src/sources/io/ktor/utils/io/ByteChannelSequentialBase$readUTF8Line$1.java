package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {731}, m = "readUTF8Line$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readUTF8Line$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public StringBuilder f50985a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50986b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50987c;

    /* renamed from: d, reason: collision with root package name */
    public int f50988d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readUTF8Line$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50987c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50986b = obj;
        this.f50988d |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.a0(this.f50987c, 0, this);
    }
}
