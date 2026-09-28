package coil3.request;

import coil3.Image;
import coil3.decode.DataSource;
import coil3.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class SuccessResult implements ImageResult {

    @NotNull
    private final DataSource dataSource;

    @Nullable
    private final String diskCacheKey;

    @NotNull
    private final Image image;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;

    @Nullable
    private final MemoryCache.Key memoryCacheKey;

    @NotNull
    private final ImageRequest request;

    public SuccessResult(@NotNull Image image, @NotNull ImageRequest imageRequest, @NotNull DataSource dataSource, @Nullable MemoryCache.Key key, @Nullable String str, boolean z, boolean z2) {
        this.image = image;
        this.request = imageRequest;
        this.dataSource = dataSource;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            image = successResult.getImage();
        }
        if ((i2 & 2) != 0) {
            imageRequest = successResult.getRequest();
        }
        if ((i2 & 4) != 0) {
            dataSource = successResult.dataSource;
        }
        if ((i2 & 8) != 0) {
            key = successResult.memoryCacheKey;
        }
        if ((i2 & 16) != 0) {
            str = successResult.diskCacheKey;
        }
        if ((i2 & 32) != 0) {
            z = successResult.isSampled;
        }
        if ((i2 & 64) != 0) {
            z2 = successResult.isPlaceholderCached;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str2 = str;
        DataSource dataSource2 = dataSource;
        return successResult.copy(image, imageRequest, dataSource2, key, str2, z3, z4);
    }

    @NotNull
    public final SuccessResult copy(@NotNull Image image, @NotNull ImageRequest imageRequest, @NotNull DataSource dataSource, @Nullable MemoryCache.Key key, @Nullable String str, boolean z, boolean z2) {
        return new SuccessResult(image, imageRequest, dataSource, key, str, z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.b(this.image, successResult.image) && Intrinsics.b(this.request, successResult.request) && this.dataSource == successResult.dataSource && Intrinsics.b(this.memoryCacheKey, successResult.memoryCacheKey) && Intrinsics.b(this.diskCacheKey, successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    @Nullable
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public Image getImage() {
        return this.image;
    }

    @Nullable
    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    public int hashCode() {
        int iHashCode = (this.dataSource.hashCode() + ((this.request.hashCode() + (this.image.hashCode() * 31)) * 31)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode2 = (iHashCode + (key == null ? 0 : key.hashCode())) * 31;
        String str = this.diskCacheKey;
        return Boolean.hashCode(this.isPlaceholderCached) + ((Boolean.hashCode(this.isSampled) + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31)) * 31);
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    @NotNull
    public String toString() {
        return "SuccessResult(image=" + this.image + ", request=" + this.request + ", dataSource=" + this.dataSource + ", memoryCacheKey=" + this.memoryCacheKey + ", diskCacheKey=" + this.diskCacheKey + ", isSampled=" + this.isSampled + ", isPlaceholderCached=" + this.isPlaceholderCached + ')';
    }

    public /* synthetic */ SuccessResult(Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, imageRequest, (i2 & 4) != 0 ? DataSource.MEMORY : dataSource, (i2 & 8) != 0 ? null : key, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2);
    }
}
