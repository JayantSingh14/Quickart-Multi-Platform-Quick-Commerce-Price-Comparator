package com.facebook.react.views.view;

import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata
/* loaded from: classes3.dex */
public final class ColorUtil {
    public static int a(double d2) {
        return Math.max(0, Math.min(255, MathKt.a(d2)));
    }
}
