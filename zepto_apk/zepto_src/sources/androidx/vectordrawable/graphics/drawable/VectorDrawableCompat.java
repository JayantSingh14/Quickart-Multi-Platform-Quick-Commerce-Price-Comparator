package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: j, reason: collision with root package name */
    public static final PorterDuff.Mode f12237j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public VectorDrawableCompatState f12238b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f12239c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f12240d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12241e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12242f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f12243g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f12244h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f12245i;

    /* loaded from: classes3.dex */
    public static class VClipPath extends VPath {
        public final void c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                TypedArray typedArrayI = TypedArrayUtils.i(resources, theme, attributeSet, AndroidResources.f12218d);
                String string = typedArrayI.getString(0);
                if (string != null) {
                    this.f12268b = string;
                }
                String string2 = typedArrayI.getString(1);
                if (string2 != null) {
                    this.f12267a = PathParser.c(string2);
                }
                this.f12269c = TypedArrayUtils.h(xmlPullParser, "fillType") ? typedArrayI.getInt(2, 0) : 0;
                typedArrayI.recycle();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VFullPath extends VPath {

        /* renamed from: d, reason: collision with root package name */
        public ComplexColorCompat f12246d;

        /* renamed from: f, reason: collision with root package name */
        public ComplexColorCompat f12248f;

        /* renamed from: e, reason: collision with root package name */
        public float f12247e = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f12249g = 1.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f12250h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f12251i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public float f12252j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f12253k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public Paint.Cap f12254l = Paint.Cap.BUTT;

        /* renamed from: m, reason: collision with root package name */
        public Paint.Join f12255m = Paint.Join.MITER;
        public float n = 4.0f;

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean a() {
            return this.f12248f.b() || this.f12246d.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(int[] r7) {
            /*
                r6 = this;
                androidx.core.content.res.ComplexColorCompat r0 = r6.f12248f
                boolean r1 = r0.b()
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L1c
                android.content.res.ColorStateList r1 = r0.f2748b
                int r4 = r1.getDefaultColor()
                int r1 = r1.getColorForState(r7, r4)
                int r4 = r0.f2749c
                if (r1 == r4) goto L1c
                r0.f2749c = r1
                r0 = r3
                goto L1d
            L1c:
                r0 = r2
            L1d:
                androidx.core.content.res.ComplexColorCompat r1 = r6.f12246d
                boolean r4 = r1.b()
                if (r4 == 0) goto L36
                android.content.res.ColorStateList r4 = r1.f2748b
                int r5 = r4.getDefaultColor()
                int r7 = r4.getColorForState(r7, r5)
                int r4 = r1.f2749c
                if (r7 == r4) goto L36
                r1.f2749c = r7
                r2 = r3
            L36:
                r7 = r0 | r2
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath.b(int[]):boolean");
        }

        public final void c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray typedArrayI = TypedArrayUtils.i(resources, theme, attributeSet, AndroidResources.f12217c);
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                String string = typedArrayI.getString(0);
                if (string != null) {
                    this.f12268b = string;
                }
                String string2 = typedArrayI.getString(2);
                if (string2 != null) {
                    this.f12267a = PathParser.c(string2);
                }
                this.f12248f = TypedArrayUtils.d(typedArrayI, xmlPullParser, theme, "fillColor", 1);
                float f2 = this.f12250h;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                    f2 = typedArrayI.getFloat(12, f2);
                }
                this.f12250h = f2;
                int i2 = !(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null) ? -1 : typedArrayI.getInt(8, -1);
                Paint.Cap cap = this.f12254l;
                if (i2 == 0) {
                    cap = Paint.Cap.BUTT;
                } else if (i2 == 1) {
                    cap = Paint.Cap.ROUND;
                } else if (i2 == 2) {
                    cap = Paint.Cap.SQUARE;
                }
                this.f12254l = cap;
                int i3 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayI.getInt(9, -1) : -1;
                Paint.Join join = this.f12255m;
                if (i3 == 0) {
                    join = Paint.Join.MITER;
                } else if (i3 == 1) {
                    join = Paint.Join.ROUND;
                } else if (i3 == 2) {
                    join = Paint.Join.BEVEL;
                }
                this.f12255m = join;
                float f3 = this.n;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                    f3 = typedArrayI.getFloat(10, f3);
                }
                this.n = f3;
                this.f12246d = TypedArrayUtils.d(typedArrayI, xmlPullParser, theme, "strokeColor", 3);
                float f4 = this.f12249g;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                    f4 = typedArrayI.getFloat(11, f4);
                }
                this.f12249g = f4;
                float f5 = this.f12247e;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                    f5 = typedArrayI.getFloat(4, f5);
                }
                this.f12247e = f5;
                float f6 = this.f12252j;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                    f6 = typedArrayI.getFloat(6, f6);
                }
                this.f12252j = f6;
                float f7 = this.f12253k;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                    f7 = typedArrayI.getFloat(7, f7);
                }
                this.f12253k = f7;
                float f8 = this.f12251i;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                    f8 = typedArrayI.getFloat(5, f8);
                }
                this.f12251i = f8;
                int i4 = this.f12269c;
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                    i4 = typedArrayI.getInt(13, i4);
                }
                this.f12269c = i4;
            }
            typedArrayI.recycle();
        }

        public float getFillAlpha() {
            return this.f12250h;
        }

        @ColorInt
        public int getFillColor() {
            return this.f12248f.f2749c;
        }

        public float getStrokeAlpha() {
            return this.f12249g;
        }

        @ColorInt
        public int getStrokeColor() {
            return this.f12246d.f2749c;
        }

        public float getStrokeWidth() {
            return this.f12247e;
        }

        public float getTrimPathEnd() {
            return this.f12252j;
        }

        public float getTrimPathOffset() {
            return this.f12253k;
        }

        public float getTrimPathStart() {
            return this.f12251i;
        }

        public void setFillAlpha(float f2) {
            this.f12250h = f2;
        }

        public void setFillColor(int i2) {
            this.f12248f.f2749c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f12249g = f2;
        }

        public void setStrokeColor(int i2) {
            this.f12246d.f2749c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f12247e = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.f12252j = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.f12253k = f2;
        }

        public void setTrimPathStart(float f2) {
            this.f12251i = f2;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class VObject {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f12283a;

        /* renamed from: b, reason: collision with root package name */
        public VPathRenderer f12284b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f12285c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f12286d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12287e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f12288f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f12289g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f12290h;

        /* renamed from: i, reason: collision with root package name */
        public int f12291i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f12292j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f12293k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f12294l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f12285c = null;
            this.f12286d = VectorDrawableCompat.f12237j;
            if (vectorDrawableCompatState != null) {
                this.f12283a = vectorDrawableCompatState.f12283a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f12284b);
                this.f12284b = vPathRenderer;
                if (vectorDrawableCompatState.f12284b.f12274e != null) {
                    vPathRenderer.f12274e = new Paint(vectorDrawableCompatState.f12284b.f12274e);
                }
                if (vectorDrawableCompatState.f12284b.f12273d != null) {
                    this.f12284b.f12273d = new Paint(vectorDrawableCompatState.f12284b.f12273d);
                }
                this.f12285c = vectorDrawableCompatState.f12285c;
                this.f12286d = vectorDrawableCompatState.f12286d;
                this.f12287e = vectorDrawableCompatState.f12287e;
            }
        }

        public final boolean a() {
            return !this.f12293k && this.f12289g == this.f12285c && this.f12290h == this.f12286d && this.f12292j == this.f12287e && this.f12291i == this.f12284b.getRootAlpha();
        }

        public final void b(int i2, int i3) {
            Bitmap bitmap = this.f12288f;
            if (bitmap != null && i2 == bitmap.getWidth() && i3 == this.f12288f.getHeight()) {
                return;
            }
            this.f12288f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f12293k = true;
        }

        public final void c(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            Paint paint;
            if (this.f12284b.getRootAlpha() >= 255 && colorFilter == null) {
                paint = null;
            } else {
                if (this.f12294l == null) {
                    Paint paint2 = new Paint();
                    this.f12294l = paint2;
                    paint2.setFilterBitmap(true);
                }
                this.f12294l.setAlpha(this.f12284b.getRootAlpha());
                this.f12294l.setColorFilter(colorFilter);
                paint = this.f12294l;
            }
            canvas.drawBitmap(this.f12288f, (Rect) null, rect, paint);
        }

        public final boolean d() {
            VPathRenderer vPathRenderer = this.f12284b;
            if (vPathRenderer.n == null) {
                vPathRenderer.n = Boolean.valueOf(vPathRenderer.f12276g.a());
            }
            return vPathRenderer.n.booleanValue();
        }

        public final boolean e(int[] iArr) {
            boolean zB = this.f12284b.f12276g.b(iArr);
            this.f12293k |= zB;
            return zB;
        }

        public final void f() {
            this.f12289g = this.f12285c;
            this.f12290h = this.f12286d;
            this.f12291i = this.f12284b.getRootAlpha();
            this.f12292j = this.f12287e;
            this.f12293k = false;
        }

        public final void g(int i2, int i3) {
            this.f12288f.eraseColor(0);
            Canvas canvas = new Canvas(this.f12288f);
            VPathRenderer vPathRenderer = this.f12284b;
            vPathRenderer.a(vPathRenderer.f12276g, VPathRenderer.p, canvas, i2, i3);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f12283a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f12285c = null;
            this.f12286d = VectorDrawableCompat.f12237j;
            this.f12284b = new VPathRenderer();
        }
    }

    public VectorDrawableCompat() {
        this.f12242f = true;
        this.f12243g = new float[9];
        this.f12244h = new Matrix();
        this.f12245i = new Rect();
        this.f12238b = new VectorDrawableCompatState();
    }

    public static VectorDrawableCompat a(Resources resources, int i2, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f12236a = ResourcesCompat.c(resources, i2, theme);
        new VectorDrawableDelegateState(vectorDrawableCompat.f12236a.getConstantState());
        return vectorDrawableCompat;
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(super.getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f12236a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f12245i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f12240d;
        if (colorFilter == null) {
            colorFilter = this.f12239c;
        }
        Matrix matrix = this.f12244h;
        canvas.getMatrix(matrix);
        float[] fArr = this.f12243g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && DrawableCompat.e(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        this.f12238b.b(iMin, iMin2);
        if (!this.f12242f) {
            this.f12238b.g(iMin, iMin2);
        } else if (!this.f12238b.a()) {
            this.f12238b.g(iMin, iMin2);
            this.f12238b.f();
        }
        this.f12238b.c(canvas, colorFilter, rect);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f12236a;
        return drawable != null ? DrawableCompat.c(drawable) : this.f12238b.f12284b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f12238b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f12236a;
        return drawable != null ? DrawableCompat.d(drawable) : this.f12240d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f12236a != null) {
            return new VectorDrawableDelegateState(this.f12236a.getConstantState());
        }
        this.f12238b.f12283a = getChangingConfigurations();
        return this.f12238b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f12238b.f12284b.f12278i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f12238b.f12284b.f12277h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f12236a;
        return drawable != null ? DrawableCompat.g(drawable) : this.f12238b.f12287e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f12238b;
        if (vectorDrawableCompatState == null) {
            return false;
        }
        if (vectorDrawableCompatState.d()) {
            return true;
        }
        ColorStateList colorStateList = this.f12238b.f12285c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f12241e && super.mutate() == this) {
            this.f12238b = new VectorDrawableCompatState(this.f12238b);
            this.f12241e = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f12238b;
        ColorStateList colorStateList = vectorDrawableCompatState.f12285c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.f12286d) == null) {
            z = false;
        } else {
            this.f12239c = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!vectorDrawableCompatState.d() || !vectorDrawableCompatState.e(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f12238b.f12284b.getRootAlpha() != i2) {
            this.f12238b.f12284b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.i(drawable, z);
        } else {
            this.f12238b.f12287e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f12240d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.l(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.m(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f12238b;
        if (vectorDrawableCompatState.f12285c != colorStateList) {
            vectorDrawableCompatState.f12285c = colorStateList;
            this.f12239c = b(colorStateList, vectorDrawableCompatState.f12286d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.n(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f12238b;
        if (vectorDrawableCompatState.f12286d != mode) {
            vectorDrawableCompatState.f12286d = mode;
            this.f12239c = b(vectorDrawableCompatState.f12285c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f12295a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f12295a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f12295a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f12295a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12236a = (VectorDrawable) this.f12295a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12236a = (VectorDrawable) this.f12295a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f12236a = (VectorDrawable) this.f12295a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class VPath extends VObject {

        /* renamed from: a, reason: collision with root package name */
        public PathParser.PathDataNode[] f12267a;

        /* renamed from: b, reason: collision with root package name */
        public String f12268b;

        /* renamed from: c, reason: collision with root package name */
        public int f12269c;

        public VPath() {
            this.f12267a = null;
            this.f12269c = 0;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f12267a;
        }

        public String getPathName() {
            return this.f12268b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.a(this.f12267a, pathDataNodeArr)) {
                this.f12267a = PathParser.e(pathDataNodeArr);
                return;
            }
            PathParser.PathDataNode[] pathDataNodeArr2 = this.f12267a;
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                pathDataNodeArr2[i2].f2813a = pathDataNodeArr[i2].f2813a;
                int i3 = 0;
                while (true) {
                    float[] fArr = pathDataNodeArr[i2].f2814b;
                    if (i3 < fArr.length) {
                        pathDataNodeArr2[i2].f2814b[i3] = fArr[i3];
                        i3++;
                    }
                }
            }
        }

        public VPath(VPath vPath) {
            this.f12267a = null;
            this.f12269c = 0;
            this.f12268b = vPath.f12268b;
            this.f12267a = PathParser.e(vPath.f12267a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i2;
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f12238b;
        vectorDrawableCompatState.f12284b = new VPathRenderer();
        TypedArray typedArrayI = TypedArrayUtils.i(resources, theme, attributeSet, AndroidResources.f12215a);
        VectorDrawableCompatState vectorDrawableCompatState2 = this.f12238b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState2.f12284b;
        int iF = TypedArrayUtils.f(typedArrayI, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i3 = 3;
        if (iF == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (iF != 5) {
            if (iF != 9) {
                switch (iF) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        vectorDrawableCompatState2.f12286d = mode;
        ColorStateList colorStateListC = TypedArrayUtils.c(typedArrayI, xmlPullParser, theme);
        if (colorStateListC != null) {
            vectorDrawableCompatState2.f12285c = colorStateListC;
        }
        vectorDrawableCompatState2.f12287e = TypedArrayUtils.b(typedArrayI, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState2.f12287e);
        vPathRenderer.f12279j = TypedArrayUtils.e(typedArrayI, xmlPullParser, "viewportWidth", 7, vPathRenderer.f12279j);
        float fE = TypedArrayUtils.e(typedArrayI, xmlPullParser, "viewportHeight", 8, vPathRenderer.f12280k);
        vPathRenderer.f12280k = fE;
        if (vPathRenderer.f12279j <= 0.0f) {
            throw new XmlPullParserException(typedArrayI.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fE > 0.0f) {
            vPathRenderer.f12277h = typedArrayI.getDimension(3, vPathRenderer.f12277h);
            int i4 = 2;
            float dimension = typedArrayI.getDimension(2, vPathRenderer.f12278i);
            vPathRenderer.f12278i = dimension;
            if (vPathRenderer.f12277h <= 0.0f) {
                throw new XmlPullParserException(typedArrayI.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.e(typedArrayI, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArrayI.getString(0);
                if (string != null) {
                    vPathRenderer.f12282m = string;
                    vPathRenderer.o.put(string, vPathRenderer);
                }
                typedArrayI.recycle();
                vectorDrawableCompatState.f12283a = getChangingConfigurations();
                int i5 = 1;
                vectorDrawableCompatState.f12293k = true;
                VectorDrawableCompatState vectorDrawableCompatState3 = this.f12238b;
                VPathRenderer vPathRenderer2 = vectorDrawableCompatState3.f12284b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(vPathRenderer2.f12276g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z = true;
                while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i3)) {
                    if (eventType == i4) {
                        String name = xmlPullParser.getName();
                        VGroup vGroup = (VGroup) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        ArrayMap arrayMap = vPathRenderer2.o;
                        if (zEquals) {
                            VFullPath vFullPath = new VFullPath();
                            vFullPath.c(resources, xmlPullParser, attributeSet, theme);
                            vGroup.f12257b.add(vFullPath);
                            if (vFullPath.getPathName() != null) {
                                arrayMap.put(vFullPath.getPathName(), vFullPath);
                            }
                            vectorDrawableCompatState3.f12283a = vectorDrawableCompatState3.f12283a;
                            z = false;
                        } else if ("clip-path".equals(name)) {
                            VClipPath vClipPath = new VClipPath();
                            vClipPath.c(resources, xmlPullParser, attributeSet, theme);
                            vGroup.f12257b.add(vClipPath);
                            if (vClipPath.getPathName() != null) {
                                arrayMap.put(vClipPath.getPathName(), vClipPath);
                            }
                            vectorDrawableCompatState3.f12283a = vectorDrawableCompatState3.f12283a;
                        } else if ("group".equals(name)) {
                            VGroup vGroup2 = new VGroup();
                            vGroup2.c(resources, xmlPullParser, attributeSet, theme);
                            vGroup.f12257b.add(vGroup2);
                            arrayDeque.push(vGroup2);
                            if (vGroup2.getGroupName() != null) {
                                arrayMap.put(vGroup2.getGroupName(), vGroup2);
                            }
                            vectorDrawableCompatState3.f12283a = vectorDrawableCompatState3.f12283a;
                        }
                        i2 = 3;
                    } else {
                        i2 = i3;
                        if (eventType == i2 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i3 = i2;
                    i5 = 1;
                    i4 = 2;
                }
                if (!z) {
                    this.f12239c = b(vectorDrawableCompatState.f12285c, vectorDrawableCompatState.f12286d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayI.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayI.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f12242f = true;
        this.f12243g = new float[9];
        this.f12244h = new Matrix();
        this.f12245i = new Rect();
        this.f12238b = vectorDrawableCompatState;
        this.f12239c = b(vectorDrawableCompatState.f12285c, vectorDrawableCompatState.f12286d);
    }

    /* loaded from: classes3.dex */
    public static class VGroup extends VObject {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f12256a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f12257b;

        /* renamed from: c, reason: collision with root package name */
        public float f12258c;

        /* renamed from: d, reason: collision with root package name */
        public float f12259d;

        /* renamed from: e, reason: collision with root package name */
        public float f12260e;

        /* renamed from: f, reason: collision with root package name */
        public float f12261f;

        /* renamed from: g, reason: collision with root package name */
        public float f12262g;

        /* renamed from: h, reason: collision with root package name */
        public float f12263h;

        /* renamed from: i, reason: collision with root package name */
        public float f12264i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f12265j;

        /* renamed from: k, reason: collision with root package name */
        public String f12266k;

        public VGroup() {
            this.f12256a = new Matrix();
            this.f12257b = new ArrayList();
            this.f12258c = 0.0f;
            this.f12259d = 0.0f;
            this.f12260e = 0.0f;
            this.f12261f = 1.0f;
            this.f12262g = 1.0f;
            this.f12263h = 0.0f;
            this.f12264i = 0.0f;
            this.f12265j = new Matrix();
            this.f12266k = null;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean a() {
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f12257b;
                if (i2 >= arrayList.size()) {
                    return false;
                }
                if (((VObject) arrayList.get(i2)).a()) {
                    return true;
                }
                i2++;
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean b(int[] iArr) {
            int i2 = 0;
            boolean zB = false;
            while (true) {
                ArrayList arrayList = this.f12257b;
                if (i2 >= arrayList.size()) {
                    return zB;
                }
                zB |= ((VObject) arrayList.get(i2)).b(iArr);
                i2++;
            }
        }

        public final void c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray typedArrayI = TypedArrayUtils.i(resources, theme, attributeSet, AndroidResources.f12216b);
            float f2 = this.f12258c;
            if (TypedArrayUtils.h(xmlPullParser, "rotation")) {
                f2 = typedArrayI.getFloat(5, f2);
            }
            this.f12258c = f2;
            this.f12259d = typedArrayI.getFloat(1, this.f12259d);
            this.f12260e = typedArrayI.getFloat(2, this.f12260e);
            float f3 = this.f12261f;
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                f3 = typedArrayI.getFloat(3, f3);
            }
            this.f12261f = f3;
            float f4 = this.f12262g;
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                f4 = typedArrayI.getFloat(4, f4);
            }
            this.f12262g = f4;
            float f5 = this.f12263h;
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                f5 = typedArrayI.getFloat(6, f5);
            }
            this.f12263h = f5;
            float f6 = this.f12264i;
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                f6 = typedArrayI.getFloat(7, f6);
            }
            this.f12264i = f6;
            String string = typedArrayI.getString(0);
            if (string != null) {
                this.f12266k = string;
            }
            d();
            typedArrayI.recycle();
        }

        public final void d() {
            Matrix matrix = this.f12265j;
            matrix.reset();
            matrix.postTranslate(-this.f12259d, -this.f12260e);
            matrix.postScale(this.f12261f, this.f12262g);
            matrix.postRotate(this.f12258c, 0.0f, 0.0f);
            matrix.postTranslate(this.f12263h + this.f12259d, this.f12264i + this.f12260e);
        }

        public String getGroupName() {
            return this.f12266k;
        }

        public Matrix getLocalMatrix() {
            return this.f12265j;
        }

        public float getPivotX() {
            return this.f12259d;
        }

        public float getPivotY() {
            return this.f12260e;
        }

        public float getRotation() {
            return this.f12258c;
        }

        public float getScaleX() {
            return this.f12261f;
        }

        public float getScaleY() {
            return this.f12262g;
        }

        public float getTranslateX() {
            return this.f12263h;
        }

        public float getTranslateY() {
            return this.f12264i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f12259d) {
                this.f12259d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f12260e) {
                this.f12260e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f12258c) {
                this.f12258c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f12261f) {
                this.f12261f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f12262g) {
                this.f12262g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f12263h) {
                this.f12263h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f12264i) {
                this.f12264i = f2;
                d();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public VGroup(VGroup vGroup, ArrayMap arrayMap) {
            VClipPath vClipPath;
            this.f12256a = new Matrix();
            this.f12257b = new ArrayList();
            this.f12258c = 0.0f;
            this.f12259d = 0.0f;
            this.f12260e = 0.0f;
            this.f12261f = 1.0f;
            this.f12262g = 1.0f;
            this.f12263h = 0.0f;
            this.f12264i = 0.0f;
            Matrix matrix = new Matrix();
            this.f12265j = matrix;
            this.f12266k = null;
            this.f12258c = vGroup.f12258c;
            this.f12259d = vGroup.f12259d;
            this.f12260e = vGroup.f12260e;
            this.f12261f = vGroup.f12261f;
            this.f12262g = vGroup.f12262g;
            this.f12263h = vGroup.f12263h;
            this.f12264i = vGroup.f12264i;
            String str = vGroup.f12266k;
            this.f12266k = str;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f12265j);
            ArrayList arrayList = vGroup.f12257b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof VGroup) {
                    this.f12257b.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        VFullPath vFullPath = (VFullPath) obj;
                        VFullPath vFullPath2 = new VFullPath(vFullPath);
                        vFullPath2.f12247e = 0.0f;
                        vFullPath2.f12249g = 1.0f;
                        vFullPath2.f12250h = 1.0f;
                        vFullPath2.f12251i = 0.0f;
                        vFullPath2.f12252j = 1.0f;
                        vFullPath2.f12253k = 0.0f;
                        vFullPath2.f12254l = Paint.Cap.BUTT;
                        vFullPath2.f12255m = Paint.Join.MITER;
                        vFullPath2.n = 4.0f;
                        vFullPath2.f12246d = vFullPath.f12246d;
                        vFullPath2.f12247e = vFullPath.f12247e;
                        vFullPath2.f12249g = vFullPath.f12249g;
                        vFullPath2.f12248f = vFullPath.f12248f;
                        vFullPath2.f12269c = vFullPath.f12269c;
                        vFullPath2.f12250h = vFullPath.f12250h;
                        vFullPath2.f12251i = vFullPath.f12251i;
                        vFullPath2.f12252j = vFullPath.f12252j;
                        vFullPath2.f12253k = vFullPath.f12253k;
                        vFullPath2.f12254l = vFullPath.f12254l;
                        vFullPath2.f12255m = vFullPath.f12255m;
                        vFullPath2.n = vFullPath.n;
                        vClipPath = vFullPath2;
                    } else if (obj instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f12257b.add(vClipPath);
                    Object obj2 = vClipPath.f12268b;
                    if (obj2 != null) {
                        arrayMap.put(obj2, vClipPath);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VPathRenderer {
        public static final Matrix p = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f12270a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f12271b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f12272c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f12273d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f12274e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f12275f;

        /* renamed from: g, reason: collision with root package name */
        public final VGroup f12276g;

        /* renamed from: h, reason: collision with root package name */
        public float f12277h;

        /* renamed from: i, reason: collision with root package name */
        public float f12278i;

        /* renamed from: j, reason: collision with root package name */
        public float f12279j;

        /* renamed from: k, reason: collision with root package name */
        public float f12280k;

        /* renamed from: l, reason: collision with root package name */
        public int f12281l;

        /* renamed from: m, reason: collision with root package name */
        public String f12282m;
        public Boolean n;
        public final ArrayMap o;

        public VPathRenderer() {
            this.f12272c = new Matrix();
            this.f12277h = 0.0f;
            this.f12278i = 0.0f;
            this.f12279j = 0.0f;
            this.f12280k = 0.0f;
            this.f12281l = 255;
            this.f12282m = null;
            this.n = null;
            this.o = new ArrayMap();
            this.f12276g = new VGroup();
            this.f12270a = new Path();
            this.f12271b = new Path();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(VGroup vGroup, Matrix matrix, Canvas canvas, int i2, int i3) {
            char c2;
            float f2;
            float f3;
            int i4;
            VGroup vGroup2 = vGroup;
            char c3 = 1;
            vGroup2.f12256a.set(matrix);
            Matrix matrix2 = vGroup2.f12265j;
            Matrix matrix3 = vGroup2.f12256a;
            matrix3.preConcat(matrix2);
            canvas.save();
            char c4 = 0;
            int i5 = 0;
            while (true) {
                ArrayList arrayList = vGroup2.f12257b;
                if (i5 >= arrayList.size()) {
                    canvas.restore();
                    return;
                }
                VObject vObject = (VObject) arrayList.get(i5);
                if (vObject instanceof VGroup) {
                    a((VGroup) vObject, matrix3, canvas, i2, i3);
                } else if (vObject instanceof VPath) {
                    VPath vPath = (VPath) vObject;
                    float f4 = i2 / this.f12279j;
                    float f5 = i3 / this.f12280k;
                    float fMin = Math.min(f4, f5);
                    Matrix matrix4 = this.f12272c;
                    matrix4.set(matrix3);
                    matrix4.postScale(f4, f5);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix3.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[c4], fArr[c3]);
                    boolean z = c3;
                    boolean z2 = c4;
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f6 = (fArr[z2 ? 1 : 0] * fArr[3]) - (fArr[z ? 1 : 0] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f6) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        vPath.getClass();
                        Path path = this.f12270a;
                        path.reset();
                        PathParser.PathDataNode[] pathDataNodeArr = vPath.f12267a;
                        if (pathDataNodeArr != null) {
                            PathParser.PathDataNode.b(pathDataNodeArr, path);
                        }
                        Path path2 = this.f12271b;
                        path2.reset();
                        if (vPath instanceof VClipPath) {
                            path2.setFillType(vPath.f12269c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix4);
                            canvas.clipPath(path2);
                        } else {
                            VFullPath vFullPath = (VFullPath) vPath;
                            float f7 = vFullPath.f12251i;
                            if (f7 != 0.0f || vFullPath.f12252j != 1.0f) {
                                float f8 = vFullPath.f12253k;
                                float f9 = (f7 + f8) % 1.0f;
                                float f10 = (vFullPath.f12252j + f8) % 1.0f;
                                if (this.f12275f == null) {
                                    this.f12275f = new PathMeasure();
                                }
                                this.f12275f.setPath(path, z2);
                                float length = this.f12275f.getLength();
                                float f11 = f9 * length;
                                float f12 = f10 * length;
                                path.reset();
                                if (f11 > f12) {
                                    this.f12275f.getSegment(f11, length, path, z);
                                    f2 = 0.0f;
                                    this.f12275f.getSegment(0.0f, f12, path, z);
                                } else {
                                    f2 = 0.0f;
                                    this.f12275f.getSegment(f11, f12, path, z);
                                }
                                path.rLineTo(f2, f2);
                            }
                            path2.addPath(path, matrix4);
                            ComplexColorCompat complexColorCompat = vFullPath.f12248f;
                            if ((complexColorCompat.f2747a == null && complexColorCompat.f2749c == 0) ? false : true) {
                                if (this.f12274e == null) {
                                    i4 = 16777215;
                                    Paint paint = new Paint(1);
                                    this.f12274e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                } else {
                                    i4 = 16777215;
                                }
                                Paint paint2 = this.f12274e;
                                Shader shader = complexColorCompat.f2747a;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix4);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(vFullPath.f12250h * 255.0f));
                                    f3 = 255.0f;
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i6 = complexColorCompat.f2749c;
                                    float f13 = vFullPath.f12250h;
                                    PorterDuff.Mode mode = VectorDrawableCompat.f12237j;
                                    f3 = 255.0f;
                                    paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f13)) << 24));
                                }
                                paint2.setColorFilter(null);
                                path2.setFillType(vFullPath.f12269c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(path2, paint2);
                            } else {
                                f3 = 255.0f;
                                i4 = 16777215;
                            }
                            ComplexColorCompat complexColorCompat2 = vFullPath.f12246d;
                            if (complexColorCompat2.f2747a != null || complexColorCompat2.f2749c != 0) {
                                if (this.f12273d == null) {
                                    Paint paint3 = new Paint(1);
                                    this.f12273d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.f12273d;
                                Paint.Join join = vFullPath.f12255m;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = vFullPath.f12254l;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(vFullPath.n);
                                Shader shader2 = complexColorCompat2.f2747a;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix4);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(vFullPath.f12249g * f3));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i7 = complexColorCompat2.f2749c;
                                    float f14 = vFullPath.f12249g;
                                    PorterDuff.Mode mode2 = VectorDrawableCompat.f12237j;
                                    paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f14)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(vFullPath.f12247e * fMin * fAbs);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                    c2 = 1;
                    i5++;
                    vGroup2 = vGroup;
                    c3 = c2;
                    c4 = 0;
                }
                c2 = c3;
                i5++;
                vGroup2 = vGroup;
                c3 = c2;
                c4 = 0;
            }
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f12281l;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f12281l = i2;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f12272c = new Matrix();
            this.f12277h = 0.0f;
            this.f12278i = 0.0f;
            this.f12279j = 0.0f;
            this.f12280k = 0.0f;
            this.f12281l = 255;
            this.f12282m = null;
            this.n = null;
            ArrayMap arrayMap = new ArrayMap();
            this.o = arrayMap;
            this.f12276g = new VGroup(vPathRenderer.f12276g, arrayMap);
            this.f12270a = new Path(vPathRenderer.f12270a);
            this.f12271b = new Path(vPathRenderer.f12271b);
            this.f12277h = vPathRenderer.f12277h;
            this.f12278i = vPathRenderer.f12278i;
            this.f12279j = vPathRenderer.f12279j;
            this.f12280k = vPathRenderer.f12280k;
            this.f12281l = vPathRenderer.f12281l;
            this.f12282m = vPathRenderer.f12282m;
            String str = vPathRenderer.f12282m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.n = vPathRenderer.n;
        }
    }
}
