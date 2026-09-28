package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FeBlendView extends FilterPrimitiveView {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f45660f = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f45661c;

    /* renamed from: d, reason: collision with root package name */
    public String f45662d;

    /* renamed from: e, reason: collision with root package name */
    public FilterProperties.FeBlendMode f45663e;

    /* renamed from: com.horcrux.svg.FeBlendView$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45664a;

        static {
            int[] iArr = new int[FilterProperties.FeBlendMode.values().length];
            f45664a = iArr;
            try {
                FilterProperties.FeBlendMode feBlendMode = FilterProperties.FeBlendMode.MULTIPLY;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f45664a;
                FilterProperties.FeBlendMode feBlendMode2 = FilterProperties.FeBlendMode.MULTIPLY;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f45664a;
                FilterProperties.FeBlendMode feBlendMode3 = FilterProperties.FeBlendMode.MULTIPLY;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f45664a;
                FilterProperties.FeBlendMode feBlendMode4 = FilterProperties.FeBlendMode.MULTIPLY;
                iArr4[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f45664a;
                FilterProperties.FeBlendMode feBlendMode5 = FilterProperties.FeBlendMode.MULTIPLY;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f45664a;
                FilterProperties.FeBlendMode feBlendMode6 = FilterProperties.FeBlendMode.MULTIPLY;
                iArr6[2] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public final Bitmap j(HashMap map, Bitmap bitmap) {
        Bitmap bitmapK = FilterPrimitiveView.k(map, bitmap, this.f45661c);
        Bitmap bitmapK2 = FilterPrimitiveView.k(map, bitmap, this.f45662d);
        if (this.f45663e == FilterProperties.FeBlendMode.MULTIPLY) {
            return CustomFilter.apply(bitmapK, bitmapK2, new CustomFilterFunction() { // from class: com.horcrux.svg.a
                @Override // com.horcrux.svg.CustomFilterFunction
                public final float[] a(float[] fArr, float[] fArr2) {
                    int i2 = FeBlendView.f45660f;
                    float f2 = fArr[0];
                    float f3 = 1.0f - f2;
                    float f4 = fArr2[0];
                    float f5 = 1.0f - f4;
                    float f6 = fArr[1] * f2;
                    float f7 = fArr2[1];
                    float f8 = (f6 * f7 * f4) + (f7 * f4 * f3) + (f5 * f6);
                    float f9 = fArr[2] * f2;
                    float f10 = fArr2[2];
                    float f11 = fArr[3] * f2;
                    float f12 = fArr2[3];
                    return new float[]{1.0f - (f5 * f3), f8, (f9 * f10 * f4) + (f10 * f4 * f3) + (f5 * f9), (f11 * f12 * f4) + (f12 * f4 * f3) + (f5 * f11)};
                }
            });
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapK.getWidth(), bitmapK.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(bitmapK, 0.0f, 0.0f, paint);
        int iOrdinal = this.f45663e.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        } else if (iOrdinal == 3) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        } else if (iOrdinal == 4) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        } else if (iOrdinal == 5) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        }
        canvas.drawBitmap(bitmapK2, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }
}
