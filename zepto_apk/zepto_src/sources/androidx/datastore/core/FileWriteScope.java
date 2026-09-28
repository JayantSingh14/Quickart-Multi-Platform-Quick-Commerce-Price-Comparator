package androidx.datastore.core;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.Object r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.f3578e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3578e = r1
            goto L18
        L13:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f3576c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3578e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.io.FileOutputStream r5 = r0.f3575b
            java.io.FileOutputStream r0 = r0.f3574a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2b
            goto L60
        L2b:
            r5 = move-exception
            goto L74
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.f3544b
            boolean r6 = r6.get()
            if (r6 != 0) goto L7a
            java.io.FileOutputStream r6 = new java.io.FileOutputStream
            java.io.File r2 = r4.f3543a
            r6.<init>(r2)
            com.google.android.gms.internal.ads.zzfxz r2 = com.google.android.gms.internal.ads.zzfxz.f31992a     // Catch: java.lang.Throwable -> L72
            androidx.datastore.core.UncloseableOutputStream r2 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L72
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L72
            r0.f3574a = r6     // Catch: java.lang.Throwable -> L72
            r0.f3575b = r6     // Catch: java.lang.Throwable -> L72
            r0.f3578e = r3     // Catch: java.lang.Throwable -> L72
            com.google.android.gms.internal.ads.zzfxw r5 = (com.google.android.gms.internal.ads.zzfxw) r5     // Catch: java.lang.Throwable -> L72
            r5.a(r2)     // Catch: java.lang.Throwable -> L72
            kotlin.Unit r5 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L72
            if (r5 != r1) goto L5e
            return r1
        L5e:
            r5 = r6
            r0 = r5
        L60:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L2b
            r5.sync()     // Catch: java.lang.Throwable -> L2b
            kotlin.Unit r5 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L2b
            r5 = 0
            kotlin.io.CloseableKt.a(r0, r5)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L70:
            r0 = r6
            goto L74
        L72:
            r5 = move-exception
            goto L70
        L74:
            throw r5     // Catch: java.lang.Throwable -> L75
        L75:
            r6 = move-exception
            kotlin.io.CloseableKt.a(r0, r5)
            throw r6
        L7a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This scope has already been closed."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.d(java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
