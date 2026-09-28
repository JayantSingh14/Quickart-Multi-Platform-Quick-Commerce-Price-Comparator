package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {155, 158, 163}, m = "flush")
/* loaded from: classes3.dex */
final class WebSocketWriter$flush$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51533a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebSocketWriter f51534b;

    /* renamed from: c, reason: collision with root package name */
    public int f51535c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$flush$1(WebSocketWriter webSocketWriter, Continuation continuation) {
        super(continuation);
        this.f51534b = webSocketWriter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw null;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            r5.f51533a = r6
            int r6 = r5.f51535c
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 | r0
            r5.f51535c = r6
            io.ktor.websocket.WebSocketWriter r6 = r5.f51534b
            r6.getClass()
            int r1 = r5.f51535c
            r2 = r1 & r0
            if (r2 == 0) goto L19
            int r1 = r1 - r0
            r5.f51535c = r1
            r0 = r5
            goto L1e
        L19:
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = new io.ktor.websocket.WebSocketWriter$flush$1
            r0.<init>(r6, r5)
        L1e:
            java.lang.Object r6 = r0.f51533a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f51535c
            r2 = 0
            if (r1 == 0) goto L4a
            r3 = 1
            r4 = 3
            if (r1 == r3) goto L42
            r3 = 2
            if (r1 == r3) goto L3e
            if (r1 != r4) goto L36
            kotlin.ResultKt.b(r6)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3e:
            kotlin.ResultKt.b(r6)
            goto L45
        L42:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L48 kotlinx.coroutines.channels.ClosedSendChannelException -> L49
        L45:
            r0.f51535c = r4
            throw r2
        L48:
            throw r2
        L49:
            throw r2
        L4a:
            kotlin.ResultKt.b(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter$flush$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
