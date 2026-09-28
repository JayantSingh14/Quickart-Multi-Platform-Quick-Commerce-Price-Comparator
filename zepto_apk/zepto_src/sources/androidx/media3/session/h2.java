package androidx.media3.session;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final /* synthetic */ class h2 implements Supplier {
    @Override // com.google.common.base.Supplier
    public final Object get() {
        Supplier supplier = SimpleBitmapLoader.f10289b;
        return MoreExecutors.b(Executors.newSingleThreadExecutor());
    }
}
