package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {264, 266}, m = "readAndInitOrPropagateAndThrowFailure")
/* loaded from: classes.dex */
final class DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DataStoreImpl f3473a;

    /* renamed from: b, reason: collision with root package name */
    public int f3474b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3475c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3476d;

    /* renamed from: e, reason: collision with root package name */
    public int f3477e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3476d = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3475c = obj;
        this.f3477e |= Integer.MIN_VALUE;
        return this.f3476d.h(this);
    }
}
