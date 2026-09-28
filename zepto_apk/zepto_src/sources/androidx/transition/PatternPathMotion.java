package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a, reason: collision with root package name */
    public final Path f12101a;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f12102b;

    public PatternPathMotion() {
        Path path = new Path();
        this.f12101a = path;
        this.f12102b = new Matrix();
        path.lineTo(1.0f, 0.0f);
    }

    @Override // androidx.transition.PathMotion
    public final Path a(float f2, float f3, float f4, float f5) {
        float f6 = f5 - f3;
        float fSqrt = (float) Math.sqrt((f6 * f6) + (r6 * r6));
        double dAtan2 = Math.atan2(f6, f4 - f2);
        Matrix matrix = this.f12102b;
        matrix.setScale(fSqrt, fSqrt);
        matrix.postRotate((float) Math.toDegrees(dAtan2));
        matrix.postTranslate(f2, f3);
        Path path = new Path();
        this.f12101a.transform(matrix, path);
        return path;
    }

    public final void b(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        Matrix matrix = this.f12102b;
        matrix.setTranslate(-f4, -f5);
        float f6 = f3 - f5;
        float fSqrt = 1.0f / ((float) Math.sqrt((f6 * f6) + (r2 * r2)));
        matrix.postScale(fSqrt, fSqrt);
        matrix.postRotate((float) Math.toDegrees(-Math.atan2(f6, f2 - f4)));
        path.transform(matrix, this.f12101a);
    }

    public PatternPathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.f12101a = new Path();
        this.f12102b = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12114i);
        try {
            String strG = TypedArrayUtils.g(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strG != null) {
                b(PathParser.d(strG));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.f12101a = new Path();
        this.f12102b = new Matrix();
        b(path);
    }
}
