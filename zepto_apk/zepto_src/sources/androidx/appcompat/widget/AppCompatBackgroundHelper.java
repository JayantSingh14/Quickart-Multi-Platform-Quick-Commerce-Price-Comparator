package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class AppCompatBackgroundHelper {

    /* renamed from: a, reason: collision with root package name */
    public final View f782a;

    /* renamed from: d, reason: collision with root package name */
    public TintInfo f785d;

    /* renamed from: e, reason: collision with root package name */
    public TintInfo f786e;

    /* renamed from: f, reason: collision with root package name */
    public TintInfo f787f;

    /* renamed from: c, reason: collision with root package name */
    public int f784c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatDrawableManager f783b = AppCompatDrawableManager.a();

    public AppCompatBackgroundHelper(View view) {
        this.f782a = view;
    }

    public final void a() {
        View view = this.f782a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f785d != null) {
                if (this.f787f == null) {
                    this.f787f = new TintInfo();
                }
                TintInfo tintInfo = this.f787f;
                tintInfo.a();
                ColorStateList colorStateListH = ViewCompat.h(view);
                if (colorStateListH != null) {
                    tintInfo.f1183d = true;
                    tintInfo.f1180a = colorStateListH;
                }
                PorterDuff.Mode modeI = ViewCompat.i(view);
                if (modeI != null) {
                    tintInfo.f1182c = true;
                    tintInfo.f1181b = modeI;
                }
                if (tintInfo.f1183d || tintInfo.f1182c) {
                    AppCompatDrawableManager.e(background, tintInfo, view.getDrawableState());
                    return;
                }
            }
            TintInfo tintInfo2 = this.f786e;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.e(background, tintInfo2, view.getDrawableState());
                return;
            }
            TintInfo tintInfo3 = this.f785d;
            if (tintInfo3 != null) {
                AppCompatDrawableManager.e(background, tintInfo3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        TintInfo tintInfo = this.f786e;
        if (tintInfo != null) {
            return tintInfo.f1180a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        TintInfo tintInfo = this.f786e;
        if (tintInfo != null) {
            return tintInfo.f1181b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListG;
        View view = this.f782a;
        TintTypedArray tintTypedArrayF = TintTypedArray.f(view.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i2);
        TypedArray typedArray = tintTypedArrayF.f1185b;
        View view2 = this.f782a;
        ViewCompat.y(view2, view2.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        try {
            if (typedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f784c = typedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                AppCompatDrawableManager appCompatDrawableManager = this.f783b;
                Context context = view.getContext();
                int i3 = this.f784c;
                synchronized (appCompatDrawableManager) {
                    colorStateListG = appCompatDrawableManager.f836a.g(i3, context);
                }
                if (colorStateListG != null) {
                    g(colorStateListG);
                }
            }
            if (typedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.C(view, tintTypedArrayF.a(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.D(view, DrawableUtils.c(typedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            tintTypedArrayF.g();
        } catch (Throwable th) {
            tintTypedArrayF.g();
            throw th;
        }
    }

    public final void e() {
        this.f784c = -1;
        g(null);
        a();
    }

    public final void f(int i2) {
        ColorStateList colorStateListG;
        this.f784c = i2;
        AppCompatDrawableManager appCompatDrawableManager = this.f783b;
        if (appCompatDrawableManager != null) {
            Context context = this.f782a.getContext();
            synchronized (appCompatDrawableManager) {
                colorStateListG = appCompatDrawableManager.f836a.g(i2, context);
            }
        } else {
            colorStateListG = null;
        }
        g(colorStateListG);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f785d == null) {
                this.f785d = new TintInfo();
            }
            TintInfo tintInfo = this.f785d;
            tintInfo.f1180a = colorStateList;
            tintInfo.f1183d = true;
        } else {
            this.f785d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f786e == null) {
            this.f786e = new TintInfo();
        }
        TintInfo tintInfo = this.f786e;
        tintInfo.f1180a = colorStateList;
        tintInfo.f1183d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f786e == null) {
            this.f786e = new TintInfo();
        }
        TintInfo tintInfo = this.f786e;
        tintInfo.f1181b = mode;
        tintInfo.f1182c = true;
        a();
    }
}
