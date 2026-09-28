package androidx.datastore.core.okio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.FileHandle;
import okio.RealBufferedSink;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", l = {216}, m = "writeData")
/* loaded from: classes3.dex */
final class OkioWriteScope$writeData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FileHandle f3684a;

    /* renamed from: b, reason: collision with root package name */
    public FileHandle f3685b;

    /* renamed from: c, reason: collision with root package name */
    public RealBufferedSink f3686c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3687d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OkioWriteScope f3688e;

    /* renamed from: f, reason: collision with root package name */
    public int f3689f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope$writeData$1(OkioWriteScope okioWriteScope, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3688e = okioWriteScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3687d = obj;
        this.f3689f |= Integer.MIN_VALUE;
        return this.f3688e.d(null, this);
    }
}
