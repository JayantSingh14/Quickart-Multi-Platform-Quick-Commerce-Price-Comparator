package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {WKSRecord.Service.ERPC, WKSRecord.Service.ERPC}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f3621a;

    /* renamed from: b, reason: collision with root package name */
    public int f3622b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SimpleActor f3623c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor simpleActor, Continuation continuation) {
        super(2, continuation);
        this.f3623c = simpleActor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SimpleActor$offer$2(this.f3623c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r1.invoke(r7, r6) != r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[PHI: r1 r7
      0x0047: PHI (r1v1 kotlin.jvm.functions.Function2) = (r1v2 kotlin.jvm.functions.Function2), (r1v4 kotlin.jvm.functions.Function2) binds: [B:13:0x0044, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0047: PHI (r7v5 java.lang.Object) = (r7v10 java.lang.Object), (r7v0 java.lang.Object) binds: [B:13:0x0044, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f3622b
            r2 = 2
            r3 = 1
            androidx.datastore.core.SimpleActor r4 = r6.f3623c
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L53
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f3621a
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.b(r7)
            goto L47
        L22:
            kotlin.ResultKt.b(r7)
            androidx.datastore.core.AtomicInt r7 = r4.f3617d
            java.util.concurrent.atomic.AtomicInteger r7 = r7.f3377a
            int r7 = r7.get()
            if (r7 <= 0) goto L60
        L2f:
            kotlinx.coroutines.CoroutineScope r7 = r4.f3614a
            kotlin.coroutines.CoroutineContext r7 = r7.r()
            kotlinx.coroutines.JobKt.d(r7)
            kotlin.jvm.functions.Function2 r1 = r4.f3615b
            kotlinx.coroutines.channels.BufferedChannel r7 = r4.f3616c
            r6.f3621a = r1
            r6.f3622b = r3
            java.lang.Object r7 = r7.K(r6)
            if (r7 != r0) goto L47
            goto L52
        L47:
            r5 = 0
            r6.f3621a = r5
            r6.f3622b = r2
            java.lang.Object r7 = r1.invoke(r7, r6)
            if (r7 != r0) goto L53
        L52:
            return r0
        L53:
            androidx.datastore.core.AtomicInt r7 = r4.f3617d
            java.util.concurrent.atomic.AtomicInteger r7 = r7.f3377a
            int r7 = r7.decrementAndGet()
            if (r7 != 0) goto L2f
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L60:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
