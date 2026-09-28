package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {214, 118}, m = "writeScope")
/* loaded from: classes3.dex */
final class FileStorageConnection$writeScope$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FileStorageConnection f3567a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3568b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3569c;

    /* renamed from: d, reason: collision with root package name */
    public FileWriteScope f3570d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f3571e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FileStorageConnection f3572f;

    /* renamed from: g, reason: collision with root package name */
    public int f3573g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageConnection$writeScope$1(FileStorageConnection fileStorageConnection, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3572f = fileStorageConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3571e = obj;
        this.f3573g |= Integer.MIN_VALUE;
        return this.f3572f.c(null, this);
    }
}
