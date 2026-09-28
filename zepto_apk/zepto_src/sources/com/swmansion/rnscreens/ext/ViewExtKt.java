package com.swmansion.rnscreens.ext;

import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ViewExtKt {
    public static final void a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 != null) {
            viewGroup2.endViewTransition(viewGroup);
            viewGroup2.removeView(viewGroup);
        }
        viewGroup.setVisibility(0);
        viewGroup.setTranslationY(0.0f);
    }
}
