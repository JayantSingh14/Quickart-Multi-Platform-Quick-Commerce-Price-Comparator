package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatSeekBar f903d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f904e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f905f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f906g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f907h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f908i;

    public AppCompatSeekBarHelper(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.f905f = null;
        this.f906g = null;
        this.f907h = false;
        this.f908i = false;
        this.f903d = appCompatSeekBar;
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public final void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        AppCompatSeekBar appCompatSeekBar = this.f903d;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(appCompatSeekBar.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i2);
        ViewCompat.y(appCompatSeekBar, appCompatSeekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        Drawable drawableC = tintTypedArrayF.c(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableC != null) {
            appCompatSeekBar.setThumb(drawableC);
        }
        Drawable drawableB = tintTypedArrayF.b(R.styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f904e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f904e = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(appCompatSeekBar);
            drawableB.setLayoutDirection(appCompatSeekBar.getLayoutDirection());
            if (drawableB.isStateful()) {
                drawableB.setState(appCompatSeekBar.getDrawableState());
            }
            c();
        }
        appCompatSeekBar.invalidate();
        int i3 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        if (typedArray.hasValue(i3)) {
            this.f906g = DrawableUtils.c(typedArray.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f906g);
            this.f908i = true;
        }
        if (typedArray.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f905f = tintTypedArrayF.a(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f907h = true;
        }
        tintTypedArrayF.g();
        c();
    }

    public final void c() {
        Drawable drawable = this.f904e;
        if (drawable != null) {
            if (this.f907h || this.f908i) {
                Drawable drawableMutate = drawable.mutate();
                this.f904e = drawableMutate;
                if (this.f907h) {
                    drawableMutate.setTintList(this.f905f);
                }
                if (this.f908i) {
                    this.f904e.setTintMode(this.f906g);
                }
                if (this.f904e.isStateful()) {
                    this.f904e.setState(this.f903d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f904e != null) {
            int max = this.f903d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f904e.getIntrinsicWidth();
                int intrinsicHeight = this.f904e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f904e.setBounds(-i2, -i3, i2, i3);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f904e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public final void e() {
        Drawable drawable = this.f904e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        AppCompatSeekBar appCompatSeekBar = this.f903d;
        if (drawable.setState(appCompatSeekBar.getDrawableState())) {
            appCompatSeekBar.invalidateDrawable(drawable);
        }
    }

    public final void f() {
        Drawable drawable = this.f904e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }
}
