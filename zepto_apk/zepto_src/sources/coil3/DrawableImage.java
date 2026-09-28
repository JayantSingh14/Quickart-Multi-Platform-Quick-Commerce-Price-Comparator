package coil3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class DrawableImage implements Image {

    @NotNull
    private final Drawable drawable;
    private final boolean shareable;

    @Metadata
    /* loaded from: classes3.dex */
    public interface SizeProvider {
        long getSize();
    }

    public DrawableImage(@NotNull Drawable drawable, boolean z) {
        this.drawable = drawable;
        this.shareable = z;
    }

    @Override // coil3.Image
    public void draw(@NotNull Canvas canvas) {
        this.drawable.draw(canvas);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableImage)) {
            return false;
        }
        DrawableImage drawableImage = (DrawableImage) obj;
        return Intrinsics.b(this.drawable, drawableImage.drawable) && this.shareable == drawableImage.shareable;
    }

    @NotNull
    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil3.Image
    public int getHeight() {
        return Utils_androidKt.getHeight(this.drawable);
    }

    @Override // coil3.Image
    public boolean getShareable() {
        return this.shareable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // coil3.Image
    public long getSize() {
        Drawable drawable = this.drawable;
        long size = drawable instanceof SizeProvider ? ((SizeProvider) drawable).getSize() : Utils_androidKt.getWidth(drawable) * 4 * Utils_androidKt.getHeight(this.drawable);
        if (size < 0) {
            return 0L;
        }
        return size;
    }

    @Override // coil3.Image
    public int getWidth() {
        return Utils_androidKt.getWidth(this.drawable);
    }

    public int hashCode() {
        return Boolean.hashCode(this.shareable) + (this.drawable.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "DrawableImage(drawable=" + this.drawable + ", shareable=" + this.shareable + ')';
    }
}
