package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import java.util.Objects;
import org.xbill.DNS.Message;

/* loaded from: classes3.dex */
public class MotionLabel extends View implements FloatLayout {
    public float A;
    public Paint A0;
    public float B;
    public float B0;
    public Drawable C;
    public float C0;
    public Matrix D;
    public float D0;
    public Bitmap E;
    public float E0;
    public BitmapShader F;
    public float F0;
    public Matrix G;
    public float H;
    public float I;
    public float J;
    public float K;
    public final Paint L;
    public int M;
    public Rect Q;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f2351a;

    /* renamed from: b, reason: collision with root package name */
    public Path f2352b;

    /* renamed from: c, reason: collision with root package name */
    public int f2353c;

    /* renamed from: d, reason: collision with root package name */
    public int f2354d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2355e;

    /* renamed from: f, reason: collision with root package name */
    public float f2356f;

    /* renamed from: g, reason: collision with root package name */
    public float f2357g;

    /* renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f2358h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f2359i;

    /* renamed from: j, reason: collision with root package name */
    public float f2360j;

    /* renamed from: k, reason: collision with root package name */
    public float f2361k;

    /* renamed from: l, reason: collision with root package name */
    public int f2362l;

    /* renamed from: m, reason: collision with root package name */
    public int f2363m;
    public float n;
    public String o;
    public boolean p;
    public final Rect q;
    public int r;
    public int s;
    public int t;
    public int u;
    public String v;
    public int w;
    public int x;
    public boolean y;
    public float z;

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2351a = new TextPaint();
        this.f2352b = new Path();
        this.f2353c = Message.MAXLENGTH;
        this.f2354d = Message.MAXLENGTH;
        this.f2355e = false;
        this.f2356f = 0.0f;
        this.f2357g = Float.NaN;
        this.f2360j = 48.0f;
        this.f2361k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.w = 8388659;
        this.x = 0;
        this.y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.C0 = Float.NaN;
        this.D0 = Float.NaN;
        this.E0 = Float.NaN;
        this.F0 = Float.NaN;
        c(context, attributeSet);
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.f2361k) ? 1.0f : this.f2360j / this.f2361k;
        String str = this.o;
        return ((this.J + 1.0f) * ((((Float.isNaN(this.A) ? getMeasuredWidth() : this.A) - getPaddingLeft()) - getPaddingRight()) - (this.f2351a.measureText(str, 0, str.length()) * f2))) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.f2361k) ? 1.0f : this.f2360j / this.f2361k;
        Paint.FontMetrics fontMetrics = this.f2351a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.B) ? getMeasuredHeight() : this.B) - getPaddingTop()) - getPaddingBottom();
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        return (((1.0f - this.K) * (measuredHeight - ((f3 - f4) * f2))) / 2.0f) - (f2 * f4);
    }

    private void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int i2 = typedValue.data;
        this.f2353c = i2;
        this.f2351a.setColor(i2);
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public final void a(float f2, float f3, float f4, float f5) {
        int i2 = (int) (f2 + 0.5f);
        this.z = f2 - i2;
        int i3 = (int) (f4 + 0.5f);
        int i4 = i3 - i2;
        int i5 = (int) (f5 + 0.5f);
        int i6 = (int) (0.5f + f3);
        int i7 = i5 - i6;
        float f6 = f4 - f2;
        this.A = f6;
        float f7 = f5 - f3;
        this.B = f7;
        if (this.G != null) {
            this.A = f6;
            this.B = f7;
            d();
        }
        if (getMeasuredHeight() == i7 && getMeasuredWidth() == i4) {
            super.layout(i2, i6, i3, i5);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
            super.layout(i2, i6, i3, i5);
        }
        if (this.y) {
            Rect rect = this.Q;
            TextPaint textPaint = this.f2351a;
            if (rect == null) {
                this.A0 = new Paint();
                this.Q = new Rect();
                this.A0.set(textPaint);
                this.B0 = this.A0.getTextSize();
            }
            this.A = f6;
            this.B = f7;
            Paint paint = this.A0;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.Q);
            float fHeight = this.Q.height() * 1.3f;
            float f8 = (f6 - this.s) - this.r;
            float f9 = (f7 - this.u) - this.t;
            float fWidth = this.Q.width();
            if (fWidth * f9 > fHeight * f8) {
                textPaint.setTextSize((this.B0 * f8) / fWidth);
            } else {
                textPaint.setTextSize((this.B0 * f9) / fHeight);
            }
            if (this.f2355e || !Float.isNaN(this.f2361k)) {
                b(Float.isNaN(this.f2361k) ? 1.0f : this.f2360j / this.f2361k);
            }
        }
    }

    public final void b(float f2) {
        if (this.f2355e || f2 != 1.0f) {
            this.f2352b.reset();
            String str = this.o;
            int length = str.length();
            TextPaint textPaint = this.f2351a;
            Rect rect = this.q;
            textPaint.getTextBounds(str, 0, length, rect);
            this.f2351a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f2352b);
            if (f2 != 1.0f) {
                Log.v("MotionLabel", Debug.a() + " scale " + f2);
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.f2352b.transform(matrix);
            }
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.p = false;
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Typeface typefaceCreate;
        setUpTheme(context);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_fontFamily) {
                    this.v = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f2361k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f2361k);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textSize) {
                    this.f2360j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f2360j);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textStyle) {
                    this.f2362l = typedArrayObtainStyledAttributes.getInt(index, this.f2362l);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_typeface) {
                    this.f2363m = typedArrayObtainStyledAttributes.getInt(index, this.f2363m);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textColor) {
                    this.f2353c = typedArrayObtainStyledAttributes.getColor(index, this.f2353c);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.f2357g);
                    this.f2357g = dimension;
                    setRound(dimension);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_borderRoundPercent) {
                    float f2 = typedArrayObtainStyledAttributes.getFloat(index, this.f2356f);
                    this.f2356f = f2;
                    setRoundPercent(f2);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.x = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textOutlineColor) {
                    this.f2354d = typedArrayObtainStyledAttributes.getInt(index, this.f2354d);
                    this.f2355e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textOutlineThickness) {
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    this.f2355e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackground) {
                    this.C = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f2355e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundPanX) {
                    this.C0 = typedArrayObtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundPanY) {
                    this.D0 = typedArrayObtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textPanX) {
                    this.J = typedArrayObtainStyledAttributes.getFloat(index, this.J);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textPanY) {
                    this.K = typedArrayObtainStyledAttributes.getFloat(index, this.K);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundRotate) {
                    this.F0 = typedArrayObtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundZoom) {
                    this.E0 = typedArrayObtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureHeight) {
                    this.H = typedArrayObtainStyledAttributes.getDimension(index, this.H);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureWidth) {
                    this.I = typedArrayObtainStyledAttributes.getDimension(index, this.I);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureEffect) {
                    this.M = typedArrayObtainStyledAttributes.getInt(index, this.M);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.C != null) {
            this.G = new Matrix();
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int intrinsicHeight = this.C.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.I) ? 128 : (int) this.I;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.H) ? 128 : (int) this.H;
            }
            if (this.M != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.E = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.E);
            this.C.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.C.setFilterBitmap(true);
            this.C.draw(canvas);
            if (this.M != 0) {
                Bitmap bitmap = this.E;
                int width = bitmap.getWidth() / 2;
                int height = bitmap.getHeight() / 2;
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                for (int i3 = 0; i3 < 4 && width >= 32 && height >= 32; i3++) {
                    width /= 2;
                    height /= 2;
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
                }
                this.E = bitmapCreateScaledBitmap;
            }
            Bitmap bitmap2 = this.E;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.F = new BitmapShader(bitmap2, tileMode, tileMode);
        }
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        String str = this.v;
        int i4 = this.f2363m;
        int i5 = this.f2362l;
        TextPaint textPaint = this.f2351a;
        if (str != null) {
            typefaceCreate = Typeface.create(str, i5);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
            }
            textPaint.setColor(this.f2353c);
            textPaint.setStrokeWidth(this.n);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint.setFlags(128);
            setTextSize(this.f2360j);
            textPaint.setAntiAlias(true);
        }
        typefaceCreate = null;
        if (i4 == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i4 == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i4 == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (i5 > 0) {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typefaceCreate, i5);
            setTypeface(typefaceDefaultFromStyle);
            int i6 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i5;
            textPaint.setFakeBoldText((i6 & 1) != 0);
            textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
        } else {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        }
        textPaint.setColor(this.f2353c);
        textPaint.setStrokeWidth(this.n);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setFlags(128);
        setTextSize(this.f2360j);
        textPaint.setAntiAlias(true);
    }

    public final void d() {
        float f2 = Float.isNaN(this.C0) ? 0.0f : this.C0;
        float f3 = Float.isNaN(this.D0) ? 0.0f : this.D0;
        float f4 = Float.isNaN(this.E0) ? 1.0f : this.E0;
        float f5 = Float.isNaN(this.F0) ? 0.0f : this.F0;
        this.G.reset();
        float width = this.E.getWidth();
        float height = this.E.getHeight();
        float f6 = Float.isNaN(this.I) ? this.A : this.I;
        float f7 = Float.isNaN(this.H) ? this.B : this.H;
        float f8 = f4 * (width * f7 < height * f6 ? f6 / width : f7 / height);
        this.G.postScale(f8, f8);
        float f9 = width * f8;
        float f10 = f6 - f9;
        float f11 = f8 * height;
        float f12 = f7 - f11;
        if (!Float.isNaN(this.H)) {
            f12 = this.H / 2.0f;
        }
        if (!Float.isNaN(this.I)) {
            f10 = this.I / 2.0f;
        }
        this.G.postTranslate((((f2 * f10) + f6) - f9) * 0.5f, (((f3 * f12) + f7) - f11) * 0.5f);
        this.G.postRotate(f5, f6 / 2.0f, f7 / 2.0f);
        this.F.setLocalMatrix(this.G);
    }

    public float getRound() {
        return this.f2357g;
    }

    public float getRoundPercent() {
        return this.f2356f;
    }

    public float getScaleFromTextSize() {
        return this.f2361k;
    }

    public float getTextBackgroundPanX() {
        return this.C0;
    }

    public float getTextBackgroundPanY() {
        return this.D0;
    }

    public float getTextBackgroundRotate() {
        return this.F0;
    }

    public float getTextBackgroundZoom() {
        return this.E0;
    }

    public int getTextOutlineColor() {
        return this.f2354d;
    }

    public float getTextPanX() {
        return this.J;
    }

    public float getTextPanY() {
        return this.K;
    }

    public float getTextureHeight() {
        return this.H;
    }

    public float getTextureWidth() {
        return this.I;
    }

    public Typeface getTypeface() {
        return this.f2351a.getTypeface();
    }

    @Override // android.view.View
    public final void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        boolean zIsNaN = Float.isNaN(this.f2361k);
        float f2 = zIsNaN ? 1.0f : this.f2360j / this.f2361k;
        this.A = i4 - i2;
        this.B = i5 - i3;
        if (this.y) {
            Rect rect = this.Q;
            TextPaint textPaint = this.f2351a;
            if (rect == null) {
                this.A0 = new Paint();
                this.Q = new Rect();
                this.A0.set(textPaint);
                this.B0 = this.A0.getTextSize();
            }
            Paint paint = this.A0;
            String str = this.o;
            paint.getTextBounds(str, 0, str.length(), this.Q);
            int iWidth = this.Q.width();
            int iHeight = (int) (this.Q.height() * 1.3f);
            float f3 = (this.A - this.s) - this.r;
            float f4 = (this.B - this.u) - this.t;
            if (zIsNaN) {
                float f5 = iWidth;
                float f6 = iHeight;
                if (f5 * f4 > f6 * f3) {
                    textPaint.setTextSize((this.B0 * f3) / f5);
                } else {
                    textPaint.setTextSize((this.B0 * f4) / f6);
                }
            } else {
                float f7 = iWidth;
                float f8 = iHeight;
                f2 = f7 * f4 > f8 * f3 ? f3 / f7 : f4 / f8;
            }
        }
        if (this.f2355e || !zIsNaN) {
            float f9 = i2;
            float f10 = i3;
            float f11 = i4;
            float f12 = i5;
            if (this.G != null) {
                this.A = f11 - f9;
                this.B = f12 - f10;
                d();
            }
            b(f2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.f2361k) ? 1.0f : this.f2360j / this.f2361k;
        super.onDraw(canvas);
        boolean z = this.f2355e;
        TextPaint textPaint = this.f2351a;
        if (!z && f2 == 1.0f) {
            canvas.drawText(this.o, this.z + this.r + getHorizontalOffset(), this.t + getVerticalOffset(), textPaint);
            return;
        }
        if (this.p) {
            b(f2);
        }
        if (this.D == null) {
            this.D = new Matrix();
        }
        if (!this.f2355e) {
            float horizontalOffset = this.r + getHorizontalOffset();
            float verticalOffset = this.t + getVerticalOffset();
            this.D.reset();
            this.D.preTranslate(horizontalOffset, verticalOffset);
            this.f2352b.transform(this.D);
            textPaint.setColor(this.f2353c);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint.setStrokeWidth(this.n);
            canvas.drawPath(this.f2352b, textPaint);
            this.D.reset();
            this.D.preTranslate(-horizontalOffset, -verticalOffset);
            this.f2352b.transform(this.D);
            return;
        }
        Paint paint = this.L;
        paint.set(textPaint);
        this.D.reset();
        float horizontalOffset2 = this.r + getHorizontalOffset();
        float verticalOffset2 = this.t + getVerticalOffset();
        this.D.postTranslate(horizontalOffset2, verticalOffset2);
        this.D.preScale(f2, f2);
        this.f2352b.transform(this.D);
        if (this.F != null) {
            textPaint.setFilterBitmap(true);
            textPaint.setShader(this.F);
        } else {
            textPaint.setColor(this.f2353c);
        }
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth(this.n);
        canvas.drawPath(this.f2352b, textPaint);
        if (this.F != null) {
            textPaint.setShader(null);
        }
        textPaint.setColor(this.f2354d);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.n);
        canvas.drawPath(this.f2352b, textPaint);
        this.D.reset();
        this.D.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f2352b.transform(this.D);
        textPaint.set(paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.y = false;
        this.r = getPaddingLeft();
        this.s = getPaddingRight();
        this.t = getPaddingTop();
        this.u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            String str = this.o;
            int length = str.length();
            this.f2351a.getTextBounds(str, 0, length, this.q);
            if (mode != 1073741824) {
                size = (int) (r7.width() + 0.99999f);
            }
            size += this.r + this.s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (r6.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.t + this.u + fontMetricsInt;
            }
        } else if (this.x != 0) {
            this.y = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i2) {
        if ((i2 & 8388615) == 0) {
            i2 |= 8388611;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        if (i2 != this.w) {
            invalidate();
        }
        this.w = i2;
        int i3 = i2 & 112;
        if (i3 == 48) {
            this.K = -1.0f;
        } else if (i3 != 80) {
            this.K = 0.0f;
        } else {
            this.K = 1.0f;
        }
        int i4 = i2 & 8388615;
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 8388611) {
                    if (i4 != 8388613) {
                        this.J = 0.0f;
                        return;
                    }
                }
            }
            this.J = 1.0f;
            return;
        }
        this.J = -1.0f;
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2357g = f2;
            float f3 = this.f2356f;
            this.f2356f = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2357g != f2;
        this.f2357g = f2;
        if (f2 != 0.0f) {
            if (this.f2352b == null) {
                this.f2352b = new Path();
            }
            if (this.f2359i == null) {
                this.f2359i = new RectF();
            }
            if (this.f2358h == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        MotionLabel motionLabel = MotionLabel.this;
                        outline.setRoundRect(0, 0, motionLabel.getWidth(), motionLabel.getHeight(), motionLabel.f2357g);
                    }
                };
                this.f2358h = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f2359i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2352b.reset();
            Path path = this.f2352b;
            RectF rectF = this.f2359i;
            float f4 = this.f2357g;
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
        boolean z = this.f2356f != f2;
        this.f2356f = f2;
        if (f2 != 0.0f) {
            if (this.f2352b == null) {
                this.f2352b = new Path();
            }
            if (this.f2359i == null) {
                this.f2359i = new RectF();
            }
            if (this.f2358h == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        MotionLabel motionLabel = MotionLabel.this;
                        outline.setRoundRect(0, 0, motionLabel.getWidth(), motionLabel.getHeight(), (Math.min(r3, r4) * motionLabel.f2356f) / 2.0f);
                    }
                };
                this.f2358h = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2356f) / 2.0f;
            this.f2359i.set(0.0f, 0.0f, width, height);
            this.f2352b.reset();
            this.f2352b.addRoundRect(this.f2359i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.f2361k = f2;
    }

    public void setText(CharSequence charSequence) {
        this.o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.C0 = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.D0 = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.F0 = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.E0 = f2;
        d();
        invalidate();
    }

    public void setTextFillColor(int i2) {
        this.f2353c = i2;
        invalidate();
    }

    public void setTextOutlineColor(int i2) {
        this.f2354d = i2;
        this.f2355e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.n = f2;
        this.f2355e = true;
        if (Float.isNaN(f2)) {
            this.n = 1.0f;
            this.f2355e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.J = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.K = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f2360j = f2;
        if (!Float.isNaN(this.f2361k)) {
            f2 = this.f2361k;
        }
        this.f2351a.setTextSize(f2);
        b(Float.isNaN(this.f2361k) ? 1.0f : this.f2360j / this.f2361k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.H = f2;
        d();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.I = f2;
        d();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        TextPaint textPaint = this.f2351a;
        if (Objects.equals(textPaint.getTypeface(), typeface)) {
            return;
        }
        textPaint.setTypeface(typeface);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2351a = new TextPaint();
        this.f2352b = new Path();
        this.f2353c = Message.MAXLENGTH;
        this.f2354d = Message.MAXLENGTH;
        this.f2355e = false;
        this.f2356f = 0.0f;
        this.f2357g = Float.NaN;
        this.f2360j = 48.0f;
        this.f2361k = Float.NaN;
        this.n = 0.0f;
        this.o = "Hello World";
        this.p = true;
        this.q = new Rect();
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.w = 8388659;
        this.x = 0;
        this.y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.C0 = Float.NaN;
        this.D0 = Float.NaN;
        this.E0 = Float.NaN;
        this.F0 = Float.NaN;
        c(context, attributeSet);
    }
}
