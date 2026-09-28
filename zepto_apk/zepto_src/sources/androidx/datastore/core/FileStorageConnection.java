package androidx.datastore.core;

import com.google.android.gms.internal.ads.zzfxz;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {

    /* renamed from: a, reason: collision with root package name */
    public final File f3556a;

    /* renamed from: b, reason: collision with root package name */
    public final InterProcessCoordinator f3557b;

    /* renamed from: c, reason: collision with root package name */
    public final Function0 f3558c;

    /* renamed from: d, reason: collision with root package name */
    public final java.util.concurrent.atomic.AtomicBoolean f3559d;

    /* renamed from: e, reason: collision with root package name */
    public final MutexImpl f3560e;

    public FileStorageConnection(File file, InterProcessCoordinator coordinator, Function0 onClose) {
        zzfxz serializer = zzfxz.f31992a;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.f3556a = file;
        this.f3557b = coordinator;
        this.f3558c = onClose;
        this.f3559d = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.f3560e = MutexKt.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c A[Catch: all -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x007d, blocks: (B:33:0x007c, B:43:0x008f, B:42:0x008c, B:39:0x0087), top: B:59:0x0020, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [androidx.datastore.core.StorageConnectionKt$readData$2] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.jvm.functions.Function3 r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.f3566f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3566f = r1
            goto L18
        L13:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f3564d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3566f
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            boolean r8 = r0.f3563c
            androidx.datastore.core.FileReadScope r1 = r0.f3562b
            androidx.datastore.core.FileStorageConnection r0 = r0.f3561a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2e
            goto L6c
        L2e:
            r9 = move-exception
            goto L87
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.b(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r7.f3559d
            boolean r9 = r9.get()
            if (r9 != 0) goto L9d
            kotlinx.coroutines.sync.MutexImpl r9 = r7.f3560e
            boolean r9 = r9.f()
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch: java.lang.Throwable -> L90
            java.io.File r5 = r7.f3556a     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzfxz r6 = com.google.android.gms.internal.ads.zzfxz.f31992a     // Catch: java.lang.Throwable -> L90
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L90
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L85
            r0.f3561a = r7     // Catch: java.lang.Throwable -> L85
            r0.f3562b = r2     // Catch: java.lang.Throwable -> L85
            r0.f3563c = r9     // Catch: java.lang.Throwable -> L85
            r0.f3566f = r4     // Catch: java.lang.Throwable -> L85
            androidx.datastore.core.StorageConnectionKt$readData$2 r8 = (androidx.datastore.core.StorageConnectionKt$readData$2) r8     // Catch: java.lang.Throwable -> L85
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L85
            if (r8 != r1) goto L67
            return r1
        L67:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L6c:
            r1.close()     // Catch: java.lang.Throwable -> L71
            r1 = r3
            goto L72
        L71:
            r1 = move-exception
        L72:
            if (r1 != 0) goto L7c
            if (r8 == 0) goto L7b
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f3560e
            r8.b(r3)
        L7b:
            return r9
        L7c:
            throw r1     // Catch: java.lang.Throwable -> L7d
        L7d:
            r9 = move-exception
            goto L95
        L7f:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
            goto L87
        L85:
            r8 = move-exception
            goto L7f
        L87:
            r1.close()     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r9, r1)     // Catch: java.lang.Throwable -> L7d
        L8f:
            throw r9     // Catch: java.lang.Throwable -> L7d
        L90:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L95:
            if (r8 == 0) goto L9c
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f3560e
            r8.b(r3)
        L9c:
            throw r9
        L9d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "StorageConnection has already been disposed."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.b(kotlin.jvm.functions.Function3, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9 A[Catch: all -> 0x012e, IOException -> 0x0130, TRY_ENTER, TryCatch #4 {IOException -> 0x0130, blocks: (B:44:0x00e9, B:46:0x00ef, B:48:0x0101, B:52:0x010d, B:53:0x012d, B:49:0x0106, B:61:0x013b, B:68:0x0148, B:67:0x0145), top: B:86:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b A[Catch: all -> 0x012e, IOException -> 0x0130, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0130, blocks: (B:44:0x00e9, B:46:0x00ef, B:48:0x0101, B:52:0x010d, B:53:0x012d, B:49:0x0106, B:61:0x013b, B:68:0x0148, B:67:0x0145), top: B:86:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.jvm.functions.Function2 r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.c(kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.f3559d.set(true);
        this.f3558c.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public final InterProcessCoordinator e() {
        return this.f3557b;
    }
}
