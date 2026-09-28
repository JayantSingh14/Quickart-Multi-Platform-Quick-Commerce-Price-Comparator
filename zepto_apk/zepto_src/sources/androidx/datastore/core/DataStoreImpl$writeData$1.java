package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {348}, m = "writeData$datastore_core_release")
/* loaded from: classes3.dex */
final class DataStoreImpl$writeData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f3531a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3532b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3533c;

    /* renamed from: d, reason: collision with root package name */
    public int f3534d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3533c = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3532b = obj;
        this.f3534d |= Integer.MIN_VALUE;
        return this.f3533c.j(null, false, this);
    }
}
