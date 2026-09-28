package com.google.android.material.color;

import androidx.annotation.RestrictTo;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.material.R;
import com.google.android.material.color.utilities.ContrastCurve;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.google.android.material.color.utilities.a;
import com.google.android.material.color.utilities.b;
import com.google.android.material.color.utilities.c;
import com.google.android.material.color.utilities.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestrictTo
/* loaded from: classes4.dex */
public final class MaterialColorUtilitiesHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f40259a;

    static {
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        HashMap map = new HashMap();
        map.put(Integer.valueOf(R.color.material_personalized_color_primary), materialDynamicColors.d());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_primary), new DynamicColor("on_primary", new c(3), new c(5), false, new b(materialDynamicColors, 5), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_primary_inverse), new DynamicColor("inverse_primary", new c(6), new c(7), false, new c(materialDynamicColors, 8), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_primary_container), materialDynamicColors.e());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_primary_container), new DynamicColor("on_primary_container", new c(14), new c(materialDynamicColors, 15), false, new b(materialDynamicColors, 7), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_secondary), materialDynamicColors.f());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_secondary), new DynamicColor("on_secondary", new c(25), new c(26), false, new b(materialDynamicColors, 9), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_secondary_container), materialDynamicColors.g());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_secondary_container), new DynamicColor("on_secondary_container", new d(8), new d(materialDynamicColors, 9), false, new b(materialDynamicColors, 13), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_tertiary), materialDynamicColors.h());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary), new DynamicColor("on_tertiary", new c(13), new c(23), false, new b(materialDynamicColors, 11), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_tertiary_container), materialDynamicColors.i());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_tertiary_container), new DynamicColor("on_tertiary_container", new d(6), new d(materialDynamicColors, 7), false, new b(materialDynamicColors, 12), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_background), new DynamicColor(AppStateModule.APP_STATE_BACKGROUND, new a(21), new a(22), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_on_background), new DynamicColor("on_background", new a(26), new a(27), false, new a(materialDynamicColors), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface), new DynamicColor("surface", new a(0), new a(15), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface), new DynamicColor("on_surface", new d(10), new d(19), false, new d(materialDynamicColors, 28), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_variant), new DynamicColor("surface_variant", new c(16), new c(17), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface_variant), new DynamicColor("on_surface_variant", new d(17), new d(18), false, new d(materialDynamicColors, 28), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_inverse), MaterialDynamicColors.c());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_surface_inverse), new DynamicColor("inverse_on_surface", new d(3), new d(4), false, new d(materialDynamicColors, 5), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_bright), new DynamicColor("surface_bright", new c(1), new c(2), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_dim), new DynamicColor("surface_dim", new a(5), new a(6), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container), new DynamicColor("surface_container", new d(15), new d(16), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_low), new DynamicColor("surface_container_low", new a(11), new a(12), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_high), new DynamicColor("surface_container_high", new a(24), new a(25), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_lowest), new DynamicColor("surface_container_lowest", new c(29), new d(0), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_surface_container_highest), new DynamicColor("surface_container_highest", new c(20), new c(21), true, null, null, null));
        map.put(Integer.valueOf(R.color.material_personalized_color_outline), new DynamicColor("outline", new d(1), new d(2), false, new d(materialDynamicColors, 28), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_outline_variant), new DynamicColor("outline_variant", new a(29), new c(0), false, new d(materialDynamicColors, 28), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_error), materialDynamicColors.a());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_error), new DynamicColor("on_error", new c(9), new c(10), false, new b(materialDynamicColors, 6), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_error_container), materialDynamicColors.b());
        map.put(Integer.valueOf(R.color.material_personalized_color_on_error_container), new DynamicColor("on_error_container", new d(22), new d(23), false, new b(materialDynamicColors, 15), new ContrastCurve(), null));
        map.put(Integer.valueOf(R.color.material_personalized_color_control_activated), DynamicColor.a("control_activated", new a(9), new a(10)));
        map.put(Integer.valueOf(R.color.material_personalized_color_control_normal), DynamicColor.a("control_normal", new a(7), new a(8)));
        map.put(Integer.valueOf(R.color.material_personalized_color_control_highlight), new DynamicColor(new a(16), new a(17), new a(18)));
        map.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse), DynamicColor.a("text_primary_inverse", new d(13), new d(14)));
        map.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse), DynamicColor.a("text_secondary_and_tertiary_inverse", new d(24), new d(25)));
        map.put(Integer.valueOf(R.color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), DynamicColor.a("text_secondary_and_tertiary_inverse_disabled", new a(23), new c(4)));
        map.put(Integer.valueOf(R.color.material_personalized_color_text_primary_inverse_disable_only), DynamicColor.a("text_primary_inverse_disable_only", new c(11), new c(12)));
        map.put(Integer.valueOf(R.color.material_personalized_color_text_hint_foreground_inverse), DynamicColor.a("text_hint_inverse", new c(18), new c(19)));
        f40259a = Collections.unmodifiableMap(map);
    }
}
