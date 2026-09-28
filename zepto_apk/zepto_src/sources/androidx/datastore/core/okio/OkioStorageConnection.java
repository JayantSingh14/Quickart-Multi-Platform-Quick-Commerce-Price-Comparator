package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.preferences.core.PreferencesSerializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FileSystem f3665a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f3666b;

    /* renamed from: c, reason: collision with root package name */
    public final InterProcessCoordinator f3667c;

    /* renamed from: d, reason: collision with root package name */
    public final Function0 f3668d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3669e;

    /* renamed from: f, reason: collision with root package name */
    public final MutexImpl f3670f;

    public OkioStorageConnection(FileSystem fileSystem, Path path, InterProcessCoordinator coordinator, Function0 onClose) {
        PreferencesSerializer serializer = PreferencesSerializer.f3729a;
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.f3665a = fileSystem;
        this.f3666b = path;
        this.f3667c = coordinator;
        this.f3668d = onClose;
        this.f3669e = new AtomicBoolean();
        this.f3670f = MutexKt.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c A[Catch: all -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:33:0x007c, B:42:0x008d, B:41:0x008a, B:38:0x0085), top: B:54:0x0020, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.jvm.functions.Function3 r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$readScope$1) r0
            int r1 = r0.f3676f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3676f = r1
            goto L18
        L13:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f3674d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3676f
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            boolean r8 = r0.f3673c
            androidx.datastore.core.okio.OkioReadScope r1 = r0.f3672b
            androidx.datastore.core.okio.OkioStorageConnection r0 = r0.f3671a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2e
            goto L6c
        L2e:
            r9 = move-exception
            goto L85
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.b(r9)
            androidx.datastore.core.okio.AtomicBoolean r9 = r7.f3669e
            java.util.concurrent.atomic.AtomicBoolean r9 = r9.f3647a
            boolean r9 = r9.get()
            if (r9 != 0) goto L9b
            kotlinx.coroutines.sync.MutexImpl r9 = r7.f3670f
            boolean r9 = r9.f()
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch: java.lang.Throwable -> L8e
            okio.FileSystem r5 = r7.f3665a     // Catch: java.lang.Throwable -> L8e
            okio.Path r6 = r7.f3666b     // Catch: java.lang.Throwable -> L8e
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8e
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L7f
            r0.f3671a = r7     // Catch: java.lang.Throwable -> L7f
            r0.f3672b = r2     // Catch: java.lang.Throwable -> L7f
            r0.f3673c = r9     // Catch: java.lang.Throwable -> L7f
            r0.f3676f = r4     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7f
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
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f3670f
            r8.b(r3)
        L7b:
            return r9
        L7c:
            throw r1     // Catch: java.lang.Throwable -> L7d
        L7d:
            r9 = move-exception
            goto L93
        L7f:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L85:
            r1.close()     // Catch: java.lang.Throwable -> L89
            goto L8d
        L89:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r9, r1)     // Catch: java.lang.Throwable -> L7d
        L8d:
            throw r9     // Catch: java.lang.Throwable -> L7d
        L8e:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L93:
            if (r8 == 0) goto L9a
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f3670f
            r8.b(r3)
        L9a:
            throw r9
        L9b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "StorageConnection has already been disposed."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.b(kotlin.jvm.functions.Function3, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: all -> 0x00cc, IOException -> 0x00cf, TRY_ENTER, TryCatch #4 {IOException -> 0x00cf, blocks: (B:41:0x00bc, B:43:0x00c4, B:52:0x00db, B:59:0x00e9, B:58:0x00e6), top: B:80:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db A[Catch: all -> 0x00cc, IOException -> 0x00cf, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x00cf, blocks: (B:41:0x00bc, B:43:0x00c4, B:52:0x00db, B:59:0x00e9, B:58:0x00e6), top: B:80:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r0v3, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v8, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Object, kotlinx.coroutines.sync.MutexImpl] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.datastore.core.okio.OkioStorageConnection$writeScope$1, java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARN: Type inference failed for: r1v3, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r1v5, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r9v0, types: [okio.FileSystem] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.jvm.functions.Function2 r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.c(kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.f3669e.f3647a.set(true);
        ((OkioStorage$createConnection$2) this.f3668d).invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public final InterProcessCoordinator e() {
        return this.f3667c;
    }
}
