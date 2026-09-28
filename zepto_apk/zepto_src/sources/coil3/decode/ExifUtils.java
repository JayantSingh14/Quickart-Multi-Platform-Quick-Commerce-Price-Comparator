package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.RealBufferedSource$inputStream$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ExifUtils {

    @NotNull
    public static final ExifUtils INSTANCE = new ExifUtils();

    @NotNull
    private static final Paint paint = new Paint(3);

    private ExifUtils() {
    }

    @NotNull
    public final ExifData getExifData(@Nullable String str, @NotNull BufferedSource bufferedSource, @NotNull ExifOrientationStrategy exifOrientationStrategy) {
        if (!exifOrientationStrategy.supports(str, bufferedSource)) {
            return ExifData.NONE;
        }
        ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(new RealBufferedSource$inputStream$1(bufferedSource.peek())));
        int iC = exifInterface.c();
        int i2 = 0;
        boolean z = iC == 2 || iC == 7 || iC == 4 || iC == 5;
        switch (exifInterface.c()) {
            case 3:
            case 4:
                i2 = 180;
                break;
            case 5:
            case 8:
                i2 = 270;
                break;
            case 6:
            case 7:
                i2 = 90;
                break;
        }
        return new ExifData(z, i2);
    }

    @NotNull
    public final Bitmap reverseTransformations(@NotNull Bitmap bitmap, @NotNull ExifData exifData) {
        if (!exifData.isFlipped() && !ExifUtilsKt.isRotated(exifData)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width = bitmap.getWidth() / 2.0f;
        float height = bitmap.getHeight() / 2.0f;
        if (exifData.isFlipped()) {
            matrix.postScale(-1.0f, 1.0f, width, height);
        }
        if (ExifUtilsKt.isRotated(exifData)) {
            matrix.postRotate(exifData.getRotationDegrees(), width, height);
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        float f2 = rectF.left;
        if (f2 != 0.0f || rectF.top != 0.0f) {
            matrix.postTranslate(-f2, -rectF.top);
        }
        Bitmap bitmapCreateBitmap = ExifUtilsKt.isSwapped(exifData) ? Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), BitmapsKt.getSafeConfig(bitmap)) : Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), BitmapsKt.getSafeConfig(bitmap));
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
