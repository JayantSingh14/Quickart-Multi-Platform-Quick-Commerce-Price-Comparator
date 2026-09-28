package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {673}, m = "discardSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$discardSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50906a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50907b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50908c;

    /* renamed from: d, reason: collision with root package name */
    public int f50909d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$discardSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50908c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteChannelSequentialBase$discardSuspend$1 byteChannelSequentialBase$discardSuspend$1;
        this.f50907b = obj;
        this.f50909d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50908c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50909d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50909d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$discardSuspend$1 = this;
        } else {
            byteChannelSequentialBase$discardSuspend$1 = new ByteChannelSequentialBase$discardSuspend$1(byteChannelSequentialBase, this);
        }
        Object objC = byteChannelSequentialBase$discardSuspend$1.f50907b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$discardSuspend$1.f50909d;
        if (i3 == 0) {
            ResultKt.b(objC);
            byteChannelSequentialBase$discardSuspend$1.f50906a = byteChannelSequentialBase;
            byteChannelSequentialBase$discardSuspend$1.f50909d = 1;
            objC = byteChannelSequentialBase.c(1, byteChannelSequentialBase$discardSuspend$1);
            if (objC == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = byteChannelSequentialBase$discardSuspend$1.f50906a;
            ResultKt.b(objC);
        }
        if (((Boolean) objC).booleanValue()) {
            byteChannelSequentialBase.getClass();
            throw null;
        }
        Throwable thA = byteChannelSequentialBase.a();
        if (thA == null) {
            return new Long(0L);
        }
        throw thA;
    }
}
