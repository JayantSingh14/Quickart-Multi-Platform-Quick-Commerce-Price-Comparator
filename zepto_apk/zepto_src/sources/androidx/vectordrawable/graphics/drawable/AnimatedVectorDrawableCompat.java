package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.AnonymousClass1;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {

    /* renamed from: c, reason: collision with root package name */
    public final Context f12224c;

    /* renamed from: d, reason: collision with root package name */
    public Animator.AnimatorListener f12225d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f12226e = null;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable.Callback f12227f = new Drawable.Callback() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final AnimatedVectorDrawableCompatState f12223b = new AnimatedVectorDrawableCompatState();

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public VectorDrawableCompat f12230a;

        /* renamed from: b, reason: collision with root package name */
        public AnimatorSet f12231b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f12232c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayMap f12233d;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat(Context context) {
        this.f12224c = context;
    }

    public static AnimatedVectorDrawableCompat a(int i2, Context context) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        Drawable drawableC = ResourcesCompat.c(context.getResources(), i2, context.getTheme());
        animatedVectorDrawableCompat.f12236a = drawableC;
        drawableC.setCallback(animatedVectorDrawableCompat.f12227f);
        new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.f12236a.getConstantState());
        return animatedVectorDrawableCompat;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public final void b(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (animationCallback.f12221a == null) {
                animationCallback.f12221a = animationCallback.new AnonymousClass1();
            }
            animatedVectorDrawable.registerAnimationCallback(animationCallback.f12221a);
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.f12226e == null) {
            this.f12226e = new ArrayList();
        }
        if (this.f12226e.contains(animationCallback)) {
            return;
        }
        this.f12226e.add(animationCallback);
        if (this.f12225d == null) {
            this.f12225d = new AnimatorListenerAdapter() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.this;
                    ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f12226e);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).a(animatedVectorDrawableCompat);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.this;
                    ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f12226e);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).b(animatedVectorDrawableCompat);
                    }
                }
            };
        }
        this.f12223b.f12231b.addListener(this.f12225d);
    }

    public final boolean c(Animatable2Compat.AnimationCallback animationCallback) {
        Animator.AnimatorListener animatorListener;
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (animationCallback.f12221a == null) {
                animationCallback.f12221a = animationCallback.new AnonymousClass1();
            }
            animatedVectorDrawable.unregisterAnimationCallback(animationCallback.f12221a);
        }
        ArrayList arrayList = this.f12226e;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(animationCallback);
        if (this.f12226e.size() == 0 && (animatorListener = this.f12225d) != null) {
            this.f12223b.f12231b.removeListener(animatorListener);
            this.f12225d = null;
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.f12223b;
        animatedVectorDrawableCompatState.f12230a.draw(canvas);
        if (animatedVectorDrawableCompatState.f12231b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getAlpha() : this.f12223b.f12230a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f12223b.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getColorFilter() : this.f12223b.f12230a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f12236a != null) {
            return new AnimatedVectorDrawableDelegateState(this.f12236a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f12223b.f12230a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f12223b.f12230a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.getOpacity() : this.f12223b.f12230a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b6, code lost:
    
        if (r3.f12231b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        r3.f12231b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
    
        r3.f12231b.playTogether(r3.f12232c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            r7 = this;
            android.graphics.drawable.Drawable r0 = r7.f12236a
            if (r0 == 0) goto L8
            r0.inflate(r8, r9, r10, r11)
            return
        L8:
            int r0 = r9.getEventType()
            int r1 = r9.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r3 = r7.f12223b
            if (r0 == r2) goto Lb4
            int r4 = r9.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lb4
        L1f:
            r4 = 2
            if (r0 != r4) goto Lae
            java.lang.String r0 = r9.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            if (r4 == 0) goto L54
            int[] r0 = androidx.vectordrawable.graphics.drawable.AndroidResources.f12219e
            android.content.res.TypedArray r0 = androidx.core.content.res.TypedArrayUtils.i(r8, r11, r10, r0)
            int r4 = r0.getResourceId(r5, r5)
            if (r4 == 0) goto L50
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r4 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.a(r8, r4, r11)
            r4.f12242f = r5
            android.graphics.drawable.Drawable$Callback r5 = r7.f12227f
            r4.setCallback(r5)
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r5 = r3.f12230a
            if (r5 == 0) goto L4e
            r6 = 0
            r5.setCallback(r6)
        L4e:
            r3.f12230a = r4
        L50:
            r0.recycle()
            goto Lae
        L54:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lae
            int[] r0 = androidx.vectordrawable.graphics.drawable.AndroidResources.f12220f
            android.content.res.TypedArray r0 = r8.obtainAttributes(r10, r0)
            java.lang.String r4 = r0.getString(r5)
            int r5 = r0.getResourceId(r2, r5)
            if (r5 == 0) goto Lab
            android.content.Context r6 = r7.f12224c
            if (r6 == 0) goto La0
            android.animation.Animator r5 = android.animation.AnimatorInflater.loadAnimator(r6, r5)
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = r3.f12230a
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r6 = r6.f12238b
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r6 = r6.f12284b
            androidx.collection.ArrayMap r6 = r6.o
            java.lang.Object r6 = r6.get(r4)
            r5.setTarget(r6)
            java.util.ArrayList r6 = r3.f12232c
            if (r6 != 0) goto L95
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r3.f12232c = r6
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            r3.f12233d = r6
        L95:
            java.util.ArrayList r6 = r3.f12232c
            r6.add(r5)
            androidx.collection.ArrayMap r3 = r3.f12233d
            r3.put(r5, r4)
            goto Lab
        La0:
            r0.recycle()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Context can't be null when inflating animators"
            r8.<init>(r9)
            throw r8
        Lab:
            r0.recycle()
        Lae:
            int r0 = r9.next()
            goto L12
        Lb4:
            android.animation.AnimatorSet r8 = r3.f12231b
            if (r8 != 0) goto Lbf
            android.animation.AnimatorSet r8 = new android.animation.AnimatorSet
            r8.<init>()
            r3.f12231b = r8
        Lbf:
            android.animation.AnimatorSet r8 = r3.f12231b
            java.util.ArrayList r9 = r3.f12232c
            r8.playTogether(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.isAutoMirrored() : this.f12223b.f12230a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f12236a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f12223b.f12231b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.isStateful() : this.f12223b.f12230a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f12223b.f12230a.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.setLevel(i2) : this.f12223b.f12230a.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f12236a;
        return drawable != null ? drawable.setState(iArr) : this.f12223b.f12230a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f12223b.f12230a.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f12223b.f12230a.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f12223b.f12230a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.l(drawable, i2);
        } else {
            this.f12223b.f12230a.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.m(drawable, colorStateList);
        } else {
            this.f12223b.f12230a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            DrawableCompat.n(drawable, mode);
        } else {
            this.f12223b.f12230a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f12223b.f12230a.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.f12223b;
        if (animatedVectorDrawableCompatState.f12231b.isStarted()) {
            return;
        }
        animatedVectorDrawableCompatState.f12231b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f12236a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f12223b.f12231b.end();
        }
    }

    @RequiresApi
    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f12234a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f12234a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f12234a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f12234a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
            Drawable drawableNewDrawable = this.f12234a.newDrawable();
            animatedVectorDrawableCompat.f12236a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f12227f);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
            Drawable drawableNewDrawable = this.f12234a.newDrawable(resources);
            animatedVectorDrawableCompat.f12236a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f12227f);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
            Drawable drawableNewDrawable = this.f12234a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f12236a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f12227f);
            return animatedVectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
