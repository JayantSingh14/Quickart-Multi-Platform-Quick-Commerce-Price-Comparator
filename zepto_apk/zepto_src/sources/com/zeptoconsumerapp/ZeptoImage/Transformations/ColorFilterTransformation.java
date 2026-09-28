package com.zeptoconsumerapp.ZeptoImage.Transformations;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import coil3.size.Size;
import coil3.transform.Transformation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ColorFilterTransformation extends Transformation {

    /* renamed from: a, reason: collision with root package name */
    public final int f47573a;

    /* renamed from: b, reason: collision with root package name */
    public final String f47574b;

    public ColorFilterTransformation(int i2) {
        this.f47573a = i2;
        this.f47574b = ColorFilterTransformation.class.getName() + "-" + i2;
    }

    @Override // coil3.transform.Transformation
    public final String getCacheKey() {
        return this.f47574b;
    }

    @Override // coil3.transform.Transformation
    public final Object transform(Bitmap bitmap, Size size, Continuation continuation) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.f47573a, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }
}
