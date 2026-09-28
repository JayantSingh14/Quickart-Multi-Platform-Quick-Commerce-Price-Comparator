package androidx.datastore.core;

import com.google.android.gms.internal.ads.zzfxz;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class FileReadScope<T> implements ReadScope<T> {

    /* renamed from: a, reason: collision with root package name */
    public final File f3543a;

    /* renamed from: b, reason: collision with root package name */
    public final java.util.concurrent.atomic.AtomicBoolean f3544b;

    public FileReadScope(File file) {
        zzfxz serializer = zzfxz.f31992a;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f3543a = file;
        this.f3544b = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object f(androidx.datastore.core.FileReadScope r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            Method dump skipped, instructions count: 187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.f(androidx.datastore.core.FileReadScope, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.ReadScope
    public final Object a(Continuation continuation) {
        return f(this, (ContinuationImpl) continuation);
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.f3544b.set(true);
    }
}
