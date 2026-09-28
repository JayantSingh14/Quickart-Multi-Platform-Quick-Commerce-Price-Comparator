package coil3;

import android.content.Context;
import coil3.annotation.DelicateCoilApi;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SingletonImageLoader {

    @NotNull
    public static final SingletonImageLoader INSTANCE = new SingletonImageLoader();
    private static final /* synthetic */ SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$VolatileWrapper$atomicfu$private = new SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private(null);

    @Metadata
    public interface Factory {
        @NotNull
        ImageLoader newImageLoader(@NotNull Context context);
    }

    private SingletonImageLoader() {
    }

    @JvmStatic
    @NotNull
    public static final ImageLoader get(@NotNull Context context) {
        Object obj = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        ImageLoader imageLoader = obj instanceof ImageLoader ? (ImageLoader) obj : null;
        return imageLoader == null ? INSTANCE.newImageLoader(context) : imageLoader;
    }

    private final ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader;
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private = singletonImageLoader$VolatileWrapper$atomicfu$private;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        ImageLoader imageLoaderNewImageLoader = null;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private);
            if (obj instanceof ImageLoader) {
                imageLoader = imageLoaderNewImageLoader;
                imageLoaderNewImageLoader = (ImageLoader) obj;
            } else {
                if (imageLoaderNewImageLoader == null) {
                    Factory factory = obj instanceof Factory ? (Factory) obj : null;
                    if (factory == null || (imageLoaderNewImageLoader = factory.newImageLoader(context)) == null) {
                        Factory factoryApplicationImageLoaderFactory = SingletonImageLoader_androidKt.applicationImageLoaderFactory(context);
                        imageLoaderNewImageLoader = factoryApplicationImageLoaderFactory != null ? factoryApplicationImageLoaderFactory.newImageLoader(context) : SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory.newImageLoader(context);
                    }
                }
                imageLoader = imageLoaderNewImageLoader;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private, obj, imageLoaderNewImageLoader)) {
                if (atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private) != obj) {
                    break;
                }
            }
            Intrinsics.d(imageLoaderNewImageLoader, "null cannot be cast to non-null type coil3.ImageLoader");
            return imageLoaderNewImageLoader;
            imageLoaderNewImageLoader = imageLoader;
        }
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void reset() {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, null);
    }

    @JvmStatic
    public static final void setSafe(@NotNull Factory factory) {
        Object obj = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        if (obj instanceof ImageLoader) {
            if (SingletonImageLoaderKt.isDefault((ImageLoader) obj)) {
                throw new IllegalStateException("The singleton image loader has already been created. This indicates that\n                    'setSafe' is being called after the first 'get' call. Ensure that 'setSafe' is\n                    called before any Coil API usages (e.g. `load`, `AsyncImage`,\n                    `rememberAsyncImagePainter`, etc.).");
            }
        } else {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
            SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private = singletonImageLoader$VolatileWrapper$atomicfu$private;
            while (!atomicReferenceFieldUpdater.compareAndSet(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private, obj, factory) && atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private) == obj) {
            }
        }
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void setUnsafe(@NotNull ImageLoader imageLoader) {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, imageLoader);
    }

    private final /* synthetic */ Object updateAndGet$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        Object objInvoke;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
            objInvoke = function1.invoke(obj2);
        } while (!android.support.v4.media.a.v(atomicReferenceFieldUpdater, obj, obj2, objInvoke));
        return objInvoke;
    }

    @JvmStatic
    @DelicateCoilApi
    public static final void setUnsafe(@NotNull Factory factory) {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, factory);
    }
}
