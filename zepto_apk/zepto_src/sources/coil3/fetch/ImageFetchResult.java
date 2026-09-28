package coil3.fetch;

import coil3.Image;
import coil3.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class ImageFetchResult implements FetchResult {

    @NotNull
    private final DataSource dataSource;

    @NotNull
    private final Image image;
    private final boolean isSampled;

    public ImageFetchResult(@NotNull Image image, boolean z, @NotNull DataSource dataSource) {
        this.image = image;
        this.isSampled = z;
        this.dataSource = dataSource;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFetchResult)) {
            return false;
        }
        ImageFetchResult imageFetchResult = (ImageFetchResult) obj;
        return Intrinsics.b(this.image, imageFetchResult.image) && this.isSampled == imageFetchResult.isSampled && this.dataSource == imageFetchResult.dataSource;
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    public int hashCode() {
        return this.dataSource.hashCode() + ((Boolean.hashCode(this.isSampled) + (this.image.hashCode() * 31)) * 31);
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    @NotNull
    public String toString() {
        return "ImageFetchResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ')';
    }
}
