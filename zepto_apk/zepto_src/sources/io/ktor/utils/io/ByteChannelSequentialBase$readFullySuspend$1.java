package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {519, 520}, m = "readFullySuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readFullySuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50951a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50952b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50953c;

    /* renamed from: d, reason: collision with root package name */
    public int f50954d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readFullySuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50953c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readFullySuspend$1 byteChannelSequentialBase$readFullySuspend$1;
        this.f50952b = obj;
        this.f50954d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50953c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50954d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50954d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readFullySuspend$1 = this;
        } else {
            byteChannelSequentialBase$readFullySuspend$1 = new ByteChannelSequentialBase$readFullySuspend$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readFullySuspend$1.f50952b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readFullySuspend$1.f50954d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readFullySuspend$1.f50951a = byteChannelSequentialBase;
            byteChannelSequentialBase$readFullySuspend$1.f50954d = 1;
            byteChannelSequentialBase.Q(0, byteChannelSequentialBase$readFullySuspend$1);
            return coroutineSingletons;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj2);
            return Unit.f53572a;
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readFullySuspend$1.f50951a;
        ResultKt.b(obj2);
        byteChannelSequentialBase$readFullySuspend$1.f50951a = null;
        byteChannelSequentialBase$readFullySuspend$1.f50954d = 2;
        byteChannelSequentialBase2.getClass();
        throw null;
    }
}
