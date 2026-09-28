package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes.dex */
abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {

    /* renamed from: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19800a;

        static {
            int[] iArr = new int[AnimatedPropertyType.values().length];
            f19800a = iArr;
            try {
                AnimatedPropertyType.Companion companion = AnimatedPropertyType.f19793a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f19800a;
                AnimatedPropertyType.Companion companion2 = AnimatedPropertyType.f19793a;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f19800a;
                AnimatedPropertyType.Companion companion3 = AnimatedPropertyType.f19793a;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f19800a;
                AnimatedPropertyType.Companion companion4 = AnimatedPropertyType.f19793a;
                iArr4[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    public final Animation b(View view, int i2, int i3, int i4, int i5) {
        AnimatedPropertyType animatedPropertyType = this.f19791c;
        if (animatedPropertyType == null) {
            Intrinsics.checkNotNullParameter("Missing animated property from animation config", "msg");
            throw new IllegalViewOperationException("Missing animated property from animation config");
        }
        int iOrdinal = animatedPropertyType.ordinal();
        if (iOrdinal == 0) {
            return new OpacityAnimation(view, e() ? view.getAlpha() : 0.0f, e() ? 0.0f : view.getAlpha());
        }
        if (iOrdinal == 1) {
            return new ScaleAnimation(e() ? 1.0f : 0.0f, e() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
        }
        if (iOrdinal == 2) {
            return new ScaleAnimation(1.0f, 1.0f, e() ? 1.0f : 0.0f, e() ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
        }
        if (iOrdinal == 3) {
            float f2 = e() ? 1.0f : 0.0f;
            float f3 = e() ? 0.0f : 1.0f;
            return new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        }
        throw new IllegalViewOperationException("Missing animation for property : " + this.f19791c);
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    public final boolean d() {
        return this.f19792d > 0 && this.f19791c != null;
    }

    public abstract boolean e();
}
