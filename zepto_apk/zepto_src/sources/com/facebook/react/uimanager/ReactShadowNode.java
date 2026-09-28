package com.facebook.react.uimanager;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.yoga.YogaDirection;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface ReactShadowNode<T extends ReactShadowNode> {
    void A(ReactStylesDiffMap reactStylesDiffMap);

    int B();

    ReactShadowNodeImpl C(int i2);

    void D();

    void E(String str);

    ArrayList F();

    int G();

    void H();

    void I();

    boolean J();

    void K(float f2);

    int L();

    ThemedReactContext M();

    NativeKind N();

    int O();

    boolean P(float f2, float f3);

    boolean Q();

    void R(float f2, float f3);

    void S(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    ReactShadowNodeImpl T();

    ReactShadowNodeImpl U();

    boolean V();

    ReactShadowNodeImpl a(int i2);

    void b();

    void c(float f2);

    void d(int i2, int i3);

    void dispose();

    boolean e();

    int f();

    void g(float f2, float f3, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    Integer getHeightMeasureSpec();

    YogaDirection getLayoutDirection();

    ReactShadowNodeImpl getParent();

    Integer getWidthMeasureSpec();

    void i();

    int j(ReactShadowNode reactShadowNode);

    int k();

    void l(ReactShadowNode reactShadowNode, int i2);

    void m(int i2);

    void n(ThemedReactContext themedReactContext);

    void o(ReactBaseTextShadowNode reactBaseTextShadowNode);

    int p();

    void q(Object obj);

    void r(ReactShadowNode reactShadowNode, int i2);

    String s();

    void t(int i2);

    float u();

    int v();

    void w(float f2, int i2);

    float x();

    boolean y(ReactShadowNode reactShadowNode);

    void z(boolean z);
}
