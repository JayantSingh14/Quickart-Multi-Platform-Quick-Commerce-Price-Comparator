package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {313}, m = "readByteSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readByteSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50933a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50934b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50935c;

    /* renamed from: d, reason: collision with root package name */
    public int f50936d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readByteSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50935c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readByteSlow$1 byteChannelSequentialBase$readByteSlow$1;
        this.f50934b = obj;
        this.f50936d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50935c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50936d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50936d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readByteSlow$1 = this;
        } else {
            byteChannelSequentialBase$readByteSlow$1 = new ByteChannelSequentialBase$readByteSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readByteSlow$1.f50934b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readByteSlow$1.f50936d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readByteSlow$1.f50933a = byteChannelSequentialBase;
            byteChannelSequentialBase$readByteSlow$1.f50936d = 1;
            byteChannelSequentialBase.Q(1, byteChannelSequentialBase$readByteSlow$1);
            return CoroutineSingletons.f53689a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readByteSlow$1.f50933a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.getClass();
        throw null;
    }
}
