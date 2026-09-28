package com.swmansion.rnscreens.stack.views;

import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ReverseFromIndex extends ChildrenDrawingOrderStrategyBase {

    /* renamed from: b, reason: collision with root package name */
    public final int f47140b;

    public ReverseFromIndex(int i2) {
        super(0);
        this.f47140b = i2;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public final void a(ArrayList drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (this.f47139a) {
            int i2 = this.f47140b;
            for (int iB = CollectionsKt.B(drawingOperations); i2 < iB; iB--) {
                Collections.swap(drawingOperations, i2, iB);
                i2++;
            }
        }
    }
}
