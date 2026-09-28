package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {570, 572}, m = "readBooleanSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readBooleanSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50929a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50930b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50931c;

    /* renamed from: d, reason: collision with root package name */
    public int f50932d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readBooleanSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50931c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteChannelSequentialBase$readBooleanSlow$1 byteChannelSequentialBase$readBooleanSlow$1;
        this.f50930b = obj;
        this.f50932d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50931c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50932d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50932d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readBooleanSlow$1 = this;
        } else {
            byteChannelSequentialBase$readBooleanSlow$1 = new ByteChannelSequentialBase$readBooleanSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readBooleanSlow$1.f50930b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readBooleanSlow$1.f50932d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readBooleanSlow$1.f50929a = byteChannelSequentialBase;
            byteChannelSequentialBase$readBooleanSlow$1.f50932d = 1;
            byteChannelSequentialBase.Q(1, byteChannelSequentialBase$readBooleanSlow$1);
            return coroutineSingletons;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj2);
            return obj2;
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readBooleanSlow$1.f50929a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.R(1, null);
        byteChannelSequentialBase$readBooleanSlow$1.f50929a = null;
        byteChannelSequentialBase$readBooleanSlow$1.f50932d = 2;
        throw null;
    }
}
