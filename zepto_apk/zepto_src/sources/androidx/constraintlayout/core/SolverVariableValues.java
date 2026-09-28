package androidx.constraintlayout.core;

import android.support.v4.media.b;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {

    /* renamed from: a, reason: collision with root package name */
    public int f1709a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1710b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1711c;

    /* renamed from: d, reason: collision with root package name */
    public float[] f1712d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1713e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1714f;

    /* renamed from: g, reason: collision with root package name */
    public int f1715g;

    /* renamed from: h, reason: collision with root package name */
    public int f1716h;

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final boolean a(SolverVariable solverVariable) {
        m(solverVariable);
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final SolverVariable b(int i2) {
        int i3 = this.f1715g;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f1716h;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                throw null;
            }
            i4 = this.f1714f[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void c(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            m(solverVariable);
            h(solverVariable, f2);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i2 = this.f1715g;
        for (int i3 = 0; i3 < i2; i3++) {
            if (b(i3) != null) {
                throw null;
            }
        }
        for (int i4 = 0; i4 < this.f1709a; i4++) {
            this.f1711c[i4] = -1;
            this.f1710b[i4] = -1;
        }
        this.f1715g = 0;
        this.f1716h = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void d() {
        int i2 = this.f1715g;
        int i3 = this.f1716h;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f1712d;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f1714f[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float e(SolverVariable solverVariable, boolean z) {
        m(solverVariable);
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final int f() {
        return this.f1715g;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float g(ArrayRow arrayRow, boolean z) {
        j(arrayRow.f1656a);
        e(arrayRow.f1656a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.f1659d;
        int i2 = solverVariableValues.f1715g;
        int i3 = 0;
        while (i2 > 0) {
            if (solverVariableValues.f1711c[i3] != -1) {
                float f2 = solverVariableValues.f1712d[i3];
                throw null;
            }
            i3++;
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void h(SolverVariable solverVariable, float f2) {
        if (f2 > -0.001f && f2 < 0.001f) {
            e(solverVariable, true);
            return;
        }
        int i2 = 0;
        if (this.f1715g == 0) {
            l(0, solverVariable, f2);
            throw null;
        }
        m(solverVariable);
        int i3 = this.f1715g + 1;
        int i4 = this.f1709a;
        if (i3 >= i4) {
            int i5 = i4 * 2;
            this.f1711c = Arrays.copyOf(this.f1711c, i5);
            this.f1712d = Arrays.copyOf(this.f1712d, i5);
            this.f1713e = Arrays.copyOf(this.f1713e, i5);
            this.f1714f = Arrays.copyOf(this.f1714f, i5);
            this.f1710b = Arrays.copyOf(this.f1710b, i5);
            for (int i6 = this.f1709a; i6 < i5; i6++) {
                this.f1711c[i6] = -1;
                this.f1710b[i6] = -1;
            }
            this.f1709a = i5;
        }
        int i7 = this.f1715g;
        int i8 = this.f1716h;
        int i9 = -1;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = this.f1711c[i8];
            int i12 = solverVariable.f1693b;
            if (i11 == i12) {
                this.f1712d[i8] = f2;
                return;
            }
            if (i11 < i12) {
                i9 = i8;
            }
            i8 = this.f1714f[i8];
            if (i8 == -1) {
                break;
            }
        }
        while (true) {
            if (i2 >= this.f1709a) {
                i2 = -1;
                break;
            } else if (this.f1711c[i2] == -1) {
                break;
            } else {
                i2++;
            }
        }
        l(i2, solverVariable, f2);
        if (i9 != -1) {
            this.f1713e[i2] = i9;
            int[] iArr = this.f1714f;
            iArr[i2] = iArr[i9];
            iArr[i9] = i2;
        } else {
            this.f1713e[i2] = -1;
            if (this.f1715g > 0) {
                this.f1714f[i2] = this.f1716h;
                this.f1716h = i2;
            } else {
                this.f1714f[i2] = -1;
            }
        }
        int i13 = this.f1714f[i2];
        if (i13 == -1) {
            throw null;
        }
        this.f1713e[i13] = i2;
        throw null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float i(int i2) {
        int i3 = this.f1715g;
        int i4 = this.f1716h;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f1712d[i4];
            }
            i4 = this.f1714f[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float j(SolverVariable solverVariable) {
        m(solverVariable);
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void k(float f2) {
        int i2 = this.f1715g;
        int i3 = this.f1716h;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f1712d;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f1714f[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    public final void l(int i2, SolverVariable solverVariable, float f2) {
        this.f1711c[i2] = solverVariable.f1693b;
        this.f1712d[i2] = f2;
        this.f1713e[i2] = -1;
        this.f1714f[i2] = -1;
        throw null;
    }

    public final int m(SolverVariable solverVariable) {
        if (this.f1715g == 0 || solverVariable == null) {
            return -1;
        }
        throw null;
    }

    public final String toString() {
        String str = hashCode() + " { ";
        int i2 = this.f1715g;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable solverVariableB = b(i3);
            if (solverVariableB != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(solverVariableB);
                sb.append(" = ");
                sb.append(i(i3));
                sb.append(StringUtils.SPACE);
                m(solverVariableB);
                int i4 = this.f1713e[-1];
                throw null;
            }
        }
        return b.k(str, " }");
    }
}
