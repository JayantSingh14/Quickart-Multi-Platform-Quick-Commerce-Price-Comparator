package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {204}, m = "writeFully$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeFully$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51015a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f51016b;

    /* renamed from: c, reason: collision with root package name */
    public int f51017c;

    /* renamed from: d, reason: collision with root package name */
    public int f51018d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f51019e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51020f;

    /* renamed from: g, reason: collision with root package name */
    public int f51021g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeFully$2(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51020f = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51019e = obj;
        this.f51021g |= Integer.MIN_VALUE;
        return ByteChannelSequentialBase.d0(this.f51020f, null, 0, 0, this);
    }
}
