package coil3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class BitmapImage implements Image {

    @NotNull
    private final Bitmap bitmap;
    private final boolean shareable;

    public BitmapImage(@NotNull Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.shareable = z;
    }

    @Override // coil3.Image
    public void draw(@NotNull Canvas canvas) {
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapImage)) {
            return false;
        }
        BitmapImage bitmapImage = (BitmapImage) obj;
        return Intrinsics.b(this.bitmap, bitmapImage.bitmap) && this.shareable == bitmapImage.shareable;
    }

    @NotNull
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // coil3.Image
    public int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // coil3.Image
    public boolean getShareable() {
        return this.shareable;
    }

    @Override // coil3.Image
    public long getSize() {
        return BitmapsKt.getAllocationByteCountCompat(this.bitmap);
    }

    @Override // coil3.Image
    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public int hashCode() {
        return Boolean.hashCode(this.shareable) + (this.bitmap.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "BitmapImage(bitmap=" + this.bitmap + ", shareable=" + this.shareable + ')';
    }
}
