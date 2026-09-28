package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {349}, m = "readIntSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readIntSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50963a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50964b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50965c;

    /* renamed from: d, reason: collision with root package name */
    public int f50966d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readIntSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50965c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readIntSlow$1 byteChannelSequentialBase$readIntSlow$1;
        this.f50964b = obj;
        this.f50966d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50965c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50966d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50966d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readIntSlow$1 = this;
        } else {
            byteChannelSequentialBase$readIntSlow$1 = new ByteChannelSequentialBase$readIntSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readIntSlow$1.f50964b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readIntSlow$1.f50966d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readIntSlow$1.f50963a = byteChannelSequentialBase;
            byteChannelSequentialBase$readIntSlow$1.f50966d = 1;
            byteChannelSequentialBase.Q(4, byteChannelSequentialBase$readIntSlow$1);
            return CoroutineSingletons.f53689a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readIntSlow$1.f50963a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }
}
