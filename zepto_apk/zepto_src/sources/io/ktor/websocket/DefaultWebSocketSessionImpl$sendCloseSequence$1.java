package io.ktor.websocket;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {281}, m = "sendCloseSequence")
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$sendCloseSequence$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DefaultWebSocketSessionImpl f51429a;

    /* renamed from: b, reason: collision with root package name */
    public Throwable f51430b;

    /* renamed from: c, reason: collision with root package name */
    public CloseReason f51431c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f51432d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51433e;

    /* renamed from: f, reason: collision with root package name */
    public int f51434f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$sendCloseSequence$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51433e = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51432d = obj;
        this.f51434f |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DefaultWebSocketSessionImpl.f51389k;
        return this.f51433e.e(null, null, this);
    }
}
