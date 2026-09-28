package com.swmansion.gesturehandler.react;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.ViewConfigurationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RNViewConfigurationHelper implements ViewConfigurationHelper {

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[PointerEvents.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PointerEvents.Companion companion = PointerEvents.f19424a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PointerEvents.Companion companion2 = PointerEvents.f19424a;
                iArr[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PointerEvents.Companion companion3 = PointerEvents.f19424a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public final View a(ViewGroup parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent instanceof ReactViewGroup) {
            View childAt = parent.getChildAt(((ReactViewGroup) parent).getZIndexMappedChildIndex(i2));
            Intrinsics.c(childAt);
            return childAt;
        }
        View childAt2 = parent.getChildAt(i2);
        Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(...)");
        return childAt2;
    }
}
