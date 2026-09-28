package coil3.util;

import androidx.fragment.app.e;
import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Image;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.Decoder;
import coil3.decode.a;
import coil3.fetch.Fetcher;
import coil3.intercept.Interceptor;
import coil3.intercept.RealInterceptorChain;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.SizeResolver;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UtilsKt {

    @NotNull
    private static final Function1<ImageRequest, Image> EMPTY_IMAGE_FACTORY = new Function1() { // from class: coil3.util.UtilsKt$EMPTY_IMAGE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(ImageRequest imageRequest) {
            return null;
        }
    };

    @NotNull
    public static final String MIME_TYPE_HEIC = "image/heic";

    @NotNull
    public static final String MIME_TYPE_HEIF = "image/heif";

    @NotNull
    public static final String MIME_TYPE_JPEG = "image/jpeg";

    @NotNull
    public static final String MIME_TYPE_WEBP = "image/webp";

    @NotNull
    public static final String MIME_TYPE_XML = "text/xml";

    @NotNull
    public static final String SCHEME_FILE = "file";

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final ErrorResult ErrorResult(@NotNull ImageRequest imageRequest, @NotNull Throwable th) {
        Image imageError;
        if (!(th instanceof NullRequestDataException) || (imageError = imageRequest.fallback()) == null) {
            imageError = imageRequest.error();
        }
        return new ErrorResult(imageError, imageRequest, th);
    }

    @NotNull
    public static final ComponentRegistry.Builder addFirst(@NotNull ComponentRegistry.Builder builder, @Nullable Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair) {
        if (pair != null) {
            builder.getLazyFetcherFactories$coil_core_release().add(0, new a(pair, 3));
        }
        return builder;
    }

    public static final void closeQuietly(@NotNull Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final Function1<ImageRequest, Image> getEMPTY_IMAGE_FACTORY() {
        return EMPTY_IMAGE_FACTORY;
    }

    @NotNull
    public static final String getEmoji(@NotNull DataSource dataSource) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return "🧠";
        }
        if (i2 == 3) {
            return "💾";
        }
        if (i2 == 4) {
            return "☁️";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final EventListener getEventListener(@NotNull Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    @NotNull
    public static final SizeResolver getSizeResolver(@NotNull Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getSizeResolver() : chain.getRequest().getSizeResolver();
    }

    public static final boolean isFileUri(@NotNull Uri uri) {
        return ((uri.getScheme() != null && !Intrinsics.b(uri.getScheme(), SCHEME_FILE)) || uri.getPath() == null || Utils_androidKt.isAssetUri(uri)) ? false : true;
    }

    public static final boolean isMinOrMax(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE;
    }

    public static final boolean isPlaceholderCached(@NotNull Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).isPlaceholderCached();
    }

    @NotNull
    public static final ComponentRegistry.Builder addFirst(@NotNull ComponentRegistry.Builder builder, @Nullable Decoder.Factory factory) {
        if (factory != null) {
            builder.getLazyDecoderFactories$coil_core_release().add(0, new a(factory, 4));
        }
        return builder;
    }

    public static final void closeQuietly(@NotNull AutoCloseable autoCloseable) {
        try {
            e.z(autoCloseable);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }
}
