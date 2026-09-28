package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import androidx.datastore.preferences.core.PreferencesSerializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FileSystem f3648a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f3649b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3650c;

    public OkioReadScope(FileSystem fileSystem, Path path) {
        PreferencesSerializer serializer = PreferencesSerializer.f3729a;
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f3648a = fileSystem;
        this.f3649b = path;
        this.f3650c = new AtomicBoolean();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
    
        if (r9 == r1) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095 A[Catch: FileNotFoundException -> 0x008f, TryCatch #3 {FileNotFoundException -> 0x008f, blocks: (B:48:0x0095, B:49:0x0099, B:44:0x008b, B:41:0x0086), top: B:79:0x0023, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099 A[Catch: FileNotFoundException -> 0x008f, TRY_LEAVE, TryCatch #3 {FileNotFoundException -> 0x008f, blocks: (B:48:0x0095, B:49:0x0099, B:44:0x008b, B:41:0x0086), top: B:79:0x0023, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.datastore.core.okio.OkioReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.okio.OkioReadScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v4, types: [androidx.datastore.core.okio.OkioReadScope] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object f(androidx.datastore.core.okio.OkioReadScope r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.f(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.ReadScope
    public final Object a(Continuation continuation) {
        return f(this, (ContinuationImpl) continuation);
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.f3650c.f3647a.set(true);
    }
}
