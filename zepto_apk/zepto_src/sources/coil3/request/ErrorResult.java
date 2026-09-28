package coil3.request;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ErrorResult implements ImageResult {

    @Nullable
    private final Image image;

    @NotNull
    private final ImageRequest request;

    @NotNull
    private final Throwable throwable;

    public ErrorResult(@Nullable Image image, @NotNull ImageRequest imageRequest, @NotNull Throwable th) {
        this.image = image;
        this.request = imageRequest;
        this.throwable = th;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Image image, ImageRequest imageRequest, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            image = errorResult.getImage();
        }
        if ((i2 & 2) != 0) {
            imageRequest = errorResult.getRequest();
        }
        if ((i2 & 4) != 0) {
            th = errorResult.throwable;
        }
        return errorResult.copy(image, imageRequest, th);
    }

    @NotNull
    public final ErrorResult copy(@Nullable Image image, @NotNull ImageRequest imageRequest, @NotNull Throwable th) {
        return new ErrorResult(image, imageRequest, th);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.b(this.image, errorResult.image) && Intrinsics.b(this.request, errorResult.request) && Intrinsics.b(this.throwable, errorResult.throwable);
    }

    @Override // coil3.request.ImageResult
    @Nullable
    public Image getImage() {
        return this.image;
    }

    @Override // coil3.request.ImageResult
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    @NotNull
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        Image image = this.image;
        return this.throwable.hashCode() + ((this.request.hashCode() + ((image == null ? 0 : image.hashCode()) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "ErrorResult(image=" + this.image + ", request=" + this.request + ", throwable=" + this.throwable + ')';
    }
}
