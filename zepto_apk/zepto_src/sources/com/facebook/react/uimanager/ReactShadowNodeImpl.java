package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.uimanager.UIViewOperationQueue.UpdateLayoutOperation;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactRawTextShadowNode;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConfigJNIBase;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeJNIFinalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@ReactPropertyHolder
/* loaded from: classes.dex */
public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    public static final YogaConfig x;

    /* renamed from: a, reason: collision with root package name */
    public int f19456a;

    /* renamed from: b, reason: collision with root package name */
    public String f19457b;

    /* renamed from: c, reason: collision with root package name */
    public int f19458c;

    /* renamed from: d, reason: collision with root package name */
    public ThemedReactContext f19459d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19460e;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f19462g;

    /* renamed from: h, reason: collision with root package name */
    public ReactShadowNodeImpl f19463h;

    /* renamed from: i, reason: collision with root package name */
    public ReactShadowNodeImpl f19464i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f19465j;

    /* renamed from: l, reason: collision with root package name */
    public ReactShadowNodeImpl f19467l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f19468m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final float[] s;
    public final YogaNode u;
    public Integer v;
    public Integer w;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19461f = true;

    /* renamed from: k, reason: collision with root package name */
    public int f19466k = 0;
    public final boolean[] t = new boolean[9];
    public final Spacing r = new Spacing(0.0f);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    static {
        Object value = ReactYogaConfigProvider.f19470a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        x = (YogaConfig) value;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, kotlin.Lazy] */
    public ReactShadowNodeImpl() {
        float[] fArr = new float[9];
        this.s = fArr;
        if (J()) {
            this.u = null;
            return;
        }
        YogaNode yogaNode = (YogaNode) ((ClearableSynchronizedPool) YogaNodePool.f19623a.getValue()).b();
        YogaNode yogaNode2 = yogaNode;
        if (yogaNode == null) {
            YogaConfig yogaConfig = x;
            YogaNodeJNIFinalizer yogaNodeJNIFinalizer = new YogaNodeJNIFinalizer(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) yogaConfig).f20341a));
            yogaNodeJNIFinalizer.f20396b = yogaConfig;
            yogaNode2 = yogaNodeJNIFinalizer;
        }
        this.u = yogaNode2;
        yogaNode2.z(this);
        Arrays.fill(fArr, Float.NaN);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void A(ReactStylesDiffMap reactStylesDiffMap) {
        HashMap map = ViewManagerPropertyUpdater.f19597a;
        ViewManagerPropertyUpdater.ShadowNodeSetter shadowNodeSetterD = ViewManagerPropertyUpdater.d(getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.f19469a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            shadowNodeSetterD.a(this, next.getKey(), next.getValue());
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int B() {
        return this.q;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl C(int i2) {
        ArrayList arrayList = this.f19462g;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException(android.support.v4.media.b.g(i2, "Index ", " out of bounds: node has no children"));
        }
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) arrayList.remove(i2);
        reactShadowNodeImpl.f19463h = null;
        YogaNode yogaNode = this.u;
        if (yogaNode != null && !b0()) {
            yogaNode.p(i2);
        }
        c0();
        int iZ = reactShadowNodeImpl.Z();
        this.f19466k -= iZ;
        k0(-iZ);
        return reactShadowNodeImpl;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void D() {
        if (!J()) {
            this.u.c();
            return;
        }
        ReactShadowNodeImpl reactShadowNodeImpl = this.f19463h;
        if (reactShadowNodeImpl != null) {
            reactShadowNodeImpl.D();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void E(String str) {
        this.f19457b = str;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ArrayList F() {
        if (this instanceof ReactTextInputShadowNode) {
            return null;
        }
        return this.f19462g;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int G() {
        return this.f19456a;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void H() {
        ArrayList arrayList = this.f19468m;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ReactShadowNodeImpl) this.f19468m.get(size)).f19467l = null;
            }
            this.f19468m.clear();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void I() {
        R(Float.NaN, Float.NaN);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean J() {
        return this instanceof ReactRawTextShadowNode;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void K(float f2) {
        this.u.j0(f2);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int L() {
        return this.p;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ThemedReactContext M() {
        ThemedReactContext themedReactContext = this.f19459d;
        Assertions.c(themedReactContext);
        return themedReactContext;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final NativeKind N() {
        return (J() || this.f19465j) ? NativeKind.f19405c : this instanceof ReactTextShadowNode ? NativeKind.f19404b : NativeKind.f19403a;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int O() {
        Assertions.a(this.f19458c != 0);
        return this.f19458c;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean P(float f2, float f3) {
        if (!a0()) {
            return false;
        }
        YogaNode yogaNode = this.u;
        float fI = yogaNode.i();
        float fJ = yogaNode.j();
        float f4 = f2 + fI;
        int iRound = Math.round(f4);
        float f5 = f3 + fJ;
        int iRound2 = Math.round(f5);
        return (Math.round(fI) == this.n && Math.round(fJ) == this.o && Math.round(yogaNode.h() + f4) - iRound == this.p && Math.round(yogaNode.f() + f5) - iRound2 == this.q) ? false : true;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean Q() {
        return this.f19460e;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void R(float f2, float f3) {
        this.u.b(f2, f3);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void S(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl T() {
        ReactShadowNodeImpl reactShadowNodeImpl = this.f19464i;
        return reactShadowNodeImpl != null ? reactShadowNodeImpl : this.f19467l;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl U() {
        return this.f19467l;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean V() {
        return this.f19465j;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void r(ReactShadowNodeImpl reactShadowNodeImpl, int i2) {
        if (this.f19462g == null) {
            this.f19462g = new ArrayList(4);
        }
        this.f19462g.add(i2, reactShadowNodeImpl);
        reactShadowNodeImpl.f19463h = this;
        YogaNode yogaNode = this.u;
        if (yogaNode != null && !b0()) {
            YogaNode yogaNode2 = reactShadowNodeImpl.u;
            if (yogaNode2 == null) {
                throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + reactShadowNodeImpl.toString() + "' to a '" + toString() + "')");
            }
            yogaNode.a(yogaNode2, i2);
        }
        c0();
        int iZ = reactShadowNodeImpl.Z();
        this.f19466k += iZ;
        k0(iZ);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final ReactShadowNodeImpl a(int i2) {
        ArrayList arrayList = this.f19462g;
        if (arrayList != null) {
            return (ReactShadowNodeImpl) arrayList.get(i2);
        }
        throw new ArrayIndexOutOfBoundsException(android.support.v4.media.b.g(i2, "Index ", " out of bounds: node has no children"));
    }

    public final float Y(int i2) {
        return this.u.g(YogaEdge.a(i2));
    }

    public final int Z() {
        NativeKind nativeKindN = N();
        if (nativeKindN == NativeKind.f19405c) {
            return this.f19466k;
        }
        if (nativeKindN == NativeKind.f19404b) {
            return this.f19466k + 1;
        }
        return 1;
    }

    public final boolean a0() {
        YogaNode yogaNode = this.u;
        return yogaNode != null && yogaNode.l();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void b() {
        YogaNode yogaNode;
        this.f19461f = false;
        if (!a0() || (yogaNode = this.u) == null) {
            return;
        }
        yogaNode.o();
    }

    public boolean b0() {
        return this.u.n();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void c(float f2) {
        this.u.L(f2);
    }

    public void c0() {
        if (this.f19461f) {
            return;
        }
        this.f19461f = true;
        ReactShadowNodeImpl reactShadowNodeImpl = this.f19463h;
        if (reactShadowNodeImpl != null) {
            reactShadowNodeImpl.c0();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void d(int i2, int i3) {
        this.v = Integer.valueOf(i2);
        this.w = Integer.valueOf(i3);
    }

    public void d0(UIViewOperationQueue uIViewOperationQueue) {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void dispose() {
        YogaNode yogaNode = this.u;
        if (yogaNode != null) {
            yogaNode.q();
            ((ClearableSynchronizedPool) YogaNodePool.f19623a.getValue()).a(yogaNode);
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean e() {
        if (this.f19461f || a0()) {
            return true;
        }
        YogaNode yogaNode = this.u;
        return yogaNode != null && yogaNode.m();
    }

    public final void e0(YogaAlign yogaAlign) {
        this.u.t(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int f() {
        ArrayList arrayList = this.f19462g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void f0(YogaAlign yogaAlign) {
        this.u.u(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void g(float f2, float f3, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.f19461f) {
            d0(uIViewOperationQueue);
        }
        if (a0()) {
            YogaNode yogaNode = this.u;
            float fI = yogaNode.i();
            float fJ = yogaNode.j();
            float f4 = f2 + fI;
            int iRound = Math.round(f4);
            float f5 = f3 + fJ;
            int iRound2 = Math.round(f5);
            int iRound3 = Math.round(yogaNode.h() + f4);
            int iRound4 = Math.round(yogaNode.f() + f5);
            int iRound5 = Math.round(fI);
            int iRound6 = Math.round(fJ);
            int i2 = iRound3 - iRound;
            int i3 = iRound4 - iRound2;
            boolean z = (iRound5 == this.n && iRound6 == this.o && i2 == this.p && i3 == this.q) ? false : true;
            this.n = iRound5;
            this.o = iRound6;
            this.p = i2;
            this.q = i3;
            if (z) {
                if (nativeViewHierarchyOptimizer != null) {
                    nativeViewHierarchyOptimizer.d(this);
                } else {
                    uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new UpdateLayoutOperation(this.f19463h.f19456a, this.f19456a, iRound5, iRound6, i2, i3, yogaNode.e()));
                }
            }
        }
    }

    public final void g0(YogaAlign yogaAlign) {
        this.u.v(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final Integer getHeightMeasureSpec() {
        return this.w;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaDirection getLayoutDirection() {
        return this.u.e();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getParent() {
        return this.f19463h;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final Integer getWidthMeasureSpec() {
        return this.v;
    }

    public final void h0(YogaFlexDirection yogaFlexDirection) {
        this.u.G(yogaFlexDirection);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void i() {
        if (f() == 0) {
            return;
        }
        int iZ = 0;
        for (int iF = f() - 1; iF >= 0; iF--) {
            YogaNode yogaNode = this.u;
            if (yogaNode != null && !b0()) {
                yogaNode.p(iF);
            }
            ReactShadowNodeImpl reactShadowNodeImplA = a(iF);
            reactShadowNodeImplA.f19463h = null;
            iZ += reactShadowNodeImplA.Z();
            reactShadowNodeImplA.dispose();
        }
        ArrayList arrayList = this.f19462g;
        Assertions.c(arrayList);
        arrayList.clear();
        c0();
        this.f19466k -= iZ;
        k0(-iZ);
    }

    public final void i0(YogaJustify yogaJustify) {
        this.u.P(yogaJustify);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int j(ReactShadowNode reactShadowNode) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        int iZ = 0;
        for (int i2 = 0; i2 < f(); i2++) {
            ReactShadowNodeImpl reactShadowNodeImplA = a(i2);
            if (reactShadowNodeImpl == reactShadowNodeImplA) {
                return iZ;
            }
            iZ += reactShadowNodeImplA.Z();
        }
        throw new RuntimeException("Child " + reactShadowNodeImpl.f19456a + " was not a child of " + this.f19456a);
    }

    public final void j0(float f2, int i2) {
        this.u.Q(YogaEdge.a(i2), f2);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int k() {
        ArrayList arrayList = this.f19468m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void k0(int i2) {
        if (N() != NativeKind.f19403a) {
            for (ReactShadowNodeImpl reactShadowNodeImpl = this.f19463h; reactShadowNodeImpl != null; reactShadowNodeImpl = reactShadowNodeImpl.f19463h) {
                reactShadowNodeImpl.f19466k += i2;
                if (reactShadowNodeImpl.N() == NativeKind.f19403a) {
                    return;
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void l(ReactShadowNode reactShadowNode, int i2) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        Assertions.a(N() == NativeKind.f19403a);
        Assertions.a(reactShadowNodeImpl.N() != NativeKind.f19405c);
        if (this.f19468m == null) {
            this.f19468m = new ArrayList(4);
        }
        this.f19468m.add(i2, reactShadowNodeImpl);
        reactShadowNodeImpl.f19467l = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0() {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 8
            if (r0 > r1) goto L99
            com.facebook.yoga.YogaNode r2 = r6.u
            float[] r3 = r6.s
            com.facebook.react.uimanager.Spacing r4 = r6.r
            if (r0 == 0) goto L57
            r5 = 2
            if (r0 == r5) goto L57
            r5 = 4
            if (r0 == r5) goto L57
            r5 = 5
            if (r0 != r5) goto L17
            goto L57
        L17:
            r5 = 1
            if (r0 == r5) goto L32
            r5 = 3
            if (r0 != r5) goto L1e
            goto L32
        L1e:
            r1 = r3[r0]
            boolean r1 = com.facebook.yoga.YogaConstants.a(r1)
            if (r1 == 0) goto L7c
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.a(r0)
            float[] r3 = r4.f19476b
            r3 = r3[r0]
            r2.e0(r1, r3)
            goto L95
        L32:
            r5 = r3[r0]
            boolean r5 = com.facebook.yoga.YogaConstants.a(r5)
            if (r5 == 0) goto L7c
            r5 = 7
            r5 = r3[r5]
            boolean r5 = com.facebook.yoga.YogaConstants.a(r5)
            if (r5 == 0) goto L7c
            r1 = r3[r1]
            boolean r1 = com.facebook.yoga.YogaConstants.a(r1)
            if (r1 == 0) goto L7c
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.a(r0)
            float[] r3 = r4.f19476b
            r3 = r3[r0]
            r2.e0(r1, r3)
            goto L95
        L57:
            r5 = r3[r0]
            boolean r5 = com.facebook.yoga.YogaConstants.a(r5)
            if (r5 == 0) goto L7c
            r5 = 6
            r5 = r3[r5]
            boolean r5 = com.facebook.yoga.YogaConstants.a(r5)
            if (r5 == 0) goto L7c
            r1 = r3[r1]
            boolean r1 = com.facebook.yoga.YogaConstants.a(r1)
            if (r1 == 0) goto L7c
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.a(r0)
            float[] r3 = r4.f19476b
            r3 = r3[r0]
            r2.e0(r1, r3)
            goto L95
        L7c:
            boolean[] r1 = r6.t
            boolean r1 = r1[r0]
            if (r1 == 0) goto L8c
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.a(r0)
            r3 = r3[r0]
            r2.f0(r1, r3)
            goto L95
        L8c:
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.a(r0)
            r3 = r3[r0]
            r2.e0(r1, r3)
        L95:
            int r0 = r0 + 1
            goto L1
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactShadowNodeImpl.l0():void");
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void m(int i2) {
        this.f19458c = i2;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void n(ThemedReactContext themedReactContext) {
        this.f19459d = themedReactContext;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void o(ReactBaseTextShadowNode reactBaseTextShadowNode) {
        this.f19464i = reactBaseTextShadowNode;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int p() {
        return this.o;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void q(Object obj) {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final String s() {
        String str = this.f19457b;
        Assertions.c(str);
        return str;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void t(int i2) {
        this.f19456a = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f19457b);
        sb.append(StringUtils.SPACE);
        return android.support.v4.media.b.o(sb, this.f19456a, "]");
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float u() {
        return this.u.j();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int v() {
        return this.n;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void w(float f2, int i2) {
        this.s[i2] = f2;
        this.t[i2] = false;
        l0();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float x() {
        return this.u.i();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean y(ReactShadowNode reactShadowNode) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        for (ReactShadowNodeImpl reactShadowNodeImpl2 = this.f19463h; reactShadowNodeImpl2 != null; reactShadowNodeImpl2 = reactShadowNodeImpl2.f19463h) {
            if (reactShadowNodeImpl2 == reactShadowNodeImpl) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void z(boolean z) {
        Assertions.b(this.f19463h == null, "Must remove from no opt parent first");
        Assertions.b(this.f19467l == null, "Must remove from native parent first");
        Assertions.b(k() == 0, "Must remove all native children first");
        this.f19465j = z;
    }
}
