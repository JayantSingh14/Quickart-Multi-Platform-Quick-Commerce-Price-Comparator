package com.facebook.react.views.image;

import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImageResizeMode {
    public static final void a() {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    }

    public static final ScalingUtils.ScaleType b() {
        ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.f17392i;
        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
        return CENTER_CROP;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final ScalingUtils.AbstractScaleType c(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.f17384a;
                        Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
                        return (ScalingUtils.AbstractScaleType) FIT_XY;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        ScalingUtils.ScaleType CENTER_INSIDE = ScalingUtils.ScaleType.f17391h;
                        Intrinsics.checkNotNullExpressionValue(CENTER_INSIDE, "CENTER_INSIDE");
                        return (ScalingUtils.AbstractScaleType) CENTER_INSIDE;
                    }
                    break;
                case -934531685:
                    if (str.equals("repeat")) {
                        return ScaleTypeStartInside.f19962l;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        return ScaleTypeStartInside.f19962l;
                    }
                    break;
                case 94852023:
                    if (str.equals("cover")) {
                        ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.f17392i;
                        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
                        return (ScalingUtils.AbstractScaleType) CENTER_CROP;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        ScalingUtils.ScaleType FIT_CENTER = ScalingUtils.ScaleType.f17388e;
                        Intrinsics.checkNotNullExpressionValue(FIT_CENTER, "FIT_CENTER");
                        return (ScalingUtils.AbstractScaleType) FIT_CENTER;
                    }
                    break;
            }
        }
        if (str != null) {
            FLog.q("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return (ScalingUtils.AbstractScaleType) b();
    }

    public static final Shader.TileMode d(String str) {
        if ("contain".equals(str) || "cover".equals(str) || "stretch".equals(str) || "center".equals(str) || "none".equals(str)) {
            return Shader.TileMode.CLAMP;
        }
        if ("repeat".equals(str)) {
            return Shader.TileMode.REPEAT;
        }
        if (str != null) {
            FLog.q("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return Shader.TileMode.CLAMP;
    }
}
