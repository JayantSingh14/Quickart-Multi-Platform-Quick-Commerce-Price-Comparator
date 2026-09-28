package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.coroutines.channels.ProducerScope r4, kotlin.jvm.functions.Function0 r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.f54425d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54425d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f54424c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54425d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.functions.Function0 r5 = r0.f54423b
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L6a
        L29:
            r4 = move-exception
            goto L70
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key.f54121a
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            if (r6 != r4) goto L74
            r0.f54422a = r4     // Catch: java.lang.Throwable -> L29
            r0.f54423b = r5     // Catch: java.lang.Throwable -> L29
            r0.f54425d = r3     // Catch: java.lang.Throwable -> L29
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L29
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r2)     // Catch: java.lang.Throwable -> L29
            r6.s()     // Catch: java.lang.Throwable -> L29
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            r4.h(r2)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.r()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L67
            java.lang.String r6 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch: java.lang.Throwable -> L29
        L67:
            if (r4 != r1) goto L6a
            return r1
        L6a:
            r5.invoke()
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L70:
            r5.invoke()
            throw r4
        L74:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.ProducerScope, kotlin.jvm.functions.Function0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final ReceiveChannel b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function2 function2) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.b(coroutineScope, coroutineContext), ChannelKt.a(i2, bufferOverflow, 4), true, true);
        producerCoroutine.A0(coroutineStart, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static ReceiveChannel c(CoroutineScope coroutineScope, int i2, Function2 function2, int i3) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return b(coroutineScope, emptyCoroutineContext, i2, BufferOverflow.f54203a, CoroutineStart.f54078a, function2);
    }
}
