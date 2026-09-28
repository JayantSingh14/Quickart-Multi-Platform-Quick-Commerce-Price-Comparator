package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class RunOnce {

    /* renamed from: a, reason: collision with root package name */
    public final MutexImpl f3606a = MutexKt.a();

    /* renamed from: b, reason: collision with root package name */
    public final CompletableDeferred f3607b = CompletableDeferredKt.a();

    public abstract Object a(ContinuationImpl continuationImpl);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.f3612e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3612e = r1
            goto L18
        L13:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f3610c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3612e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlinx.coroutines.sync.Mutex r1 = r0.f3609b
            androidx.datastore.core.RunOnce r0 = r0.f3608a
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2f
            goto L85
        L2f:
            r7 = move-exception
            goto L90
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L39:
            kotlinx.coroutines.sync.Mutex r2 = r0.f3609b
            androidx.datastore.core.RunOnce r4 = r0.f3608a
            kotlin.ResultKt.b(r7)
            r7 = r2
            goto L62
        L42:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CompletableDeferred r7 = r6.f3607b
            kotlinx.coroutines.JobSupport r7 = (kotlinx.coroutines.JobSupport) r7
            boolean r7 = r7.W()
            if (r7 == 0) goto L52
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L52:
            kotlinx.coroutines.sync.MutexImpl r7 = r6.f3606a
            r0.f3608a = r6
            r0.f3609b = r7
            r0.f3612e = r4
            java.lang.Object r2 = r7.c(r0)
            if (r2 != r1) goto L61
            goto L82
        L61:
            r4 = r6
        L62:
            kotlinx.coroutines.CompletableDeferred r2 = r4.f3607b     // Catch: java.lang.Throwable -> L72
            kotlinx.coroutines.JobSupport r2 = (kotlinx.coroutines.JobSupport) r2     // Catch: java.lang.Throwable -> L72
            boolean r2 = r2.W()     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto L76
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L72
            r7.b(r5)
            return r0
        L72:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L90
        L76:
            r0.f3608a = r4     // Catch: java.lang.Throwable -> L72
            r0.f3609b = r7     // Catch: java.lang.Throwable -> L72
            r0.f3612e = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r0 = r4.a(r0)     // Catch: java.lang.Throwable -> L72
            if (r0 != r1) goto L83
        L82:
            return r1
        L83:
            r1 = r7
            r0 = r4
        L85:
            kotlinx.coroutines.CompletableDeferred r7 = r0.f3607b     // Catch: java.lang.Throwable -> L2f
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L2f
            r7.r0(r0)     // Catch: java.lang.Throwable -> L2f
            r1.b(r5)
            return r0
        L90:
            r1.b(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
