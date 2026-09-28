package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;

/* loaded from: classes.dex */
abstract class AbstractLayoutAnimation {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f19788e = MapBuilder.b(InterpolatorType.f19802b, new LinearInterpolator(), InterpolatorType.f19803c, new AccelerateInterpolator(), InterpolatorType.f19804d, new DecelerateInterpolator(), InterpolatorType.f19805e, new AccelerateDecelerateInterpolator());

    /* renamed from: a, reason: collision with root package name */
    public Interpolator f19789a;

    /* renamed from: b, reason: collision with root package name */
    public int f19790b;

    /* renamed from: c, reason: collision with root package name */
    public AnimatedPropertyType f19791c;

    /* renamed from: d, reason: collision with root package name */
    public int f19792d;

    public final Animation a(View view, int i2, int i3, int i4, int i5) {
        if (!d()) {
            return null;
        }
        Animation animationB = b(view, i2, i3, i4, i5);
        if (animationB != null) {
            animationB.setDuration(this.f19792d);
            animationB.setStartOffset(this.f19790b);
            animationB.setInterpolator(this.f19789a);
        }
        return animationB;
    }

    public abstract Animation b(View view, int i2, int i3, int i4, int i5);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r3, com.facebook.react.bridge.ReadableMap r4) {
        /*
            r2 = this;
            java.lang.String r0 = "property"
            boolean r1 = r4.hasKey(r0)
            if (r1 == 0) goto L11
            java.lang.String r0 = r4.getString(r0)
            com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r0 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.a(r0)
            goto L12
        L11:
            r0 = 0
        L12:
            r2.f19791c = r0
            java.lang.String r0 = "duration"
            boolean r1 = r4.hasKey(r0)
            if (r1 == 0) goto L20
            int r3 = r4.getInt(r0)
        L20:
            r2.f19792d = r3
            java.lang.String r3 = "delay"
            boolean r0 = r4.hasKey(r3)
            if (r0 == 0) goto L2f
            int r3 = r4.getInt(r3)
            goto L30
        L2f:
            r3 = 0
        L30:
            r2.f19790b = r3
            java.lang.String r3 = "type"
            boolean r0 = r4.hasKey(r3)
            if (r0 == 0) goto Leb
            java.lang.String r3 = r4.getString(r3)
            com.facebook.react.uimanager.layoutanimation.InterpolatorType$Companion r0 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19801a
            r0.getClass()
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r3.toLowerCase(r0)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1965056864: goto L88;
                case -1310315117: goto L7d;
                case -1102672091: goto L72;
                case -895679987: goto L67;
                case 1164546989: goto L5c;
                default: goto L5a;
            }
        L5a:
            goto Ldf
        L5c:
            java.lang.String r1 = "easeineaseout"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ldf
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r3 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19805e
            goto L92
        L67:
            java.lang.String r1 = "spring"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ldf
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r3 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19806f
            goto L92
        L72:
            java.lang.String r1 = "linear"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ldf
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r3 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19802b
            goto L92
        L7d:
            java.lang.String r1 = "easein"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ldf
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r3 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19803c
            goto L92
        L88:
            java.lang.String r1 = "easeout"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ldf
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r3 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19804d
        L92:
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r0 = com.facebook.react.uimanager.layoutanimation.InterpolatorType.f19806f
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto La4
            com.facebook.react.uimanager.layoutanimation.SimpleSpringInterpolator r0 = new com.facebook.react.uimanager.layoutanimation.SimpleSpringInterpolator
            float r1 = com.facebook.react.uimanager.layoutanimation.SimpleSpringInterpolator.a(r4)
            r0.<init>(r1)
            goto Lac
        La4:
            java.util.HashMap r0 = com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation.f19788e
            java.lang.Object r0 = r0.get(r3)
            android.view.animation.Interpolator r0 = (android.view.animation.Interpolator) r0
        Lac:
            if (r0 == 0) goto Lcb
            r2.f19789a = r0
            boolean r3 = r2.d()
            if (r3 == 0) goto Lb7
            return
        Lb7:
            com.facebook.react.uimanager.IllegalViewOperationException r3 = new com.facebook.react.uimanager.IllegalViewOperationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid layout animation : "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        Lcb:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Missing interpolator for type : "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        Ldf:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unsupported interpolation type : "
            java.lang.String r3 = r0.concat(r3)
            r4.<init>(r3)
            throw r4
        Leb:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Missing interpolation type."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation.c(int, com.facebook.react.bridge.ReadableMap):void");
    }

    public abstract boolean d();
}
