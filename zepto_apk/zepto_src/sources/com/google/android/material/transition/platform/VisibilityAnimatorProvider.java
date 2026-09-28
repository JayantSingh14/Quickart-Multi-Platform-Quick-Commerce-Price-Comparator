package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
public interface VisibilityAnimatorProvider {
    Animator a(View view);

    Animator b(View view);
}
