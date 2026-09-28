package androidx.datastore.core.okio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.Path;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {236, WKSRecord.Service.NETBIOS_NS}, m = "writeScope")
/* loaded from: classes3.dex */
final class OkioStorageConnection$writeScope$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OkioStorageConnection f3677a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3678b;

    /* renamed from: c, reason: collision with root package name */
    public Path f3679c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3680d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f3681e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ OkioStorageConnection f3682f;

    /* renamed from: g, reason: collision with root package name */
    public int f3683g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorageConnection$writeScope$1(OkioStorageConnection okioStorageConnection, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3682f = okioStorageConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3681e = obj;
        this.f3683g |= Integer.MIN_VALUE;
        return this.f3682f.c(null, this);
    }
}
