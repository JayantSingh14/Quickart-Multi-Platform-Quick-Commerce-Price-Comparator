package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {459}, m = "readPacketSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readPacketSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50971a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50972b;

    /* renamed from: c, reason: collision with root package name */
    public int f50973c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readPacketSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50972b = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteChannelSequentialBase$readPacketSuspend$1 byteChannelSequentialBase$readPacketSuspend$1;
        this.f50971a = obj;
        this.f50973c |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50972b;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50973c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50973c = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readPacketSuspend$1 = this;
        } else {
            byteChannelSequentialBase$readPacketSuspend$1 = new ByteChannelSequentialBase$readPacketSuspend$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readPacketSuspend$1.f50971a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readPacketSuspend$1.f50973c;
        if (i3 == 0) {
            ResultKt.b(obj2);
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj2);
            byteChannelSequentialBase = null;
        }
        byteChannelSequentialBase.R(0, null);
        throw null;
    }
}
