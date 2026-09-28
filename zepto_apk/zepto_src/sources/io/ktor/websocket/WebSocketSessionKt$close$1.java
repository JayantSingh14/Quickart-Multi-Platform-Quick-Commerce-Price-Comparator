package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", l = {120, WKSRecord.Service.ERPC}, m = "close")
/* loaded from: classes3.dex */
final class WebSocketSessionKt$close$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public WebSocketSession f51527a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51528b;

    /* renamed from: c, reason: collision with root package name */
    public int f51529c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51528b = obj;
        this.f51529c |= Integer.MIN_VALUE;
        return WebSocketSessionKt.a(null, null, this);
    }
}
