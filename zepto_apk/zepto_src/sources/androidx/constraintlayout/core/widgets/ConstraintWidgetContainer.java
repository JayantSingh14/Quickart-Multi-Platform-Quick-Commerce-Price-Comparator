package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    public final LinearSystem A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public ChainHead[] F0;
    public ChainHead[] G0;
    public int H0;
    public boolean I0;
    public boolean J0;
    public WeakReference K0;
    public WeakReference L0;
    public WeakReference M0;
    public WeakReference N0;
    public final HashSet O0;
    public final BasicMeasure.Measure P0;
    public final BasicMeasure v0 = new BasicMeasure(this);
    public final DependencyGraph w0;
    public int x0;
    public BasicMeasure.Measurer y0;
    public boolean z0;

    public ConstraintWidgetContainer() {
        DependencyGraph dependencyGraph = new DependencyGraph();
        dependencyGraph.f2000b = true;
        dependencyGraph.f2001c = true;
        dependencyGraph.f2003e = new ArrayList();
        new ArrayList();
        dependencyGraph.f2004f = null;
        dependencyGraph.f2005g = new BasicMeasure.Measure();
        dependencyGraph.f2006h = new ArrayList();
        dependencyGraph.f1999a = this;
        dependencyGraph.f2002d = this;
        this.w0 = dependencyGraph;
        this.y0 = null;
        this.z0 = false;
        this.A0 = new LinearSystem();
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = new ChainHead[4];
        this.G0 = new ChainHead[4];
        this.H0 = Type.CAA;
        this.I0 = false;
        this.J0 = false;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = new HashSet();
        this.P0 = new BasicMeasure.Measure();
    }

    public static void Y(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure) {
        int i2;
        int i3;
        if (measurer == null) {
            return;
        }
        if (constraintWidget.i0 == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.f1991e = 0;
            measure.f1992f = 0;
            return;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        measure.f1987a = dimensionBehaviourArr[0];
        measure.f1988b = dimensionBehaviourArr[1];
        measure.f1989c = constraintWidget.u();
        measure.f1990d = constraintWidget.o();
        measure.f1995i = false;
        measure.f1996j = 0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f1987a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1966c;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.f1988b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.Y > 0.0f;
        boolean z4 = z2 && constraintWidget.Y > 0.0f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1965b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1964a;
        if (z && constraintWidget.x(0) && constraintWidget.r == 0 && !z3) {
            measure.f1987a = dimensionBehaviour3;
            if (z2 && constraintWidget.s == 0) {
                measure.f1987a = dimensionBehaviour4;
            }
            z = false;
        }
        if (z2 && constraintWidget.x(1) && constraintWidget.s == 0 && !z4) {
            measure.f1988b = dimensionBehaviour3;
            if (z && constraintWidget.r == 0) {
                measure.f1988b = dimensionBehaviour4;
            }
            z2 = false;
        }
        if (constraintWidget.E()) {
            measure.f1987a = dimensionBehaviour4;
            z = false;
        }
        if (constraintWidget.F()) {
            measure.f1988b = dimensionBehaviour4;
            z2 = false;
        }
        int[] iArr = constraintWidget.t;
        if (z3) {
            if (iArr[0] == 4) {
                measure.f1987a = dimensionBehaviour4;
            } else if (!z2) {
                if (measure.f1988b == dimensionBehaviour4) {
                    i3 = measure.f1990d;
                } else {
                    measure.f1987a = dimensionBehaviour3;
                    measurer.b(constraintWidget, measure);
                    i3 = measure.f1992f;
                }
                measure.f1987a = dimensionBehaviour4;
                measure.f1989c = (int) (constraintWidget.Y * i3);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                measure.f1988b = dimensionBehaviour4;
            } else if (!z) {
                if (measure.f1987a == dimensionBehaviour4) {
                    i2 = measure.f1989c;
                } else {
                    measure.f1988b = dimensionBehaviour3;
                    measurer.b(constraintWidget, measure);
                    i2 = measure.f1991e;
                }
                measure.f1988b = dimensionBehaviour4;
                if (constraintWidget.Z == -1) {
                    measure.f1990d = (int) (i2 / constraintWidget.Y);
                } else {
                    measure.f1990d = (int) (constraintWidget.Y * i2);
                }
            }
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.S(measure.f1991e);
        constraintWidget.P(measure.f1992f);
        constraintWidget.E = measure.f1994h;
        constraintWidget.M(measure.f1993g);
        measure.f1996j = 0;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void G() {
        this.A0.t();
        this.B0 = 0;
        this.C0 = 0;
        super.G();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void T(boolean z, boolean z2) {
        super.T(z, z2);
        int size = this.u0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.u0.get(i2)).T(z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x08b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0927 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:538:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0966  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x099e A[PHI: r15 r25
      0x099e: PHI (r15v10 boolean) = (r15v9 boolean), (r15v14 boolean), (r15v14 boolean), (r15v14 boolean) binds: [B:543:0x0964, B:551:0x0986, B:552:0x0988, B:554:0x098e] A[DONT_GENERATE, DONT_INLINE]
      0x099e: PHI (r25v9 boolean) = (r25v8 boolean), (r25v11 boolean), (r25v11 boolean), (r25v11 boolean) binds: [B:543:0x0964, B:551:0x0986, B:552:0x0988, B:554:0x098e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:558:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:621:0x09a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0142  */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v9 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V() {
        /*
            Method dump skipped, instructions count: 2506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.V():void");
    }

    public final void W(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            int i3 = this.D0 + 1;
            ChainHead[] chainHeadArr = this.G0;
            if (i3 >= chainHeadArr.length) {
                this.G0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            ChainHead[] chainHeadArr2 = this.G0;
            int i4 = this.D0;
            chainHeadArr2[i4] = new ChainHead(constraintWidget, 0, this.z0);
            this.D0 = i4 + 1;
            return;
        }
        if (i2 == 1) {
            int i5 = this.E0 + 1;
            ChainHead[] chainHeadArr3 = this.F0;
            if (i5 >= chainHeadArr3.length) {
                this.F0 = (ChainHead[]) Arrays.copyOf(chainHeadArr3, chainHeadArr3.length * 2);
            }
            ChainHead[] chainHeadArr4 = this.F0;
            int i6 = this.E0;
            chainHeadArr4[i6] = new ChainHead(constraintWidget, 1, this.z0);
            this.E0 = i6 + 1;
        }
    }

    public final void X(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer;
        LinearSystem linearSystem2;
        boolean Z = Z(64);
        e(linearSystem, Z);
        int size = this.u0.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.u0.get(i2);
            boolean[] zArr = constraintWidget.T;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.u0.get(i3);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int i4 = 0; i4 < barrier.v0; i4++) {
                        ConstraintWidget constraintWidget3 = barrier.u0[i4];
                        if (barrier.x0 || constraintWidget3.f()) {
                            int i5 = barrier.w0;
                            if (i5 == 0 || i5 == 1) {
                                constraintWidget3.T[0] = true;
                            } else if (i5 == 2 || i5 == 3) {
                                constraintWidget3.T[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.O0;
        hashSet.clear();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) this.u0.get(i6);
            constraintWidget4.getClass();
            boolean z2 = constraintWidget4 instanceof VirtualLayout;
            if (z2 || (constraintWidget4 instanceof Guideline)) {
                if (z2) {
                    hashSet.add(constraintWidget4);
                } else {
                    constraintWidget4.e(linearSystem, Z);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) ((ConstraintWidget) it.next());
                for (int i7 = 0; i7 < virtualLayout.v0; i7++) {
                    if (hashSet.contains(virtualLayout.u0[i7])) {
                        virtualLayout.e(linearSystem, Z);
                        hashSet.remove(virtualLayout);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).e(linearSystem, Z);
                }
                hashSet.clear();
            }
        }
        boolean z3 = LinearSystem.q;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1965b;
        if (z3) {
            HashSet hashSet2 = new HashSet();
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) this.u0.get(i8);
                constraintWidget5.getClass();
                if (!(constraintWidget5 instanceof VirtualLayout) && !(constraintWidget5 instanceof Guideline)) {
                    hashSet2.add(constraintWidget5);
                }
            }
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            constraintWidgetContainer.d(this, linearSystem2, hashSet2, this.U[0] == dimensionBehaviour ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) it3.next();
                Optimizer.a(this, linearSystem2, constraintWidget6);
                constraintWidget6.e(linearSystem2, Z);
            }
        } else {
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget7 = (ConstraintWidget) constraintWidgetContainer.u0.get(i9);
                if (constraintWidget7 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget7.U;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1964a;
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget7.Q(dimensionBehaviour4);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget7.R(dimensionBehaviour4);
                    }
                    constraintWidget7.e(linearSystem2, Z);
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget7.Q(dimensionBehaviour2);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget7.R(dimensionBehaviour3);
                    }
                } else {
                    Optimizer.a(this, linearSystem2, constraintWidget7);
                    if (!(constraintWidget7 instanceof VirtualLayout) && !(constraintWidget7 instanceof Guideline)) {
                        constraintWidget7.e(linearSystem2, Z);
                    }
                }
            }
        }
        if (constraintWidgetContainer.D0 > 0) {
            Chain.a(this, linearSystem2, null, 0);
        }
        if (constraintWidgetContainer.E0 > 0) {
            Chain.a(this, linearSystem2, null, 1);
        }
    }

    public final boolean Z(int i2) {
        return (this.H0 & i2) == i2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void r(StringBuilder sb) {
        sb.append(this.f1959j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.W);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        sb.append("  actualHeight:" + this.X);
        sb.append(StringUtils.LF);
        Iterator it = this.u0.iterator();
        while (it.hasNext()) {
            ((ConstraintWidget) it.next()).r(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
