package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {327}, m = "checkMaxFrameSize")
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$checkMaxFrameSize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f51402a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51403b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51404c;

    /* renamed from: d, reason: collision with root package name */
    public int f51405d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$checkMaxFrameSize$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51404c = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51403b = obj;
        this.f51405d |= Integer.MIN_VALUE;
        return DefaultWebSocketSessionImpl.a(this.f51404c, null, null, this);
    }
}
