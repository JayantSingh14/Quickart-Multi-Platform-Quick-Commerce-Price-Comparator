package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

/* loaded from: classes4.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* renamed from: a, reason: collision with root package name */
    public IndeterminateDrawable f40826a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f40827b = new ArrayList();

    public IndeterminateAnimatorDelegate(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f40827b.add(new DrawingDelegate.ActiveIndicator());
        }
    }

    public static float b(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    public abstract void a();

    public abstract void c();

    public abstract void d(Animatable2Compat.AnimationCallback animationCallback);

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
