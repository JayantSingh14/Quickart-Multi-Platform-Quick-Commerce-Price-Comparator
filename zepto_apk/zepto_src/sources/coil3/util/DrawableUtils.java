package coil3.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.WorkerThread;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;

    @NotNull
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == BitmapsKt.toSoftware(config);
    }

    private final boolean isSizeValid(boolean z, Bitmap bitmap, Size size, Scale scale) {
        if (z) {
            return true;
        }
        long jM1computeDstSizesEdh43o = DecodeUtils.m1computeDstSizesEdh43o(bitmap.getWidth(), bitmap.getHeight(), size, scale, Size.ORIGINAL);
        return DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), IntPair.m51getFirstimpl(jM1computeDstSizesEdh43o), IntPair.m52getSecondimpl(jM1computeDstSizesEdh43o), scale) == 1.0d;
    }

    @WorkerThread
    @NotNull
    public final Bitmap convertToBitmap(@NotNull Drawable drawable, @NotNull Bitmap.Config config, @NotNull Size size, @NotNull Scale scale, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(z, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int width = Utils_androidKt.getWidth(drawableMutate);
        if (width <= 0) {
            width = 512;
        }
        int height = Utils_androidKt.getHeight(drawableMutate);
        int i2 = height > 0 ? height : 512;
        long jM1computeDstSizesEdh43o = DecodeUtils.m1computeDstSizesEdh43o(width, i2, size, scale, Size.ORIGINAL);
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i2, IntPair.m51getFirstimpl(jM1computeDstSizesEdh43o), IntPair.m52getSecondimpl(jM1computeDstSizesEdh43o), scale);
        int iA = MathKt.a(width * dComputeSizeMultiplier);
        int iA2 = MathKt.a(dComputeSizeMultiplier * i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA2, BitmapsKt.toSoftware(config));
        Rect bounds = drawableMutate.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iA, iA2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i3, i4, i5, i6);
        return bitmapCreateBitmap;
    }
}
