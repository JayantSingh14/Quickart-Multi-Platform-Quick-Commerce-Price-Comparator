package androidx.datastore.core.okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class OkioStorage$createConnection$2 extends Lambda implements Function0<Unit> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OkioStorage f3664c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorage$createConnection$2(OkioStorage okioStorage) {
        super(0);
        this.f3664c = okioStorage;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Synchronizer synchronizer = OkioStorage.f3657f;
        OkioStorage okioStorage = this.f3664c;
        synchronized (synchronizer) {
            OkioStorage.f3656e.remove(((Path) okioStorage.f3661d.getValue()).f56973a.z());
        }
        return Unit.f53572a;
    }
}
