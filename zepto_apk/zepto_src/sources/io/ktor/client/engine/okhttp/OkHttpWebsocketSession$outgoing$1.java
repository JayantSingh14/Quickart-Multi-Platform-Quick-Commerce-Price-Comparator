package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import okhttp3.Request;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", l = {62, WKSRecord.Protocol.RVD}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f49429a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49430b;

    /* renamed from: c, reason: collision with root package name */
    public int f49431c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49432d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OkHttpWebsocketSession f49433e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Request f49434f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation continuation) {
        super(2, continuation);
        this.f49433e = okHttpWebsocketSession;
        this.f49434f = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OkHttpWebsocketSession$outgoing$1 okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.f49433e, this.f49434f, continuation);
        okHttpWebsocketSession$outgoing$1.f49432d = obj;
        return okHttpWebsocketSession$outgoing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OkHttpWebsocketSession$outgoing$1) create((ActorScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        if (r8 != r0) goto L24;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0075 -> B:24:0x0078). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
