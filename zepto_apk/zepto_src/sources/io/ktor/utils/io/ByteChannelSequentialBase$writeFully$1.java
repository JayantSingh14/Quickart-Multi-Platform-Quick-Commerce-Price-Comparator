package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {193}, m = "writeFully$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeFully$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51010a;

    /* renamed from: b, reason: collision with root package name */
    public Buffer f51011b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51012c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51013d;

    /* renamed from: e, reason: collision with root package name */
    public int f51014e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeFully$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51013d = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51012c = obj;
        this.f51014e |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.e0(this.f51013d, null, this);
        return CoroutineSingletons.f53689a;
    }
}
