package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.widget.ImageView;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ScalingUtils {

    /* renamed from: com.facebook.drawee.drawable.ScalingUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17383a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f17383a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17383a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17383a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17383a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17383a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17383a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17383a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17383a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static abstract class AbstractScaleType implements ScaleType {
        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public final Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            b(matrix, rect, i2, i3, f2, f3, rect.width() / i2, rect.height() / i3);
            return matrix;
        }

        public abstract void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public final Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            throw null;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public final Float getState() {
            return Float.valueOf(0.0f);
        }

        public final String toString() {
            throw null;
        }
    }

    public interface ScaleType {

        /* renamed from: a, reason: collision with root package name */
        public static final ScaleType f17384a = ScaleTypeFitXY.f17403l;

        /* renamed from: b, reason: collision with root package name */
        public static final ScaleType f17385b = ScaleTypeFitX.f17402l;

        /* renamed from: c, reason: collision with root package name */
        public static final ScaleType f17386c = ScaleTypeFitY.f17404l;

        /* renamed from: d, reason: collision with root package name */
        public static final ScaleType f17387d = ScaleTypeFitStart.f17401l;

        /* renamed from: e, reason: collision with root package name */
        public static final ScaleType f17388e = ScaleTypeFitCenter.f17399l;

        /* renamed from: f, reason: collision with root package name */
        public static final ScaleType f17389f = ScaleTypeFitEnd.f17400l;

        /* renamed from: g, reason: collision with root package name */
        public static final ScaleType f17390g = ScaleTypeCenter.f17395l;

        /* renamed from: h, reason: collision with root package name */
        public static final ScaleType f17391h = ScaleTypeCenterInside.f17397l;

        /* renamed from: i, reason: collision with root package name */
        public static final ScaleType f17392i = ScaleTypeCenterCrop.f17396l;

        /* renamed from: j, reason: collision with root package name */
        public static final ScaleType f17393j = ScaleTypeFocusCrop.f17405l;

        /* renamed from: k, reason: collision with root package name */
        public static final ScaleType f17394k = ScaleTypeFitBottomStart.f17398l;

        Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    public static class ScaleTypeCenter extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17395l = new ScaleTypeCenter();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((int) (((rect.width() - i2) * 0.5f) + rect.left + 0.5f), (int) (((rect.height() - i3) * 0.5f) + rect.top + 0.5f));
        }

        public final String toString() {
            return "center";
        }
    }

    public static class ScaleTypeCenterCrop extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17396l = new ScaleTypeCenterCrop();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fWidth;
            float fHeight;
            if (f5 > f4) {
                fWidth = ((rect.width() - (i2 * f5)) * 0.5f) + rect.left;
                fHeight = rect.top;
                f4 = f5;
            } else {
                fWidth = rect.left;
                fHeight = ((rect.height() - (i3 * f4)) * 0.5f) + rect.top;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "center_crop";
        }
    }

    public static class ScaleTypeCenterInside extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17397l = new ScaleTypeCenterInside();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMin = Math.min(Math.min(f4, f5), 1.0f);
            float fWidth = ((rect.width() - (i2 * fMin)) * 0.5f) + rect.left;
            float fHeight = ((rect.height() - (i3 * fMin)) * 0.5f) + rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "center_inside";
        }
    }

    public static class ScaleTypeFitBottomStart extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17398l = new ScaleTypeFitBottomStart();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMin = Math.min(f4, f5);
            float f6 = rect.left;
            float fHeight = (rect.height() - (i3 * fMin)) + rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "fit_bottom_start";
        }
    }

    public static class ScaleTypeFitCenter extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17399l = new ScaleTypeFitCenter();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMin = Math.min(f4, f5);
            float fWidth = ((rect.width() - (i2 * fMin)) * 0.5f) + rect.left;
            float fHeight = ((rect.height() - (i3 * fMin)) * 0.5f) + rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "fit_center";
        }
    }

    public static class ScaleTypeFitEnd extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17400l = new ScaleTypeFitEnd();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMin = Math.min(f4, f5);
            float fWidth = (rect.width() - (i2 * fMin)) + rect.left;
            float fHeight = (rect.height() - (i3 * fMin)) + rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "fit_end";
        }
    }

    public static class ScaleTypeFitStart extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17401l = new ScaleTypeFitStart();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMin = Math.min(f4, f5);
            float f6 = rect.left;
            float f7 = rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (f7 + 0.5f));
        }

        public final String toString() {
            return "fit_start";
        }
    }

    public static class ScaleTypeFitX extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17402l = new ScaleTypeFitX();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6 = rect.left;
            float fHeight = ((rect.height() - (i3 * f4)) * 0.5f) + rect.top;
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (fHeight + 0.5f));
        }

        public final String toString() {
            return "fit_x";
        }
    }

    public static class ScaleTypeFitXY extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17403l = new ScaleTypeFitXY();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6 = rect.left;
            float f7 = rect.top;
            matrix.setScale(f4, f5);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (f7 + 0.5f));
        }

        public final String toString() {
            return "fit_xy";
        }
    }

    public static class ScaleTypeFitY extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17404l = new ScaleTypeFitY();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fWidth = ((rect.width() - (i2 * f5)) * 0.5f) + rect.left;
            float f6 = rect.top;
            matrix.setScale(f5, f5);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (f6 + 0.5f));
        }

        public final String toString() {
            return "fit_y";
        }
    }

    public static class ScaleTypeFocusCrop extends AbstractScaleType {

        /* renamed from: l, reason: collision with root package name */
        public static final ScaleType f17405l = new ScaleTypeFocusCrop();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float fMax;
            float fMax2;
            if (f5 > f4) {
                float f6 = i2 * f5;
                fMax = Math.max(Math.min((rect.width() * 0.5f) - (f2 * f6), 0.0f), rect.width() - f6) + rect.left;
                fMax2 = rect.top;
                f4 = f5;
            } else {
                fMax = rect.left;
                float f7 = i3 * f4;
                fMax2 = Math.max(Math.min((rect.height() * 0.5f) - (f3 * f7), 0.0f), rect.height() - f7) + rect.top;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (fMax + 0.5f), (int) (fMax2 + 0.5f));
        }

        public final String toString() {
            return "focus_crop";
        }
    }

    public interface StatefulScaleType {
        Float getState();
    }
}
