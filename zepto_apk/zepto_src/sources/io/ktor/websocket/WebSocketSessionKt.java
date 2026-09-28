package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSocketSessionKt {
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r5.n0(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.websocket.WebSocketSession r5, io.ktor.websocket.CloseReason r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.websocket.WebSocketSessionKt$close$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = (io.ktor.websocket.WebSocketSessionKt$close$1) r0
            int r1 = r0.f51529c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51529c = r1
            goto L18
        L13:
            io.ktor.websocket.WebSocketSessionKt$close$1 r0 = new io.ktor.websocket.WebSocketSessionKt$close$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f51528b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51529c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L57
            goto L57
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            io.ktor.websocket.WebSocketSession r5 = r0.f51527a
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L57
            goto L4b
        L38:
            kotlin.ResultKt.b(r7)
            io.ktor.websocket.Frame$Close r7 = new io.ktor.websocket.Frame$Close     // Catch: java.lang.Throwable -> L57
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L57
            r0.f51527a = r5     // Catch: java.lang.Throwable -> L57
            r0.f51529c = r4     // Catch: java.lang.Throwable -> L57
            java.lang.Object r6 = r5.c1(r7, r0)     // Catch: java.lang.Throwable -> L57
            if (r6 != r1) goto L4b
            goto L56
        L4b:
            r6 = 0
            r0.f51527a = r6     // Catch: java.lang.Throwable -> L57
            r0.f51529c = r3     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.n0(r0)     // Catch: java.lang.Throwable -> L57
            if (r5 != r1) goto L57
        L56:
            return r1
        L57:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketSessionKt.a(io.ktor.websocket.WebSocketSession, io.ktor.websocket.CloseReason, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
