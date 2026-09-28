package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.activity.BackEventCompat;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class MaterialBackAnimationHelper<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f40666a;

    /* renamed from: b, reason: collision with root package name */
    public final View f40667b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40668c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40669d;

    /* renamed from: e, reason: collision with root package name */
    public final int f40670e;

    /* renamed from: f, reason: collision with root package name */
    public BackEventCompat f40671f;

    public MaterialBackAnimationHelper(View view) {
        this.f40667b = view;
        Context context = view.getContext();
        this.f40666a = MotionUtils.d(context, R.attr.motionEasingStandardDecelerateInterpolator, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
        this.f40668c = MotionUtils.c(context, R.attr.motionDurationMedium2, 300);
        this.f40669d = MotionUtils.c(context, R.attr.motionDurationShort3, 150);
        this.f40670e = MotionUtils.c(context, R.attr.motionDurationShort2, 100);
    }

    public final BackEventCompat a() {
        if (this.f40671f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.f40671f;
        this.f40671f = null;
        return backEventCompat;
    }
}
