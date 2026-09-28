package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
class TransitionUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f12159a;

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Bitmap a(Picture picture) {
            return Bitmap.createBitmap(picture);
        }
    }

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f12160a = new float[9];

        /* renamed from: b, reason: collision with root package name */
        public final float[] f12161b = new float[9];

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f12162c = new Matrix();

        @Override // android.animation.TypeEvaluator
        public final Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            float[] fArr = this.f12160a;
            matrix.getValues(fArr);
            float[] fArr2 = this.f12161b;
            matrix2.getValues(fArr2);
            for (int i2 = 0; i2 < 9; i2++) {
                float f3 = fArr2[i2];
                float f4 = fArr[i2];
                fArr2[i2] = android.support.v4.media.a.a(f3, f4, f2, f4);
            }
            Matrix matrix3 = this.f12162c;
            matrix3.setValues(fArr2);
            return matrix3;
        }
    }

    static {
        f12159a = Build.VERSION.SDK_INT >= 28;
    }
}
