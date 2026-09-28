package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {544}, m = "incrementCollector")
/* loaded from: classes3.dex */
final class DataStoreImpl$incrementCollector$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DataStoreImpl f3465a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f3466b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3467c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3468d;

    /* renamed from: e, reason: collision with root package name */
    public int f3469e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3468d = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3467c = obj;
        this.f3469e |= Integer.MIN_VALUE;
        return DataStoreImpl.d(this.f3468d, this);
    }
}
