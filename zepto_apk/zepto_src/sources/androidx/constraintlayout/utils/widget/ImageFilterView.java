package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    public final ImageMatrix f2314d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2315e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2316f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f2317g;

    /* renamed from: h, reason: collision with root package name */
    public float f2318h;

    /* renamed from: i, reason: collision with root package name */
    public float f2319i;

    /* renamed from: j, reason: collision with root package name */
    public float f2320j;

    /* renamed from: k, reason: collision with root package name */
    public Path f2321k;

    /* renamed from: l, reason: collision with root package name */
    public ViewOutlineProvider f2322l;

    /* renamed from: m, reason: collision with root package name */
    public RectF f2323m;
    public final Drawable[] n;
    public LayerDrawable o;
    public float p;
    public float q;
    public float r;
    public float s;

    public static class ImageMatrix {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f2326a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        public final ColorMatrix f2327b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        public final ColorMatrix f2328c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        public float f2329d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f2330e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f2331f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f2332g = 1.0f;

        public final void a(ImageView imageView) {
            boolean z;
            float f2;
            char c2;
            char c3;
            char c4;
            char c5;
            char c6;
            char c7;
            float f3;
            char c8;
            float fLog;
            float fPow;
            char c9;
            float f4;
            float fLog2;
            ColorMatrix colorMatrix = this.f2327b;
            colorMatrix.reset();
            float f5 = this.f2330e;
            float[] fArr = this.f2326a;
            boolean z2 = true;
            if (f5 != 1.0f) {
                float f6 = 1.0f - f5;
                float f7 = 0.2999f * f6;
                float f8 = 0.587f * f6;
                float f9 = f6 * 0.114f;
                fArr[0] = f7 + f5;
                fArr[1] = f8;
                fArr[2] = f9;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = f7;
                fArr[6] = f8 + f5;
                fArr[7] = f9;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = f7;
                fArr[11] = f8;
                fArr[12] = f9 + f5;
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 0.0f;
                fArr[16] = 0.0f;
                fArr[17] = 0.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                colorMatrix.set(fArr);
                z = true;
            } else {
                z = false;
            }
            float f10 = this.f2331f;
            ColorMatrix colorMatrix2 = this.f2328c;
            if (f10 != 1.0f) {
                colorMatrix2.setScale(f10, f10, f10, 1.0f);
                colorMatrix.postConcat(colorMatrix2);
                z = true;
            }
            float f11 = this.f2332g;
            if (f11 != 1.0f) {
                if (f11 <= 0.0f) {
                    f11 = 0.01f;
                }
                float f12 = (5000.0f / f11) / 100.0f;
                f2 = 1.0f;
                if (f12 > 66.0f) {
                    f3 = 66.0f;
                    c2 = 17;
                    c3 = 16;
                    double d2 = f12 - 60.0f;
                    c4 = 15;
                    c5 = 14;
                    fPow = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                    c8 = '\r';
                    c7 = '\f';
                    fLog = ((float) Math.pow(d2, 0.07551485300064087d)) * 288.12216f;
                } else {
                    f3 = 66.0f;
                    c2 = 17;
                    c3 = 16;
                    c4 = 15;
                    c5 = 14;
                    c8 = '\r';
                    c7 = '\f';
                    fLog = (((float) Math.log(f12)) * 99.4708f) - 161.11957f;
                    fPow = 255.0f;
                }
                if (f12 >= f3) {
                    c9 = c8;
                    f4 = 305.0448f;
                    fLog2 = 255.0f;
                } else if (f12 > 19.0f) {
                    c9 = c8;
                    f4 = 305.0448f;
                    fLog2 = (((float) Math.log(f12 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    c9 = c8;
                    f4 = 305.0448f;
                    fLog2 = 0.0f;
                }
                float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
                float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
                float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
                float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
                c6 = c9;
                float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - f4;
                float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
                float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
                float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
                fArr[0] = fMin / fMin4;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = fMin2 / fMin5;
                fArr[7] = 0.0f;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = 0.0f;
                fArr[11] = 0.0f;
                fArr[c7] = fMin6;
                fArr[c6] = 0.0f;
                fArr[c5] = 0.0f;
                fArr[c4] = 0.0f;
                fArr[c3] = 0.0f;
                fArr[c2] = 0.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                colorMatrix2.set(fArr);
                colorMatrix.postConcat(colorMatrix2);
                z = true;
            } else {
                f2 = 1.0f;
                c2 = 17;
                c3 = 16;
                c4 = 15;
                c5 = 14;
                c6 = '\r';
                c7 = '\f';
            }
            float f13 = this.f2329d;
            if (f13 != f2) {
                fArr[0] = f13;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f13;
                fArr[7] = 0.0f;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = 0.0f;
                fArr[11] = 0.0f;
                fArr[c7] = f13;
                fArr[c6] = 0.0f;
                fArr[c5] = 0.0f;
                fArr[c4] = 0.0f;
                fArr[c3] = 0.0f;
                fArr[c2] = 0.0f;
                fArr[18] = f2;
                fArr[19] = 0.0f;
                colorMatrix2.set(fArr);
                colorMatrix.postConcat(colorMatrix2);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2314d = new ImageMatrix();
        this.f2315e = true;
        this.f2316f = null;
        this.f2317g = null;
        this.f2318h = 0.0f;
        this.f2319i = 0.0f;
        this.f2320j = Float.NaN;
        this.n = new Drawable[2];
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        c(context, attributeSet);
    }

    private void setOverlay(boolean z) {
        this.f2315e = z;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f2316f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2318h = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f2315e));
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
            this.f2317g = drawable;
            Drawable drawable2 = this.f2316f;
            Drawable[] drawableArr = this.n;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.f2317g = drawable3;
                if (drawable3 != null) {
                    Drawable drawableMutate = drawable3.mutate();
                    this.f2317g = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f2317g = drawableMutate2;
            drawableArr[0] = drawableMutate2;
            drawableArr[1] = this.f2316f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f2318h * 255.0f));
            if (!this.f2315e) {
                this.o.getDrawable(0).setAlpha((int) ((1.0f - this.f2318h) * 255.0f));
            }
            super.setImageDrawable(this.o);
        }
    }

    public final void d() {
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

    public final void e() {
        if (Float.isNaN(this.p) && Float.isNaN(this.q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    public float getBrightness() {
        return this.f2314d.f2329d;
    }

    public float getContrast() {
        return this.f2314d.f2331f;
    }

    public float getCrossfade() {
        return this.f2318h;
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
        return this.f2320j;
    }

    public float getRoundPercent() {
        return this.f2319i;
    }

    public float getSaturation() {
        return this.f2314d.f2330e;
    }

    public float getWarmth() {
        return this.f2314d.f2332g;
    }

    @Override // android.view.View
    public final void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        d();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable drawableMutate = drawable.mutate();
        this.f2316f = drawableMutate;
        Drawable drawable2 = this.f2317g;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = drawable2;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2318h);
    }

    public void setAltImageResource(int i2) {
        Drawable drawableB = AppCompatResources.b(i2, getContext());
        this.f2316f = drawableB;
        setAltImageDrawable(drawableB);
    }

    public void setBrightness(float f2) {
        ImageMatrix imageMatrix = this.f2314d;
        imageMatrix.f2329d = f2;
        imageMatrix.a(this);
    }

    public void setContrast(float f2) {
        ImageMatrix imageMatrix = this.f2314d;
        imageMatrix.f2331f = f2;
        imageMatrix.a(this);
    }

    public void setCrossfade(float f2) {
        this.f2318h = f2;
        if (this.n != null) {
            if (!this.f2315e) {
                this.o.getDrawable(0).setAlpha((int) ((1.0f - this.f2318h) * 255.0f));
            }
            this.o.getDrawable(1).setAlpha((int) (this.f2318h * 255.0f));
            super.setImageDrawable(this.o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f2316f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f2317g = drawableMutate;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2316f;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2318h);
    }

    public void setImagePanX(float f2) {
        this.p = f2;
        e();
    }

    public void setImagePanY(float f2) {
        this.q = f2;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.f2316f == null) {
            super.setImageResource(i2);
            return;
        }
        Drawable drawableMutate = AppCompatResources.b(i2, getContext()).mutate();
        this.f2317g = drawableMutate;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2316f;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2318h);
    }

    public void setImageRotate(float f2) {
        this.s = f2;
        e();
    }

    public void setImageZoom(float f2) {
        this.r = f2;
        e();
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2320j = f2;
            float f3 = this.f2319i;
            this.f2319i = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2320j != f2;
        this.f2320j = f2;
        if (f2 != 0.0f) {
            if (this.f2321k == null) {
                this.f2321k = new Path();
            }
            if (this.f2323m == null) {
                this.f2323m = new RectF();
            }
            if (this.f2322l == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        ImageFilterView imageFilterView = ImageFilterView.this;
                        outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), imageFilterView.f2320j);
                    }
                };
                this.f2322l = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f2323m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2321k.reset();
            Path path = this.f2321k;
            RectF rectF = this.f2323m;
            float f4 = this.f2320j;
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
        boolean z = this.f2319i != f2;
        this.f2319i = f2;
        if (f2 != 0.0f) {
            if (this.f2321k == null) {
                this.f2321k = new Path();
            }
            if (this.f2323m == null) {
                this.f2323m = new RectF();
            }
            if (this.f2322l == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        ImageFilterView imageFilterView = ImageFilterView.this;
                        outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), (Math.min(r3, r4) * imageFilterView.f2319i) / 2.0f);
                    }
                };
                this.f2322l = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2319i) / 2.0f;
            this.f2323m.set(0.0f, 0.0f, width, height);
            this.f2321k.reset();
            this.f2321k.addRoundRect(this.f2323m, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageMatrix imageMatrix = this.f2314d;
        imageMatrix.f2330e = f2;
        imageMatrix.a(this);
    }

    public void setWarmth(float f2) {
        ImageMatrix imageMatrix = this.f2314d;
        imageMatrix.f2332g = f2;
        imageMatrix.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2314d = new ImageMatrix();
        this.f2315e = true;
        this.f2316f = null;
        this.f2317g = null;
        this.f2318h = 0.0f;
        this.f2319i = 0.0f;
        this.f2320j = Float.NaN;
        this.n = new Drawable[2];
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        c(context, attributeSet);
    }
}
