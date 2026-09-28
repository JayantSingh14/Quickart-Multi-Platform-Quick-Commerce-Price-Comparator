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
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {377}, m = "readFloatSlow")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readFloatSlow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50941a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50942b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50943c;

    /* renamed from: d, reason: collision with root package name */
    public int f50944d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readFloatSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50943c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteChannelSequentialBase$readFloatSlow$1 byteChannelSequentialBase$readFloatSlow$1;
        this.f50942b = obj;
        this.f50944d |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50943c;
        byteChannelSequentialBase.getClass();
        int i2 = this.f50944d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50944d = i2 - Integer.MIN_VALUE;
            byteChannelSequentialBase$readFloatSlow$1 = this;
        } else {
            byteChannelSequentialBase$readFloatSlow$1 = new ByteChannelSequentialBase$readFloatSlow$1(byteChannelSequentialBase, this);
        }
        Object obj2 = byteChannelSequentialBase$readFloatSlow$1.f50942b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$readFloatSlow$1.f50944d;
        if (i3 == 0) {
            ResultKt.b(obj2);
            byteChannelSequentialBase$readFloatSlow$1.f50941a = byteChannelSequentialBase;
            byteChannelSequentialBase$readFloatSlow$1.f50944d = 1;
            byteChannelSequentialBase.Q(4, byteChannelSequentialBase$readFloatSlow$1);
            return CoroutineSingletons.f53689a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ByteChannelSequentialBase byteChannelSequentialBase2 = byteChannelSequentialBase$readFloatSlow$1.f50941a;
        ResultKt.b(obj2);
        byteChannelSequentialBase2.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }
}
