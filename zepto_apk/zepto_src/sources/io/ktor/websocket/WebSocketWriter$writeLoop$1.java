package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {46, Type.DNSKEY}, m = "writeLoop")
/* loaded from: classes3.dex */
final class WebSocketWriter$writeLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51536a;

    /* renamed from: b, reason: collision with root package name */
    public int f51537b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51536a = obj;
        this.f51537b |= Integer.MIN_VALUE;
        throw null;
    }
}
