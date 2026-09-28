package com.google.android.material.shape;

import android.widget.FrameLayout;

/* loaded from: classes4.dex */
class ShapeableDelegateV14 extends ShapeableDelegate {
    @Override // com.google.android.material.shape.ShapeableDelegate
    public final void b(FrameLayout frameLayout) {
        if (this.f41081c == null || this.f41082d.isEmpty()) {
            return;
        }
        frameLayout.invalidate();
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean c() {
        return true;
    }
}
