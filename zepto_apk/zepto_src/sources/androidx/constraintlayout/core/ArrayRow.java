package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ArrayRow implements LinearSystem.Row {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayRowVariables f1659d;

    /* renamed from: a, reason: collision with root package name */
    public SolverVariable f1656a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f1657b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1658c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f1660e = false;

    public interface ArrayRowVariables {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i2);

        void c(SolverVariable solverVariable, float f2, boolean z);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z);

        int f();

        float g(ArrayRow arrayRow, boolean z);

        void h(SolverVariable solverVariable, float f2);

        float i(int i2);

        float j(SolverVariable solverVariable);

        void k(float f2);
    }

    public ArrayRow() {
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable a(boolean[] zArr) {
        return f(zArr, null);
    }

    public final void b(LinearSystem linearSystem, int i2) {
        this.f1659d.h(linearSystem.j(i2), 1.0f);
        this.f1659d.h(linearSystem.j(i2), -1.0f);
    }

    public final void c(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f1657b = i2;
        }
        if (z) {
            this.f1659d.h(solverVariable, 1.0f);
            this.f1659d.h(solverVariable2, -1.0f);
            this.f1659d.h(solverVariable3, -1.0f);
        } else {
            this.f1659d.h(solverVariable, -1.0f);
            this.f1659d.h(solverVariable2, 1.0f);
            this.f1659d.h(solverVariable3, 1.0f);
        }
    }

    public final void d(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f1657b = i2;
        }
        if (z) {
            this.f1659d.h(solverVariable, 1.0f);
            this.f1659d.h(solverVariable2, -1.0f);
            this.f1659d.h(solverVariable3, 1.0f);
        } else {
            this.f1659d.h(solverVariable, -1.0f);
            this.f1659d.h(solverVariable2, 1.0f);
            this.f1659d.h(solverVariable3, -1.0f);
        }
    }

    public boolean e() {
        return this.f1656a == null && this.f1657b == 0.0f && this.f1659d.f() == 0;
    }

    public final SolverVariable f(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int iF = this.f1659d.f();
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < iF; i2++) {
            float fI = this.f1659d.i(i2);
            if (fI < 0.0f) {
                SolverVariable solverVariableB = this.f1659d.b(i2);
                if ((zArr == null || !zArr[solverVariableB.f1693b]) && solverVariableB != solverVariable && (((type = solverVariableB.f1700i) == SolverVariable.Type.f1705b || type == SolverVariable.Type.f1706c) && fI < f2)) {
                    f2 = fI;
                    solverVariable2 = solverVariableB;
                }
            }
        }
        return solverVariable2;
    }

    public final void g(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1656a;
        if (solverVariable2 != null) {
            this.f1659d.h(solverVariable2, -1.0f);
            this.f1656a.f1694c = -1;
            this.f1656a = null;
        }
        float fE = this.f1659d.e(solverVariable, true) * (-1.0f);
        this.f1656a = solverVariable;
        if (fE == 1.0f) {
            return;
        }
        this.f1657b /= fE;
        this.f1659d.k(fE);
    }

    public final void h(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.f1697f) {
            return;
        }
        float fJ = this.f1659d.j(solverVariable);
        this.f1657b = (solverVariable.f1696e * fJ) + this.f1657b;
        this.f1659d.e(solverVariable, z);
        if (z) {
            solverVariable.b(this);
        }
        if (this.f1659d.f() == 0) {
            this.f1660e = true;
            linearSystem.f1665b = true;
        }
    }

    public void i(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        float fG = this.f1659d.g(arrayRow, z);
        this.f1657b = (arrayRow.f1657b * fG) + this.f1657b;
        if (z) {
            arrayRow.f1656a.b(this);
        }
        if (this.f1656a == null || this.f1659d.f() != 0) {
            return;
        }
        this.f1660e = true;
        linearSystem.f1665b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f1656a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f1656a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = android.support.v4.media.b.k(r0, r1)
            float r1 = r10.f1657b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = android.support.v4.media.b.w(r0)
            float r1 = r10.f1657b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L36
        L35:
            r1 = r4
        L36:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.f1659d
            int r5 = r5.f()
        L3c:
            if (r4 >= r5) goto L9c
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.f1659d
            androidx.constraintlayout.core.SolverVariable r6 = r6.b(r4)
            if (r6 != 0) goto L47
            goto L99
        L47:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.f1659d
            float r7 = r7.i(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = android.support.v4.media.b.k(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = android.support.v4.media.b.k(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = android.support.v4.media.b.k(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = android.support.v4.media.b.k(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r3
        L99:
            int r4 = r4 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = android.support.v4.media.b.k(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toString():java.lang.String");
    }

    public ArrayRow(Cache cache) {
        this.f1659d = new ArrayLinkedVariables(this, cache);
    }
}
