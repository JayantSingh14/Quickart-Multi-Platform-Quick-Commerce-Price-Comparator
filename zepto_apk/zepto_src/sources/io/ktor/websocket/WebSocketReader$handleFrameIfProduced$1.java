package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {WKSRecord.Service.SFTP}, m = "handleFrameIfProduced")
/* loaded from: classes3.dex */
final class WebSocketReader$handleFrameIfProduced$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebSocketReader f51520b;

    /* renamed from: c, reason: collision with root package name */
    public int f51521c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$handleFrameIfProduced$1(WebSocketReader webSocketReader, Continuation continuation) {
        super(continuation);
        this.f51520b = webSocketReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebSocketReader$handleFrameIfProduced$1 webSocketReader$handleFrameIfProduced$1;
        this.f51519a = obj;
        this.f51521c |= Integer.MIN_VALUE;
        WebSocketReader webSocketReader = this.f51520b;
        webSocketReader.getClass();
        int i2 = this.f51521c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51521c = i2 - Integer.MIN_VALUE;
            webSocketReader$handleFrameIfProduced$1 = this;
        } else {
            webSocketReader$handleFrameIfProduced$1 = new WebSocketReader$handleFrameIfProduced$1(webSocketReader, this);
        }
        Object obj2 = webSocketReader$handleFrameIfProduced$1.f51519a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = webSocketReader$handleFrameIfProduced$1.f51521c;
        if (i3 == 0) {
            ResultKt.b(obj2);
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        throw null;
    }
}
