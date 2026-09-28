package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;
import java.util.Objects;

/* loaded from: classes4.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final Paint x;

    /* renamed from: a, reason: collision with root package name */
    public MaterialShapeDrawableState f40974a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapePath.ShadowCompatOperation[] f40975b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapePath.ShadowCompatOperation[] f40976c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f40977d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40978e;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f40979f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f40980g;

    /* renamed from: h, reason: collision with root package name */
    public final Path f40981h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f40982i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f40983j;

    /* renamed from: k, reason: collision with root package name */
    public final Region f40984k;

    /* renamed from: l, reason: collision with root package name */
    public final Region f40985l;

    /* renamed from: m, reason: collision with root package name */
    public ShapeAppearanceModel f40986m;
    public final Paint n;
    public final Paint o;
    public final ShadowRenderer p;
    public final ShapeAppearancePathProvider.PathListener q;
    public final ShapeAppearancePathProvider r;
    public PorterDuffColorFilter s;
    public PorterDuffColorFilter t;
    public int u;
    public final RectF v;
    public boolean w;

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$1, reason: invalid class name */
    class AnonymousClass1 implements ShapeAppearancePathProvider.PathListener {
        public AnonymousClass1() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    static {
        Paint paint = new Paint(1);
        x = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public void a() {
        invalidateSelf();
    }

    public final void b(Path path, RectF rectF) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        this.r.a(materialShapeDrawableState.f40989a, materialShapeDrawableState.f40997i, rectF, this.q, path);
        if (this.f40974a.f40996h != 1.0f) {
            Matrix matrix = this.f40979f;
            matrix.reset();
            float f2 = this.f40974a.f40996h;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.v, true);
    }

    public final int c(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        float f2 = materialShapeDrawableState.f41001m + 0.0f + materialShapeDrawableState.f41000l;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawableState.f40990b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.a(f2, i2) : i2;
    }

    public final void d(Canvas canvas) {
        if (this.f40977d.cardinality() > 0) {
            Log.w("MaterialShapeDrawable", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i2 = this.f40974a.p;
        Path path = this.f40980g;
        ShadowRenderer shadowRenderer = this.p;
        if (i2 != 0) {
            canvas.drawPath(path, shadowRenderer.f40960a);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            ShapePath.ShadowCompatOperation shadowCompatOperation = this.f40975b[i3];
            int i4 = this.f40974a.o;
            Matrix matrix = ShapePath.ShadowCompatOperation.f41077b;
            shadowCompatOperation.a(matrix, shadowRenderer, i4, canvas);
            this.f40976c[i3].a(matrix, shadowRenderer, this.f40974a.o, canvas);
        }
        if (this.w) {
            MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
            int iSin = (int) (Math.sin(Math.toRadians(materialShapeDrawableState.q)) * materialShapeDrawableState.p);
            int iH = h();
            canvas.translate(-iSin, -iH);
            canvas.drawPath(path, x);
            canvas.translate(iSin, iH);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (!shapeAppearanceModel.f(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = shapeAppearanceModel.f41012f.a(rectF) * this.f40974a.f40997i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void f(Canvas canvas) {
        Paint paint = this.o;
        Path path = this.f40981h;
        ShapeAppearanceModel shapeAppearanceModel = this.f40986m;
        RectF rectF = this.f40983j;
        rectF.set(g());
        float strokeWidth = j() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, path, shapeAppearanceModel, rectF);
    }

    public final RectF g() {
        RectF rectF = this.f40982i;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f40974a.f40999k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f40974a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.n == 2) {
            return;
        }
        if (materialShapeDrawableState.f40989a.f(g())) {
            outline.setRoundRect(getBounds(), i() * this.f40974a.f40997i);
        } else {
            RectF rectFG = g();
            Path path = this.f40980g;
            b(path, rectFG);
            DrawableUtils.e(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f40974a.f40995g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40974a.f40989a;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f40984k;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.f40980g;
        b(path, rectFG);
        Region region2 = this.f40985l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final int h() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        return (int) (Math.cos(Math.toRadians(materialShapeDrawableState.q)) * materialShapeDrawableState.p);
    }

    public final float i() {
        return this.f40974a.f40989a.f41011e.a(g());
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f40978e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f40974a.f40993e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f40974a.getClass();
        ColorStateList colorStateList2 = this.f40974a.f40992d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f40974a.f40991c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final boolean j() {
        Paint.Style style = this.f40974a.r;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    public final void k(Context context) {
        this.f40974a.f40990b = new ElevationOverlayProvider(context);
        x();
    }

    public final void l(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f41001m != f2) {
            materialShapeDrawableState.f41001m = f2;
            x();
        }
    }

    public final void m(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f40991c != colorStateList) {
            materialShapeDrawableState.f40991c = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f40974a = new MaterialShapeDrawableState(this.f40974a);
        return this;
    }

    public final void n(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f40997i != f2) {
            materialShapeDrawableState.f40997i = f2;
            this.f40978e = true;
            invalidateSelf();
        }
    }

    public final void o() {
        this.f40974a.r = Paint.Style.FILL;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f40978e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z = v(iArr) || w();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public final void p(int i2) {
        this.p.c(i2);
        this.f40974a.getClass();
        super.invalidateSelf();
    }

    public final void q(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.q != i2) {
            materialShapeDrawableState.q = i2;
            super.invalidateSelf();
        }
    }

    public final void r(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.n != i2) {
            materialShapeDrawableState.n = i2;
            super.invalidateSelf();
        }
    }

    public final void s(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.p != i2) {
            materialShapeDrawableState.p = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f40999k != i2) {
            materialShapeDrawableState.f40999k = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f40974a.getClass();
        super.invalidateSelf();
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f40974a.f40989a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f40974a.f40993e = colorStateList;
        w();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f40994f != mode) {
            materialShapeDrawableState.f40994f = mode;
            w();
            super.invalidateSelf();
        }
    }

    public final void t(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        if (materialShapeDrawableState.f40992d != colorStateList) {
            materialShapeDrawableState.f40992d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void u(float f2) {
        this.f40974a.f40998j = f2;
        invalidateSelf();
    }

    public final boolean v(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f40974a.f40991c == null || color2 == (colorForState2 = this.f40974a.f40991c.getColorForState(iArr, (color2 = (paint2 = this.n).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.f40974a.f40992d == null || color == (colorForState = this.f40974a.f40992d.getColorForState(iArr, (color = (paint = this.o).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean w() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.s;
        PorterDuffColorFilter porterDuffColorFilter3 = this.t;
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        ColorStateList colorStateList = materialShapeDrawableState.f40993e;
        PorterDuff.Mode mode = materialShapeDrawableState.f40994f;
        Paint paint = this.n;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int iC = c(color);
            this.u = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.u = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.s = porterDuffColorFilter;
        this.f40974a.getClass();
        this.t = null;
        this.f40974a.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.s) && Objects.equals(porterDuffColorFilter3, this.t)) ? false : true;
    }

    public final void x() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
        float f2 = materialShapeDrawableState.f41001m + 0.0f;
        materialShapeDrawableState.o = (int) Math.ceil(0.75f * f2);
        this.f40974a.p = (int) Math.ceil(f2 * 0.25f);
        w();
        super.invalidateSelf();
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel));
    }

    public MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.f40975b = new ShapePath.ShadowCompatOperation[4];
        this.f40976c = new ShapePath.ShadowCompatOperation[4];
        this.f40977d = new BitSet(8);
        this.f40979f = new Matrix();
        this.f40980g = new Path();
        this.f40981h = new Path();
        this.f40982i = new RectF();
        this.f40983j = new RectF();
        this.f40984k = new Region();
        this.f40985l = new Region();
        Paint paint = new Paint(1);
        this.n = paint;
        Paint paint2 = new Paint(1);
        this.o = paint2;
        this.p = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.Lazy.f41043a;
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.r = shapeAppearancePathProvider;
        this.v = new RectF();
        this.w = true;
        this.f40974a = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        w();
        v(getState());
        this.q = new AnonymousClass1();
    }

    @RestrictTo
    public static class MaterialShapeDrawableState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public ShapeAppearanceModel f40989a;

        /* renamed from: b, reason: collision with root package name */
        public ElevationOverlayProvider f40990b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f40991c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f40992d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f40993e;

        /* renamed from: f, reason: collision with root package name */
        public PorterDuff.Mode f40994f;

        /* renamed from: g, reason: collision with root package name */
        public Rect f40995g;

        /* renamed from: h, reason: collision with root package name */
        public final float f40996h;

        /* renamed from: i, reason: collision with root package name */
        public float f40997i;

        /* renamed from: j, reason: collision with root package name */
        public float f40998j;

        /* renamed from: k, reason: collision with root package name */
        public int f40999k;

        /* renamed from: l, reason: collision with root package name */
        public float f41000l;

        /* renamed from: m, reason: collision with root package name */
        public float f41001m;
        public int n;
        public int o;
        public int p;
        public int q;
        public Paint.Style r;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel) {
            this.f40991c = null;
            this.f40992d = null;
            this.f40993e = null;
            this.f40994f = PorterDuff.Mode.SRC_IN;
            this.f40995g = null;
            this.f40996h = 1.0f;
            this.f40997i = 1.0f;
            this.f40999k = 255;
            this.f41000l = 0.0f;
            this.f41001m = 0.0f;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = Paint.Style.FILL_AND_STROKE;
            this.f40989a = shapeAppearanceModel;
            this.f40990b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.f40978e = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.f40991c = null;
            this.f40992d = null;
            this.f40993e = null;
            this.f40994f = PorterDuff.Mode.SRC_IN;
            this.f40995g = null;
            this.f40996h = 1.0f;
            this.f40997i = 1.0f;
            this.f40999k = 255;
            this.f41000l = 0.0f;
            this.f41001m = 0.0f;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = Paint.Style.FILL_AND_STROKE;
            this.f40989a = materialShapeDrawableState.f40989a;
            this.f40990b = materialShapeDrawableState.f40990b;
            this.f40998j = materialShapeDrawableState.f40998j;
            this.f40991c = materialShapeDrawableState.f40991c;
            this.f40992d = materialShapeDrawableState.f40992d;
            this.f40994f = materialShapeDrawableState.f40994f;
            this.f40993e = materialShapeDrawableState.f40993e;
            this.f40999k = materialShapeDrawableState.f40999k;
            this.f40996h = materialShapeDrawableState.f40996h;
            this.p = materialShapeDrawableState.p;
            this.n = materialShapeDrawableState.n;
            this.f40997i = materialShapeDrawableState.f40997i;
            this.f41000l = materialShapeDrawableState.f41000l;
            this.f41001m = materialShapeDrawableState.f41001m;
            this.o = materialShapeDrawableState.o;
            this.q = materialShapeDrawableState.q;
            this.r = materialShapeDrawableState.r;
            if (materialShapeDrawableState.f40995g != null) {
                this.f40995g = new Rect(materialShapeDrawableState.f40995g);
            }
        }
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(ShapeAppearanceModel.c(context, attributeSet, i2, i3).a());
    }
}
