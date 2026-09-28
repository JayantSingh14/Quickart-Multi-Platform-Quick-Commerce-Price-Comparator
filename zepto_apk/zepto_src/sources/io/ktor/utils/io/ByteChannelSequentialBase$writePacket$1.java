package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacket;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {186}, m = "writePacket$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writePacket$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51032a;

    /* renamed from: b, reason: collision with root package name */
    public ByteReadPacket f51033b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51034c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51035d;

    /* renamed from: e, reason: collision with root package name */
    public int f51036e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writePacket$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51035d = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51034c = obj;
        this.f51036e |= Integer.MIN_VALUE;
        ByteChannelSequentialBase.h0(this.f51035d, null, this);
        return CoroutineSingletons.f53689a;
    }
}
