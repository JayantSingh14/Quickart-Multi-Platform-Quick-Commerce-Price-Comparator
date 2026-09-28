package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54116a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ coil3.decode.a f54117b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterruptibleKt$runInterruptible$2(coil3.decode.a aVar, Continuation continuation) {
        super(2, continuation);
        this.f54117b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.f54117b, continuation);
        interruptibleKt$runInterruptible$2.f54116a = obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        return coil3.decode.BitmapFactoryDecoder.decode$lambda$1$lambda$0((coil3.decode.BitmapFactoryDecoder) r0.f13863b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r1.n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        throw r5;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = r4.f54116a
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.coroutines.CoroutineContext r5 = r5.r()
            coil3.decode.a r0 = r4.f54117b
            kotlinx.coroutines.ThreadState r1 = new kotlinx.coroutines.ThreadState     // Catch: java.lang.InterruptedException -> L45
            r1.<init>()     // Catch: java.lang.InterruptedException -> L45
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.e(r5)     // Catch: java.lang.InterruptedException -> L45
            kotlinx.coroutines.DisposableHandle r5 = kotlinx.coroutines.JobKt.f(r5, r1)     // Catch: java.lang.InterruptedException -> L45
            r1.f54163f = r5     // Catch: java.lang.InterruptedException -> L45
        L1e:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = kotlinx.coroutines.ThreadState.f54161g     // Catch: java.lang.InterruptedException -> L45
            int r2 = r5.get(r1)     // Catch: java.lang.InterruptedException -> L45
            if (r2 == 0) goto L32
            r5 = 2
            if (r2 == r5) goto L39
            r5 = 3
            if (r2 != r5) goto L2d
            goto L39
        L2d:
            kotlinx.coroutines.ThreadState.o(r2)     // Catch: java.lang.InterruptedException -> L45
            r5 = 0
            throw r5     // Catch: java.lang.InterruptedException -> L45
        L32:
            r3 = 0
            boolean r5 = r5.compareAndSet(r1, r2, r3)     // Catch: java.lang.InterruptedException -> L45
            if (r5 == 0) goto L1e
        L39:
            java.lang.Object r5 = r0.f13863b     // Catch: java.lang.Throwable -> L47
            coil3.decode.BitmapFactoryDecoder r5 = (coil3.decode.BitmapFactoryDecoder) r5     // Catch: java.lang.Throwable -> L47
            coil3.decode.DecodeResult r5 = coil3.decode.BitmapFactoryDecoder.a(r5)     // Catch: java.lang.Throwable -> L47
            r1.n()     // Catch: java.lang.InterruptedException -> L45
            return r5
        L45:
            r5 = move-exception
            goto L4c
        L47:
            r5 = move-exception
            r1.n()     // Catch: java.lang.InterruptedException -> L45
            throw r5     // Catch: java.lang.InterruptedException -> L45
        L4c:
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.String r1 = "Blocking call was interrupted due to parent cancellation"
            r0.<init>(r1)
            java.lang.Throwable r5 = r0.initCause(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.InterruptibleKt$runInterruptible$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
