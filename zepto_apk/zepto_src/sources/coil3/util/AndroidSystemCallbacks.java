package coil3.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil3.RealImageLoader;
import coil3.memory.MemoryCache;
import coil3.util.Logger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidSystemCallbacks implements SystemCallbacks, ComponentCallbacks2 {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final String TAG = "AndroidSystemCallbacks";

    @Nullable
    private Context application;

    @NotNull
    private final WeakReference<RealImageLoader> imageLoader;
    private boolean shutdown;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidSystemCallbacks(@NotNull RealImageLoader realImageLoader) {
        this.imageLoader = new WeakReference<>(realImageLoader);
    }

    public static /* synthetic */ void getImageLoader$annotations() {
    }

    public static /* synthetic */ void getShutdown$annotations() {
    }

    private final void withImageLoader(Function1<? super RealImageLoader, Unit> function1) {
        RealImageLoader realImageLoader = this.imageLoader.get();
        if (realImageLoader != null) {
            function1.invoke(realImageLoader);
        } else {
            shutdown();
        }
    }

    @NotNull
    public final WeakReference<RealImageLoader> getImageLoader() {
        return this.imageLoader;
    }

    public final boolean getShutdown() {
        return this.shutdown;
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onConfigurationChanged(@NotNull Configuration configuration) {
        if (this.imageLoader.get() == null) {
            shutdown();
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public synchronized void onTrimMemory(int i2) {
        MemoryCache memoryCache;
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader != null) {
                Logger logger = realImageLoader.getOptions().getLogger();
                if (logger != null) {
                    Logger.Level level = Logger.Level.Verbose;
                    if (logger.getMinLevel().compareTo(level) <= 0) {
                        logger.log(TAG, level, "trimMemory, level=" + i2, null);
                    }
                }
                if (i2 >= 40) {
                    MemoryCache memoryCache2 = realImageLoader.getMemoryCache();
                    if (memoryCache2 != null) {
                        memoryCache2.clear();
                    }
                } else if (i2 >= 10 && (memoryCache = realImageLoader.getMemoryCache()) != null) {
                    memoryCache.trimToSize(memoryCache.getSize() / 2);
                }
            } else {
                shutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil3.util.SystemCallbacks
    public synchronized void registerMemoryPressureCallbacks() {
        try {
            RealImageLoader realImageLoader = this.imageLoader.get();
            if (realImageLoader == null) {
                shutdown();
            } else if (this.application == null) {
                Context application = realImageLoader.getOptions().getApplication();
                this.application = application;
                application.registerComponentCallbacks(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setShutdown(boolean z) {
        this.shutdown = z;
    }

    @Override // coil3.util.SystemCallbacks
    public synchronized void shutdown() {
        try {
            if (this.shutdown) {
                return;
            }
            this.shutdown = true;
            Context context = this.application;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            this.imageLoader.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
