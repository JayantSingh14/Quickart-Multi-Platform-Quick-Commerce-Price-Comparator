package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {101}, m = "readScope")
/* loaded from: classes3.dex */
final class FileStorageConnection$readScope$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FileStorageConnection f3561a;

    /* renamed from: b, reason: collision with root package name */
    public FileReadScope f3562b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3563c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3564d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FileStorageConnection f3565e;

    /* renamed from: f, reason: collision with root package name */
    public int f3566f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageConnection$readScope$1(FileStorageConnection fileStorageConnection, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3565e = fileStorageConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3564d = obj;
        this.f3566f |= Integer.MIN_VALUE;
        return this.f3565e.b(null, this);
    }
}
