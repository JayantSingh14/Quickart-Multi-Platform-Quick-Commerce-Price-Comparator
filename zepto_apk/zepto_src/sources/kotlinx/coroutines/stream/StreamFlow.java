package kotlinx.coroutines.stream;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata
/* loaded from: classes3.dex */
final class StreamFlow<T> implements Flow<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55223a = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlinx.coroutines.flow.FlowCollector r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r6 = r7 instanceof kotlinx.coroutines.stream.StreamFlow$collect$1
            if (r6 == 0) goto L13
            r6 = r7
            kotlinx.coroutines.stream.StreamFlow$collect$1 r6 = (kotlinx.coroutines.stream.StreamFlow$collect$1) r6
            int r0 = r6.f55228e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.f55228e = r0
            goto L18
        L13:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r6 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r6.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r6.f55226c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f55228e
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L4d
            if (r1 != r3) goto L45
            java.util.Iterator r1 = r6.f55225b
            kotlinx.coroutines.flow.FlowCollector r4 = r6.f55224a
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L42
        L2b:
            boolean r7 = r1.hasNext()     // Catch: java.lang.Throwable -> L42
            if (r7 == 0) goto L44
            java.lang.Object r7 = r1.next()     // Catch: java.lang.Throwable -> L42
            r6.f55224a = r4     // Catch: java.lang.Throwable -> L42
            r6.f55225b = r1     // Catch: java.lang.Throwable -> L42
            r6.f55228e = r3     // Catch: java.lang.Throwable -> L42
            java.lang.Object r7 = r4.a(r7, r6)     // Catch: java.lang.Throwable -> L42
            if (r7 != r0) goto L2b
            return r0
        L42:
            r6 = r2
            goto L63
        L44:
            throw r2
        L45:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4d:
            kotlin.ResultKt.b(r7)
            r6 = 0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = kotlinx.coroutines.stream.StreamFlow.f55223a
            boolean r6 = r7.compareAndSet(r5, r6, r3)
            if (r6 != 0) goto L61
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Stream.consumeAsFlow can be collected only once"
            r6.<init>(r7)
            throw r6
        L61:
            throw r2     // Catch: java.lang.Throwable -> L62
        L62:
            r6 = r5
        L63:
            r6.getClass()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.c(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
