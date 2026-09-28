package io.ktor.utils.io;

import io.ktor.utils.io.core.InputPrimitivesKt;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {329}, m = "readShortSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readShortSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50977a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50978b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50979c;

    /* renamed from: d, reason: collision with root package name */
    public int f50980d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readShortSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50979c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readShortSlow$1 byteChannelSequentialBase$readShortSlow$1;
        this.f50978b = obj;
        this.f50980d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50979c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50980d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50980d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readShortSlow$1 = this;
        } else {
            byteChannelSequentialBase$readShortSlow$1 = new ByteChannelSequentialBase$readShortSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readShortSlow$1.f50978b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readShortSlow$1.f50980d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readShortSlow$1.f50977a = byteChannelSequentialBase;
            byteChannelSequentialBase$readShortSlow$1.f50980d = 1;
            byteChannelSequentialBase.Q(2, byteChannelSequentialBase$readShortSlow$1);
            return CoroutineSingletons.f53689a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readShortSlow$1.f50977a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.getClass();
        InputPrimitivesKt.a(null);
        throw null;
    }
}
