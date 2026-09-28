package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {WKSRecord.Service.ERPC}, m = "drainQueueAndSerialize")
/* loaded from: classes3.dex */
final class WebSocketWriter$drainQueueAndSerialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51530a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebSocketWriter f51531b;

    /* renamed from: c, reason: collision with root package name */
    public int f51532c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$drainQueueAndSerialize$1(WebSocketWriter webSocketWriter, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51531b = webSocketWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebSocketWriter$drainQueueAndSerialize$1 webSocketWriter$drainQueueAndSerialize$1;
        this.f51530a = obj;
        this.f51532c |= Integer.MIN_VALUE;
        WebSocketWriter webSocketWriter = this.f51531b;
        webSocketWriter.getClass();
        int i2 = this.f51532c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51532c = i2 - Integer.MIN_VALUE;
            webSocketWriter$drainQueueAndSerialize$1 = this;
        } else {
            webSocketWriter$drainQueueAndSerialize$1 = new WebSocketWriter$drainQueueAndSerialize$1(webSocketWriter, this);
        }
        Object obj2 = webSocketWriter$drainQueueAndSerialize$1.f51530a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = webSocketWriter$drainQueueAndSerialize$1.f51532c;
        if (i3 == 0) {
            ResultKt.b(obj2);
            new Ref.ObjectRef();
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        throw null;
    }
}
