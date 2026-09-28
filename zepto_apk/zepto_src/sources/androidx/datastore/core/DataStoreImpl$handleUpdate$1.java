package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {237, WKSRecord.Service.SUR_MEAS, 246}, m = "handleUpdate")
/* loaded from: classes3.dex */
final class DataStoreImpl$handleUpdate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3459a;

    /* renamed from: b, reason: collision with root package name */
    public DataStoreImpl f3460b;

    /* renamed from: c, reason: collision with root package name */
    public CompletableDeferred f3461c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3462d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3463e;

    /* renamed from: f, reason: collision with root package name */
    public int f3464f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$handleUpdate$1(DataStoreImpl dataStoreImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3463e = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3462d = obj;
        this.f3464f |= Integer.MIN_VALUE;
        return DataStoreImpl.c(this.f3463e, null, this);
    }
}
