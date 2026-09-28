package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1] */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlinx.coroutines.sync.Mutex, kotlinx.coroutines.sync.MutexImpl] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.jvm.functions.Function2 r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r5 = r6 instanceof androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            if (r5 == 0) goto L13
            r5 = r6
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r5 = (androidx.datastore.core.MultiProcessCoordinator$tryLock$1) r5
            int r0 = r5.f3600e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.f3600e = r0
            goto L18
        L13:
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r5 = new androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            r5.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r5.f3598c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r5.f3600e
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            if (r0 == r2) goto L4b
            r2 = 2
            if (r0 != r2) goto L43
            boolean r0 = r5.f3597b
            r2 = 0
            kotlinx.coroutines.sync.MutexImpl r5 = r5.f3596a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L3a
            kotlin.io.CloseableKt.a(r2, r1)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L37
            r5.b(r1)
        L37:
            return r6
        L38:
            r6 = move-exception
            goto L58
        L3a:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L3c
        L3c:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L3e
        L3e:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r2, r6)     // Catch: java.lang.Throwable -> L38
            throw r3     // Catch: java.lang.Throwable -> L38
        L43:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L4b:
            boolean r0 = r5.f3597b
            kotlinx.coroutines.sync.MutexImpl r5 = r5.f3596a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L57
            r5.b(r1)
        L57:
            return r6
        L58:
            if (r0 == 0) goto L5d
            r5.b(r1)
        L5d:
            throw r6
        L5e:
            kotlin.ResultKt.b(r6)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.a(kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public final Flow b() {
        return null;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public final Object c(ContinuationImpl continuationImpl) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[Catch: all -> 0x006f, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x006f, blocks: (B:28:0x006b, B:43:0x0087, B:44:0x008a), top: B:61:0x0026, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087 A[Catch: all -> 0x006f, TRY_ENTER, TryCatch #6 {all -> 0x006f, blocks: (B:28:0x006b, B:43:0x0087, B:44:0x008a), top: B:61:0x0026, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.MultiProcessCoordinator$lock$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.jvm.functions.Function1] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.jvm.functions.Function1 r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.d(kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public final Object e(Continuation continuation) {
        throw null;
    }
}
