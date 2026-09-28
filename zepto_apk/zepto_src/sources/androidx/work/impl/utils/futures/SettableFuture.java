package androidx.work.impl.utils.futures;

import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.futures.AbstractFuture;

@RestrictTo
/* loaded from: classes.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public final boolean i(Object obj) {
        if (obj == null) {
            obj = AbstractFuture.f13035g;
        }
        if (!AbstractFuture.f13034f.b(this, null, obj)) {
            return false;
        }
        AbstractFuture.b(this);
        return true;
    }

    public final boolean j(Throwable th) {
        if (!AbstractFuture.f13034f.b(this, null, new AbstractFuture.Failure(th))) {
            return false;
        }
        AbstractFuture.b(this);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(com.google.common.util.concurrent.ListenableFuture r6) {
        /*
            r5 = this;
            r6.getClass()
            java.lang.Object r0 = r5.f13036a
            r1 = 0
            if (r0 != 0) goto L44
            boolean r0 = r6.isDone()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L20
            java.lang.Object r6 = androidx.work.impl.utils.futures.AbstractFuture.e(r6)
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r0 = androidx.work.impl.utils.futures.AbstractFuture.f13034f
            boolean r6 = r0.b(r5, r3, r6)
            if (r6 == 0) goto L4f
            androidx.work.impl.utils.futures.AbstractFuture.b(r5)
            return r2
        L20:
            androidx.work.impl.utils.futures.AbstractFuture$SetFuture r0 = new androidx.work.impl.utils.futures.AbstractFuture$SetFuture
            r0.<init>(r5, r6)
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r4 = androidx.work.impl.utils.futures.AbstractFuture.f13034f
            boolean r3 = r4.b(r5, r3, r0)
            if (r3 == 0) goto L42
            androidx.work.impl.utils.futures.DirectExecutor r1 = androidx.work.impl.utils.futures.DirectExecutor.f13059a     // Catch: java.lang.Throwable -> L33
            r6.q(r0, r1)     // Catch: java.lang.Throwable -> L33
            return r2
        L33:
            r6 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$Failure r1 = new androidx.work.impl.utils.futures.AbstractFuture$Failure     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L3a:
            androidx.work.impl.utils.futures.AbstractFuture$Failure r1 = androidx.work.impl.utils.futures.AbstractFuture.Failure.f13043b
        L3c:
            androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper r6 = androidx.work.impl.utils.futures.AbstractFuture.f13034f
            r6.b(r5, r0, r1)
            return r2
        L42:
            java.lang.Object r0 = r5.f13036a
        L44:
            boolean r2 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.Cancellation
            if (r2 == 0) goto L4f
            androidx.work.impl.utils.futures.AbstractFuture$Cancellation r0 = (androidx.work.impl.utils.futures.AbstractFuture.Cancellation) r0
            boolean r0 = r0.f13041a
            r6.cancel(r0)
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.SettableFuture.k(com.google.common.util.concurrent.ListenableFuture):boolean");
    }
}
