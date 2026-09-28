package coil3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Image_androidKt {
    @NotNull
    public static final Drawable asDrawable(@NotNull Image image, @NotNull Resources resources) {
        return image instanceof DrawableImage ? ((DrawableImage) image).getDrawable() : image instanceof BitmapImage ? new BitmapDrawable(resources, ((BitmapImage) image).getBitmap()) : new ImageDrawable(image);
    }

    @JvmOverloads
    @NotNull
    public static final BitmapImage asImage(@NotNull Bitmap bitmap) {
        return asImage$default(bitmap, false, 1, null);
    }

    public static /* synthetic */ BitmapImage asImage$default(Bitmap bitmap, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return asImage(bitmap, z);
    }

    @JvmOverloads
    @NotNull
    public static final Bitmap toBitmap(@NotNull Image image) {
        return toBitmap$default(image, 0, 0, 3, null);
    }

    public static /* synthetic */ Bitmap toBitmap$default(Image image, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = image.getWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = image.getHeight();
        }
        return toBitmap(image, i2, i3);
    }

    @JvmOverloads
    @NotNull
    public static final BitmapImage asImage(@NotNull Bitmap bitmap, boolean z) {
        return new BitmapImage(bitmap, z);
    }

    @JvmOverloads
    @NotNull
    public static final Bitmap toBitmap(@NotNull Image image, int i2) {
        return toBitmap$default(image, i2, 0, 2, null);
    }

    @NotNull
    public static final Image asImage(@NotNull Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return asImage$default(((BitmapDrawable) drawable).getBitmap(), false, 1, null);
        }
        return new DrawableImage(drawable, false);
    }

    @JvmOverloads
    @NotNull
    public static final Bitmap toBitmap(@NotNull Image image, int i2, int i3) {
        return toBitmap(image, i2, i3, Bitmap.Config.ARGB_8888);
    }

    @NotNull
    public static final Bitmap toBitmap(@NotNull Image image, int i2, int i3, @NotNull Bitmap.Config config) {
        if (image instanceof BitmapImage) {
            BitmapImage bitmapImage = (BitmapImage) image;
            if (bitmapImage.getBitmap().getWidth() == i2 && bitmapImage.getBitmap().getHeight() == i3 && bitmapImage.getBitmap().getConfig() == config) {
                return bitmapImage.getBitmap();
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        image.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    @NotNull
    public static final Image asImage(@NotNull Drawable drawable, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            return asImage(((BitmapDrawable) drawable).getBitmap(), z);
        }
        return new DrawableImage(drawable, z);
    }
}
