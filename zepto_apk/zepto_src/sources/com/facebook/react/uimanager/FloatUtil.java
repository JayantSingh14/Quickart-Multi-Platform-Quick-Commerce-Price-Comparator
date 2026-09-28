package com.facebook.react.uimanager;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class FloatUtil {
    public static final boolean a(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) && Float.isNaN(f3) : Math.abs(f3 - f2) < 1.0E-5f;
    }
}
