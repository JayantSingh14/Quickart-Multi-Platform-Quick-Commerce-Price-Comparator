package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore", f = "DataStoreImpl.kt", l = {430, 434}, m = "doRun")
/* loaded from: classes.dex */
final class DataStoreImpl$InitDataStore$doRun$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3415a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3416b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl.InitDataStore f3417c;

    /* renamed from: d, reason: collision with root package name */
    public int f3418d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$1(DataStoreImpl.InitDataStore initDataStore, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3417c = initDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3416b = obj;
        this.f3418d |= Integer.MIN_VALUE;
        return this.f3417c.a(this);
    }
}
