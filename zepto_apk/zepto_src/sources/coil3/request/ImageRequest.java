package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.Image;
import coil3.decode.Decoder;
import coil3.e;
import coil3.fetch.Fetcher;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.size.SizeResolver;
import coil3.size.SizeResolverKt;
import coil3.target.Target;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.Coroutines_nonJsCommonKt;
import coil3.util.FileSystems_nonJsCommonKt;
import coil3.util.UtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.KEYRecord;

@Metadata
/* loaded from: classes.dex */
public final class ImageRequest {

    @NotNull
    private final Context context;

    @NotNull
    private final Object data;

    @NotNull
    private final CoroutineContext decoderCoroutineContext;

    @Nullable
    private final Decoder.Factory decoderFactory;

    @NotNull
    private final Defaults defaults;

    @NotNull
    private final Defined defined;

    @Nullable
    private final String diskCacheKey;

    @NotNull
    private final CachePolicy diskCachePolicy;

    @NotNull
    private final Function1<ImageRequest, Image> errorFactory;

    @NotNull
    private final Extras extras;

    @NotNull
    private final Function1<ImageRequest, Image> fallbackFactory;

    @NotNull
    private final CoroutineContext fetcherCoroutineContext;

    @Nullable
    private final Pair<Fetcher.Factory<?>, KClass<?>> fetcherFactory;

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final CoroutineContext interceptorCoroutineContext;

    @Nullable
    private final Listener listener;

    @Nullable
    private final String memoryCacheKey;

    @NotNull
    private final Map<String, String> memoryCacheKeyExtras;

    @NotNull
    private final CachePolicy memoryCachePolicy;

    @NotNull
    private final CachePolicy networkCachePolicy;

    @NotNull
    private final Function1<ImageRequest, Image> placeholderFactory;

    @Nullable
    private final MemoryCache.Key placeholderMemoryCacheKey;

    @NotNull
    private final Precision precision;

    @NotNull
    private final Scale scale;

    @NotNull
    private final SizeResolver sizeResolver;

    @Nullable
    private final Target target;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        @NotNull
        private final Context context;

        @Nullable
        private Object data;

        @Nullable
        private CoroutineContext decoderCoroutineContext;

        @Nullable
        private Decoder.Factory decoderFactory;

        @NotNull
        private Defaults defaults;

        @Nullable
        private String diskCacheKey;

        @Nullable
        private CachePolicy diskCachePolicy;

        @Nullable
        private Function1<? super ImageRequest, ? extends Image> errorFactory;

        @Nullable
        private Function1<? super ImageRequest, ? extends Image> fallbackFactory;

        @Nullable
        private CoroutineContext fetcherCoroutineContext;

        @Nullable
        private Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> fetcherFactory;

        @Nullable
        private FileSystem fileSystem;

        @Nullable
        private CoroutineContext interceptorCoroutineContext;

        @NotNull
        private Object lazyExtras;

        @NotNull
        private Object lazyMemoryCacheKeyExtras;

        @Nullable
        private Listener listener;

        @Nullable
        private String memoryCacheKey;
        private boolean memoryCacheKeyExtrasAreMutable;

        @Nullable
        private CachePolicy memoryCachePolicy;

        @Nullable
        private CachePolicy networkCachePolicy;

        @Nullable
        private Function1<? super ImageRequest, ? extends Image> placeholderFactory;

        @Nullable
        private MemoryCache.Key placeholderMemoryCacheKey;

        @Nullable
        private Precision precision;

        @Nullable
        private Scale scale;

        @Nullable
        private SizeResolver sizeResolver;

        @Nullable
        private Target target;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest) {
            this(imageRequest, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image error$lambda$27(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image fallback$lambda$29(Image image, ImageRequest imageRequest) {
            return image;
        }

        private final Map<String, String> getMemoryCacheKeyExtras() {
            Object objN = this.lazyMemoryCacheKeyExtras;
            if (!Intrinsics.b(objN, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                if (!(objN instanceof Map)) {
                    throw new AssertionError();
                }
                objN = MapsKt.n((Map) objN);
                this.lazyMemoryCacheKeyExtras = objN;
                this.memoryCacheKeyExtrasAreMutable = true;
            }
            Intrinsics.d(objN, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            return TypeIntrinsics.a(objN);
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                function1 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$1
                    public final void invoke(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((ImageRequest) obj2);
                        return Unit.f53572a;
                    }
                };
            }
            if ((i2 & 2) != 0) {
                function12 = new Function1<ImageRequest, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$2
                    public final void invoke(ImageRequest imageRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((ImageRequest) obj2);
                        return Unit.f53572a;
                    }
                };
            }
            if ((i2 & 4) != 0) {
                function2 = new Function2<ImageRequest, ErrorResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$3
                    public final void invoke(ImageRequest imageRequest, ErrorResult errorResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((ImageRequest) obj2, (ErrorResult) obj3);
                        return Unit.f53572a;
                    }
                };
            }
            if ((i2 & 8) != 0) {
                function22 = new Function2<ImageRequest, SuccessResult, Unit>() { // from class: coil3.request.ImageRequest$Builder$listener$4
                    public final void invoke(ImageRequest imageRequest, SuccessResult successResult) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((ImageRequest) obj2, (SuccessResult) obj3);
                        return Unit.f53572a;
                    }
                };
            }
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Image placeholder$lambda$25(Image image, ImageRequest imageRequest) {
            return image;
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                function1 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$1
                    public final void invoke(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Image) obj2);
                        return Unit.f53572a;
                    }
                };
            }
            if ((i2 & 2) != 0) {
                function12 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$2
                    public final void invoke(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Image) obj2);
                        return Unit.f53572a;
                    }
                };
            }
            if ((i2 & 4) != 0) {
                function13 = new Function1<Image, Unit>() { // from class: coil3.request.ImageRequest$Builder$target$3
                    public final void invoke(Image image) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Image) obj2);
                        return Unit.f53572a;
                    }
                };
            }
            return builder.target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        @NotNull
        public final ImageRequest build() {
            Map immutableMap;
            Extras extrasBuild;
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            String str = this.memoryCacheKey;
            Object obj3 = this.lazyMemoryCacheKeyExtras;
            if (Intrinsics.b(obj3, Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                Intrinsics.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
                immutableMap = Collections_jvmCommonKt.toImmutableMap(TypeIntrinsics.a(obj3));
            } else {
                if (!(obj3 instanceof Map)) {
                    throw new AssertionError();
                }
                immutableMap = (Map) obj3;
            }
            Map map = immutableMap;
            Intrinsics.d(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            String str2 = this.diskCacheKey;
            FileSystem fileSystem = this.fileSystem;
            if (fileSystem == null) {
                fileSystem = this.defaults.getFileSystem();
            }
            FileSystem fileSystem2 = fileSystem;
            Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            CachePolicy memoryCachePolicy = this.memoryCachePolicy;
            if (memoryCachePolicy == null) {
                memoryCachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy = memoryCachePolicy;
            CachePolicy diskCachePolicy = this.diskCachePolicy;
            if (diskCachePolicy == null) {
                diskCachePolicy = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy2 = diskCachePolicy;
            CachePolicy networkCachePolicy = this.networkCachePolicy;
            if (networkCachePolicy == null) {
                networkCachePolicy = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy3 = networkCachePolicy;
            CoroutineContext interceptorCoroutineContext = this.interceptorCoroutineContext;
            if (interceptorCoroutineContext == null) {
                interceptorCoroutineContext = this.defaults.getInterceptorCoroutineContext();
            }
            CoroutineContext coroutineContext = interceptorCoroutineContext;
            CoroutineContext fetcherCoroutineContext = this.fetcherCoroutineContext;
            if (fetcherCoroutineContext == null) {
                fetcherCoroutineContext = this.defaults.getFetcherCoroutineContext();
            }
            CoroutineContext coroutineContext2 = fetcherCoroutineContext;
            CoroutineContext decoderCoroutineContext = this.decoderCoroutineContext;
            if (decoderCoroutineContext == null) {
                decoderCoroutineContext = this.defaults.getDecoderCoroutineContext();
            }
            CoroutineContext coroutineContext3 = decoderCoroutineContext;
            MemoryCache.Key key = this.placeholderMemoryCacheKey;
            Function1 placeholderFactory = this.placeholderFactory;
            if (placeholderFactory == null) {
                placeholderFactory = this.defaults.getPlaceholderFactory();
            }
            Function1 function1 = placeholderFactory;
            Function1 errorFactory = this.errorFactory;
            if (errorFactory == null) {
                errorFactory = this.defaults.getErrorFactory();
            }
            Function1 function12 = errorFactory;
            Function1 fallbackFactory = this.fallbackFactory;
            if (fallbackFactory == null) {
                fallbackFactory = this.defaults.getFallbackFactory();
            }
            Function1 function13 = fallbackFactory;
            SizeResolver sizeResolver = this.sizeResolver;
            if (sizeResolver == null) {
                sizeResolver = this.defaults.getSizeResolver();
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.scale;
            if (scale == null) {
                scale = this.defaults.getScale();
            }
            Scale scale2 = scale;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Object obj4 = this.lazyExtras;
            if (obj4 instanceof Extras.Builder) {
                extrasBuild = ((Extras.Builder) obj4).build();
            } else {
                if (!(obj4 instanceof Extras)) {
                    throw new AssertionError();
                }
                extrasBuild = (Extras) obj4;
            }
            return new ImageRequest(context, obj2, target, listener, str, map, str2, fileSystem2, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function12, function13, sizeResolver2, scale2, precision2, extrasBuild, new Defined(this.fileSystem, this.interceptorCoroutineContext, this.fetcherCoroutineContext, this.decoderCoroutineContext, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy, this.placeholderFactory, this.errorFactory, this.fallbackFactory, this.sizeResolver, this.scale, this.precision), this.defaults, null);
        }

        @NotNull
        public final Builder coroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext;
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        @NotNull
        public final Builder data(@Nullable Object obj) {
            this.data = obj;
            return this;
        }

        @NotNull
        public final Builder decoderCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        @NotNull
        public final Builder decoderFactory(@NotNull Decoder.Factory factory) {
            this.decoderFactory = factory;
            return this;
        }

        @NotNull
        public final Builder defaults(@NotNull Defaults defaults) {
            this.defaults = defaults;
            return this;
        }

        @NotNull
        public final Builder diskCacheKey(@Nullable String str) {
            this.diskCacheKey = str;
            return this;
        }

        @NotNull
        public final Builder diskCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder error(@Nullable Image image) {
            return error(new e(image, 4));
        }

        @NotNull
        public final Builder fallback(@Nullable Image image) {
            return fallback(new e(image, 3));
        }

        @NotNull
        public final Builder fetcherCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.fetcherCoroutineContext = coroutineContext;
            return this;
        }

        @NotNull
        public final <T> Builder fetcherFactory(@NotNull Fetcher.Factory<T> factory, @NotNull KClass<T> kClass) {
            this.fetcherFactory = new Pair<>(factory, kClass);
            return this;
        }

        @NotNull
        public final Builder fileSystem(@NotNull FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        @NotNull
        public final Extras.Builder getExtras() {
            Object obj = this.lazyExtras;
            if (obj instanceof Extras.Builder) {
                return (Extras.Builder) obj;
            }
            if (!(obj instanceof Extras)) {
                throw new AssertionError();
            }
            Extras.Builder builderNewBuilder = ((Extras) obj).newBuilder();
            this.lazyExtras = builderNewBuilder;
            return builderNewBuilder;
        }

        @NotNull
        public final Builder interceptorCoroutineContext(@NotNull CoroutineContext coroutineContext) {
            this.interceptorCoroutineContext = coroutineContext;
            return this;
        }

        @NotNull
        public final Builder listener(@NotNull Function1<? super ImageRequest, Unit> function1, @NotNull Function1<? super ImageRequest, Unit> function12, @NotNull Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, @NotNull Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable MemoryCache.Key key) {
            memoryCacheKey(key != null ? key.getKey() : null);
            Map<String, String> extras = key != null ? key.getExtras() : null;
            if (extras == null) {
                extras = MapsKt.c();
            }
            memoryCacheKeyExtras(extras);
            return this;
        }

        @NotNull
        public final Builder memoryCacheKeyExtra(@NotNull String str, @Nullable String str2) {
            if (str2 != null) {
                getMemoryCacheKeyExtras().put(str, str2);
                return this;
            }
            getMemoryCacheKeyExtras().remove(str);
            return this;
        }

        @NotNull
        public final Builder memoryCacheKeyExtras(@NotNull Map<String, String> map) {
            this.lazyMemoryCacheKeyExtras = MapsKt.n(map);
            this.memoryCacheKeyExtrasAreMutable = true;
            return this;
        }

        @NotNull
        public final Builder memoryCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder networkCachePolicy(@NotNull CachePolicy cachePolicy) {
            this.networkCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder placeholder(@Nullable Image image) {
            return placeholder(new coil3.disk.a(image, 1));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable String str) {
            MemoryCache.Key key = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (str != null) {
                key = new MemoryCache.Key(str, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
            }
            return placeholderMemoryCacheKey(key);
        }

        @NotNull
        public final Builder precision(@NotNull Precision precision) {
            this.precision = precision;
            return this;
        }

        @NotNull
        public final Builder scale(@NotNull Scale scale) {
            this.scale = scale;
            return this;
        }

        @NotNull
        public final Builder size(int i2) {
            return size(SizeKt.Size(i2, i2));
        }

        @NotNull
        public final Builder target(@NotNull Function1<? super Image, Unit> function1, @NotNull Function1<? super Image, Unit> function12, @NotNull Function1<? super Image, Unit> function13) {
            return target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public Builder(@NotNull Context context) {
            this.context = context;
            this.defaults = Defaults.DEFAULT;
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.lazyMemoryCacheKeyExtras = MapsKt.c();
            this.diskCacheKey = null;
            this.fileSystem = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.interceptorCoroutineContext = null;
            this.fetcherCoroutineContext = null;
            this.decoderCoroutineContext = null;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.errorFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.fallbackFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.sizeResolver = null;
            this.scale = null;
            this.precision = null;
            this.lazyExtras = Extras.EMPTY;
        }

        @NotNull
        public final Builder error(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.errorFactory = function1;
            return this;
        }

        @NotNull
        public final Builder fallback(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.fallbackFactory = function1;
            return this;
        }

        @NotNull
        public final Builder listener(@Nullable Listener listener) {
            this.listener = listener;
            return this;
        }

        @NotNull
        public final Builder placeholder(@NotNull Function1<? super ImageRequest, ? extends Image> function1) {
            this.placeholderFactory = function1;
            return this;
        }

        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable MemoryCache.Key key) {
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder size(int i2, int i3) {
            return size(SizeKt.Size(i2, i3));
        }

        @NotNull
        public final Builder target(@Nullable Target target) {
            this.target = target;
            return this;
        }

        public final <T> Builder fetcherFactory(Fetcher.Factory<T> factory) {
            Intrinsics.g();
            throw null;
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable String str) {
            this.memoryCacheKey = str;
            return this;
        }

        @NotNull
        public final Builder size(@NotNull Dimension dimension, @NotNull Dimension dimension2) {
            return size(new Size(dimension, dimension2));
        }

        @NotNull
        public final Builder size(@NotNull Size size) {
            return size(SizeResolverKt.SizeResolver(size));
        }

        @NotNull
        public final Builder size(@NotNull SizeResolver sizeResolver) {
            this.sizeResolver = sizeResolver;
            return this;
        }

        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest, @NotNull Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.lazyMemoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.fileSystem = imageRequest.getDefined().getFileSystem();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.interceptorCoroutineContext = imageRequest.getDefined().getInterceptorCoroutineContext();
            this.fetcherCoroutineContext = imageRequest.getDefined().getFetcherCoroutineContext();
            this.decoderCoroutineContext = imageRequest.getDefined().getDecoderCoroutineContext();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderFactory = imageRequest.getDefined().getPlaceholderFactory();
            this.errorFactory = imageRequest.getDefined().getErrorFactory();
            this.fallbackFactory = imageRequest.getDefined().getFallbackFactory();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.precision = imageRequest.getDefined().getPrecision();
            this.lazyExtras = imageRequest.getExtras();
        }

        public /* synthetic */ Builder(ImageRequest imageRequest, Context context, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i2 & 2) != 0 ? imageRequest.getContext() : context);
        }
    }

    @Metadata
    public static final class Defaults {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final Defaults DEFAULT = new Defaults(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);

        @NotNull
        private final CoroutineContext decoderCoroutineContext;

        @NotNull
        private final CachePolicy diskCachePolicy;

        @NotNull
        private final Function1<ImageRequest, Image> errorFactory;

        @NotNull
        private final Extras extras;

        @NotNull
        private final Function1<ImageRequest, Image> fallbackFactory;

        @NotNull
        private final CoroutineContext fetcherCoroutineContext;

        @NotNull
        private final FileSystem fileSystem;

        @NotNull
        private final CoroutineContext interceptorCoroutineContext;

        @NotNull
        private final CachePolicy memoryCachePolicy;

        @NotNull
        private final CachePolicy networkCachePolicy;

        @NotNull
        private final Function1<ImageRequest, Image> placeholderFactory;

        @NotNull
        private final Precision precision;

        @NotNull
        private final Scale scale;

        @NotNull
        private final SizeResolver sizeResolver;

        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Defaults() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public static /* synthetic */ Defaults copy$default(Defaults defaults, FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, Precision precision, Extras extras, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                fileSystem = defaults.fileSystem;
            }
            if ((i2 & 2) != 0) {
                coroutineContext = defaults.interceptorCoroutineContext;
            }
            if ((i2 & 4) != 0) {
                coroutineContext2 = defaults.fetcherCoroutineContext;
            }
            if ((i2 & 8) != 0) {
                coroutineContext3 = defaults.decoderCoroutineContext;
            }
            if ((i2 & 16) != 0) {
                cachePolicy = defaults.memoryCachePolicy;
            }
            if ((i2 & 32) != 0) {
                cachePolicy2 = defaults.diskCachePolicy;
            }
            if ((i2 & 64) != 0) {
                cachePolicy3 = defaults.networkCachePolicy;
            }
            if ((i2 & 128) != 0) {
                function1 = defaults.placeholderFactory;
            }
            if ((i2 & 256) != 0) {
                function12 = defaults.errorFactory;
            }
            if ((i2 & 512) != 0) {
                function13 = defaults.fallbackFactory;
            }
            if ((i2 & 1024) != 0) {
                precision = defaults.precision;
            }
            if ((i2 & 2048) != 0) {
                extras = defaults.extras;
            }
            Precision precision2 = precision;
            Extras extras2 = extras;
            Function1 function14 = function12;
            Function1 function15 = function13;
            CachePolicy cachePolicy4 = cachePolicy3;
            Function1 function16 = function1;
            CachePolicy cachePolicy5 = cachePolicy;
            CachePolicy cachePolicy6 = cachePolicy2;
            return defaults.copy(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy5, cachePolicy6, cachePolicy4, function16, function14, function15, precision2, extras2);
        }

        @NotNull
        public final Defaults copy(@NotNull FileSystem fileSystem, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2, @NotNull CoroutineContext coroutineContext3, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Function1<? super ImageRequest, ? extends Image> function1, @NotNull Function1<? super ImageRequest, ? extends Image> function12, @NotNull Function1<? super ImageRequest, ? extends Image> function13, @NotNull Precision precision, @NotNull Extras extras) {
            return new Defaults(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, null, null, precision, extras, 3072, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defaults)) {
                return false;
            }
            Defaults defaults = (Defaults) obj;
            return Intrinsics.b(this.fileSystem, defaults.fileSystem) && Intrinsics.b(this.interceptorCoroutineContext, defaults.interceptorCoroutineContext) && Intrinsics.b(this.fetcherCoroutineContext, defaults.fetcherCoroutineContext) && Intrinsics.b(this.decoderCoroutineContext, defaults.decoderCoroutineContext) && this.memoryCachePolicy == defaults.memoryCachePolicy && this.diskCachePolicy == defaults.diskCachePolicy && this.networkCachePolicy == defaults.networkCachePolicy && Intrinsics.b(this.placeholderFactory, defaults.placeholderFactory) && Intrinsics.b(this.errorFactory, defaults.errorFactory) && Intrinsics.b(this.fallbackFactory, defaults.fallbackFactory) && Intrinsics.b(this.sizeResolver, defaults.sizeResolver) && this.scale == defaults.scale && this.precision == defaults.precision && Intrinsics.b(this.extras, defaults.extras);
        }

        @NotNull
        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        @NotNull
        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        @NotNull
        public final Extras getExtras() {
            return this.extras;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        @NotNull
        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        @NotNull
        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        @NotNull
        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        @NotNull
        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        @NotNull
        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        @NotNull
        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        @NotNull
        public final Precision getPrecision() {
            return this.precision;
        }

        @NotNull
        public final Scale getScale() {
            return this.scale;
        }

        @NotNull
        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public int hashCode() {
            return this.extras.hashCode() + ((this.precision.hashCode() + ((this.scale.hashCode() + ((this.sizeResolver.hashCode() + ((this.fallbackFactory.hashCode() + ((this.errorFactory.hashCode() + ((this.placeholderFactory.hashCode() + ((this.networkCachePolicy.hashCode() + ((this.diskCachePolicy.hashCode() + ((this.memoryCachePolicy.hashCode() + ((this.decoderCoroutineContext.hashCode() + ((this.fetcherCoroutineContext.hashCode() + ((this.interceptorCoroutineContext.hashCode() + (this.fileSystem.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "Defaults(fileSystem=" + this.fileSystem + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Defaults(@NotNull FileSystem fileSystem, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2, @NotNull CoroutineContext coroutineContext3, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Function1<? super ImageRequest, ? extends Image> function1, @NotNull Function1<? super ImageRequest, ? extends Image> function12, @NotNull Function1<? super ImageRequest, ? extends Image> function13, @NotNull SizeResolver sizeResolver, @NotNull Scale scale, @NotNull Precision precision, @NotNull Extras extras) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
            this.extras = extras;
        }

        public /* synthetic */ Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? FileSystems_nonJsCommonKt.defaultFileSystem() : fileSystem, (i2 & 2) != 0 ? EmptyCoroutineContext.f53685a : coroutineContext, (i2 & 4) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext2, (i2 & 8) != 0 ? Coroutines_nonJsCommonKt.ioCoroutineDispatcher() : coroutineContext3, (i2 & 16) != 0 ? CachePolicy.ENABLED : cachePolicy, (i2 & 32) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i2 & 64) != 0 ? CachePolicy.ENABLED : cachePolicy3, (i2 & 128) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function1, (i2 & 256) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function12, (i2 & 512) != 0 ? UtilsKt.getEMPTY_IMAGE_FACTORY() : function13, (i2 & 1024) != 0 ? SizeResolver.ORIGINAL : sizeResolver, (i2 & 2048) != 0 ? Scale.FIT : scale, (i2 & 4096) != 0 ? Precision.EXACT : precision, (i2 & KEYRecord.Flags.FLAG2) != 0 ? Extras.EMPTY : extras);
        }
    }

    @Metadata
    public static final class Defined {

        @Nullable
        private final CoroutineContext decoderCoroutineContext;

        @Nullable
        private final CachePolicy diskCachePolicy;

        @Nullable
        private final Function1<ImageRequest, Image> errorFactory;

        @Nullable
        private final Function1<ImageRequest, Image> fallbackFactory;

        @Nullable
        private final CoroutineContext fetcherCoroutineContext;

        @Nullable
        private final FileSystem fileSystem;

        @Nullable
        private final CoroutineContext interceptorCoroutineContext;

        @Nullable
        private final CachePolicy memoryCachePolicy;

        @Nullable
        private final CachePolicy networkCachePolicy;

        @Nullable
        private final Function1<ImageRequest, Image> placeholderFactory;

        @Nullable
        private final Precision precision;

        @Nullable
        private final Scale scale;

        @Nullable
        private final SizeResolver sizeResolver;

        /* JADX WARN: Multi-variable type inference failed */
        public Defined(@Nullable FileSystem fileSystem, @Nullable CoroutineContext coroutineContext, @Nullable CoroutineContext coroutineContext2, @Nullable CoroutineContext coroutineContext3, @Nullable CachePolicy cachePolicy, @Nullable CachePolicy cachePolicy2, @Nullable CachePolicy cachePolicy3, @Nullable Function1<? super ImageRequest, ? extends Image> function1, @Nullable Function1<? super ImageRequest, ? extends Image> function12, @Nullable Function1<? super ImageRequest, ? extends Image> function13, @Nullable SizeResolver sizeResolver, @Nullable Scale scale, @Nullable Precision precision) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
        }

        public static /* synthetic */ Defined copy$default(Defined defined, FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                fileSystem = defined.fileSystem;
            }
            return defined.copy(fileSystem, (i2 & 2) != 0 ? defined.interceptorCoroutineContext : coroutineContext, (i2 & 4) != 0 ? defined.fetcherCoroutineContext : coroutineContext2, (i2 & 8) != 0 ? defined.decoderCoroutineContext : coroutineContext3, (i2 & 16) != 0 ? defined.memoryCachePolicy : cachePolicy, (i2 & 32) != 0 ? defined.diskCachePolicy : cachePolicy2, (i2 & 64) != 0 ? defined.networkCachePolicy : cachePolicy3, (i2 & 128) != 0 ? defined.placeholderFactory : function1, (i2 & 256) != 0 ? defined.errorFactory : function12, (i2 & 512) != 0 ? defined.fallbackFactory : function13, (i2 & 1024) != 0 ? defined.sizeResolver : sizeResolver, (i2 & 2048) != 0 ? defined.scale : scale, (i2 & 4096) != 0 ? defined.precision : precision);
        }

        @NotNull
        public final Defined copy(@Nullable FileSystem fileSystem, @Nullable CoroutineContext coroutineContext, @Nullable CoroutineContext coroutineContext2, @Nullable CoroutineContext coroutineContext3, @Nullable CachePolicy cachePolicy, @Nullable CachePolicy cachePolicy2, @Nullable CachePolicy cachePolicy3, @Nullable Function1<? super ImageRequest, ? extends Image> function1, @Nullable Function1<? super ImageRequest, ? extends Image> function12, @Nullable Function1<? super ImageRequest, ? extends Image> function13, @Nullable SizeResolver sizeResolver, @Nullable Scale scale, @Nullable Precision precision) {
            return new Defined(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, sizeResolver, scale, precision);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defined)) {
                return false;
            }
            Defined defined = (Defined) obj;
            return Intrinsics.b(this.fileSystem, defined.fileSystem) && Intrinsics.b(this.interceptorCoroutineContext, defined.interceptorCoroutineContext) && Intrinsics.b(this.fetcherCoroutineContext, defined.fetcherCoroutineContext) && Intrinsics.b(this.decoderCoroutineContext, defined.decoderCoroutineContext) && this.memoryCachePolicy == defined.memoryCachePolicy && this.diskCachePolicy == defined.diskCachePolicy && this.networkCachePolicy == defined.networkCachePolicy && Intrinsics.b(this.placeholderFactory, defined.placeholderFactory) && Intrinsics.b(this.errorFactory, defined.errorFactory) && Intrinsics.b(this.fallbackFactory, defined.fallbackFactory) && Intrinsics.b(this.sizeResolver, defined.sizeResolver) && this.scale == defined.scale && this.precision == defined.precision;
        }

        @Nullable
        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        @Nullable
        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        @Nullable
        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        @Nullable
        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        @Nullable
        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        @Nullable
        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        @Nullable
        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        @Nullable
        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        @Nullable
        public final Precision getPrecision() {
            return this.precision;
        }

        @Nullable
        public final Scale getScale() {
            return this.scale;
        }

        @Nullable
        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public int hashCode() {
            FileSystem fileSystem = this.fileSystem;
            int iHashCode = (fileSystem == null ? 0 : fileSystem.hashCode()) * 31;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            int iHashCode2 = (iHashCode + (coroutineContext == null ? 0 : coroutineContext.hashCode())) * 31;
            CoroutineContext coroutineContext2 = this.fetcherCoroutineContext;
            int iHashCode3 = (iHashCode2 + (coroutineContext2 == null ? 0 : coroutineContext2.hashCode())) * 31;
            CoroutineContext coroutineContext3 = this.decoderCoroutineContext;
            int iHashCode4 = (iHashCode3 + (coroutineContext3 == null ? 0 : coroutineContext3.hashCode())) * 31;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            int iHashCode5 = (iHashCode4 + (cachePolicy == null ? 0 : cachePolicy.hashCode())) * 31;
            CachePolicy cachePolicy2 = this.diskCachePolicy;
            int iHashCode6 = (iHashCode5 + (cachePolicy2 == null ? 0 : cachePolicy2.hashCode())) * 31;
            CachePolicy cachePolicy3 = this.networkCachePolicy;
            int iHashCode7 = (iHashCode6 + (cachePolicy3 == null ? 0 : cachePolicy3.hashCode())) * 31;
            Function1<ImageRequest, Image> function1 = this.placeholderFactory;
            int iHashCode8 = (iHashCode7 + (function1 == null ? 0 : function1.hashCode())) * 31;
            Function1<ImageRequest, Image> function12 = this.errorFactory;
            int iHashCode9 = (iHashCode8 + (function12 == null ? 0 : function12.hashCode())) * 31;
            Function1<ImageRequest, Image> function13 = this.fallbackFactory;
            int iHashCode10 = (iHashCode9 + (function13 == null ? 0 : function13.hashCode())) * 31;
            SizeResolver sizeResolver = this.sizeResolver;
            int iHashCode11 = (iHashCode10 + (sizeResolver == null ? 0 : sizeResolver.hashCode())) * 31;
            Scale scale = this.scale;
            int iHashCode12 = (iHashCode11 + (scale == null ? 0 : scale.hashCode())) * 31;
            Precision precision = this.precision;
            return iHashCode12 + (precision != null ? precision.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Defined(fileSystem=" + this.fileSystem + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ')';
        }
    }

    @Metadata
    public interface Listener {
        default void onCancel(@NotNull ImageRequest imageRequest) {
        }

        default void onError(@NotNull ImageRequest imageRequest, @NotNull ErrorResult errorResult) {
        }

        default void onStart(@NotNull ImageRequest imageRequest) {
        }

        default void onSuccess(@NotNull ImageRequest imageRequest, @NotNull SuccessResult successResult) {
        }
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map map, String str2, FileSystem fileSystem, Pair pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, str, map, str2, fileSystem, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function12, function13, sizeResolver, scale, precision, extras, defined, defaults);
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.b(this.context, imageRequest.context) && Intrinsics.b(this.data, imageRequest.data) && Intrinsics.b(this.target, imageRequest.target) && Intrinsics.b(this.listener, imageRequest.listener) && Intrinsics.b(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.b(this.memoryCacheKeyExtras, imageRequest.memoryCacheKeyExtras) && Intrinsics.b(this.diskCacheKey, imageRequest.diskCacheKey) && Intrinsics.b(this.fileSystem, imageRequest.fileSystem) && Intrinsics.b(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.b(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.b(this.interceptorCoroutineContext, imageRequest.interceptorCoroutineContext) && Intrinsics.b(this.fetcherCoroutineContext, imageRequest.fetcherCoroutineContext) && Intrinsics.b(this.decoderCoroutineContext, imageRequest.decoderCoroutineContext) && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.b(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.b(this.placeholderFactory, imageRequest.placeholderFactory) && Intrinsics.b(this.errorFactory, imageRequest.errorFactory) && Intrinsics.b(this.fallbackFactory, imageRequest.fallbackFactory) && Intrinsics.b(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.precision == imageRequest.precision && Intrinsics.b(this.extras, imageRequest.extras) && Intrinsics.b(this.defined, imageRequest.defined) && Intrinsics.b(this.defaults, imageRequest.defaults);
    }

    @Nullable
    public final Image error() {
        Image image = (Image) this.errorFactory.invoke(this);
        return image == null ? (Image) this.defaults.getErrorFactory().invoke(this) : image;
    }

    @Nullable
    public final Image fallback() {
        Image image = (Image) this.fallbackFactory.invoke(this);
        return image == null ? (Image) this.defaults.getFallbackFactory().invoke(this) : image;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final CoroutineContext getDecoderCoroutineContext() {
        return this.decoderCoroutineContext;
    }

    @Nullable
    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    @NotNull
    public final Defaults getDefaults() {
        return this.defaults;
    }

    @NotNull
    public final Defined getDefined() {
        return this.defined;
    }

    @Nullable
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    @NotNull
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getErrorFactory() {
        return this.errorFactory;
    }

    @NotNull
    public final Extras getExtras() {
        return this.extras;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getFallbackFactory() {
        return this.fallbackFactory;
    }

    @NotNull
    public final CoroutineContext getFetcherCoroutineContext() {
        return this.fetcherCoroutineContext;
    }

    @Nullable
    public final Pair<Fetcher.Factory<?>, KClass<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @NotNull
    public final CoroutineContext getInterceptorCoroutineContext() {
        return this.interceptorCoroutineContext;
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    @Nullable
    public final String getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    @NotNull
    public final Map<String, String> getMemoryCacheKeyExtras() {
        return this.memoryCacheKeyExtras;
    }

    @NotNull
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @NotNull
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @NotNull
    public final Function1<ImageRequest, Image> getPlaceholderFactory() {
        return this.placeholderFactory;
    }

    @Nullable
    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    @NotNull
    public final Precision getPrecision() {
        return this.precision;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @NotNull
    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    @Nullable
    public final Target getTarget() {
        return this.target;
    }

    public int hashCode() {
        int iHashCode = (this.data.hashCode() + (this.context.hashCode() * 31)) * 31;
        Target target = this.target;
        int iHashCode2 = (iHashCode + (target == null ? 0 : target.hashCode())) * 31;
        Listener listener = this.listener;
        int iHashCode3 = (iHashCode2 + (listener == null ? 0 : listener.hashCode())) * 31;
        String str = this.memoryCacheKey;
        int iHashCode4 = (this.memoryCacheKeyExtras.hashCode() + ((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.diskCacheKey;
        int iHashCode5 = (this.fileSystem.hashCode() + ((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        Pair<Fetcher.Factory<?>, KClass<?>> pair = this.fetcherFactory;
        int iHashCode6 = (iHashCode5 + (pair == null ? 0 : pair.hashCode())) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int iHashCode7 = (this.networkCachePolicy.hashCode() + ((this.diskCachePolicy.hashCode() + ((this.memoryCachePolicy.hashCode() + ((this.decoderCoroutineContext.hashCode() + ((this.fetcherCoroutineContext.hashCode() + ((this.interceptorCoroutineContext.hashCode() + ((iHashCode6 + (factory == null ? 0 : factory.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        MemoryCache.Key key = this.placeholderMemoryCacheKey;
        return this.defaults.hashCode() + ((this.defined.hashCode() + ((this.extras.hashCode() + ((this.precision.hashCode() + ((this.scale.hashCode() + ((this.sizeResolver.hashCode() + ((this.fallbackFactory.hashCode() + ((this.errorFactory.hashCode() + ((this.placeholderFactory.hashCode() + ((iHashCode7 + (key != null ? key.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @JvmOverloads
    @NotNull
    public final Builder newBuilder() {
        return newBuilder$default(this, null, 1, null);
    }

    @Nullable
    public final Image placeholder() {
        Image image = (Image) this.placeholderFactory.invoke(this);
        return image == null ? (Image) this.defaults.getPlaceholderFactory().invoke(this) : image;
    }

    @NotNull
    public String toString() {
        return "ImageRequest(context=" + this.context + ", data=" + this.data + ", target=" + this.target + ", listener=" + this.listener + ", memoryCacheKey=" + this.memoryCacheKey + ", memoryCacheKeyExtras=" + this.memoryCacheKeyExtras + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", fetcherFactory=" + this.fetcherFactory + ", decoderFactory=" + this.decoderFactory + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderMemoryCacheKey=" + this.placeholderMemoryCacheKey + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + ", defined=" + this.defined + ", defaults=" + this.defaults + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImageRequest(Context context, Object obj, Target target, Listener listener, String str, Map<String, String> map, String str2, FileSystem fileSystem, Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = str;
        this.memoryCacheKeyExtras = map;
        this.diskCacheKey = str2;
        this.fileSystem = fileSystem;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.interceptorCoroutineContext = coroutineContext;
        this.fetcherCoroutineContext = coroutineContext2;
        this.decoderCoroutineContext = coroutineContext3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderMemoryCacheKey = key;
        this.placeholderFactory = function1;
        this.errorFactory = function12;
        this.fallbackFactory = function13;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.precision = precision;
        this.extras = extras;
        this.defined = defined;
        this.defaults = defaults;
    }

    @JvmOverloads
    @NotNull
    public final Builder newBuilder(@NotNull Context context) {
        return new Builder(this, context);
    }
}
