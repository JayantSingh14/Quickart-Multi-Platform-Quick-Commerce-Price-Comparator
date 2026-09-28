package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f40612a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f40613b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f40614c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f40615d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40616e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40617f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40618g;

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f40613b == null || this.f40612a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z = this.f40615d;
        Rect rect = this.f40614c;
        if (z) {
            rect.set(0, 0, width, this.f40613b.top);
            this.f40612a.setBounds(rect);
            this.f40612a.draw(canvas);
        }
        if (this.f40616e) {
            rect.set(0, height - this.f40613b.bottom, width, height);
            this.f40612a.setBounds(rect);
            this.f40612a.draw(canvas);
        }
        if (this.f40617f) {
            Rect rect2 = this.f40613b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f40612a.setBounds(rect);
            this.f40612a.draw(canvas);
        }
        if (this.f40618g) {
            Rect rect3 = this.f40613b;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f40612a.setBounds(rect);
            this.f40612a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public void g(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f40612a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f40612a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f40616e = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.f40617f = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.f40618g = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f40615d = z;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f40612a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f40614c = new Rect();
        this.f40615d = true;
        this.f40616e = true;
        this.f40617f = true;
        this.f40618g = true;
        TypedArray typedArrayD = ThemeEnforcement.d(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i2, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f40612a = typedArrayD.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayD.recycle();
        setWillNotDraw(true);
        ViewCompat.H(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.f40613b == null) {
                    scrimInsetsFrameLayout.f40613b = new Rect();
                }
                scrimInsetsFrameLayout.f40613b.set(windowInsetsCompat.h(), windowInsetsCompat.j(), windowInsetsCompat.i(), windowInsetsCompat.g());
                scrimInsetsFrameLayout.g(windowInsetsCompat);
                scrimInsetsFrameLayout.setWillNotDraw(!windowInsetsCompat.k() || scrimInsetsFrameLayout.f40612a == null);
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                scrimInsetsFrameLayout.postInvalidateOnAnimation();
                return windowInsetsCompat.c();
            }
        });
    }
}
