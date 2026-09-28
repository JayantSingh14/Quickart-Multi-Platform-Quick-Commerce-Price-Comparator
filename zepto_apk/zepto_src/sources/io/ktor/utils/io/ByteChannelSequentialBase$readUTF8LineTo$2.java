package io.ktor.utils.io;

import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", f = "ByteChannelSequential.kt", l = {721}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readUTF8LineTo$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Input>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50989a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f50990b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50991c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readUTF8LineTo$2(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(2, continuation);
        this.f50991c = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteChannelSequentialBase$readUTF8LineTo$2 byteChannelSequentialBase$readUTF8LineTo$2 = new ByteChannelSequentialBase$readUTF8LineTo$2(this.f50991c, continuation);
        byteChannelSequentialBase$readUTF8LineTo$2.f50990b = ((Number) obj).intValue();
        return byteChannelSequentialBase$readUTF8LineTo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ByteChannelSequentialBase$readUTF8LineTo$2) create(Integer.valueOf(((Number) obj).intValue()), (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50989a;
        ByteChannelSequentialBase byteChannelSequentialBase = this.f50991c;
        if (i2 == 0) {
            ResultKt.b(obj);
            int i3 = this.f50990b;
            this.f50989a = 1;
            obj = byteChannelSequentialBase.c(i3, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            byteChannelSequentialBase.getClass();
        }
        return null;
    }
}
