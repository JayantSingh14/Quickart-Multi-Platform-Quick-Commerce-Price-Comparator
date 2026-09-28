package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {781, 782}, m = "writeAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeAvailableSuspend$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50998a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50999b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f51000c;

    /* renamed from: d, reason: collision with root package name */
    public int f51001d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeAvailableSuspend$2(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f51000c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$writeAvailableSuspend$2 byteChannelSequentialBase$writeAvailableSuspend$2;
        this.f50999b = obj;
        this.f51001d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f51000c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f51001d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51001d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$writeAvailableSuspend$2 = this;
        } else {
            byteChannelSequentialBase$writeAvailableSuspend$2 = new ByteChannelSequentialBase$writeAvailableSuspend$2(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$writeAvailableSuspend$2.f50999b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$writeAvailableSuspend$2.f51001d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$writeAvailableSuspend$2.f50998a = byteChannelSequentialBase;
            byteChannelSequentialBase$writeAvailableSuspend$2.f51001d = 1;
            if (byteChannelSequentialBase.P(1, byteChannelSequentialBase$writeAvailableSuspend$2) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj2);
            return obj2;
        }
        byteChannelSequentialBase = byteChannelSequentialBase$writeAvailableSuspend$2.f50998a;
        ResultKt.b(obj2);
        byteChannelSequentialBase$writeAvailableSuspend$2.f50998a = null;
        byteChannelSequentialBase$writeAvailableSuspend$2.f51001d = 2;
        byteChannelSequentialBase.getClass();
        Integer num = new Integer(0);
        if (num != coroutineSingletons) {
            return num;
        }
        return coroutineSingletons;
    }
}
