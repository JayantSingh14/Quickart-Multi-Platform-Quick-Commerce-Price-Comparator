package io.ktor.client.content;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.client.content.ObservableContent$content$1", f = "ObservableContent.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ObservableContent$content$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49332a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49333b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObservableContent f49334c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableContent$content$1(ObservableContent observableContent, Continuation continuation) {
        super(2, continuation);
        this.f49334c = observableContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ObservableContent$content$1 observableContent$content$1 = new ObservableContent$content$1(this.f49334c, continuation);
        observableContent$content$1.f49333b = obj;
        return observableContent$content$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ObservableContent$content$1) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49332a;
        if (i2 == 0) {
            ResultKt.b(obj);
            WriterScope writerScope = (WriterScope) this.f49333b;
            OutgoingContent.WriteChannelContent writeChannelContent = (OutgoingContent.WriteChannelContent) this.f49334c.f49328a;
            ByteChannel byteChannelL0 = writerScope.l0();
            this.f49332a = 1;
            if (writeChannelContent.d(byteChannelL0, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
