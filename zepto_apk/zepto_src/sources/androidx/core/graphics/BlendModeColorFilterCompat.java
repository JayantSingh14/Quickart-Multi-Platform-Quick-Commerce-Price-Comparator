package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;

/* loaded from: classes3.dex */
public class BlendModeColorFilterCompat {

    @RequiresApi
    public static class Api29Impl {
        public static ColorFilter a(Object obj) {
            return new BlendModeColorFilter(0, (BlendMode) obj);
        }
    }

    public static ColorFilter a(BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = BlendModeUtils.Api29Impl.a(blendModeCompat);
            if (objA != null) {
                return Api29Impl.a(objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = BlendModeUtils.a(blendModeCompat);
        if (modeA != null) {
            return new PorterDuffColorFilter(0, modeA);
        }
        return null;
    }
}
