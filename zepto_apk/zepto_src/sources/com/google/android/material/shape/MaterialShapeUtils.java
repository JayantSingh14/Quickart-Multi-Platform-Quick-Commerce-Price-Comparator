package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes4.dex */
public class MaterialShapeUtils {
    public static CornerTreatment a(int i2) {
        return i2 != 0 ? i2 != 1 ? new RoundedCornerTreatment() : new CutCornerTreatment() : new RoundedCornerTreatment();
    }

    public static void b(ViewGroup viewGroup, float f2) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).l(f2);
        }
    }

    public static void c(View view, MaterialShapeDrawable materialShapeDrawable) {
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.f40974a.f40990b;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.f40420a) {
            return;
        }
        float fJ = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fJ += ViewCompat.j((View) parent);
        }
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.f40974a;
        if (materialShapeDrawableState.f41000l != fJ) {
            materialShapeDrawableState.f41000l = fJ;
            materialShapeDrawable.x();
        }
    }

    public static void d(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            c(viewGroup, (MaterialShapeDrawable) background);
        }
    }
}
