package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNodeJNIBase;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ProgressBarShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    public String C;
    public final SparseIntArray z = new SparseIntArray();
    public final SparseIntArray A = new SparseIntArray();
    public final HashSet B = new HashSet();

    public ProgressBarShadowNode() {
        this.u.X(this);
        this.C = ReactProgressBarViewManager.DEFAULT_STYLE;
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public final long h(YogaNodeJNIBase node, float f2, YogaMeasureMode widthMode, float f3, YogaMeasureMode heightMode) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        ReactProgressBarViewManager.Companion companion = ReactProgressBarViewManager.Companion;
        String str = this.C;
        companion.getClass();
        int iB = ReactProgressBarViewManager.Companion.b(str);
        HashSet hashSet = this.B;
        boolean zContains = hashSet.contains(Integer.valueOf(iB));
        SparseIntArray sparseIntArray = this.A;
        SparseIntArray sparseIntArray2 = this.z;
        if (!zContains) {
            ThemedReactContext themedReactContext = this.f19459d;
            Assertions.c(themedReactContext);
            ProgressBar progressBarA = ReactProgressBarViewManager.Companion.a(iB, themedReactContext);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            progressBarA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            sparseIntArray2.put(iB, progressBarA.getMeasuredHeight());
            sparseIntArray.put(iB, progressBarA.getMeasuredWidth());
            hashSet.add(Integer.valueOf(iB));
        }
        return YogaMeasureOutput.a(sparseIntArray.get(iB), sparseIntArray2.get(iB));
    }

    @ReactProp(name = ReactProgressBarViewManager.PROP_STYLE)
    public final void setStyle(@Nullable String str) {
        if (str == null) {
            str = ReactProgressBarViewManager.DEFAULT_STYLE;
        }
        this.C = str;
    }
}
