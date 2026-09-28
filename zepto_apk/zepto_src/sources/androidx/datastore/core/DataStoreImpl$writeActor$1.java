package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class DataStoreImpl$writeActor$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3526c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeActor$1(DataStoreImpl dataStoreImpl) {
        super(1);
        this.f3526c = dataStoreImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        DataStoreImpl dataStoreImpl = this.f3526c;
        if (th != null) {
            dataStoreImpl.f3403h.b(new Final(th));
        }
        if (dataStoreImpl.f3405j.d()) {
            ((StorageConnection) dataStoreImpl.f3405j.getValue()).close();
        }
        return Unit.f53572a;
    }
}
