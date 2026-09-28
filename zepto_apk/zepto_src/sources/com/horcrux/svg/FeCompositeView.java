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
class FeCompositeView extends FilterPrimitiveView {

    /* renamed from: c, reason: collision with root package name */
    public String f45669c;

    /* renamed from: d, reason: collision with root package name */
    public String f45670d;

    /* renamed from: e, reason: collision with root package name */
    public float f45671e;

    /* renamed from: f, reason: collision with root package name */
    public float f45672f;

    /* renamed from: g, reason: collision with root package name */
    public float f45673g;

    /* renamed from: h, reason: collision with root package name */
    public float f45674h;

    /* renamed from: i, reason: collision with root package name */
    public FilterProperties.FeCompositeOperator f45675i;

    /* renamed from: com.horcrux.svg.FeCompositeView$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45676a;

        static {
            int[] iArr = new int[FilterProperties.FeCompositeOperator.values().length];
            f45676a = iArr;
            try {
                FilterProperties.FeCompositeOperator feCompositeOperator = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f45676a;
                FilterProperties.FeCompositeOperator feCompositeOperator2 = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f45676a;
                FilterProperties.FeCompositeOperator feCompositeOperator3 = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f45676a;
                FilterProperties.FeCompositeOperator feCompositeOperator4 = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f45676a;
                FilterProperties.FeCompositeOperator feCompositeOperator5 = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f45676a;
                FilterProperties.FeCompositeOperator feCompositeOperator6 = FilterProperties.FeCompositeOperator.ARITHMETIC;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public final Bitmap j(HashMap map, Bitmap bitmap) {
        Bitmap bitmapK = FilterPrimitiveView.k(map, bitmap, this.f45669c);
        Bitmap bitmapK2 = FilterPrimitiveView.k(map, bitmap, this.f45670d);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapK.getWidth(), bitmapK.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(bitmapK, 0.0f, 0.0f, paint);
        int iOrdinal = this.f45675i.ordinal();
        if (iOrdinal == 0) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        } else if (iOrdinal == 1) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        } else if (iOrdinal == 2) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else if (iOrdinal == 3) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        } else if (iOrdinal == 4) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        } else if (iOrdinal == 5) {
            int height = bitmapCreateBitmap.getHeight() * bitmapCreateBitmap.getWidth();
            int[] iArr = new int[height];
            bitmapCreateBitmap.getPixels(iArr, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            int width = bitmapCreateBitmap.getWidth();
            int width2 = bitmapCreateBitmap.getWidth();
            int height2 = bitmapCreateBitmap.getHeight();
            int[] iArr2 = new int[height];
            bitmapK2.getPixels(iArr2, 0, width, 0, 0, width2, height2);
            int i2 = 0;
            while (i2 < height) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = height;
                int[] iArr3 = iArr2;
                float f2 = this.f45671e;
                float f3 = (i3 >> 16) & 255;
                float f4 = (i4 >> 16) & 255;
                float f5 = f2 * f3 * f4;
                float f6 = this.f45672f;
                float f7 = (f3 * f6) + f5;
                float f8 = this.f45673g;
                float f9 = (f4 * f8) + f7;
                float f10 = this.f45674h;
                int i6 = (int) (f9 + f10);
                float f11 = (i3 >> 8) & 255;
                float f12 = (i4 >> 8) & 255;
                int i7 = (int) ((f12 * f8) + (f11 * f6) + (f2 * f11 * f12) + f10);
                float f13 = i3 & 255;
                float f14 = i4 & 255;
                int i8 = (int) ((f14 * f8) + (f13 * f6) + (f2 * f13 * f14) + f10);
                float f15 = i3 >>> 24;
                float f16 = i4 >>> 24;
                int i9 = (int) ((f8 * f16) + (f15 * f6) + (f2 * f15 * f16) + f10);
                iArr[i2] = (Math.min(255, Math.max(0, i6)) << 16) | (Math.min(255, Math.max(0, i9)) << 24) | (Math.min(255, Math.max(0, i7)) << 8) | Math.min(255, Math.max(0, i8));
                i2++;
                height = i5;
                iArr2 = iArr3;
            }
            int width3 = bitmapCreateBitmap.getWidth();
            int width4 = bitmapCreateBitmap.getWidth();
            bitmapCreateBitmap = bitmapCreateBitmap;
            bitmapCreateBitmap.setPixels(iArr, 0, width3, 0, 0, width4, bitmapCreateBitmap.getHeight());
        }
        if (this.f45675i != FilterProperties.FeCompositeOperator.ARITHMETIC) {
            canvas.drawBitmap(bitmapK2, 0.0f, 0.0f, paint);
        }
        return bitmapCreateBitmap;
    }
}
