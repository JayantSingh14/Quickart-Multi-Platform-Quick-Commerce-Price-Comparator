package coil3.decode;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class DecodeResult {

    @NotNull
    private final Image image;
    private final boolean isSampled;

    public DecodeResult(@NotNull Image image, boolean z) {
        this.image = image;
        this.isSampled = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.b(this.image, decodeResult.image) && this.isSampled == decodeResult.isSampled;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSampled) + (this.image.hashCode() * 31);
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    @NotNull
    public String toString() {
        return "DecodeResult(image=" + this.image + ", isSampled=" + this.isSampled + ')';
    }
}
