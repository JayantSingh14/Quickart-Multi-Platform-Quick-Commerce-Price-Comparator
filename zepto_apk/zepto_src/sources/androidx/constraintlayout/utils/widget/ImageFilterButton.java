package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d, reason: collision with root package name */
    public final ImageFilterView.ImageMatrix f2302d;

    /* renamed from: e, reason: collision with root package name */
    public float f2303e;

    /* renamed from: f, reason: collision with root package name */
    public float f2304f;

    /* renamed from: g, reason: collision with root package name */
    public float f2305g;

    /* renamed from: h, reason: collision with root package name */
    public Path f2306h;

    /* renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f2307i;

    /* renamed from: j, reason: collision with root package name */
    public RectF f2308j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable[] f2309k;

    /* renamed from: l, reason: collision with root package name */
    public LayerDrawable f2310l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2311m;
    public Drawable n;
    public Drawable o;
    public float p;
    public float q;
    public float r;
    public float s;

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2302d = new ImageFilterView.ImageMatrix();
        this.f2303e = 0.0f;
        this.f2304f = 0.0f;
        this.f2305g = Float.NaN;
        this.f2309k = new Drawable[2];
        this.f2311m = true;
        this.n = null;
        this.o = null;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        a(context, attributeSet);
    }

    private void setOverlay(boolean z) {
        this.f2311m = z;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.n = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2303e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f2311m));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.o = drawable;
            Drawable drawable2 = this.n;
            Drawable[] drawableArr = this.f2309k;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.o = drawable3;
                if (drawable3 != null) {
                    Drawable drawableMutate = drawable3.mutate();
                    this.o = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable drawableMutate2 = getDrawable().mutate();
            this.o = drawableMutate2;
            drawableArr[0] = drawableMutate2;
            drawableArr[1] = this.n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f2310l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f2303e * 255.0f));
            if (!this.f2311m) {
                this.f2310l.getDrawable(0).setAlpha((int) ((1.0f - this.f2303e) * 255.0f));
            }
            super.setImageDrawable(this.f2310l);
        }
    }

    public final void b() {
        if (Float.isNaN(this.p) && Float.isNaN(this.q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            return;
        }
        float f2 = Float.isNaN(this.p) ? 0.0f : this.p;
        float f3 = Float.isNaN(this.q) ? 0.0f : this.q;
        float f4 = Float.isNaN(this.r) ? 1.0f : this.r;
        float f5 = Float.isNaN(this.s) ? 0.0f : this.s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f6 = f4 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f6, f6);
        float f7 = intrinsicWidth * f6;
        float f8 = f6 * intrinsicHeight;
        matrix.postTranslate(((((width - f7) * f2) + width) - f7) * 0.5f, ((((height - f8) * f3) + height) - f8) * 0.5f);
        matrix.postRotate(f5, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void c() {
        if (Float.isNaN(this.p) && Float.isNaN(this.q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            b();
        }
    }

    public float getContrast() {
        return this.f2302d.f2331f;
    }

    public float getCrossfade() {
        return this.f2303e;
    }

    public float getImagePanX() {
        return this.p;
    }

    public float getImagePanY() {
        return this.q;
    }

    public float getImageRotate() {
        return this.s;
    }

    public float getImageZoom() {
        return this.r;
    }

    public float getRound() {
        return this.f2305g;
    }

    public float getRoundPercent() {
        return this.f2304f;
    }

    public float getSaturation() {
        return this.f2302d.f2330e;
    }

    public float getWarmth() {
        return this.f2302d.f2332g;
    }

    @Override // android.view.View
    public final void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        b();
    }

    public void setAltImageResource(int i2) {
        Drawable drawableMutate = AppCompatResources.b(i2, getContext()).mutate();
        this.n = drawableMutate;
        Drawable drawable = this.o;
        Drawable[] drawableArr = this.f2309k;
        drawableArr[0] = drawable;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f2310l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2303e);
    }

    public void setBrightness(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f2302d;
        imageMatrix.f2329d = f2;
        imageMatrix.a(this);
    }

    public void setContrast(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f2302d;
        imageMatrix.f2331f = f2;
        imageMatrix.a(this);
    }

    public void setCrossfade(float f2) {
        this.f2303e = f2;
        if (this.f2309k != null) {
            if (!this.f2311m) {
                this.f2310l.getDrawable(0).setAlpha((int) ((1.0f - this.f2303e) * 255.0f));
            }
            this.f2310l.getDrawable(1).setAlpha((int) (this.f2303e * 255.0f));
            super.setImageDrawable(this.f2310l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.o = drawableMutate;
        Drawable[] drawableArr = this.f2309k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.n;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f2310l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2303e);
    }

    public void setImagePanX(float f2) {
        this.p = f2;
        c();
    }

    public void setImagePanY(float f2) {
        this.q = f2;
        c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.n == null) {
            super.setImageResource(i2);
            return;
        }
        Drawable drawableMutate = AppCompatResources.b(i2, getContext()).mutate();
        this.o = drawableMutate;
        Drawable[] drawableArr = this.f2309k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.n;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f2310l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2303e);
    }

    public void setImageRotate(float f2) {
        this.s = f2;
        c();
    }

    public void setImageZoom(float f2) {
        this.r = f2;
        c();
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2305g = f2;
            float f3 = this.f2304f;
            this.f2304f = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2305g != f2;
        this.f2305g = f2;
        if (f2 != 0.0f) {
            if (this.f2306h == null) {
                this.f2306h = new Path();
            }
            if (this.f2308j == null) {
                this.f2308j = new RectF();
            }
            if (this.f2307i == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.2
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        ImageFilterButton imageFilterButton = ImageFilterButton.this;
                        outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), imageFilterButton.f2305g);
                    }
                };
                this.f2307i = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f2308j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2306h.reset();
            Path path = this.f2306h;
            RectF rectF = this.f2308j;
            float f4 = this.f2305g;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi
    public void setRoundPercent(float f2) {
        boolean z = this.f2304f != f2;
        this.f2304f = f2;
        if (f2 != 0.0f) {
            if (this.f2306h == null) {
                this.f2306h = new Path();
            }
            if (this.f2308j == null) {
                this.f2308j = new RectF();
            }
            if (this.f2307i == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.1
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        ImageFilterButton imageFilterButton = ImageFilterButton.this;
                        outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), (Math.min(r3, r4) * imageFilterButton.f2304f) / 2.0f);
                    }
                };
                this.f2307i = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2304f) / 2.0f;
            this.f2308j.set(0.0f, 0.0f, width, height);
            this.f2306h.reset();
            this.f2306h.addRoundRect(this.f2308j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f2302d;
        imageMatrix.f2330e = f2;
        imageMatrix.a(this);
    }

    public void setWarmth(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f2302d;
        imageMatrix.f2332g = f2;
        imageMatrix.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2302d = new ImageFilterView.ImageMatrix();
        this.f2303e = 0.0f;
        this.f2304f = 0.0f;
        this.f2305g = Float.NaN;
        this.f2309k = new Drawable[2];
        this.f2311m = true;
        this.n = null;
        this.o = null;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        a(context, attributeSet);
    }
}
