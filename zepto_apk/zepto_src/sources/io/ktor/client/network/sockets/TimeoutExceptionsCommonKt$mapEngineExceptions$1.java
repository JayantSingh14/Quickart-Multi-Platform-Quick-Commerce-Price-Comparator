package io.ktor.client.network.sockets;

import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1", f = "TimeoutExceptionsCommon.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TimeoutExceptionsCommonKt$mapEngineExceptions$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
    
        throw null;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        /*
            r1 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            kotlin.ResultKt.b(r2)
            r2 = 0
            throw r2     // Catch: java.lang.Throwable -> L7
        L7:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
