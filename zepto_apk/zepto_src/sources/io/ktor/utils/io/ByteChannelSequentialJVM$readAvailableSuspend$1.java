package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {112, WKSRecord.Service.AUTH}, m = "readAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$readAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51048a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51049b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51050c;

    /* renamed from: d, reason: collision with root package name */
    public int f51051d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$readAvailableSuspend$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation continuation) {
        super(continuation);
        this.f51050c = byteChannelSequentialJVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteChannelSequentialJVM$readAvailableSuspend$1 byteChannelSequentialJVM$readAvailableSuspend$1;
        this.f51049b = obj;
        this.f51051d |= Integer.MIN_VALUE;
        int i2 = ByteChannelSequentialJVM.f51042g;
        ByteChannelSequentialJVM byteChannelSequentialJVM = this.f51050c;
        byteChannelSequentialJVM.getClass();
        int i3 = this.f51051d;
        if ((i3 & Integer.MIN_VALUE) != 0) {
            this.f51051d = i3 - Integer.MIN_VALUE;
            byteChannelSequentialJVM$readAvailableSuspend$1 = this;
        } else {
            byteChannelSequentialJVM$readAvailableSuspend$1 = new ByteChannelSequentialJVM$readAvailableSuspend$1(byteChannelSequentialJVM, this);
        }
        Object objC = byteChannelSequentialJVM$readAvailableSuspend$1.f51049b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i4 = byteChannelSequentialJVM$readAvailableSuspend$1.f51051d;
        if (i4 == 0) {
            ResultKt.b(objC);
            byteChannelSequentialJVM$readAvailableSuspend$1.f51048a = byteChannelSequentialJVM;
            byteChannelSequentialJVM$readAvailableSuspend$1.f51051d = 1;
            objC = byteChannelSequentialJVM.c(1, byteChannelSequentialJVM$readAvailableSuspend$1);
            if (objC != coroutineSingletons) {
            }
        }
        if (i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objC);
            return objC;
        }
        byteChannelSequentialJVM = byteChannelSequentialJVM$readAvailableSuspend$1.f51048a;
        ResultKt.b(objC);
        if (!((Boolean) objC).booleanValue()) {
            return new Integer(-1);
        }
        byteChannelSequentialJVM$readAvailableSuspend$1.f51048a = null;
        byteChannelSequentialJVM$readAvailableSuspend$1.f51051d = 2;
        Object objF = byteChannelSequentialJVM.F(null, byteChannelSequentialJVM$readAvailableSuspend$1);
        return objF == coroutineSingletons ? coroutineSingletons : objF;
    }
}
