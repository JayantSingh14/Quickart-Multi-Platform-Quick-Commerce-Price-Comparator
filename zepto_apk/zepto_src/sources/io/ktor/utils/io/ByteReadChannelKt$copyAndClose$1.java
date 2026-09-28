package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", l = {261}, m = "copyAndClose")
/* loaded from: classes3.dex */
final class ByteReadChannelKt$copyAndClose$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51089a;

    /* renamed from: b, reason: collision with root package name */
    public int f51090b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteReadChannelKt$copyAndClose$1 byteReadChannelKt$copyAndClose$1;
        this.f51089a = obj;
        int i2 = this.f51090b | Integer.MIN_VALUE;
        this.f51090b = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51090b = i2 - Integer.MIN_VALUE;
            byteReadChannelKt$copyAndClose$1 = this;
        } else {
            byteReadChannelKt$copyAndClose$1 = new ByteReadChannelKt$copyAndClose$1(this);
        }
        Object objA = byteReadChannelKt$copyAndClose$1.f51089a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteReadChannelKt$copyAndClose$1.f51090b;
        if (i3 == 0) {
            ResultKt.b(objA);
            byteReadChannelKt$copyAndClose$1.f51090b = 1;
            objA = ByteReadChannelJVMKt.a(null, null, 0L, byteReadChannelKt$copyAndClose$1);
            if (objA == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objA);
        }
        ((Number) objA).longValue();
        ByteWriteChannelKt.a(null);
        throw null;
    }
}
