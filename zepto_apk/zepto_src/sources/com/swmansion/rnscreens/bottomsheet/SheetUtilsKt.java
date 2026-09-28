package com.swmansion.rnscreens.bottomsheet;

import android.view.ViewGroup;
import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SheetUtilsKt {
    public static final boolean a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.isLaidOut() || viewGroup.getHeight() > 0 || viewGroup.getWidth() > 0;
    }

    public static final boolean b(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.f46972d && screen.getSheetDetents().size() == 1 && ((Number) CollectionsKt.z(screen.getSheetDetents())).doubleValue() == -1.0d;
    }

    public static final boolean c(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.f46972d;
    }
}
