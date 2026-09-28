package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;
import com.airbnb.lottie.animation.LPaint;

/* loaded from: classes3.dex */
public final class PaintCompat {

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api29Impl {
        public static void a(LPaint lPaint, Object obj) {
            lPaint.setBlendMode((BlendMode) obj);
        }
    }

    static {
        new ThreadLocal();
    }

    public static boolean a(TextPaint textPaint, String str) {
        return textPaint.hasGlyph(str);
    }

    public static void b(LPaint lPaint, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(lPaint, blendModeCompat != null ? BlendModeUtils.Api29Impl.a(blendModeCompat) : null);
        } else if (blendModeCompat == null) {
            lPaint.setXfermode(null);
        } else {
            PorterDuff.Mode modeA = BlendModeUtils.a(blendModeCompat);
            lPaint.setXfermode(modeA != null ? new PorterDuffXfermode(modeA) : null);
        }
    }
}
