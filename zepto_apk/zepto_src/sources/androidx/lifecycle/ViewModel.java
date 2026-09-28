package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final ViewModelImpl f4936a = new ViewModelImpl();

    public final void a(String key, AutoCloseable closeable) {
        AutoCloseable autoCloseable;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        ViewModelImpl viewModelImpl = this.f4936a;
        if (viewModelImpl != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(closeable, "closeable");
            if (viewModelImpl.f4971d) {
                ViewModelImpl.a(closeable);
                return;
            }
            synchronized (viewModelImpl.f4968a) {
                autoCloseable = (AutoCloseable) viewModelImpl.f4969b.put(key, closeable);
            }
            ViewModelImpl.a(autoCloseable);
        }
    }

    public final void b() {
        ViewModelImpl viewModelImpl = this.f4936a;
        if (viewModelImpl != null && !viewModelImpl.f4971d) {
            viewModelImpl.f4971d = true;
            synchronized (viewModelImpl.f4968a) {
                try {
                    Iterator it = viewModelImpl.f4969b.values().iterator();
                    while (it.hasNext()) {
                        ViewModelImpl.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = viewModelImpl.f4970c.iterator();
                    while (it2.hasNext()) {
                        ViewModelImpl.a((AutoCloseable) it2.next());
                    }
                    viewModelImpl.f4970c.clear();
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d();
    }

    public final AutoCloseable c(String key) {
        AutoCloseable autoCloseable;
        Intrinsics.checkNotNullParameter(key, "key");
        ViewModelImpl viewModelImpl = this.f4936a;
        if (viewModelImpl == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (viewModelImpl.f4968a) {
            autoCloseable = (AutoCloseable) viewModelImpl.f4969b.get(key);
        }
        return autoCloseable;
    }

    public void d() {
    }
}
