package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DispatchedContinuationKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f55073a = new Symbol("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f55074b = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[Catch: all -> 0x006b, DONT_GENERATE, TryCatch #1 {all -> 0x006b, blocks: (B:16:0x004b, B:18:0x0059, B:20:0x005f, B:33:0x0091, B:23:0x006d, B:25:0x007b, B:30:0x0088, B:32:0x008e, B:38:0x009e, B:41:0x00a7, B:40:0x00a4, B:28:0x0081), top: B:52:0x004b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto Lb2
            kotlinx.coroutines.internal.DispatchedContinuation r9 = (kotlinx.coroutines.internal.DispatchedContinuation) r9
            java.lang.Throwable r0 = kotlin.Result.a(r8)
            if (r0 != 0) goto Le
            r1 = r8
            goto L14
        Le:
            kotlinx.coroutines.CompletedExceptionally r1 = new kotlinx.coroutines.CompletedExceptionally
            r2 = 0
            r1.<init>(r2, r0)
        L14:
            kotlinx.coroutines.CoroutineDispatcher r0 = r9.f55069d
            kotlin.coroutines.jvm.internal.ContinuationImpl r2 = r9.f55070e
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()
            boolean r0 = r0.o1(r3)
            r3 = 1
            if (r0 == 0) goto L31
            r9.f55071f = r1
            r9.f54090c = r3
            kotlin.coroutines.CoroutineContext r8 = r2.getContext()
            kotlinx.coroutines.CoroutineDispatcher r0 = r9.f55069d
            r0.c1(r8, r9)
            return
        L31:
            kotlinx.coroutines.EventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.a()
            long r4 = r0.f54098b
            r6 = 4294967296(0x100000000, double:2.121995791E-314)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L48
            r9.f55071f = r1
            r9.f54090c = r3
            r0.S1(r9)
            goto Lac
        L48:
            r0.T1(r3)
            kotlin.coroutines.CoroutineContext r1 = r2.getContext()     // Catch: java.lang.Throwable -> L6b
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key.f54121a     // Catch: java.lang.Throwable -> L6b
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L6b
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L6d
            boolean r4 = r1.a()     // Catch: java.lang.Throwable -> L6b
            if (r4 != 0) goto L6d
            java.util.concurrent.CancellationException r8 = r1.O()     // Catch: java.lang.Throwable -> L6b
            kotlin.Result$Failure r8 = kotlin.ResultKt.a(r8)     // Catch: java.lang.Throwable -> L6b
            r9.resumeWith(r8)     // Catch: java.lang.Throwable -> L6b
            goto L91
        L6b:
            r8 = move-exception
            goto La8
        L6d:
            java.lang.Object r1 = r9.f55072g     // Catch: java.lang.Throwable -> L6b
            kotlin.coroutines.CoroutineContext r4 = r2.getContext()     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r1)     // Catch: java.lang.Throwable -> L6b
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.f55109a     // Catch: java.lang.Throwable -> L6b
            if (r1 == r5) goto L80
            kotlinx.coroutines.UndispatchedCoroutine r5 = kotlinx.coroutines.CoroutineContextKt.c(r2, r4, r1)     // Catch: java.lang.Throwable -> L6b
            goto L81
        L80:
            r5 = 0
        L81:
            r2.resumeWith(r8)     // Catch: java.lang.Throwable -> L9b
            kotlin.Unit r8 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L9b
            if (r5 == 0) goto L8e
            boolean r8 = r5.B0()     // Catch: java.lang.Throwable -> L6b
            if (r8 == 0) goto L91
        L8e:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r1)     // Catch: java.lang.Throwable -> L6b
        L91:
            boolean r8 = r0.V1()     // Catch: java.lang.Throwable -> L6b
            if (r8 != 0) goto L91
        L97:
            r0.O1(r3)
            goto Lac
        L9b:
            r8 = move-exception
            if (r5 == 0) goto La4
            boolean r2 = r5.B0()     // Catch: java.lang.Throwable -> L6b
            if (r2 == 0) goto La7
        La4:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r1)     // Catch: java.lang.Throwable -> L6b
        La7:
            throw r8     // Catch: java.lang.Throwable -> L6b
        La8:
            r9.g(r8)     // Catch: java.lang.Throwable -> Lad
            goto L97
        Lac:
            return
        Lad:
            r8 = move-exception
            r0.O1(r3)
            throw r8
        Lb2:
            r9.resumeWith(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.a(java.lang.Object, kotlin.coroutines.Continuation):void");
    }
}
