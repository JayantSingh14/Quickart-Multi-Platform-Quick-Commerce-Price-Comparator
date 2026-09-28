package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes4.dex */
public final class StateListAnimator {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f40620a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Tuple f40621b = null;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f40622c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f40623d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f40622c == animator) {
                stateListAnimator.f40622c = null;
            }
        }
    };

    public static class Tuple {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f40625a;

        /* renamed from: b, reason: collision with root package name */
        public final ValueAnimator f40626b;

        public Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f40625a = iArr;
            this.f40626b = valueAnimator;
        }
    }

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f40623d);
        this.f40620a.add(tuple);
    }

    public final void b(int[] iArr) {
        Tuple tuple;
        ValueAnimator valueAnimator;
        ArrayList arrayList = this.f40620a;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                tuple = null;
                break;
            }
            tuple = (Tuple) arrayList.get(i2);
            if (StateSet.stateSetMatches(tuple.f40625a, iArr)) {
                break;
            } else {
                i2++;
            }
        }
        Tuple tuple2 = this.f40621b;
        if (tuple == tuple2) {
            return;
        }
        if (tuple2 != null && (valueAnimator = this.f40622c) != null) {
            valueAnimator.cancel();
            this.f40622c = null;
        }
        this.f40621b = tuple;
        if (tuple != null) {
            ValueAnimator valueAnimator2 = tuple.f40626b;
            this.f40622c = valueAnimator2;
            valueAnimator2.start();
        }
    }
}
