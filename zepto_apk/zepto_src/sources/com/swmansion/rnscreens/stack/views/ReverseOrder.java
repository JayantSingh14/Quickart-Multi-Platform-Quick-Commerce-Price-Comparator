package com.swmansion.rnscreens.stack.views;

import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ReverseOrder extends ChildrenDrawingOrderStrategyBase {
    public ReverseOrder() {
        super(0);
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public final void a(ArrayList drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (this.f47139a) {
            Intrinsics.checkNotNullParameter(drawingOperations, "<this>");
            Collections.reverse(drawingOperations);
        }
    }
}
