package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {

    /* renamed from: k, reason: collision with root package name */
    public static final Property f40808k = new AnonymousClass3(Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    public final Context f40809a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseProgressIndicatorSpec f40810b;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f40812d;

    /* renamed from: e, reason: collision with root package name */
    public ObjectAnimator f40813e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f40814f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40815g;

    /* renamed from: h, reason: collision with root package name */
    public float f40816h;

    /* renamed from: j, reason: collision with root package name */
    public int f40818j;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f40817i = new Paint();

    /* renamed from: c, reason: collision with root package name */
    public AnimatorDurationScaleProvider f40811c = new AnimatorDurationScaleProvider();

    /* renamed from: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$3, reason: invalid class name */
    public class AnonymousClass3 extends Property<DrawableWithAnimatedVisibilityChange, Float> {
        @Override // android.util.Property
        public final Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.b());
        }

        @Override // android.util.Property
        public final void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f2) {
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = drawableWithAnimatedVisibilityChange;
            float fFloatValue = f2.floatValue();
            if (drawableWithAnimatedVisibilityChange2.f40816h != fFloatValue) {
                drawableWithAnimatedVisibilityChange2.f40816h = fFloatValue;
                drawableWithAnimatedVisibilityChange2.invalidateSelf();
            }
        }
    }

    public DrawableWithAnimatedVisibilityChange(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f40809a = context;
        this.f40810b = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    public final float b() {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40810b;
        if (baseProgressIndicatorSpec.f40781e == 0 && baseProgressIndicatorSpec.f40782f == 0) {
            return 1.0f;
        }
        return this.f40816h;
    }

    public void c() {
        f(false, false, false);
    }

    public boolean d() {
        ObjectAnimator objectAnimator = this.f40813e;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public boolean e() {
        ObjectAnimator objectAnimator = this.f40812d;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public boolean f(boolean z, boolean z2, boolean z3) {
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.f40811c;
        ContentResolver contentResolver = this.f40809a.getContentResolver();
        animatorDurationScaleProvider.getClass();
        return g(z, z2, z3 && Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) > 0.0f);
    }

    public boolean g(boolean z, boolean z2, boolean z3) {
        ObjectAnimator objectAnimator = this.f40812d;
        Property property = f40808k;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) property, 0.0f, 1.0f);
            this.f40812d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f40812d.setInterpolator(AnimationUtils.f39817b);
            ObjectAnimator objectAnimator2 = this.f40812d;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f40812d = objectAnimator2;
            objectAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = DrawableWithAnimatedVisibilityChange.this;
                    ArrayList arrayList = drawableWithAnimatedVisibilityChange.f40814f;
                    if (arrayList == null || drawableWithAnimatedVisibilityChange.f40815g) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).b(drawableWithAnimatedVisibilityChange);
                    }
                }
            });
        }
        if (this.f40813e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) property, 1.0f, 0.0f);
            this.f40813e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f40813e.setInterpolator(AnimationUtils.f39817b);
            ObjectAnimator objectAnimator3 = this.f40813e;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f40813e = objectAnimator3;
            objectAnimator3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = DrawableWithAnimatedVisibilityChange.this;
                    DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                    ArrayList arrayList = drawableWithAnimatedVisibilityChange.f40814f;
                    if (arrayList == null || drawableWithAnimatedVisibilityChange.f40815g) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).a(drawableWithAnimatedVisibilityChange);
                    }
                }
            });
        }
        if (isVisible() || z) {
            ObjectAnimator objectAnimator4 = z ? this.f40812d : this.f40813e;
            ObjectAnimator objectAnimator5 = z ? this.f40813e : this.f40812d;
            if (!z3) {
                if (objectAnimator5.isRunning()) {
                    boolean z4 = this.f40815g;
                    this.f40815g = true;
                    new ValueAnimator[]{objectAnimator5}[0].cancel();
                    this.f40815g = z4;
                }
                if (objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                } else {
                    boolean z5 = this.f40815g;
                    this.f40815g = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f40815g = z5;
                }
                return super.setVisible(z, false);
            }
            if (!objectAnimator4.isRunning()) {
                boolean z6 = !z || super.setVisible(z, false);
                BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40810b;
                if (!z ? baseProgressIndicatorSpec.f40782f != 0 : baseProgressIndicatorSpec.f40781e != 0) {
                    boolean z7 = this.f40815g;
                    this.f40815g = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f40815g = z7;
                    return z6;
                }
                if (z2 || !objectAnimator4.isPaused()) {
                    objectAnimator4.start();
                    return z6;
                }
                objectAnimator4.resume();
                return z6;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f40818j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h(Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList arrayList = this.f40814f;
        if (arrayList == null || !arrayList.contains(animationCallback)) {
            return false;
        }
        this.f40814f.remove(animationCallback);
        if (!this.f40814f.isEmpty()) {
            return true;
        }
        this.f40814f = null;
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return e() || d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f40818j = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f40817i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return f(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        g(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        g(false, true, false);
    }
}
