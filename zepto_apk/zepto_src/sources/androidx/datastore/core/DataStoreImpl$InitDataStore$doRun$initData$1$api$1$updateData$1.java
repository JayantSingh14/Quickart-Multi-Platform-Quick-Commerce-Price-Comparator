package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1", f = "DataStoreImpl.kt", l = {544, 447, 449}, m = "updateData")
/* loaded from: classes.dex */
final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3432a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3433b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3434c;

    /* renamed from: d, reason: collision with root package name */
    public Ref.ObjectRef f3435d;

    /* renamed from: e, reason: collision with root package name */
    public DataStoreImpl f3436e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3437f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl$InitDataStore$doRun$initData$1$api$1 f3438g;

    /* renamed from: h, reason: collision with root package name */
    public int f3439h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3438g = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3437f = obj;
        this.f3439h |= Integer.MIN_VALUE;
        return this.f3438g.a(null, this);
    }
}
