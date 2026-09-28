package coil3;

import android.content.Context;
import androidx.media3.exoplayer.analytics.l;
import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Extras;
import coil3.RealImageLoader;
import coil3.disk.DiskCache;
import coil3.memory.MemoryCache;
import coil3.request.CachePolicy;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Precision;
import coil3.util.ContextsKt;
import coil3.util.Logger;
import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface ImageLoader {

    @Metadata
    public static final class Builder {

        @NotNull
        private final Context application;

        @Nullable
        private ComponentRegistry componentRegistry;

        @NotNull
        private ImageRequest.Defaults defaults;

        @Nullable
        private Lazy<? extends DiskCache> diskCacheLazy;

        @Nullable
        private EventListener.Factory eventListenerFactory;

        @NotNull
        private final Extras.Builder extras;

        @Nullable
        private Logger logger;

        @Nullable
        private Lazy<? extends MemoryCache> memoryCacheLazy;

        public Builder(@NotNull Context context) {
            this.application = ContextsKt.getApplication(context);
            this.defaults = ImageRequest.Defaults.DEFAULT;
            this.memoryCacheLazy = null;
            this.diskCacheLazy = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.logger = null;
            this.extras = new Extras.Builder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MemoryCache build$lambda$23(Builder builder) {
            return MemoryCache.Builder.maxSizePercent$default(new MemoryCache.Builder(), builder.application, 0.0d, 2, null).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image error$lambda$15(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EventListener eventListener$lambda$6(EventListener eventListener, ImageRequest imageRequest) {
            return eventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image fallback$lambda$17(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image placeholder$lambda$13(Image image, ImageRequest imageRequest) {
            return image;
        }

        @NotNull
        public final ImageLoader build() {
            Context context = this.application;
            ImageRequest.Defaults defaultsCopy$default = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, null, null, this.extras.build(), 2047, null);
            Lazy<? extends MemoryCache> lazyB = this.memoryCacheLazy;
            if (lazyB == null) {
                lazyB = LazyKt.b(new defpackage.b(this, 3));
            }
            Lazy<? extends DiskCache> lazyB2 = this.diskCacheLazy;
            if (lazyB2 == null) {
                lazyB2 = LazyKt.b(new d(0));
            }
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            ComponentRegistry componentRegistry = this.componentRegistry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(new RealImageLoader.Options(context, defaultsCopy$default, lazyB, lazyB2, factory, componentRegistry, this.logger));
        }

        public final /* synthetic */ Builder components(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return components(builder.build());
        }

        @NotNull
        public final Builder coroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, coroutineContext, coroutineContext, coroutineContext, null, null, null, null, null, null, null, null, 4081, null);
            return this;
        }

        @NotNull
        public final Builder decoderCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, coroutineContext, null, null, null, null, null, null, null, null, 4087, null);
            return this;
        }

        @NotNull
        public final Builder diskCache(@Nullable DiskCache diskCache) {
            this.diskCacheLazy = new InitializedLazyImpl(diskCache);
            return this;
        }

        @NotNull
        public final Builder diskCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, cachePolicy, null, null, null, null, null, null, 4063, null);
            return this;
        }

        @NotNull
        public final Builder error(@Nullable Image image) {
            return error(new e(image, 0));
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            return eventListenerFactory(new l(eventListener, 3));
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory factory) {
            this.eventListenerFactory = factory;
            return this;
        }

        @NotNull
        public final Builder fallback(@Nullable Image image) {
            return fallback(new e(image, 1));
        }

        @NotNull
        public final Builder fetcherCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, coroutineContext, null, null, null, null, null, null, null, null, null, 4091, null);
            return this;
        }

        @NotNull
        public final Builder fileSystem(@NotNull FileSystem fileSystem) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, fileSystem, null, null, null, null, null, null, null, null, null, null, null, 4094, null);
            return this;
        }

        @NotNull
        public final Extras.Builder getExtras() {
            return this.extras;
        }

        @NotNull
        public final Builder interceptorCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, coroutineContext, null, null, null, null, null, null, null, null, null, null, 4093, null);
            return this;
        }

        @NotNull
        public final Builder logger(@Nullable Logger logger) {
            this.logger = logger;
            return this;
        }

        @NotNull
        public final Builder memoryCache(@Nullable MemoryCache memoryCache) {
            this.memoryCacheLazy = new InitializedLazyImpl(memoryCache);
            return this;
        }

        @NotNull
        public final Builder memoryCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, cachePolicy, null, null, null, null, null, null, null, 4079, null);
            return this;
        }

        @NotNull
        public final Builder networkCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, cachePolicy, null, null, null, null, null, 4031, null);
            return this;
        }

        @NotNull
        public final Builder placeholder(@Nullable Image image) {
            return placeholder(new e(image, 2));
        }

        @NotNull
        public final Builder precision(@NotNull Precision precision) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, null, precision, null, 3071, null);
            return this;
        }

        @NotNull
        public final Builder components(@NotNull ComponentRegistry componentRegistry) {
            this.componentRegistry = componentRegistry;
            return this;
        }

        @NotNull
        public final Builder error(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, function1, null, null, null, 3839, null);
            return this;
        }

        @NotNull
        public final Builder fallback(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, null, null, function1, null, null, 3583, null);
            return this;
        }

        @NotNull
        public final Builder placeholder(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, null, null, null, null, null, null, null, function1, null, null, null, null, 3967, null);
            return this;
        }

        @NotNull
        public final Builder diskCache(@NotNull Function0<? extends DiskCache> function0) {
            this.diskCacheLazy = LazyKt.b(function0);
            return this;
        }

        @NotNull
        public final Builder memoryCache(@NotNull Function0<? extends MemoryCache> function0) {
            this.memoryCacheLazy = LazyKt.b(function0);
            return this;
        }

        public Builder(@NotNull RealImageLoader.Options options) {
            this.application = options.getApplication();
            this.defaults = options.getDefaults();
            this.memoryCacheLazy = options.getMemoryCacheLazy();
            this.diskCacheLazy = options.getDiskCacheLazy();
            this.eventListenerFactory = options.getEventListenerFactory();
            this.componentRegistry = options.getComponentRegistry();
            this.logger = options.getLogger();
            this.extras = options.getDefaults().getExtras().newBuilder();
        }
    }

    @NotNull
    Disposable enqueue(@NotNull ImageRequest imageRequest);

    @Nullable
    Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation);

    @NotNull
    ComponentRegistry getComponents();

    @NotNull
    ImageRequest.Defaults getDefaults();

    @Nullable
    DiskCache getDiskCache();

    @Nullable
    MemoryCache getMemoryCache();

    @NotNull
    Builder newBuilder();

    void shutdown();
}
