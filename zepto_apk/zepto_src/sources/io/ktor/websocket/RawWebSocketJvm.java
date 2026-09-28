package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RawWebSocketJvm implements WebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f51505a;

    @Metadata
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketJvm$1", f = "RawWebSocketJvm.kt", l = {67, WKSRecord.Service.BOOTPC, 71, WKSRecord.Service.NETRJS_4}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.RawWebSocketJvm$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            throw null;
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl("maxFrameSize", "getMaxFrameSize()J", RawWebSocketJvm.class);
        Reflection.f53802a.getClass();
        f51505a = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl("masking", "getMasking()Z", RawWebSocketJvm.class)};
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        KProperty kProperty = f51505a[0];
        throw null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        throw null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object c1(Frame.Close close, Continuation continuation) {
        Z();
        throw null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object n0(Continuation continuation) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        KProperty kProperty = f51505a[0];
        throw null;
    }
}
