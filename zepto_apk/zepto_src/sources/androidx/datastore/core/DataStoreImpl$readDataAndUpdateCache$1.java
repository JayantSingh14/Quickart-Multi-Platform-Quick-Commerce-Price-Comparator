package androidx.datastore.core;

import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {287, 296, UtilsKt.HTTP_RESPONSE_NOT_MODIFIED}, m = "readDataAndUpdateCache")
/* loaded from: classes.dex */
final class DataStoreImpl$readDataAndUpdateCache$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DataStoreImpl f3478a;

    /* renamed from: b, reason: collision with root package name */
    public State f3479b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3480c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3481d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3482e;

    /* renamed from: f, reason: collision with root package name */
    public int f3483f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$1(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(continuation);
        this.f3482e = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3481d = obj;
        this.f3483f |= Integer.MIN_VALUE;
        return DataStoreImpl.e(this.f3482e, false, this);
    }
}
