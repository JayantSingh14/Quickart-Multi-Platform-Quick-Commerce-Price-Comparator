package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {425}, m = "readRemainingSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readRemainingSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50975b;

    /* renamed from: c, reason: collision with root package name */
    public int f50976c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readRemainingSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50975b = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readRemainingSuspend$1 byteChannelSequentialBase$readRemainingSuspend$1;
        this.f50974a = obj;
        this.f50976c |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50975b;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50976c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50976c = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readRemainingSuspend$1 = this;
        } else {
            byteChannelSequentialBase$readRemainingSuspend$1 = new ByteChannelSequentialBase$readRemainingSuspend$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readRemainingSuspend$1.f50974a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readRemainingSuspend$1.f50976c;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        throw null;
    }
}
