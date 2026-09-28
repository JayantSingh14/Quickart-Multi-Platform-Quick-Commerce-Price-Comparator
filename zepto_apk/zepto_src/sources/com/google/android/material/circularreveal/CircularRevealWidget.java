package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;

/* loaded from: classes4.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {

        /* renamed from: b, reason: collision with root package name */
        public static final CircularRevealEvaluator f40244b = new CircularRevealEvaluator();

        /* renamed from: a, reason: collision with root package name */
        public final RevealInfo f40245a = new RevealInfo();

        @Override // android.animation.TypeEvaluator
        public final RevealInfo evaluate(float f2, RevealInfo revealInfo, RevealInfo revealInfo2) {
            RevealInfo revealInfo3 = revealInfo;
            RevealInfo revealInfo4 = revealInfo2;
            float fC = MathUtils.c(revealInfo3.f40248a, revealInfo4.f40248a, f2);
            float fC2 = MathUtils.c(revealInfo3.f40249b, revealInfo4.f40249b, f2);
            float fC3 = MathUtils.c(revealInfo3.f40250c, revealInfo4.f40250c, f2);
            RevealInfo revealInfo5 = this.f40245a;
            revealInfo5.f40248a = fC;
            revealInfo5.f40249b = fC2;
            revealInfo5.f40250c = fC3;
            return revealInfo5;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final CircularRevealProperty f40246a = new CircularRevealProperty(RevealInfo.class, "circularReveal");

        @Override // android.util.Property
        public final RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final CircularRevealScrimColorProperty f40247a = new CircularRevealScrimColorProperty(Integer.class, "circularRevealScrimColor");

        @Override // android.util.Property
        public final Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(RevealInfo revealInfo);

    public static class RevealInfo {

        /* renamed from: a, reason: collision with root package name */
        public float f40248a;

        /* renamed from: b, reason: collision with root package name */
        public float f40249b;

        /* renamed from: c, reason: collision with root package name */
        public float f40250c;

        public RevealInfo(float f2, float f3, float f4) {
            this.f40248a = f2;
            this.f40249b = f3;
            this.f40250c = f4;
        }

        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.f40248a, revealInfo.f40249b, revealInfo.f40250c);
        }
    }
}
