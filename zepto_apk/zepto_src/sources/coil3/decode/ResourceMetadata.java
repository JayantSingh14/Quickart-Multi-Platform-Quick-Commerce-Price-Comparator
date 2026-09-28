package coil3.decode;

import androidx.annotation.DrawableRes;
import coil3.decode.ImageSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ResourceMetadata extends ImageSource.Metadata {
    private final int density;

    @NotNull
    private final String packageName;
    private final int resId;

    public ResourceMetadata(@NotNull String str, @DrawableRes int i2, int i3) {
        this.packageName = str;
        this.resId = i2;
        this.density = i3;
    }

    public final int getDensity() {
        return this.density;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getResId() {
        return this.resId;
    }
}
