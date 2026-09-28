package androidx.datastore.core;

import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.FileWriteScope", f = "FileStorage.kt", l = {201}, m = "writeData")
/* loaded from: classes3.dex */
final class FileWriteScope$writeData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FileOutputStream f3574a;

    /* renamed from: b, reason: collision with root package name */
    public FileOutputStream f3575b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3576c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FileWriteScope f3577d;

    /* renamed from: e, reason: collision with root package name */
    public int f3578e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope$writeData$1(FileWriteScope fileWriteScope, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3577d = fileWriteScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3576c = obj;
        this.f3578e |= Integer.MIN_VALUE;
        return this.f3577d.d(null, this);
    }
}
