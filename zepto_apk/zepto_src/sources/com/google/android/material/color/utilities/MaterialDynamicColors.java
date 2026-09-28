package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class MaterialDynamicColors {
    public static DynamicColor c() {
        return new DynamicColor("inverse_surface", new d(20), new d(21), false, null, null, null);
    }

    public final DynamicColor a() {
        return new DynamicColor("error", new d(11), new d(12), true, new b(this, 2), new ContrastCurve(), new b(this, 14));
    }

    public final DynamicColor b() {
        return new DynamicColor("error_container", new d(26), new d(27), true, new b(this, 2), new ContrastCurve(), new b(this, 16));
    }

    public final DynamicColor d() {
        return new DynamicColor("primary", new a(1), new a(2), true, new b(this, 2), new ContrastCurve(), new b(this, 0));
    }

    public final DynamicColor e() {
        return new DynamicColor("primary_container", new a(19), new a(20), true, new b(this, 2), new ContrastCurve(), new b(this, 4));
    }

    public final DynamicColor f() {
        return new DynamicColor("secondary", new c(27), new c(28), true, new b(this, 2), new ContrastCurve(), new b(this, 10));
    }

    public final DynamicColor g() {
        return new DynamicColor("secondary_container", new a(13), new a(14), true, new b(this, 2), new ContrastCurve(), new b(this, 3));
    }

    public final DynamicColor h() {
        return new DynamicColor("tertiary", new a(3), new a(4), true, new b(this, 2), new ContrastCurve(), new b(this, 1));
    }

    public final DynamicColor i() {
        return new DynamicColor("tertiary_container", new c(22), new c(24), true, new b(this, 2), new ContrastCurve(), new b(this, 8));
    }
}
