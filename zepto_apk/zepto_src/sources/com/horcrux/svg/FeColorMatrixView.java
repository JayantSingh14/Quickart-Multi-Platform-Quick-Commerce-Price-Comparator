package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FeColorMatrixView extends FilterPrimitiveView {

    /* renamed from: c, reason: collision with root package name */
    public String f45665c;

    /* renamed from: d, reason: collision with root package name */
    public FilterProperties.FeColorMatrixType f45666d;

    /* renamed from: e, reason: collision with root package name */
    public ReadableArray f45667e;

    /* renamed from: com.horcrux.svg.FeColorMatrixView$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45668a;

        static {
            int[] iArr = new int[FilterProperties.FeColorMatrixType.values().length];
            f45668a = iArr;
            try {
                HashMap map = FilterProperties.FeColorMatrixType.f45696b;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f45668a;
                HashMap map2 = FilterProperties.FeColorMatrixType.f45696b;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f45668a;
                HashMap map3 = FilterProperties.FeColorMatrixType.f45696b;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f45668a;
                HashMap map4 = FilterProperties.FeColorMatrixType.f45696b;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public final Bitmap j(HashMap map, Bitmap bitmap) {
        Bitmap bitmapK = FilterPrimitiveView.k(map, bitmap, this.f45665c);
        ColorMatrix colorMatrix = new ColorMatrix();
        int iOrdinal = this.f45666d.ordinal();
        if (iOrdinal == 0) {
            if (this.f45667e.size() >= 20) {
                float[] fArr = new float[this.f45667e.size()];
                for (int i2 = 0; i2 < this.f45667e.size(); i2++) {
                    fArr[i2] = ((float) this.f45667e.getDouble(i2)) * (i2 % 5 == 4 ? 255 : 1);
                }
                colorMatrix.set(fArr);
                return FilterUtils.getBitmapWithColorMatrix(colorMatrix, bitmapK);
            }
            return bitmapK;
        }
        if (iOrdinal == 1) {
            if (this.f45667e.size() == 1) {
                colorMatrix.setSaturation((float) this.f45667e.getDouble(0));
                return FilterUtils.getBitmapWithColorMatrix(colorMatrix, bitmapK);
            }
            return bitmapK;
        }
        if (iOrdinal == 2) {
            if (this.f45667e.size() == 1) {
                double d2 = (((float) this.f45667e.getDouble(0)) * 3.141592653589793d) / 180.0d;
                float fCos = (float) Math.cos(d2);
                float fSin = (float) Math.sin(d2);
                float f2 = 0.715f - (fCos * 0.715f);
                float f3 = fSin * 0.715f;
                float f4 = 0.072f - (fCos * 0.072f);
                float f5 = 0.213f - (fCos * 0.213f);
                colorMatrix.set(new float[]{((fCos * 0.787f) + 0.213f) - (fSin * 0.213f), f2 - f3, (fSin * 0.928f) + f4, 0.0f, 0.0f, (0.143f * fSin) + f5, (0.14f * fSin) + (0.285f * fCos) + 0.715f, f4 - (0.283f * fSin), 0.0f, 0.0f, f5 - (0.787f * fSin), f2 + f3, (fSin * 0.072f) + (fCos * 0.928f) + 0.072f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            }
            return bitmapK;
        }
        if (iOrdinal == 3) {
            colorMatrix.set(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2125f, 0.7154f, 0.0721f, 0.0f, 0.0f});
        }
        return FilterUtils.getBitmapWithColorMatrix(colorMatrix, bitmapK);
    }
}
