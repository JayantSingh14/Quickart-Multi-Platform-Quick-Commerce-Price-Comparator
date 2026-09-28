package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
/* loaded from: classes3.dex */
final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f54165e;

    public TimeoutCoroutine(long j2, ContinuationImpl continuationImpl) {
        super(continuationImpl, continuationImpl.getContext());
        this.f54165e = j2;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String b0() {
        return super.b0() + "(timeMillis=" + this.f54165e + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            kotlin.coroutines.CoroutineContext r0 = r5.f54036c
            kotlinx.coroutines.Delay r0 = kotlinx.coroutines.DelayKt.b(r0)
            boolean r1 = r0 instanceof kotlinx.coroutines.DelayWithTimeoutDiagnostics
            if (r1 == 0) goto Ld
            kotlinx.coroutines.DelayWithTimeoutDiagnostics r0 = (kotlinx.coroutines.DelayWithTimeoutDiagnostics) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            long r1 = r5.f54165e
            if (r0 == 0) goto L20
            kotlin.time.Duration$Companion r3 = kotlin.time.Duration.f54014b
            kotlin.time.DurationUnit r3 = kotlin.time.DurationUnit.f54021d
            long r3 = kotlin.time.DurationKt.h(r1, r3)
            java.lang.String r0 = r0.l(r3)
            if (r0 != 0) goto L33
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Timed out waiting for "
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L33:
            kotlinx.coroutines.TimeoutCancellationException r1 = new kotlinx.coroutines.TimeoutCancellationException
            r1.<init>(r0, r5)
            r5.w(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutCoroutine.run():void");
    }
}
