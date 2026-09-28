package androidx.datastore.core.okio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {WKSRecord.Service.AUTH}, m = "readScope")
/* loaded from: classes.dex */
final class OkioStorageConnection$readScope$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OkioStorageConnection f3671a;

    /* renamed from: b, reason: collision with root package name */
    public OkioReadScope f3672b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3673c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3674d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OkioStorageConnection f3675e;

    /* renamed from: f, reason: collision with root package name */
    public int f3676f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorageConnection$readScope$1(OkioStorageConnection okioStorageConnection, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3675e = okioStorageConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3674d = obj;
        this.f3676f |= Integer.MIN_VALUE;
        return this.f3675e.b(null, this);
    }
}
