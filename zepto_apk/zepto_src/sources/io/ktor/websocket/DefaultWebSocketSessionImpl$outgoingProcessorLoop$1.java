package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {252, 256, 266}, m = "outgoingProcessorLoop")
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DefaultWebSocketSessionImpl f51406a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f51407b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51408c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51409d;

    /* renamed from: e, reason: collision with root package name */
    public int f51410e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$outgoingProcessorLoop$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51409d = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51408c = obj;
        this.f51410e |= Integer.MIN_VALUE;
        return DefaultWebSocketSessionImpl.c(this.f51409d, this);
    }
}
