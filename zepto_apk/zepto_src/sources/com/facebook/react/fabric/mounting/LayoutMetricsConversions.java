package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public interface LayoutMetricsConversions {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final float getMaxSize(int i2) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 0) {
                return Float.POSITIVE_INFINITY;
            }
            return size;
        }

        @JvmStatic
        public final float getMinSize(int i2) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                return size;
            }
            return 0.0f;
        }

        @JvmStatic
        @NotNull
        public final YogaMeasureMode getYogaMeasureMode(float f2, float f3) {
            return f2 == f3 ? YogaMeasureMode.f20392b : Float.isInfinite(f3) ? YogaMeasureMode.f20391a : YogaMeasureMode.f20393c;
        }

        @JvmStatic
        public final float getYogaSize(float f2, float f3) {
            if (f2 == f3) {
                return PixelUtil.b(f3);
            }
            if (Float.isInfinite(f3)) {
                return Float.POSITIVE_INFINITY;
            }
            return PixelUtil.b(f3);
        }
    }

    @JvmStatic
    static float getMaxSize(int i2) {
        return Companion.getMaxSize(i2);
    }

    @JvmStatic
    static float getMinSize(int i2) {
        return Companion.getMinSize(i2);
    }

    @JvmStatic
    @NotNull
    static YogaMeasureMode getYogaMeasureMode(float f2, float f3) {
        return Companion.getYogaMeasureMode(f2, f3);
    }

    @JvmStatic
    static float getYogaSize(float f2, float f3) {
        return Companion.getYogaSize(f2, f3);
    }
}
