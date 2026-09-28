package coil3.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Px;
import coil3.decode.DecodeUtils;
import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.apache.commons.codec.language.Soundex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RoundedCornersTransformation extends Transformation {
    private final float bottomLeft;
    private final float bottomRight;

    @NotNull
    private final String cacheKey;
    private final float topLeft;
    private final float topRight;

    public RoundedCornersTransformation() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    /* renamed from: calculateOutputSize-nmZnaPc, reason: not valid java name */
    private final long m43calculateOutputSizenmZnaPc(Bitmap bitmap, Size size) {
        if (SizeKt.isOriginal(size)) {
            return IntPair.m47constructorimpl(bitmap.getWidth(), bitmap.getHeight());
        }
        Dimension dimensionComponent1 = size.component1();
        Dimension dimensionComponent2 = size.component2();
        if ((dimensionComponent1 instanceof Dimension.Pixels) && (dimensionComponent2 instanceof Dimension.Pixels)) {
            return IntPair.m47constructorimpl(((Dimension.Pixels) dimensionComponent1).m42unboximpl(), ((Dimension.Pixels) dimensionComponent2).m42unboximpl());
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Dimension width2 = size.getWidth();
        int iM42unboximpl = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).m42unboximpl() : Integer.MIN_VALUE;
        Dimension height2 = size.getHeight();
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, iM42unboximpl, height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).m42unboximpl() : Integer.MIN_VALUE, Scale.FILL);
        return IntPair.m47constructorimpl(MathKt.a(bitmap.getWidth() * dComputeSizeMultiplier), MathKt.a(dComputeSizeMultiplier * bitmap.getHeight()));
    }

    @Override // coil3.transform.Transformation
    @NotNull
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil3.transform.Transformation
    @Nullable
    public Object transform(@NotNull Bitmap bitmap, @NotNull Size size, @NotNull Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        long jM43calculateOutputSizenmZnaPc = m43calculateOutputSizenmZnaPc(bitmap, size);
        int iM51getFirstimpl = IntPair.m51getFirstimpl(jM43calculateOutputSizenmZnaPc);
        int iM52getSecondimpl = IntPair.m52getSecondimpl(jM43calculateOutputSizenmZnaPc);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM51getFirstimpl, iM52getSecondimpl, BitmapsKt.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        float fComputeSizeMultiplier = (float) DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), iM51getFirstimpl, iM52getSecondimpl, Scale.FILL);
        float f2 = 2;
        matrix.setTranslate((iM51getFirstimpl - (bitmap.getWidth() * fComputeSizeMultiplier)) / f2, (iM52getSecondimpl - (bitmap.getHeight() * fComputeSizeMultiplier)) / f2);
        matrix.preScale(fComputeSizeMultiplier, fComputeSizeMultiplier);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f3 = this.topLeft;
        float f4 = this.topRight;
        float f5 = this.bottomRight;
        float f6 = this.bottomLeft;
        float[] fArr = {f3, f3, f4, f4, f5, f5, f6, f6};
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return bitmapCreateBitmap;
    }

    public /* synthetic */ RoundedCornersTransformation(float f2, float f3, float f4, float f5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f2, (i2 & 2) != 0 ? 0.0f : f3, (i2 & 4) != 0 ? 0.0f : f4, (i2 & 8) != 0 ? 0.0f : f5);
    }

    public RoundedCornersTransformation(@Px float f2, @Px float f3, @Px float f4, @Px float f5) {
        this.topLeft = f2;
        this.topRight = f3;
        this.bottomLeft = f4;
        this.bottomRight = f5;
        if (f2 >= 0.0f && f3 >= 0.0f && f4 >= 0.0f && f5 >= 0.0f) {
            this.cacheKey = Reflection.a(RoundedCornersTransformation.class).k() + Soundex.SILENT_MARKER + f2 + ',' + f3 + ',' + f4 + ',' + f5;
            return;
        }
        throw new IllegalArgumentException("All radii must be >= 0.");
    }

    public RoundedCornersTransformation(@Px float f2) {
        this(f2, f2, f2, f2);
    }
}
