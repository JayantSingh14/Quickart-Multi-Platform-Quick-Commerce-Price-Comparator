package androidx.datastore.core;

import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", l = {169, 178}, m = "readData$suspendImpl")
/* loaded from: classes3.dex */
final class FileReadScope$readData$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3545a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f3546b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3547c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FileReadScope f3548d;

    /* renamed from: e, reason: collision with root package name */
    public int f3549e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileReadScope$readData$1(FileReadScope fileReadScope, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3548d = fileReadScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3547c = obj;
        this.f3549e |= Integer.MIN_VALUE;
        return FileReadScope.f(this.f3548d, this);
    }
}
