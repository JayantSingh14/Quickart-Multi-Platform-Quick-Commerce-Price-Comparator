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
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {364}, m = "readLongSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readLongSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50967a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50968b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50969c;

    /* renamed from: d, reason: collision with root package name */
    public int f50970d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readLongSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50969c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readLongSlow$1 byteChannelSequentialBase$readLongSlow$1;
        this.f50968b = obj;
        this.f50970d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50969c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50970d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50970d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readLongSlow$1 = this;
        } else {
            byteChannelSequentialBase$readLongSlow$1 = new ByteChannelSequentialBase$readLongSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readLongSlow$1.f50968b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readLongSlow$1.f50970d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readLongSlow$1.f50967a = byteChannelSequentialBase;
            byteChannelSequentialBase$readLongSlow$1.f50970d = 1;
            byteChannelSequentialBase.Q(8, byteChannelSequentialBase$readLongSlow$1);
            return CoroutineSingletons.f53689a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readLongSlow$1.f50967a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }
}
