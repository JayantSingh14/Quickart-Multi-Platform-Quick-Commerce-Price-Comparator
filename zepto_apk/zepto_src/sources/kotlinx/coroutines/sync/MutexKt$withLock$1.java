package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", l = {WKSRecord.Service.ERPC}, m = "withLock")
/* loaded from: classes3.dex */
final class MutexKt$withLock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f55237a;

    /* renamed from: b, reason: collision with root package name */
    public int f55238b;

    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        throw null;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            r3.f55237a = r4
            int r0 = r3.f55238b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r3.f55238b = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            if (r0 != r2) goto L17
            kotlin.ResultKt.b(r4)
            throw r1     // Catch: java.lang.Throwable -> L16
        L16:
            throw r1
        L17:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L1f:
            kotlin.ResultKt.b(r4)
            r3.f55238b = r2
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt$withLock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
