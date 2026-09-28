package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.FileSystems_nonJsCommonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class Options {

    @NotNull
    private final Context context;

    @Nullable
    private final String diskCacheKey;

    @NotNull
    private final CachePolicy diskCachePolicy;

    @NotNull
    private final Extras extras;

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final CachePolicy memoryCachePolicy;

    @NotNull
    private final CachePolicy networkCachePolicy;

    @NotNull
    private final Precision precision;

    @NotNull
    private final Scale scale;

    @NotNull
    private final Size size;

    public Options(@NotNull Context context, @NotNull Size size, @NotNull Scale scale, @NotNull Precision precision, @Nullable String str, @NotNull FileSystem fileSystem, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Extras extras) {
        this.context = context;
        this.size = size;
        this.scale = scale;
        this.precision = precision;
        this.diskCacheKey = str;
        this.fileSystem = fileSystem;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.extras = extras;
    }

    public static /* synthetic */ Options copy$default(Options options, Context context, Size size, Scale scale, Precision precision, String str, FileSystem fileSystem, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = options.context;
        }
        if ((i2 & 2) != 0) {
            size = options.size;
        }
        if ((i2 & 4) != 0) {
            scale = options.scale;
        }
        if ((i2 & 8) != 0) {
            precision = options.precision;
        }
        if ((i2 & 16) != 0) {
            str = options.diskCacheKey;
        }
        if ((i2 & 32) != 0) {
            fileSystem = options.fileSystem;
        }
        if ((i2 & 64) != 0) {
            cachePolicy = options.memoryCachePolicy;
        }
        if ((i2 & 128) != 0) {
            cachePolicy2 = options.diskCachePolicy;
        }
        if ((i2 & 256) != 0) {
            cachePolicy3 = options.networkCachePolicy;
        }
        if ((i2 & 512) != 0) {
            extras = options.extras;
        }
        CachePolicy cachePolicy4 = cachePolicy3;
        Extras extras2 = extras;
        CachePolicy cachePolicy5 = cachePolicy;
        CachePolicy cachePolicy6 = cachePolicy2;
        String str2 = str;
        FileSystem fileSystem2 = fileSystem;
        return options.copy(context, size, scale, precision, str2, fileSystem2, cachePolicy5, cachePolicy6, cachePolicy4, extras2);
    }

    @NotNull
    public final Options copy(@NotNull Context context, @NotNull Size size, @NotNull Scale scale, @NotNull Precision precision, @Nullable String str, @NotNull FileSystem fileSystem, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Extras extras) {
        return new Options(context, size, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, extras);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        return Intrinsics.b(this.context, options.context) && Intrinsics.b(this.size, options.size) && this.scale == options.scale && this.precision == options.precision && Intrinsics.b(this.diskCacheKey, options.diskCacheKey) && Intrinsics.b(this.fileSystem, options.fileSystem) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy && Intrinsics.b(this.extras, options.extras);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
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
    public final Extras getExtras() {
        return this.extras;
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
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
    public final Precision getPrecision() {
        return this.precision;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    public int hashCode() {
        int iHashCode = (this.precision.hashCode() + ((this.scale.hashCode() + ((this.size.hashCode() + (this.context.hashCode() * 31)) * 31)) * 31)) * 31;
        String str = this.diskCacheKey;
        return this.extras.hashCode() + ((this.networkCachePolicy.hashCode() + ((this.diskCachePolicy.hashCode() + ((this.memoryCachePolicy.hashCode() + ((this.fileSystem.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "Options(context=" + this.context + ", size=" + this.size + ", scale=" + this.scale + ", precision=" + this.precision + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", extras=" + this.extras + ')';
    }

    public /* synthetic */ Options(Context context, Size size, Scale scale, Precision precision, String str, FileSystem fileSystem, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? Size.ORIGINAL : size, (i2 & 4) != 0 ? Scale.FIT : scale, (i2 & 8) != 0 ? Precision.EXACT : precision, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? FileSystems_nonJsCommonKt.defaultFileSystem() : fileSystem, (i2 & 64) != 0 ? CachePolicy.ENABLED : cachePolicy, (i2 & 128) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i2 & 256) != 0 ? CachePolicy.ENABLED : cachePolicy3, (i2 & 512) != 0 ? Extras.EMPTY : extras);
    }
}
