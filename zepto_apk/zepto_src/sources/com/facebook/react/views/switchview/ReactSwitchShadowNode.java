package com.facebook.react.views.switchview;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNodeJNIBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    public int A;
    public boolean B;
    public int z;

    public ReactSwitchShadowNode() {
        this.u.X(this);
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public final long h(YogaNodeJNIBase node, float f2, YogaMeasureMode widthMode, float f3, YogaMeasureMode heightMode) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        if (!this.B) {
            ThemedReactContext themedReactContext = this.f19459d;
            Assertions.c(themedReactContext);
            Intrinsics.checkNotNullExpressionValue(themedReactContext, "getThemedContext(...)");
            ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
            reactSwitch.setShowText(false);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            reactSwitch.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.z = reactSwitch.getMeasuredWidth();
            this.A = reactSwitch.getMeasuredHeight();
            this.B = true;
        }
        return YogaMeasureOutput.a(this.z, this.A);
    }
}
