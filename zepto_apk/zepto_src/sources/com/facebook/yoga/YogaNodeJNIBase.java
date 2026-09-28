package com.facebook.yoga;

import android.support.v4.media.b;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

@DoNotStrip
/* loaded from: classes.dex */
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public YogaNodeJNIBase f20395a;

    @DoNotStrip
    @Nullable
    private float[] arr;

    /* renamed from: b, reason: collision with root package name */
    public YogaConfig f20396b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f20397c;

    /* renamed from: d, reason: collision with root package name */
    public YogaMeasureFunction f20398d;

    /* renamed from: e, reason: collision with root package name */
    public YogaBaselineFunction f20399e;

    /* renamed from: f, reason: collision with root package name */
    public long f20400f;

    /* renamed from: g, reason: collision with root package name */
    public ReactShadowNodeImpl f20401g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20402h;

    @DoNotStrip
    private int mLayoutDirection;

    /* renamed from: com.facebook.yoga.YogaNodeJNIBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20403a;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            f20403a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20403a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20403a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20403a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20403a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20403a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public YogaNodeJNIBase(long j2) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.f20402h = true;
        if (j2 == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.f20400f = j2;
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        ArrayList arrayList = this.f20397c;
        if (arrayList == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        arrayList.remove(i2);
        this.f20397c.add(i2, yogaNodeJNIBase);
        yogaNodeJNIBase.f20395a = this;
        return yogaNodeJNIBase.f20400f;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void A() {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.f20400f, 2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void B(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.f20400f, yogaDisplay.f20350a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void C(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void D(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void E() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void F(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void G(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.f20400f, yogaFlexDirection.f20369a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void H(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void I(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void J(YogaGutter yogaGutter, float f2) {
        YogaNative.jni_YGNodeStyleSetGapJNI(this.f20400f, yogaGutter.a(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void K(YogaGutter yogaGutter, float f2) {
        YogaNative.jni_YGNodeStyleSetGapPercentJNI(this.f20400f, yogaGutter.a(), f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void L(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void M() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void O(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void P(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.f20400f, yogaJustify.f20382a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void Q(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void R(YogaEdge yogaEdge) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.f20400f, yogaEdge.f20361a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void S(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void T(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void U(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void V(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void W(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void X(YogaMeasureFunction yogaMeasureFunction) {
        this.f20398d = yogaMeasureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.f20400f, true);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void Y(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void a(YogaNode yogaNode, int i2) {
        if (yogaNode instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            if (yogaNodeJNIBase.f20395a != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.f20397c == null) {
                this.f20397c = new ArrayList(4);
            }
            this.f20397c.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.f20395a = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.f20400f, yogaNodeJNIBase.f20400f, i2);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public final void a0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void b(float f2, float f3) {
        ReactShadowNode reactShadowNode = this.f20401g;
        if (reactShadowNode instanceof YogaNode.Inputs) {
            ((YogaNode.Inputs) reactShadowNode).freeze();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList arrayList2 = ((YogaNodeJNIBase) arrayList.get(i2)).f20397c;
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) it.next();
                    ReactShadowNode reactShadowNode2 = yogaNodeJNIBase.f20401g;
                    if (reactShadowNode2 instanceof YogaNode.Inputs) {
                        ((YogaNode.Inputs) reactShadowNode2).freeze();
                    }
                    arrayList.add(yogaNodeJNIBase);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i3 = 0; i3 < yogaNodeJNIBaseArr.length; i3++) {
            jArr[i3] = yogaNodeJNIBaseArr[i3].f20400f;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.f20400f, f2, f3, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void b0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.f20400f, f2);
    }

    @DoNotStrip
    public final float baseline(float f2, float f3) {
        return this.f20399e.a(f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void c() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void c0(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final YogaValue d() {
        long jJni_YGNodeStyleGetHeightJNI = YogaNative.jni_YGNodeStyleGetHeightJNI(this.f20400f);
        return new YogaValue(Float.intBitsToFloat((int) jJni_YGNodeStyleGetHeightJNI), (int) (jJni_YGNodeStyleGetHeightJNI >> 32));
    }

    @Override // com.facebook.yoga.YogaNode
    public final void d0(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.f20400f, yogaOverflow.f20409a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final YogaDirection e() {
        float[] fArr = this.arr;
        int i2 = fArr != null ? (int) fArr[5] : this.mLayoutDirection;
        if (i2 == 0) {
            return YogaDirection.INHERIT;
        }
        if (i2 == 1) {
            return YogaDirection.LTR;
        }
        if (i2 == 2) {
            return YogaDirection.RTL;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown enum value: "));
    }

    @Override // com.facebook.yoga.YogaNode
    public final void e0(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final float f() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void f0(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final float g(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        int i2 = (int) fArr[0];
        if ((i2 & 2) != 2) {
            return 0.0f;
        }
        int i3 = (i2 & 1) != 1 ? 4 : 0;
        int i4 = 10 - i3;
        int iOrdinal = yogaEdge.ordinal();
        if (iOrdinal == 0) {
            return this.arr[i4];
        }
        if (iOrdinal == 1) {
            return this.arr[11 - i3];
        }
        if (iOrdinal == 2) {
            return this.arr[12 - i3];
        }
        if (iOrdinal == 3) {
            return this.arr[13 - i3];
        }
        YogaDirection yogaDirection = YogaDirection.RTL;
        if (iOrdinal == 4) {
            return e() == yogaDirection ? this.arr[12 - i3] : this.arr[i4];
        }
        if (iOrdinal == 5) {
            return e() == yogaDirection ? this.arr[i4] : this.arr[12 - i3];
        }
        throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
    }

    @Override // com.facebook.yoga.YogaNode
    public final void g0(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final float h() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void h0(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final float i() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void i0(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.f20400f, yogaPositionType.f20413a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final float j() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void j0(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final YogaValue k() {
        long jJni_YGNodeStyleGetWidthJNI = YogaNative.jni_YGNodeStyleGetWidthJNI(this.f20400f);
        return new YogaValue(Float.intBitsToFloat((int) jJni_YGNodeStyleGetWidthJNI), (int) (jJni_YGNodeStyleGetWidthJNI >> 32));
    }

    @Override // com.facebook.yoga.YogaNode
    public final void k0() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final boolean l() {
        float[] fArr = this.arr;
        return fArr != null ? (((int) fArr[0]) & 16) == 16 : this.f20402h;
    }

    @Override // com.facebook.yoga.YogaNode
    public final boolean m() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void m0(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.f20400f, f2);
    }

    @DoNotStrip
    public final long measure(float f2, int i2, float f3, int i3) {
        if (n()) {
            return this.f20398d.h(this, f2, YogaMeasureMode.a(i2), f3, YogaMeasureMode.a(i3));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.facebook.yoga.YogaNode
    public final boolean n() {
        return this.f20398d != null;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void o() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = ((int) fArr[0]) & (-17);
        }
        this.f20402h = false;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void o0(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.f20400f, yogaWrap.a());
    }

    @Override // com.facebook.yoga.YogaNode
    public final YogaNodeJNIBase p(int i2) {
        ArrayList arrayList = this.f20397c;
        if (arrayList == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.remove(i2);
        yogaNodeJNIBase.f20395a = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.f20400f, yogaNodeJNIBase.f20400f);
        return yogaNodeJNIBase;
    }

    @Override // com.facebook.yoga.YogaNode
    public final void q() {
        this.f20398d = null;
        this.f20399e = null;
        this.f20401g = null;
        this.arr = null;
        this.f20402h = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.f20400f);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void t(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.f20400f, yogaAlign.f20339a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void u(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.f20400f, yogaAlign.f20339a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void v(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.f20400f, yogaAlign.f20339a);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void w(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.f20400f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void x(YogaBaselineFunction yogaBaselineFunction) {
        this.f20399e = yogaBaselineFunction;
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(this.f20400f, true);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void y(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.f20400f, yogaEdge.f20361a, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public final void z(ReactShadowNodeImpl reactShadowNodeImpl) {
        this.f20401g = reactShadowNodeImpl;
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }
}
