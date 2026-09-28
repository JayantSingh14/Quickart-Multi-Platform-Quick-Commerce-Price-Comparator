package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* loaded from: classes4.dex */
public class ShapeAppearanceModel {

    /* renamed from: m, reason: collision with root package name */
    public static final RelativeCornerSize f41006m = new RelativeCornerSize(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public CornerTreatment f41007a = new RoundedCornerTreatment();

    /* renamed from: b, reason: collision with root package name */
    public CornerTreatment f41008b = new RoundedCornerTreatment();

    /* renamed from: c, reason: collision with root package name */
    public CornerTreatment f41009c = new RoundedCornerTreatment();

    /* renamed from: d, reason: collision with root package name */
    public CornerTreatment f41010d = new RoundedCornerTreatment();

    /* renamed from: e, reason: collision with root package name */
    public CornerSize f41011e = new AbsoluteCornerSize(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public CornerSize f41012f = new AbsoluteCornerSize(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public CornerSize f41013g = new AbsoluteCornerSize(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public CornerSize f41014h = new AbsoluteCornerSize(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public EdgeTreatment f41015i = new EdgeTreatment();

    /* renamed from: j, reason: collision with root package name */
    public EdgeTreatment f41016j = new EdgeTreatment();

    /* renamed from: k, reason: collision with root package name */
    public EdgeTreatment f41017k = new EdgeTreatment();

    /* renamed from: l, reason: collision with root package name */
    public EdgeTreatment f41018l = new EdgeTreatment();

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public CornerTreatment f41019a = new RoundedCornerTreatment();

        /* renamed from: b, reason: collision with root package name */
        public CornerTreatment f41020b = new RoundedCornerTreatment();

        /* renamed from: c, reason: collision with root package name */
        public CornerTreatment f41021c = new RoundedCornerTreatment();

        /* renamed from: d, reason: collision with root package name */
        public CornerTreatment f41022d = new RoundedCornerTreatment();

        /* renamed from: e, reason: collision with root package name */
        public CornerSize f41023e = new AbsoluteCornerSize(0.0f);

        /* renamed from: f, reason: collision with root package name */
        public CornerSize f41024f = new AbsoluteCornerSize(0.0f);

        /* renamed from: g, reason: collision with root package name */
        public CornerSize f41025g = new AbsoluteCornerSize(0.0f);

        /* renamed from: h, reason: collision with root package name */
        public CornerSize f41026h = new AbsoluteCornerSize(0.0f);

        /* renamed from: i, reason: collision with root package name */
        public EdgeTreatment f41027i = new EdgeTreatment();

        /* renamed from: j, reason: collision with root package name */
        public EdgeTreatment f41028j = new EdgeTreatment();

        /* renamed from: k, reason: collision with root package name */
        public EdgeTreatment f41029k = new EdgeTreatment();

        /* renamed from: l, reason: collision with root package name */
        public EdgeTreatment f41030l = new EdgeTreatment();

        public static float b(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).f41005a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).f40972a;
            }
            return -1.0f;
        }

        public final ShapeAppearanceModel a() {
            ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel();
            shapeAppearanceModel.f41007a = this.f41019a;
            shapeAppearanceModel.f41008b = this.f41020b;
            shapeAppearanceModel.f41009c = this.f41021c;
            shapeAppearanceModel.f41010d = this.f41022d;
            shapeAppearanceModel.f41011e = this.f41023e;
            shapeAppearanceModel.f41012f = this.f41024f;
            shapeAppearanceModel.f41013g = this.f41025g;
            shapeAppearanceModel.f41014h = this.f41026h;
            shapeAppearanceModel.f41015i = this.f41027i;
            shapeAppearanceModel.f41016j = this.f41028j;
            shapeAppearanceModel.f41017k = this.f41029k;
            shapeAppearanceModel.f41018l = this.f41030l;
            return shapeAppearanceModel;
        }

        public final void c(float f2) {
            h(f2);
            k(f2);
            e(f2);
            d(f2);
        }

        public final void d(float f2) {
            this.f41026h = new AbsoluteCornerSize(f2);
        }

        public final void e(float f2) {
            this.f41025g = new AbsoluteCornerSize(f2);
        }

        public final void f(float f2) {
            g(MaterialShapeUtils.a(0));
            h(f2);
        }

        public final void g(CornerTreatment cornerTreatment) {
            this.f41019a = cornerTreatment;
            float fB = b(cornerTreatment);
            if (fB != -1.0f) {
                h(fB);
            }
        }

        public final void h(float f2) {
            this.f41023e = new AbsoluteCornerSize(f2);
        }

        public final void i(float f2) {
            j(MaterialShapeUtils.a(0));
            k(f2);
        }

        public final void j(CornerTreatment cornerTreatment) {
            this.f41020b = cornerTreatment;
            float fB = b(cornerTreatment);
            if (fB != -1.0f) {
                k(fB);
            }
        }

        public final void k(float f2) {
            this.f41024f = new AbsoluteCornerSize(f2);
        }
    }

    @RestrictTo
    public interface CornerSizeUnaryOperator {
        CornerSize b(CornerSize cornerSize);
    }

    public static Builder a(Context context, int i2, int i3) {
        return b(context, i2, i3, new AbsoluteCornerSize(0));
    }

    public static Builder b(Context context, int i2, int i3, CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
        if (i3 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i3);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            CornerSize cornerSizeE = e(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize cornerSizeE2 = e(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSizeE);
            CornerSize cornerSizeE3 = e(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, cornerSizeE);
            CornerSize cornerSizeE4 = e(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSizeE);
            CornerSize cornerSizeE5 = e(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSizeE);
            Builder builder = new Builder();
            builder.g(MaterialShapeUtils.a(i5));
            builder.f41023e = cornerSizeE2;
            builder.j(MaterialShapeUtils.a(i6));
            builder.f41024f = cornerSizeE3;
            CornerTreatment cornerTreatmentA = MaterialShapeUtils.a(i7);
            builder.f41021c = cornerTreatmentA;
            float fB = Builder.b(cornerTreatmentA);
            if (fB != -1.0f) {
                builder.e(fB);
            }
            builder.f41025g = cornerSizeE4;
            CornerTreatment cornerTreatmentA2 = MaterialShapeUtils.a(i8);
            builder.f41022d = cornerTreatmentA2;
            float fB2 = Builder.b(cornerTreatmentA2);
            if (fB2 != -1.0f) {
                builder.d(fB2);
            }
            builder.f41026h = cornerSizeE5;
            return builder;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Builder c(Context context, AttributeSet attributeSet, int i2, int i3) {
        return d(context, attributeSet, i2, i3, new AbsoluteCornerSize(0));
    }

    public static Builder d(Context context, AttributeSet attributeSet, int i2, int i3, CornerSize cornerSize) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, cornerSize);
    }

    public static CornerSize e(TypedArray typedArray, int i2, CornerSize cornerSize) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i3 == 6) {
                return new RelativeCornerSize(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public final boolean f(RectF rectF) {
        boolean z = this.f41018l.getClass().equals(EdgeTreatment.class) && this.f41016j.getClass().equals(EdgeTreatment.class) && this.f41015i.getClass().equals(EdgeTreatment.class) && this.f41017k.getClass().equals(EdgeTreatment.class);
        float fA = this.f41011e.a(rectF);
        return z && ((this.f41012f.a(rectF) > fA ? 1 : (this.f41012f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f41014h.a(rectF) > fA ? 1 : (this.f41014h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f41013g.a(rectF) > fA ? 1 : (this.f41013g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f41008b instanceof RoundedCornerTreatment) && (this.f41007a instanceof RoundedCornerTreatment) && (this.f41009c instanceof RoundedCornerTreatment) && (this.f41010d instanceof RoundedCornerTreatment));
    }

    public final Builder g() {
        Builder builder = new Builder();
        builder.f41019a = new RoundedCornerTreatment();
        builder.f41020b = new RoundedCornerTreatment();
        builder.f41021c = new RoundedCornerTreatment();
        builder.f41022d = new RoundedCornerTreatment();
        builder.f41023e = new AbsoluteCornerSize(0.0f);
        builder.f41024f = new AbsoluteCornerSize(0.0f);
        builder.f41025g = new AbsoluteCornerSize(0.0f);
        builder.f41026h = new AbsoluteCornerSize(0.0f);
        builder.f41027i = new EdgeTreatment();
        builder.f41028j = new EdgeTreatment();
        builder.f41029k = new EdgeTreatment();
        new EdgeTreatment();
        builder.f41019a = this.f41007a;
        builder.f41020b = this.f41008b;
        builder.f41021c = this.f41009c;
        builder.f41022d = this.f41010d;
        builder.f41023e = this.f41011e;
        builder.f41024f = this.f41012f;
        builder.f41025g = this.f41013g;
        builder.f41026h = this.f41014h;
        builder.f41027i = this.f41015i;
        builder.f41028j = this.f41016j;
        builder.f41029k = this.f41017k;
        builder.f41030l = this.f41018l;
        return builder;
    }

    public final ShapeAppearanceModel h(CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        Builder builderG = g();
        builderG.f41023e = cornerSizeUnaryOperator.b(this.f41011e);
        builderG.f41024f = cornerSizeUnaryOperator.b(this.f41012f);
        builderG.f41026h = cornerSizeUnaryOperator.b(this.f41014h);
        builderG.f41025g = cornerSizeUnaryOperator.b(this.f41013g);
        return builderG.a();
    }
}
