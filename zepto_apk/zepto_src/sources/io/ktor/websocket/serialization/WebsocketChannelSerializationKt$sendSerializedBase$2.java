package io.ktor.websocket.serialization;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", l = {50, 55}, m = "sendSerializedBase")
/* loaded from: classes3.dex */
final class WebsocketChannelSerializationKt$sendSerializedBase$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51544a;

    /* renamed from: b, reason: collision with root package name */
    public int f51545b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51544a = obj;
        int i2 = (this.f51545b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51545b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51545b = 1;
            throw null;
        }
        if (i2 == 1) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Unit.f53572a;
    }
}
