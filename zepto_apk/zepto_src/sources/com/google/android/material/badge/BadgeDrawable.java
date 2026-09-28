package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.OptIn;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

@OptIn
/* loaded from: classes4.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int n = R.style.Widget_MaterialComponents_Badge;
    public static final int o = R.attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f39913a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialShapeDrawable f39914b;

    /* renamed from: c, reason: collision with root package name */
    public final TextDrawableHelper f39915c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f39916d;

    /* renamed from: e, reason: collision with root package name */
    public final BadgeState f39917e;

    /* renamed from: f, reason: collision with root package name */
    public float f39918f;

    /* renamed from: g, reason: collision with root package name */
    public float f39919g;

    /* renamed from: h, reason: collision with root package name */
    public final int f39920h;

    /* renamed from: i, reason: collision with root package name */
    public float f39921i;

    /* renamed from: j, reason: collision with root package name */
    public float f39922j;

    /* renamed from: k, reason: collision with root package name */
    public float f39923k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f39924l;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference f39925m;

    /* renamed from: com.google.android.material.badge.BadgeDrawable$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public BadgeDrawable(Context context, BadgeState.State state) {
        TextAppearance textAppearance;
        WeakReference weakReference = new WeakReference(context);
        this.f39913a = weakReference;
        ThemeEnforcement.c(context, ThemeEnforcement.f40650b, "Theme.MaterialComponents");
        this.f39916d = new Rect();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f39915c = textDrawableHelper;
        TextPaint textPaint = textDrawableHelper.f40640a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, state);
        this.f39917e = badgeState;
        boolean zF = f();
        BadgeState.State state2 = badgeState.f39927b;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.a(context, zF ? state2.f39943g.intValue() : state2.f39941e.intValue(), f() ? state2.f39944h.intValue() : state2.f39942f.intValue()).a());
        this.f39914b = materialShapeDrawable;
        h();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && textDrawableHelper.f40646g != (textAppearance = new TextAppearance(context2, state2.f39940d.intValue()))) {
            textDrawableHelper.c(textAppearance, context2);
            textPaint.setColor(state2.f39939c.intValue());
            invalidateSelf();
            j();
            invalidateSelf();
        }
        int i2 = state2.f39948l;
        if (i2 != -2) {
            this.f39920h = ((int) Math.pow(10.0d, i2 - 1.0d)) - 1;
        } else {
            this.f39920h = state2.f39949m;
        }
        textDrawableHelper.f40644e = true;
        j();
        invalidateSelf();
        textDrawableHelper.f40644e = true;
        h();
        j();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(state2.f39938b.intValue());
        if (materialShapeDrawable.f40974a.f40991c != colorStateListValueOf) {
            materialShapeDrawable.m(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(state2.f39939c.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f39924l;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f39924l.get();
            WeakReference weakReference3 = this.f39925m;
            i(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        j();
        setVisible(state2.t.booleanValue(), false);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        BadgeState badgeState = this.f39917e;
        BadgeState.State state = badgeState.f39927b;
        String str = state.f39946j;
        boolean z = str != null;
        WeakReference weakReference = this.f39913a;
        if (z) {
            int i2 = state.f39948l;
            if (i2 == -2 || str == null || str.length() <= i2) {
                return str;
            }
            Context context = (Context) weakReference.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i2 - 1), "…");
        }
        if (!g()) {
            return null;
        }
        int i3 = this.f39920h;
        BadgeState.State state2 = badgeState.f39927b;
        if (i3 == -2 || e() <= this.f39920h) {
            return NumberFormat.getInstance(state2.n).format(e());
        }
        Context context2 = (Context) weakReference.get();
        return context2 == null ? "" : String.format(state2.n, context2.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f39920h), "+");
    }

    public final CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        BadgeState badgeState = this.f39917e;
        BadgeState.State state = badgeState.f39927b;
        String str = state.f39946j;
        if (str != null) {
            String str2 = state.o;
            return str2 != null ? str2 : str;
        }
        boolean zG = g();
        BadgeState.State state2 = badgeState.f39927b;
        if (!zG) {
            return state2.p;
        }
        if (state2.q == 0 || (context = (Context) this.f39913a.get()) == null) {
            return null;
        }
        if (this.f39920h != -2) {
            int iE = e();
            int i2 = this.f39920h;
            if (iE > i2) {
                return context.getString(state2.r, Integer.valueOf(i2));
            }
        }
        return context.getResources().getQuantityString(state2.q, e(), Integer.valueOf(e()));
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.f39925m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strB;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f39914b.draw(canvas);
        if (!f() || (strB = b()) == null) {
            return;
        }
        Rect rect = new Rect();
        TextDrawableHelper textDrawableHelper = this.f39915c;
        textDrawableHelper.f40640a.getTextBounds(strB, 0, strB.length(), rect);
        float fExactCenterY = this.f39919g - rect.exactCenterY();
        canvas.drawText(strB, this.f39918f, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), textDrawableHelper.f40640a);
    }

    public final int e() {
        int i2 = this.f39917e.f39927b.f39947k;
        if (i2 != -1) {
            return i2;
        }
        return 0;
    }

    public final boolean f() {
        return this.f39917e.f39927b.f39946j != null || g();
    }

    public final boolean g() {
        BadgeState.State state = this.f39917e.f39927b;
        return state.f39946j == null && state.f39947k != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f39917e.f39927b.f39945i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f39916d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f39916d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        Context context = (Context) this.f39913a.get();
        if (context == null) {
            return;
        }
        boolean zF = f();
        BadgeState badgeState = this.f39917e;
        this.f39914b.setShapeAppearanceModel(ShapeAppearanceModel.a(context, zF ? badgeState.f39927b.f39943g.intValue() : badgeState.f39927b.f39941e.intValue(), f() ? badgeState.f39927b.f39944h.intValue() : badgeState.f39927b.f39942f.intValue()).a());
        invalidateSelf();
    }

    public final void i(View view, FrameLayout frameLayout) {
        this.f39924l = new WeakReference(view);
        this.f39925m = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.badge.BadgeDrawable.j():void");
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        BadgeState badgeState = this.f39917e;
        badgeState.f39926a.f39945i = i2;
        badgeState.f39927b.f39945i = i2;
        this.f39915c.f40640a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
