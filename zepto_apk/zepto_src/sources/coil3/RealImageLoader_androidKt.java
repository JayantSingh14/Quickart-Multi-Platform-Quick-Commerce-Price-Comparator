package coil3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import coil3.ComponentRegistry;
import coil3.RealImageLoader;
import coil3.decode.BitmapFactoryDecoder;
import coil3.decode.ExifOrientationStrategy;
import coil3.decode.StaticImageDecoder;
import coil3.fetch.AssetUriFetcher;
import coil3.fetch.BitmapFetcher;
import coil3.fetch.ContentUriFetcher;
import coil3.fetch.DrawableFetcher;
import coil3.fetch.ResourceUriFetcher;
import coil3.key.AndroidResourceUriKeyer;
import coil3.map.AndroidUriMapper;
import coil3.map.ResourceIntMapper;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.OneShotDisposable;
import coil3.request.ViewTargetRequestManagerKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealImageLoader_androidKt {
    @NotNull
    public static final ComponentRegistry.Builder addAndroidComponents(@NotNull ComponentRegistry.Builder builder, @NotNull RealImageLoader.Options options) {
        builder.add(new AndroidUriMapper(), Reflection.a(android.net.Uri.class));
        builder.add(new ResourceIntMapper(), Reflection.a(Integer.class));
        builder.add(new AndroidResourceUriKeyer(), Reflection.a(Uri.class));
        builder.add(new AssetUriFetcher.Factory(), Reflection.a(Uri.class));
        builder.add(new ContentUriFetcher.Factory(), Reflection.a(Uri.class));
        builder.add(new ResourceUriFetcher.Factory(), Reflection.a(Uri.class));
        builder.add(new DrawableFetcher.Factory(), Reflection.a(Drawable.class));
        builder.add(new BitmapFetcher.Factory(), Reflection.a(Bitmap.class));
        Semaphore semaphoreA = SemaphoreKt.a(ImageLoaders_androidKt.getBitmapFactoryMaxParallelism(options));
        if (enableStaticImageDecoder(options)) {
            builder.add(new StaticImageDecoder.Factory(semaphoreA));
        }
        builder.add(new BitmapFactoryDecoder.Factory(semaphoreA, ImageLoaders_androidKt.getBitmapFactoryExifOrientationStrategy(options)));
        return builder;
    }

    private static final boolean enableStaticImageDecoder(RealImageLoader.Options options) {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        ExifOrientationStrategy bitmapFactoryExifOrientationStrategy = ImageLoaders_androidKt.getBitmapFactoryExifOrientationStrategy(options);
        return Intrinsics.b(bitmapFactoryExifOrientationStrategy, ExifOrientationStrategy.RESPECT_PERFORMANCE) || Intrinsics.b(bitmapFactoryExifOrientationStrategy, ExifOrientationStrategy.RESPECT_ALL);
    }

    @NotNull
    public static final Disposable getDisposable(@NotNull ImageRequest imageRequest, @NotNull Deferred<? extends ImageResult> deferred) {
        return imageRequest.getTarget() instanceof ViewTarget ? ViewTargetRequestManagerKt.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView()).getDisposable(deferred) : new OneShotDisposable(deferred);
    }

    public static final boolean needsExecuteOnMainDispatcher(@NotNull ImageRequest imageRequest) {
        return (imageRequest.getTarget() instanceof ViewTarget) || ImageRequests_androidKt.getLifecycle(imageRequest) != null;
    }

    public static final void transition(@NotNull ImageResult imageResult, @Nullable Target target, @NotNull EventListener eventListener, @NotNull Function0<Unit> function0) {
        if (!(target instanceof TransitionTarget)) {
            function0.invoke();
            return;
        }
        Transition transitionCreate = ImageRequests_androidKt.getTransitionFactory(imageResult.getRequest()).create((TransitionTarget) target, imageResult);
        if (transitionCreate instanceof NoneTransition) {
            function0.invoke();
            return;
        }
        eventListener.transitionStart(imageResult.getRequest(), transitionCreate);
        transitionCreate.transition();
        eventListener.transitionEnd(imageResult.getRequest(), transitionCreate);
    }
}
