package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class DefsView extends DefinitionView {
    public DefsView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
    }

    @Override // com.horcrux.svg.DefinitionView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
    }

    @Override // com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
    }
}
