package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;
import androidx.constraintlayout.core.PriorityGoalRow.GoalVariableAccessor;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class LinearSystem {
    public static boolean q = false;

    /* renamed from: d, reason: collision with root package name */
    public final PriorityGoalRow f1667d;

    /* renamed from: m, reason: collision with root package name */
    public final Cache f1676m;
    public ArrayRow p;

    /* renamed from: a, reason: collision with root package name */
    public int f1664a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1665b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f1666c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f1668e = 32;

    /* renamed from: f, reason: collision with root package name */
    public int f1669f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1671h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean[] f1672i = new boolean[32];

    /* renamed from: j, reason: collision with root package name */
    public int f1673j = 1;

    /* renamed from: k, reason: collision with root package name */
    public int f1674k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f1675l = 32;
    public SolverVariable[] n = new SolverVariable[1000];
    public int o = 0;

    /* renamed from: g, reason: collision with root package name */
    public ArrayRow[] f1670g = new ArrayRow[32];

    public interface Row {
        SolverVariable a(boolean[] zArr);
    }

    public static class ValuesRow extends ArrayRow {
    }

    public LinearSystem() {
        s();
        Cache cache = new Cache();
        this.f1676m = cache;
        PriorityGoalRow priorityGoalRow = new PriorityGoalRow(cache);
        priorityGoalRow.f1686f = new SolverVariable[128];
        priorityGoalRow.f1687g = new SolverVariable[128];
        priorityGoalRow.f1688h = 0;
        priorityGoalRow.f1689i = priorityGoalRow.new GoalVariableAccessor();
        this.f1667d = priorityGoalRow;
        this.p = new ArrayRow(cache);
    }

    public static int n(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).f1940i;
        if (solverVariable != null) {
            return (int) (solverVariable.f1696e + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final SolverVariable a(SolverVariable.Type type) {
        Pools.SimplePool simplePool = this.f1676m.f1662b;
        int i2 = simplePool.f1685b;
        SolverVariable solverVariable = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            ?? r3 = simplePool.f1684a;
            ?? r4 = r3[i3];
            r3[i3] = 0;
            simplePool.f1685b = i3;
            solverVariable = r4;
        }
        SolverVariable solverVariable2 = solverVariable;
        if (solverVariable2 == null) {
            solverVariable2 = new SolverVariable(type);
            solverVariable2.f1700i = type;
        } else {
            solverVariable2.c();
            solverVariable2.f1700i = type;
        }
        int i4 = this.o;
        int i5 = this.f1664a;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.f1664a = i6;
            this.n = (SolverVariable[]) Arrays.copyOf(this.n, i6);
        }
        SolverVariable[] solverVariableArr = this.n;
        int i7 = this.o;
        this.o = i7 + 1;
        solverVariableArr[i7] = solverVariable2;
        return solverVariable2;
    }

    public final void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        ArrayRow arrayRowL = l();
        if (solverVariable2 == solverVariable3) {
            arrayRowL.f1659d.h(solverVariable, 1.0f);
            arrayRowL.f1659d.h(solverVariable4, 1.0f);
            arrayRowL.f1659d.h(solverVariable2, -2.0f);
        } else if (f2 == 0.5f) {
            arrayRowL.f1659d.h(solverVariable, 1.0f);
            arrayRowL.f1659d.h(solverVariable2, -1.0f);
            arrayRowL.f1659d.h(solverVariable3, -1.0f);
            arrayRowL.f1659d.h(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                arrayRowL.f1657b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            arrayRowL.f1659d.h(solverVariable, -1.0f);
            arrayRowL.f1659d.h(solverVariable2, 1.0f);
            arrayRowL.f1657b = i2;
        } else if (f2 >= 1.0f) {
            arrayRowL.f1659d.h(solverVariable4, -1.0f);
            arrayRowL.f1659d.h(solverVariable3, 1.0f);
            arrayRowL.f1657b = -i3;
        } else {
            float f3 = 1.0f - f2;
            arrayRowL.f1659d.h(solverVariable, f3 * 1.0f);
            arrayRowL.f1659d.h(solverVariable2, f3 * (-1.0f));
            arrayRowL.f1659d.h(solverVariable3, (-1.0f) * f2);
            arrayRowL.f1659d.h(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                arrayRowL.f1657b = (i3 * f2) + ((-i2) * f3);
            }
        }
        if (i4 != 8) {
            arrayRowL.b(this, i4);
        }
        c(arrayRowL);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.constraintlayout.core.ArrayRow r18) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.c(androidx.constraintlayout.core.ArrayRow):void");
    }

    public final void d(SolverVariable solverVariable, int i2) {
        int i3 = solverVariable.f1694c;
        if (i3 == -1) {
            solverVariable.d(this, i2);
            for (int i4 = 0; i4 < this.f1666c + 1; i4++) {
                SolverVariable solverVariable2 = this.f1676m.f1663c[i4];
            }
            return;
        }
        if (i3 == -1) {
            ArrayRow arrayRowL = l();
            arrayRowL.f1656a = solverVariable;
            float f2 = i2;
            solverVariable.f1696e = f2;
            arrayRowL.f1657b = f2;
            arrayRowL.f1660e = true;
            c(arrayRowL);
            return;
        }
        ArrayRow arrayRow = this.f1670g[i3];
        if (arrayRow.f1660e) {
            arrayRow.f1657b = i2;
            return;
        }
        if (arrayRow.f1659d.f() == 0) {
            arrayRow.f1660e = true;
            arrayRow.f1657b = i2;
            return;
        }
        ArrayRow arrayRowL2 = l();
        if (i2 < 0) {
            arrayRowL2.f1657b = i2 * (-1);
            arrayRowL2.f1659d.h(solverVariable, 1.0f);
        } else {
            arrayRowL2.f1657b = i2;
            arrayRowL2.f1659d.h(solverVariable, -1.0f);
        }
        c(arrayRowL2);
    }

    public final void e(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (i3 == 8 && solverVariable2.f1697f && solverVariable.f1694c == -1) {
            solverVariable.d(this, solverVariable2.f1696e + i2);
            return;
        }
        ArrayRow arrayRowL = l();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            arrayRowL.f1657b = i2;
        }
        if (z) {
            arrayRowL.f1659d.h(solverVariable, 1.0f);
            arrayRowL.f1659d.h(solverVariable2, -1.0f);
        } else {
            arrayRowL.f1659d.h(solverVariable, -1.0f);
            arrayRowL.f1659d.h(solverVariable2, 1.0f);
        }
        if (i3 != 8) {
            arrayRowL.b(this, i3);
        }
        c(arrayRowL);
    }

    public final void f(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow arrayRowL = l();
        SolverVariable solverVariableM = m();
        solverVariableM.f1695d = 0;
        arrayRowL.c(solverVariable, solverVariable2, solverVariableM, i2);
        if (i3 != 8) {
            arrayRowL.f1659d.h(j(i3), (int) (arrayRowL.f1659d.j(solverVariableM) * (-1.0f)));
        }
        c(arrayRowL);
    }

    public final void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow arrayRowL = l();
        SolverVariable solverVariableM = m();
        solverVariableM.f1695d = 0;
        arrayRowL.d(solverVariable, solverVariable2, solverVariableM, i2);
        if (i3 != 8) {
            arrayRowL.f1659d.h(j(i3), (int) (arrayRowL.f1659d.j(solverVariableM) * (-1.0f)));
        }
        c(arrayRowL);
    }

    public final void h(ArrayRow arrayRow) {
        int i2;
        if (arrayRow.f1660e) {
            arrayRow.f1656a.d(this, arrayRow.f1657b);
        } else {
            ArrayRow[] arrayRowArr = this.f1670g;
            int i3 = this.f1674k;
            arrayRowArr[i3] = arrayRow;
            SolverVariable solverVariable = arrayRow.f1656a;
            solverVariable.f1694c = i3;
            this.f1674k = i3 + 1;
            solverVariable.e(this, arrayRow);
        }
        if (this.f1665b) {
            int i4 = 0;
            while (i4 < this.f1674k) {
                if (this.f1670g[i4] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f1670g[i4];
                if (arrayRow2 != null && arrayRow2.f1660e) {
                    arrayRow2.f1656a.d(this, arrayRow2.f1657b);
                    this.f1676m.f1661a.a(arrayRow2);
                    this.f1670g[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.f1674k;
                        if (i5 >= i2) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f1670g;
                        int i7 = i5 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i5];
                        arrayRowArr2[i7] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f1656a;
                        if (solverVariable2.f1694c == i5) {
                            solverVariable2.f1694c = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.f1670g[i6] = null;
                    }
                    this.f1674k = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.f1665b = false;
        }
    }

    public final void i() {
        for (int i2 = 0; i2 < this.f1674k; i2++) {
            ArrayRow arrayRow = this.f1670g[i2];
            arrayRow.f1656a.f1696e = arrayRow.f1657b;
        }
    }

    public final SolverVariable j(int i2) {
        if (this.f1673j + 1 >= this.f1669f) {
            o();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.f1706c);
        int i3 = this.f1666c + 1;
        this.f1666c = i3;
        this.f1673j++;
        solverVariableA.f1693b = i3;
        solverVariableA.f1695d = i2;
        this.f1676m.f1663c[i3] = solverVariableA;
        PriorityGoalRow priorityGoalRow = this.f1667d;
        priorityGoalRow.f1689i.f1690a = solverVariableA;
        float[] fArr = solverVariableA.f1699h;
        Arrays.fill(fArr, 0.0f);
        fArr[solverVariableA.f1695d] = 1.0f;
        priorityGoalRow.j(solverVariableA);
        return solverVariableA;
    }

    public final SolverVariable k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f1673j + 1 >= this.f1669f) {
            o();
        }
        if (!(obj instanceof ConstraintAnchor)) {
            return null;
        }
        ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
        SolverVariable solverVariable = constraintAnchor.f1940i;
        if (solverVariable == null) {
            constraintAnchor.k();
            solverVariable = constraintAnchor.f1940i;
        }
        int i2 = solverVariable.f1693b;
        Cache cache = this.f1676m;
        if (i2 != -1 && i2 <= this.f1666c && cache.f1663c[i2] != null) {
            return solverVariable;
        }
        if (i2 != -1) {
            solverVariable.c();
        }
        int i3 = this.f1666c + 1;
        this.f1666c = i3;
        this.f1673j++;
        solverVariable.f1693b = i3;
        solverVariable.f1700i = SolverVariable.Type.f1704a;
        cache.f1663c[i3] = solverVariable;
        return solverVariable;
    }

    public final ArrayRow l() {
        Object obj;
        Cache cache = this.f1676m;
        Pools.SimplePool simplePool = cache.f1661a;
        int i2 = simplePool.f1685b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = simplePool.f1684a;
            obj = objArr[i3];
            objArr[i3] = null;
            simplePool.f1685b = i3;
        } else {
            obj = null;
        }
        ArrayRow arrayRow = (ArrayRow) obj;
        if (arrayRow == null) {
            return new ArrayRow(cache);
        }
        arrayRow.f1656a = null;
        arrayRow.f1659d.clear();
        arrayRow.f1657b = 0.0f;
        arrayRow.f1660e = false;
        return arrayRow;
    }

    public final SolverVariable m() {
        if (this.f1673j + 1 >= this.f1669f) {
            o();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.f1705b);
        int i2 = this.f1666c + 1;
        this.f1666c = i2;
        this.f1673j++;
        solverVariableA.f1693b = i2;
        this.f1676m.f1663c[i2] = solverVariableA;
        return solverVariableA;
    }

    public final void o() {
        int i2 = this.f1668e * 2;
        this.f1668e = i2;
        this.f1670g = (ArrayRow[]) Arrays.copyOf(this.f1670g, i2);
        Cache cache = this.f1676m;
        cache.f1663c = (SolverVariable[]) Arrays.copyOf(cache.f1663c, this.f1668e);
        int i3 = this.f1668e;
        this.f1672i = new boolean[i3];
        this.f1669f = i3;
        this.f1675l = i3;
    }

    public final void p() {
        PriorityGoalRow priorityGoalRow = this.f1667d;
        if (priorityGoalRow.e()) {
            i();
            return;
        }
        if (!this.f1671h) {
            q(priorityGoalRow);
            return;
        }
        for (int i2 = 0; i2 < this.f1674k; i2++) {
            if (!this.f1670g[i2].f1660e) {
                q(priorityGoalRow);
                return;
            }
        }
        i();
    }

    public final void q(PriorityGoalRow priorityGoalRow) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f1674k) {
                break;
            }
            ArrayRow arrayRow = this.f1670g[i2];
            SolverVariable.Type type = arrayRow.f1656a.f1700i;
            SolverVariable.Type type2 = SolverVariable.Type.f1704a;
            if (type != type2) {
                float f2 = 0.0f;
                if (arrayRow.f1657b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3++;
                        float f3 = Float.MAX_VALUE;
                        int i4 = 0;
                        int i5 = -1;
                        int i6 = -1;
                        int i7 = 0;
                        while (i4 < this.f1674k) {
                            ArrayRow arrayRow2 = this.f1670g[i4];
                            if (arrayRow2.f1656a.f1700i != type2 && !arrayRow2.f1660e && arrayRow2.f1657b < f2) {
                                int iF = arrayRow2.f1659d.f();
                                int i8 = 0;
                                while (i8 < iF) {
                                    SolverVariable solverVariableB = arrayRow2.f1659d.b(i8);
                                    float f4 = f2;
                                    float fJ = arrayRow2.f1659d.j(solverVariableB);
                                    if (fJ > f4) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f5 = solverVariableB.f1698g[i9] / fJ;
                                            if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i6 = solverVariableB.f1693b;
                                                i5 = i4;
                                                f3 = f5;
                                            }
                                        }
                                    }
                                    i8++;
                                    f2 = f4;
                                }
                            }
                            i4++;
                            f2 = f2;
                        }
                        float f6 = f2;
                        if (i5 != -1) {
                            ArrayRow arrayRow3 = this.f1670g[i5];
                            arrayRow3.f1656a.f1694c = -1;
                            arrayRow3.g(this.f1676m.f1663c[i6]);
                            SolverVariable solverVariable = arrayRow3.f1656a;
                            solverVariable.f1694c = i5;
                            solverVariable.e(this, arrayRow3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.f1673j / 2) {
                            z = true;
                        }
                        f2 = f6;
                    }
                }
            }
            i2++;
        }
        r(priorityGoalRow);
        i();
    }

    public final void r(ArrayRow arrayRow) {
        for (int i2 = 0; i2 < this.f1673j; i2++) {
            this.f1672i[i2] = false;
        }
        boolean z = false;
        int i3 = 0;
        while (!z) {
            i3++;
            if (i3 >= this.f1673j * 2) {
                return;
            }
            SolverVariable solverVariable = arrayRow.f1656a;
            if (solverVariable != null) {
                this.f1672i[solverVariable.f1693b] = true;
            }
            SolverVariable solverVariableA = arrayRow.a(this.f1672i);
            if (solverVariableA != null) {
                boolean[] zArr = this.f1672i;
                int i4 = solverVariableA.f1693b;
                if (zArr[i4]) {
                    return;
                } else {
                    zArr[i4] = true;
                }
            }
            if (solverVariableA != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f1674k; i6++) {
                    ArrayRow arrayRow2 = this.f1670g[i6];
                    if (arrayRow2.f1656a.f1700i != SolverVariable.Type.f1704a && !arrayRow2.f1660e && arrayRow2.f1659d.a(solverVariableA)) {
                        float fJ = arrayRow2.f1659d.j(solverVariableA);
                        if (fJ < 0.0f) {
                            float f3 = (-arrayRow2.f1657b) / fJ;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow3 = this.f1670g[i5];
                    arrayRow3.f1656a.f1694c = -1;
                    arrayRow3.g(solverVariableA);
                    SolverVariable solverVariable2 = arrayRow3.f1656a;
                    solverVariable2.f1694c = i5;
                    solverVariable2.e(this, arrayRow3);
                }
            } else {
                z = true;
            }
        }
    }

    public final void s() {
        for (int i2 = 0; i2 < this.f1674k; i2++) {
            ArrayRow arrayRow = this.f1670g[i2];
            if (arrayRow != null) {
                this.f1676m.f1661a.a(arrayRow);
            }
            this.f1670g[i2] = null;
        }
    }

    public final void t() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.f1676m;
            SolverVariable[] solverVariableArr = cache.f1663c;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.c();
            }
            i2++;
        }
        Pools.SimplePool simplePool = cache.f1662b;
        SolverVariable[] solverVariableArr2 = this.n;
        int length = this.o;
        simplePool.getClass();
        if (length > solverVariableArr2.length) {
            length = solverVariableArr2.length;
        }
        for (int i3 = 0; i3 < length; i3++) {
            SolverVariable solverVariable2 = solverVariableArr2[i3];
            int i4 = simplePool.f1685b;
            Object[] objArr = simplePool.f1684a;
            if (i4 < objArr.length) {
                objArr[i4] = solverVariable2;
                simplePool.f1685b = i4 + 1;
            }
        }
        this.o = 0;
        Arrays.fill(cache.f1663c, (Object) null);
        this.f1666c = 0;
        PriorityGoalRow priorityGoalRow = this.f1667d;
        priorityGoalRow.f1688h = 0;
        priorityGoalRow.f1657b = 0.0f;
        this.f1673j = 1;
        for (int i5 = 0; i5 < this.f1674k; i5++) {
            ArrayRow arrayRow = this.f1670g[i5];
        }
        s();
        this.f1674k = 0;
        this.p = new ArrayRow(cache);
    }
}
