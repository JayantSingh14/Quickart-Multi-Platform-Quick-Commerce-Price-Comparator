package androidx.loader.app;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.zbc;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* loaded from: classes3.dex */
    public interface LoaderCallbacks<D> {
        void a(Object obj);

        zbc b();
    }

    public static LoaderManager b(LifecycleOwner lifecycleOwner) {
        return new LoaderManagerImpl(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Loader c(LoaderCallbacks loaderCallbacks);

    public abstract void d();
}
