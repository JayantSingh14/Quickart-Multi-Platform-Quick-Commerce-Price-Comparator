package com.facebook.react.uimanager;

import android.annotation.TargetApi;
import android.graphics.BlendMode;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt$children$1;
import androidx.core.view.ViewGroupKt$iterator$1;
import com.facebook.react.R;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@TargetApi(29)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BlendModeHelper {
    public static final boolean a(ViewGroup view) {
        ViewGroupKt$iterator$1 viewGroupKt$iterator$1;
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator it = new ViewGroupKt$children$1(view).iterator();
        do {
            viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
            if (!viewGroupKt$iterator$1.hasNext()) {
                return false;
            }
        } while (((View) viewGroupKt$iterator$1.next()).getTag(R.id.mix_blend_mode) == null);
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final BlendMode b(String str) {
        if (str == null || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        switch (str.hashCode()) {
            case -2120744511:
                if (str.equals("luminosity")) {
                    return BlendMode.LUMINOSITY;
                }
                break;
            case -1427739212:
                if (str.equals("hard-light")) {
                    return BlendMode.HARD_LIGHT;
                }
                break;
            case -1338968417:
                if (str.equals("darken")) {
                    return BlendMode.DARKEN;
                }
                break;
            case -1247677005:
                if (str.equals("soft-light")) {
                    return BlendMode.SOFT_LIGHT;
                }
                break;
            case -1091287984:
                if (str.equals("overlay")) {
                    return BlendMode.OVERLAY;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    return null;
                }
                break;
            case -907689876:
                if (str.equals(PaymentConstants.Event.SCREEN)) {
                    return BlendMode.SCREEN;
                }
                break;
            case -230491182:
                if (str.equals("saturation")) {
                    return BlendMode.SATURATION;
                }
                break;
            case -120580883:
                if (str.equals("color-dodge")) {
                    return BlendMode.COLOR_DODGE;
                }
                break;
            case 103672:
                if (str.equals("hue")) {
                    return BlendMode.HUE;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    return BlendMode.COLOR;
                }
                break;
            case 170546239:
                if (str.equals("lighten")) {
                    return BlendMode.LIGHTEN;
                }
                break;
            case 653829668:
                if (str.equals("multiply")) {
                    return BlendMode.MULTIPLY;
                }
                break;
            case 1242982905:
                if (str.equals("color-burn")) {
                    return BlendMode.COLOR_BURN;
                }
                break;
            case 1686617550:
                if (str.equals("exclusion")) {
                    return BlendMode.EXCLUSION;
                }
                break;
            case 1728361789:
                if (str.equals("difference")) {
                    return BlendMode.DIFFERENCE;
                }
                break;
        }
        throw new IllegalArgumentException("Invalid mix-blend-mode name: ".concat(str));
    }
}
