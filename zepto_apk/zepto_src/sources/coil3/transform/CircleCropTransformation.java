package coil3.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import coil3.size.Size;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CircleCropTransformation extends Transformation {

    @NotNull
    private final String cacheKey = String.valueOf(Reflection.a(CircleCropTransformation.class).k());

    @Override // coil3.transform.Transformation
    @NotNull
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil3.transform.Transformation
    @Nullable
    public Object transform(@NotNull Bitmap bitmap, @NotNull Size size, @NotNull Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f2 = iMin / 2.0f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, BitmapsKt.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawCircle(f2, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, f2 - (bitmap.getWidth() / 2.0f), f2 - (bitmap.getHeight() / 2.0f), paint);
        return bitmapCreateBitmap;
    }
}
