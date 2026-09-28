package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    public static final int v = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeAppearancePathProvider f40526d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f40527e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f40528f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f40529g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f40530h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f40531i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f40532j;

    /* renamed from: k, reason: collision with root package name */
    public MaterialShapeDrawable f40533k;

    /* renamed from: l, reason: collision with root package name */
    public ShapeAppearanceModel f40534l;

    /* renamed from: m, reason: collision with root package name */
    public float f40535m;
    public final Path n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public boolean u;

    @TargetApi(21)
    public class OutlineProvider extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f40536a = new Rect();

        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            ShapeableImageView shapeableImageView = ShapeableImageView.this;
            if (shapeableImageView.f40534l == null) {
                return;
            }
            if (shapeableImageView.f40533k == null) {
                shapeableImageView.f40533k = new MaterialShapeDrawable(shapeableImageView.f40534l);
            }
            RectF rectF = shapeableImageView.f40527e;
            Rect rect = this.f40536a;
            rectF.round(rect);
            shapeableImageView.f40533k.setBounds(rect);
            shapeableImageView.f40533k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean c() {
        return getLayoutDirection() == 1;
    }

    public final void d(int i2, int i3) {
        RectF rectF = this.f40527e;
        rectF.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        ShapeAppearanceModel shapeAppearanceModel = this.f40534l;
        Path path = this.f40531i;
        this.f40526d.a(shapeAppearanceModel, 1.0f, rectF, null, path);
        Path path2 = this.n;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f40528f;
        rectF2.set(0.0f, 0.0f, i2, i3);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.r;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i2 = this.t;
        return i2 != Integer.MIN_VALUE ? i2 : c() ? this.o : this.q;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (this.s != Integer.MIN_VALUE || this.t != Integer.MIN_VALUE) {
            if (c() && (i3 = this.t) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!c() && (i2 = this.s) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.o;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (this.s != Integer.MIN_VALUE || this.t != Integer.MIN_VALUE) {
            if (c() && (i3 = this.s) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!c() && (i2 = this.t) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.q;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i2 = this.s;
        return i2 != Integer.MIN_VALUE ? i2 : c() ? this.q : this.o;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.p;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40534l;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f40532j;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f40535m;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.n, this.f40530h);
        if (this.f40532j == null) {
            return;
        }
        Paint paint = this.f40529g;
        paint.setStrokeWidth(this.f40535m);
        int colorForState = this.f40532j.getColorForState(getDrawableState(), this.f40532j.getDefaultColor());
        if (this.f40535m <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f40531i, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!this.u && isLayoutDirectionResolved()) {
            this.u = true;
            if (!isPaddingRelative() && this.s == Integer.MIN_VALUE && this.t == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d(i2, i3);
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(getContentPaddingLeft() + i2, getContentPaddingTop() + i3, getContentPaddingRight() + i4, getContentPaddingBottom() + i5);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(getContentPaddingStart() + i2, getContentPaddingTop() + i3, getContentPaddingEnd() + i4, getContentPaddingBottom() + i5);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f40534l = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f40533k;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f40532j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(ContextCompat.b(i2, getContext()));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.f40535m != f2) {
            this.f40535m = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = v;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40526d = ShapeAppearancePathProvider.b();
        this.f40531i = new Path();
        this.u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f40530h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f40527e = new RectF();
        this.f40528f = new RectF();
        this.n = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i2, i3);
        setLayerType(2, null);
        this.f40532j = MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.f40535m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
        this.o = dimensionPixelSize;
        this.p = dimensionPixelSize;
        this.q = dimensionPixelSize;
        this.r = dimensionPixelSize;
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f40529g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f40534l = ShapeAppearanceModel.c(context2, attributeSet, i2, i3).a();
        setOutlineProvider(new OutlineProvider());
    }
}
