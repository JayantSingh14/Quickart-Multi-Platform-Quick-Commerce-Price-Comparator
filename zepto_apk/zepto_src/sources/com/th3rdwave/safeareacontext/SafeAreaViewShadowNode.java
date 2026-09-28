package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class SafeAreaViewShadowNode extends LayoutShadowNode {
    public final float[] A;
    public final float[] B;
    public boolean C;
    public SafeAreaViewLocalData z;

    public SafeAreaViewShadowNode() {
        int[] iArr = ViewProps.f19620a;
        this.A = new float[9];
        this.B = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            this.A[i2] = Float.NaN;
            this.B[i2] = Float.NaN;
        }
    }

    public static float n0(SafeAreaViewEdgeModes safeAreaViewEdgeModes, float f2, float f3) {
        return safeAreaViewEdgeModes == SafeAreaViewEdgeModes.f47174a ? f3 : safeAreaViewEdgeModes == SafeAreaViewEdgeModes.f47176c ? Math.max(f2, f3) : f2 + f3;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void S(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        if (this.C) {
            this.C = false;
            o0();
        }
    }

    public final void o0() {
        SafeAreaViewLocalData safeAreaViewLocalData = this.z;
        if (safeAreaViewLocalData == null) {
            return;
        }
        SafeAreaViewMode safeAreaViewModeC = safeAreaViewLocalData.c();
        SafeAreaViewMode safeAreaViewMode = SafeAreaViewMode.f47186a;
        float[] fArr = safeAreaViewModeC == safeAreaViewMode ? this.A : this.B;
        float f2 = fArr[8];
        if (Float.isNaN(f2)) {
            f2 = 0.0f;
        }
        float f3 = f2;
        float f4 = f3;
        float f5 = f4;
        float f6 = fArr[7];
        if (!Float.isNaN(f6)) {
            f2 = f6;
            f4 = f2;
        }
        float f7 = fArr[6];
        if (!Float.isNaN(f7)) {
            f3 = f7;
            f5 = f3;
        }
        float f8 = fArr[1];
        if (!Float.isNaN(f8)) {
            f2 = f8;
        }
        float f9 = fArr[2];
        if (!Float.isNaN(f9)) {
            f3 = f9;
        }
        float f10 = fArr[3];
        if (!Float.isNaN(f10)) {
            f4 = f10;
        }
        float f11 = fArr[0];
        if (!Float.isNaN(f11)) {
            f5 = f11;
        }
        float fB = PixelUtil.b(f2);
        float fB2 = PixelUtil.b(f3);
        float fB3 = PixelUtil.b(f4);
        float fB4 = PixelUtil.b(f5);
        SafeAreaViewEdges safeAreaViewEdgesA = safeAreaViewLocalData.a();
        EdgeInsets edgeInsetsB = safeAreaViewLocalData.b();
        if (safeAreaViewLocalData.c() == safeAreaViewMode) {
            w(n0(safeAreaViewEdgesA.d(), edgeInsetsB.f47154a, fB), 1);
            w(n0(safeAreaViewEdgesA.c(), edgeInsetsB.f47155b, fB2), 2);
            w(n0(safeAreaViewEdgesA.a(), edgeInsetsB.f47156c, fB3), 3);
            w(n0(safeAreaViewEdgesA.b(), edgeInsetsB.f47157d, fB4), 0);
            return;
        }
        j0(n0(safeAreaViewEdgesA.d(), edgeInsetsB.f47154a, fB), 1);
        j0(n0(safeAreaViewEdgesA.c(), edgeInsetsB.f47155b, fB2), 2);
        j0(n0(safeAreaViewEdgesA.a(), edgeInsetsB.f47156c, fB3), 3);
        j0(n0(safeAreaViewEdgesA.b(), edgeInsetsB.f47157d, fB4), 0);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void q(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = this.z;
            if (safeAreaViewLocalData != null && safeAreaViewLocalData.c() != ((SafeAreaViewLocalData) data).c()) {
                if (safeAreaViewLocalData.c() == SafeAreaViewMode.f47186a) {
                    float[] fArr = this.A;
                    w(fArr[1], 1);
                    w(fArr[2], 2);
                    w(fArr[3], 3);
                    w(fArr[0], 0);
                } else {
                    float[] fArr2 = this.B;
                    j0(fArr2[1], 1);
                    j0(fArr2[2], 2);
                    j0(fArr2[3], 3);
                    j0(fArr2[0], 0);
                }
                c0();
            }
            this.z = (SafeAreaViewLocalData) data;
            this.C = false;
            o0();
        }
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i2, @NotNull Dynamic margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        this.B[ViewProps.f19621b[i2]] = margin.getType() == ReadableType.Number ? (float) margin.asDouble() : Float.NaN;
        super.setMargins(i2, margin);
        this.C = true;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i2, @NotNull Dynamic padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.A[ViewProps.f19621b[i2]] = padding.getType() == ReadableType.Number ? (float) padding.asDouble() : Float.NaN;
        super.setPaddings(i2, padding);
        this.C = true;
    }
}
