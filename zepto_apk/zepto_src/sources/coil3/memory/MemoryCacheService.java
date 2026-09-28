package coil3.memory;

import coil3.EventListener;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.decode.DecodeUtils;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.request.SuccessResult;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.Logger;
import coil3.util.UtilsKt;
import com.google.android.gms.common.api.Api;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MemoryCacheService {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";

    @NotNull
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";

    @NotNull
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";

    @NotNull
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";

    @NotNull
    private static final String TAG = "MemoryCacheService";

    @NotNull
    private final ImageLoader imageLoader;

    @Nullable
    private final Logger logger;

    @NotNull
    private final RequestService requestService;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MemoryCacheService(@NotNull ImageLoader imageLoader, @NotNull RequestService requestService, @Nullable Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean isSizeValid(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        String str;
        double d2;
        double d3;
        boolean zIsSampled = isSampled(value);
        if (SizeKt.isOriginal(size)) {
            if (!zIsSampled) {
                return true;
            }
            Logger logger = this.logger;
            if (logger != null) {
                Logger.Level level = Logger.Level.Debug;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(TAG, level, imageRequest.getData() + ": Requested original size, but cached image is sampled.", null);
                }
            }
            return false;
        }
        String str2 = key.getExtras().get(EXTRA_TRANSFORMATION_SIZE);
        if (str2 != null) {
            return str2.equals(size.toString());
        }
        int width = value.getImage().getWidth();
        int height = value.getImage().getHeight();
        Dimension width2 = size.getWidth();
        boolean z = width2 instanceof Dimension.Pixels;
        int iM42unboximpl = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iM42unboximpl2 = z ? ((Dimension.Pixels) width2).m42unboximpl() : Integer.MAX_VALUE;
        Dimension height2 = size.getHeight();
        if (height2 instanceof Dimension.Pixels) {
            iM42unboximpl = ((Dimension.Pixels) height2).m42unboximpl();
        }
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, iM42unboximpl2, iM42unboximpl, scale);
        boolean z2 = imageRequest.getPrecision() == Precision.INEXACT;
        if (!z2) {
            str = TAG;
            d2 = 1.0d;
            if ((!UtilsKt.isMinOrMax(iM42unboximpl2) && Math.abs(iM42unboximpl2 - width) > 1) || (!UtilsKt.isMinOrMax(iM42unboximpl) && Math.abs(iM42unboximpl - height) > 1)) {
            }
            return true;
        }
        if (dComputeSizeMultiplier > 1.0d) {
            d2 = 1.0d;
            d3 = 1.0d;
        } else {
            d3 = dComputeSizeMultiplier;
            d2 = 1.0d;
        }
        str = TAG;
        if (Math.abs(iM42unboximpl2 - (width * d3)) <= d2 || Math.abs(iM42unboximpl - (d3 * height)) <= d2) {
            return true;
        }
        if (dComputeSizeMultiplier != d2 && !z2) {
            Logger logger2 = this.logger;
            if (logger2 != null) {
                Logger.Level level2 = Logger.Level.Debug;
                if (logger2.getMinLevel().compareTo(level2) <= 0) {
                    logger2.log(str, level2, imageRequest.getData() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
                }
            }
            return false;
        }
        String str3 = str;
        if (dComputeSizeMultiplier > d2 && zIsSampled) {
            Logger logger3 = this.logger;
            if (logger3 != null) {
                Logger.Level level3 = Logger.Level.Debug;
                if (logger3.getMinLevel().compareTo(level3) <= 0) {
                    logger3.log(str3, level3, imageRequest.getData() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final MemoryCache.Value getCacheValue(@NotNull ImageRequest imageRequest, @NotNull MemoryCache.Key key, @NotNull Size size, @NotNull Scale scale) {
        if (!imageRequest.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(key) : null;
        if (value == null || !isCacheValueValid$coil_core_release(imageRequest, key, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_core_release(@NotNull ImageRequest imageRequest, @NotNull MemoryCache.Key key, @NotNull MemoryCache.Value value, @NotNull Size size, @NotNull Scale scale) {
        if (this.requestService.isCacheValueValidForHardware(imageRequest, value)) {
            return isSizeValid(imageRequest, key, value, size, scale);
        }
        Logger logger = this.logger;
        if (logger == null) {
            return false;
        }
        Logger.Level level = Logger.Level.Debug;
        if (logger.getMinLevel().compareTo(level) > 0) {
            return false;
        }
        logger.log(TAG, level, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
        return false;
    }

    @Nullable
    public final MemoryCache.Key newCacheKey(@NotNull ImageRequest imageRequest, @NotNull Object obj, @NotNull Options options, @NotNull EventListener eventListener) {
        if (imageRequest.getMemoryCacheKey() != null) {
            return new MemoryCache.Key(imageRequest.getMemoryCacheKey(), imageRequest.getMemoryCacheKeyExtras());
        }
        eventListener.keyStart(imageRequest, obj);
        String strKey = this.imageLoader.getComponents().key(obj, options);
        eventListener.keyEnd(imageRequest, strKey);
        if (strKey == null) {
            return null;
        }
        return new MemoryCache.Key(strKey, MemoryCacheServiceKt.createComplexMemoryCacheKeyExtras(imageRequest, options));
    }

    @NotNull
    public final SuccessResult newResult(@NotNull Interceptor.Chain chain, @NotNull ImageRequest imageRequest, @NotNull MemoryCache.Key key, @NotNull MemoryCache.Value value) {
        return new SuccessResult(value.getImage(), imageRequest, DataSource.MEMORY_CACHE, key, getDiskCacheKey(value), isSampled(value), UtilsKt.isPlaceholderCached(chain));
    }

    public final boolean setCacheValue(@Nullable MemoryCache.Key key, @NotNull ImageRequest imageRequest, @NotNull EngineInterceptor.ExecuteResult executeResult) {
        MemoryCache memoryCache;
        if (key == null || !imageRequest.getMemoryCachePolicy().getWriteEnabled() || !executeResult.getImage().getShareable() || (memoryCache = this.imageLoader.getMemoryCache()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EXTRA_IS_SAMPLED, Boolean.valueOf(executeResult.isSampled()));
        String diskCacheKey = executeResult.getDiskCacheKey();
        if (diskCacheKey != null) {
            linkedHashMap.put(EXTRA_DISK_CACHE_KEY, diskCacheKey);
        }
        memoryCache.set(key, new MemoryCache.Value(executeResult.getImage(), linkedHashMap));
        return true;
    }
}
