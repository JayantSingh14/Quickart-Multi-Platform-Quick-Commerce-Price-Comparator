package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes4.dex */
public class ElevationOverlayProvider {

    /* renamed from: f, reason: collision with root package name */
    public static final int f40419f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f40420a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40421b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40422c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40423d;

    /* renamed from: e, reason: collision with root package name */
    public final float f40424e;

    public ElevationOverlayProvider(Context context) {
        boolean zB = MaterialAttributes.b(context, R.attr.elevationOverlayEnabled, false);
        int iC = MaterialColors.c(context, R.attr.elevationOverlayColor, 0);
        int iC2 = MaterialColors.c(context, R.attr.elevationOverlayAccentColor, 0);
        int iC3 = MaterialColors.c(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f40420a = zB;
        this.f40421b = iC;
        this.f40422c = iC2;
        this.f40423d = iC3;
        this.f40424e = f2;
    }

    public final int a(float f2, int i2) {
        int i3;
        if (!this.f40420a || ColorUtils.k(i2, 255) != this.f40423d) {
            return i2;
        }
        float fMin = (this.f40424e <= 0.0f || f2 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f2 / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i2);
        int iG = MaterialColors.g(fMin, ColorUtils.k(i2, 255), this.f40421b);
        if (fMin > 0.0f && (i3 = this.f40422c) != 0) {
            iG = ColorUtils.h(ColorUtils.k(i3, f40419f), iG);
        }
        return ColorUtils.k(iG, iAlpha);
    }
}
