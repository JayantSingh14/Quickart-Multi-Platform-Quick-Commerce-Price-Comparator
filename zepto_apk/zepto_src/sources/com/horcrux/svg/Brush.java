package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.SVGLength;

/* loaded from: classes4.dex */
class Brush {

    /* renamed from: a, reason: collision with root package name */
    public final BrushType f45633a;

    /* renamed from: b, reason: collision with root package name */
    public final SVGLength[] f45634b;

    /* renamed from: c, reason: collision with root package name */
    public ReadableArray f45635c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f45636d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f45637e;

    /* renamed from: f, reason: collision with root package name */
    public Matrix f45638f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f45639g;

    /* renamed from: h, reason: collision with root package name */
    public PatternView f45640h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class BrushType {

        /* renamed from: a, reason: collision with root package name */
        public static final BrushType f45641a;

        /* renamed from: b, reason: collision with root package name */
        public static final BrushType f45642b;

        /* renamed from: c, reason: collision with root package name */
        public static final BrushType f45643c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ BrushType[] f45644d;

        static {
            BrushType brushType = new BrushType("LINEAR_GRADIENT", 0);
            f45641a = brushType;
            BrushType brushType2 = new BrushType("RADIAL_GRADIENT", 1);
            f45642b = brushType2;
            BrushType brushType3 = new BrushType("PATTERN", 2);
            f45643c = brushType3;
            f45644d = new BrushType[]{brushType, brushType2, brushType3};
        }

        public static BrushType valueOf(String str) {
            return (BrushType) Enum.valueOf(BrushType.class, str);
        }

        public static BrushType[] values() {
            return (BrushType[]) f45644d.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class BrushUnits {

        /* renamed from: a, reason: collision with root package name */
        public static final BrushUnits f45645a;

        /* renamed from: b, reason: collision with root package name */
        public static final BrushUnits f45646b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ BrushUnits[] f45647c;

        static {
            BrushUnits brushUnits = new BrushUnits("OBJECT_BOUNDING_BOX", 0);
            f45645a = brushUnits;
            BrushUnits brushUnits2 = new BrushUnits("USER_SPACE_ON_USE", 1);
            f45646b = brushUnits2;
            f45647c = new BrushUnits[]{brushUnits, brushUnits2};
        }

        public static BrushUnits valueOf(String str) {
            return (BrushUnits) Enum.valueOf(BrushUnits.class, str);
        }

        public static BrushUnits[] values() {
            return (BrushUnits[]) f45647c.clone();
        }
    }

    public Brush(BrushType brushType, SVGLength[] sVGLengthArr, BrushUnits brushUnits) {
        this.f45633a = brushType;
        this.f45634b = sVGLengthArr;
        this.f45636d = brushUnits == BrushUnits.f45645a;
    }

    public final double a(SVGLength sVGLength, double d2, float f2, float f3) {
        return PropHelper.b(sVGLength, d2, (this.f45636d && sVGLength.f45854b == SVGLength.UnitType.NUMBER) ? d2 : f2, f3);
    }

    public final void b(BrushUnits brushUnits) {
        this.f45637e = brushUnits == BrushUnits.f45645a;
    }

    public final void c(ReadableArray readableArray) {
        this.f45635c = readableArray;
    }

    public final void d(Matrix matrix) {
        this.f45638f = matrix;
    }

    public final void e(PatternView patternView) {
        this.f45640h = patternView;
    }

    public final void f(Rect rect) {
        this.f45639g = rect;
    }

    public final void g(Paint paint, RectF rectF, float f2, float f3) {
        float f4;
        float f5;
        float[] fArr;
        int[] iArr;
        float[] fArr2;
        int[] iArr2;
        double d2;
        boolean z = this.f45636d;
        RectF rectF2 = z ? rectF : new RectF(this.f45639g);
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (z) {
            f4 = rectF2.left;
            f5 = rectF2.top;
        } else {
            f4 = 0.0f;
            f5 = 0.0f;
        }
        RectF rectF3 = new RectF(f4, f5, fWidth + f4, fHeight + f5);
        float fWidth2 = rectF3.width();
        float fHeight2 = rectF3.height();
        float f6 = rectF3.left;
        float f7 = rectF3.top;
        float textSize = paint.getTextSize();
        BrushType brushType = BrushType.f45643c;
        BrushType brushType2 = this.f45633a;
        SVGLength[] sVGLengthArr = this.f45634b;
        if (brushType2 == brushType) {
            double d3 = fWidth2;
            double dA = a(sVGLengthArr[0], d3, f2, textSize);
            double d4 = fHeight2;
            double dA2 = a(sVGLengthArr[1], d4, f2, textSize);
            double dA3 = a(sVGLengthArr[2], d3, f2, textSize);
            double dA4 = a(sVGLengthArr[3], d4, f2, textSize);
            if (dA3 <= 1.0d || dA4 <= 1.0d) {
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) dA3, (int) dA4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            PatternView patternView = this.f45640h;
            patternView.getClass();
            float f8 = patternView.f45815l;
            float f9 = patternView.mScale;
            float f10 = patternView.f45816m;
            RectF rectF4 = new RectF(f8 * f9, f10 * f9, (f8 + patternView.n) * f9, (f10 + patternView.o) * f9);
            if (rectF4.width() > 0.0f && rectF4.height() > 0.0f) {
                RectF rectF5 = new RectF((float) dA, (float) dA2, (float) dA3, (float) dA4);
                PatternView patternView2 = this.f45640h;
                canvas.concat(ViewBox.a(rectF4, rectF5, patternView2.p, patternView2.q));
            }
            if (this.f45637e) {
                canvas.scale(fWidth2 / f2, fHeight2 / f2);
            }
            this.f45640h.draw(canvas, new Paint(), f3);
            Matrix matrix = new Matrix();
            Matrix matrix2 = this.f45638f;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            return;
        }
        int size = this.f45635c.size();
        if (size == 0) {
            FLog.q("ReactNative", "Gradient contains no stops");
            return;
        }
        int i2 = size / 2;
        int[] iArr3 = new int[i2];
        float[] fArr3 = new float[i2];
        ReadableArray readableArray = this.f45635c;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * 2;
            int[] iArr4 = iArr3;
            fArr3[i3] = (float) readableArray.getDouble(i4);
            iArr4[i3] = (readableArray.getInt(i4 + 1) & 16777215) | (Math.round((r4 >>> 24) * f3) << 24);
            i3++;
            textSize = textSize;
            iArr3 = iArr4;
        }
        int[] iArr5 = iArr3;
        float f11 = textSize;
        if (i2 == 1) {
            int[] iArr6 = {iArr5[0], iArr5[0]};
            float[] fArr4 = {fArr3[0], fArr3[0]};
            FLog.q("ReactNative", "Gradient contains only one stop");
            iArr = iArr6;
            fArr = fArr4;
        } else {
            fArr = fArr3;
            iArr = iArr5;
        }
        if (brushType2 == BrushType.f45641a) {
            double d5 = fWidth2;
            double d6 = f6;
            double dA5 = a(sVGLengthArr[0], d5, f2, f11) + d6;
            double d7 = fHeight2;
            double d8 = f7;
            LinearGradient linearGradient = new LinearGradient((float) dA5, (float) (a(sVGLengthArr[1], d7, f2, f11) + d8), (float) (a(sVGLengthArr[2], d5, f2, f11) + d6), (float) (a(sVGLengthArr[3], d7, f2, f11) + d8), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.f45638f != null) {
                Matrix matrix3 = new Matrix();
                matrix3.preConcat(this.f45638f);
                linearGradient.setLocalMatrix(matrix3);
            }
            paint.setShader(linearGradient);
            return;
        }
        int[] iArr7 = iArr;
        float[] fArr5 = fArr;
        if (brushType2 == BrushType.f45642b) {
            double d9 = fWidth2;
            double dA6 = a(sVGLengthArr[2], d9, f2, f11);
            double d10 = fHeight2;
            double dA7 = a(sVGLengthArr[3], d10, f2, f11);
            if (dA6 <= 0.0d || dA7 <= 0.0d) {
                fArr2 = new float[]{fArr5[0], fArr5[fArr5.length - 1]};
                iArr2 = new int[]{iArr7[iArr7.length - 1], iArr7[iArr7.length - 1]};
                dA6 = d9;
                d2 = d10;
            } else {
                iArr2 = iArr7;
                fArr2 = fArr5;
                d2 = dA7;
            }
            double d11 = d2 / dA6;
            RadialGradient radialGradient = new RadialGradient((float) (a(sVGLengthArr[4], d9, f2, f11) + f6), (float) ((f7 / d11) + a(sVGLengthArr[5], d10 / d11, f2, f11)), (float) dA6, iArr2, fArr2, Shader.TileMode.CLAMP);
            Matrix matrix4 = new Matrix();
            matrix4.preScale(1.0f, (float) d11);
            Matrix matrix5 = this.f45638f;
            if (matrix5 != null) {
                matrix4.preConcat(matrix5);
            }
            radialGradient.setLocalMatrix(matrix4);
            paint.setShader(radialGradient);
        }
    }
}
