package coil3.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import coil3.annotation.InternalCoilApi;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BitmapsKt {
    public static final int getAllocationByteCountCompat(@NotNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                return getBytesPerPixel(bitmap.getConfig()) * bitmap.getHeight() * bitmap.getWidth();
            }
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
    }

    public static final int getBytesPerPixel(@Nullable Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        return (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) ? 4 : 8;
    }

    public static /* synthetic */ void getBytesPerPixel$annotations(Bitmap.Config config) {
    }

    @NotNull
    public static final Bitmap.Config getSafeConfig(@NotNull Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static final boolean isHardware(@NotNull Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    @InternalCoilApi
    public static /* synthetic */ void isHardware$annotations(Bitmap.Config config) {
    }

    public static final boolean isImmutable(@NotNull Bitmap bitmap) {
        return !bitmap.isMutable();
    }

    @NotNull
    public static final BitmapDrawable toDrawable(@NotNull Bitmap bitmap, @NotNull Context context) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    @InternalCoilApi
    @NotNull
    public static final Bitmap.Config toSoftware(@Nullable Bitmap.Config config) {
        return (config == null || isHardware(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
