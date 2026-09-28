package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {544}, m = "decrementCollector")
/* loaded from: classes3.dex */
final class DataStoreImpl$decrementCollector$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DataStoreImpl f3452a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f3453b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3454c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3455d;

    /* renamed from: e, reason: collision with root package name */
    public int f3456e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$decrementCollector$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3455d = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3454c = obj;
        this.f3456e |= Integer.MIN_VALUE;
        return DataStoreImpl.b(this.f3455d, this);
    }
}
