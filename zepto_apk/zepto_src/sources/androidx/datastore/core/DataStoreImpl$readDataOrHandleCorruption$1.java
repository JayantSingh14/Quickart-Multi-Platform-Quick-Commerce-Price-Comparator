package androidx.datastore.core;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {365, 366, 368, 369, 380, 384}, m = "readDataOrHandleCorruption")
/* loaded from: classes.dex */
final class DataStoreImpl$readDataOrHandleCorruption$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3492a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3493b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f3494c;

    /* renamed from: d, reason: collision with root package name */
    public Ref.ObjectRef f3495d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3496e;

    /* renamed from: f, reason: collision with root package name */
    public int f3497f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3498g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3499h;

    /* renamed from: i, reason: collision with root package name */
    public int f3500i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3499h = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3498g = obj;
        this.f3500i |= Integer.MIN_VALUE;
        return DataStoreImpl.f(this.f3499h, false, this);
    }
}
