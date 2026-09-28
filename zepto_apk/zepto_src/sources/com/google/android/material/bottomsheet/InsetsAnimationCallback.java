package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final View f40069a;

    /* renamed from: b, reason: collision with root package name */
    public int f40070b;

    /* renamed from: c, reason: collision with root package name */
    public int f40071c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f40072d;

    public InsetsAnimationCallback(View view) {
        super(0);
        this.f40072d = new int[2];
        this.f40069a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f40069a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        View view = this.f40069a;
        int[] iArr = this.f40072d;
        view.getLocationOnScreen(iArr);
        this.f40070b = iArr[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimationCompat) it.next()).d() & 8) != 0) {
                this.f40069a.setTranslationY(AnimationUtils.c(r0.c(), this.f40071c, 0));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        View view = this.f40069a;
        int[] iArr = this.f40072d;
        view.getLocationOnScreen(iArr);
        int i2 = this.f40070b - iArr[1];
        this.f40071c = i2;
        view.setTranslationY(i2);
        return boundsCompat;
    }
}
