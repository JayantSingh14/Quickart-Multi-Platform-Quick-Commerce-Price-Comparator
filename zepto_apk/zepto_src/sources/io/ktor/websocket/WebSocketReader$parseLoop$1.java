package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {92, 100}, m = "parseLoop")
/* loaded from: classes3.dex */
final class WebSocketReader$parseLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51522a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebSocketReader f51523b;

    /* renamed from: c, reason: collision with root package name */
    public int f51524c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$parseLoop$1(WebSocketReader webSocketReader, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51523b = webSocketReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebSocketReader$parseLoop$1 webSocketReader$parseLoop$1;
        this.f51522a = obj;
        this.f51524c |= Integer.MIN_VALUE;
        WebSocketReader webSocketReader = this.f51523b;
        webSocketReader.getClass();
        int i2 = this.f51524c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51524c = i2 - Integer.MIN_VALUE;
            webSocketReader$parseLoop$1 = this;
        } else {
            webSocketReader$parseLoop$1 = new WebSocketReader$parseLoop$1(webSocketReader, this);
        }
        Object obj2 = webSocketReader$parseLoop$1.f51522a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = webSocketReader$parseLoop$1.f51524c;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        throw null;
    }
}
