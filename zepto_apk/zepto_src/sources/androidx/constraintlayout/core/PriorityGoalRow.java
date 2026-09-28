package androidx.constraintlayout.core;

import android.support.v4.media.b;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class PriorityGoalRow extends ArrayRow {

    /* renamed from: f, reason: collision with root package name */
    public SolverVariable[] f1686f;

    /* renamed from: g, reason: collision with root package name */
    public SolverVariable[] f1687g;

    /* renamed from: h, reason: collision with root package name */
    public int f1688h;

    /* renamed from: i, reason: collision with root package name */
    public GoalVariableAccessor f1689i;

    /* renamed from: androidx.constraintlayout.core.PriorityGoalRow$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<SolverVariable> {
        @Override // java.util.Comparator
        public final int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f1693b - solverVariable2.f1693b;
        }
    }

    public class GoalVariableAccessor {

        /* renamed from: a, reason: collision with root package name */
        public SolverVariable f1690a;

        public GoalVariableAccessor() {
        }

        public final String toString() {
            String string = "[ ";
            if (this.f1690a != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    StringBuilder sbW = b.w(string);
                    sbW.append(this.f1690a.f1699h[i2]);
                    sbW.append(StringUtils.SPACE);
                    string = sbW.toString();
                }
            }
            StringBuilder sbX = b.x(string, "] ");
            sbX.append(this.f1690a);
            return sbX.toString();
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public final SolverVariable a(boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f1688h; i3++) {
            SolverVariable[] solverVariableArr = this.f1686f;
            SolverVariable solverVariable = solverVariableArr[i3];
            if (!zArr[solverVariable.f1693b]) {
                GoalVariableAccessor goalVariableAccessor = this.f1689i;
                goalVariableAccessor.f1690a = solverVariable;
                int i4 = 8;
                if (i2 == -1) {
                    while (i4 >= 0) {
                        float f2 = goalVariableAccessor.f1690a.f1699h[i4];
                        if (f2 <= 0.0f) {
                            if (f2 < 0.0f) {
                                i2 = i3;
                                break;
                            }
                            i4--;
                        }
                    }
                } else {
                    SolverVariable solverVariable2 = solverVariableArr[i2];
                    while (true) {
                        if (i4 >= 0) {
                            float f3 = solverVariable2.f1699h[i4];
                            float f4 = goalVariableAccessor.f1690a.f1699h[i4];
                            if (f4 == f3) {
                                i4--;
                            } else if (f4 < f3) {
                            }
                        }
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f1686f[i2];
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final boolean e() {
        return this.f1688h == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final void i(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.f1656a;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f1659d;
        int iF = arrayRowVariables.f();
        for (int i2 = 0; i2 < iF; i2++) {
            SolverVariable solverVariableB = arrayRowVariables.b(i2);
            float fI = arrayRowVariables.i(i2);
            GoalVariableAccessor goalVariableAccessor = this.f1689i;
            goalVariableAccessor.f1690a = solverVariableB;
            boolean z2 = solverVariableB.f1692a;
            float[] fArr = solverVariable.f1699h;
            if (z2) {
                boolean z3 = true;
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr2 = goalVariableAccessor.f1690a.f1699h;
                    float f2 = (fArr[i3] * fI) + fArr2[i3];
                    fArr2[i3] = f2;
                    if (Math.abs(f2) < 1.0E-4f) {
                        goalVariableAccessor.f1690a.f1699h[i3] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    PriorityGoalRow.this.k(goalVariableAccessor.f1690a);
                }
            } else {
                for (int i4 = 0; i4 < 9; i4++) {
                    float f3 = fArr[i4];
                    if (f3 != 0.0f) {
                        float f4 = f3 * fI;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        goalVariableAccessor.f1690a.f1699h[i4] = f4;
                    } else {
                        goalVariableAccessor.f1690a.f1699h[i4] = 0.0f;
                    }
                }
                j(solverVariableB);
            }
            this.f1657b = (arrayRow.f1657b * fI) + this.f1657b;
        }
        k(solverVariable);
    }

    public final void j(SolverVariable solverVariable) {
        int i2;
        int i3 = this.f1688h + 1;
        SolverVariable[] solverVariableArr = this.f1686f;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f1686f = solverVariableArr2;
            this.f1687g = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f1686f;
        int i4 = this.f1688h;
        solverVariableArr3[i4] = solverVariable;
        int i5 = i4 + 1;
        this.f1688h = i5;
        if (i5 > 1 && solverVariableArr3[i4].f1693b > solverVariable.f1693b) {
            int i6 = 0;
            while (true) {
                i2 = this.f1688h;
                if (i6 >= i2) {
                    break;
                }
                this.f1687g[i6] = this.f1686f[i6];
                i6++;
            }
            Arrays.sort(this.f1687g, 0, i2, new AnonymousClass1());
            for (int i7 = 0; i7 < this.f1688h; i7++) {
                this.f1686f[i7] = this.f1687g[i7];
            }
        }
        solverVariable.f1692a = true;
        solverVariable.a(this);
    }

    public final void k(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.f1688h) {
            if (this.f1686f[i2] == solverVariable) {
                while (true) {
                    int i3 = this.f1688h;
                    if (i2 >= i3 - 1) {
                        this.f1688h = i3 - 1;
                        solverVariable.f1692a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f1686f;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final String toString() {
        String str = " goal -> (" + this.f1657b + ") : ";
        for (int i2 = 0; i2 < this.f1688h; i2++) {
            SolverVariable solverVariable = this.f1686f[i2];
            GoalVariableAccessor goalVariableAccessor = this.f1689i;
            goalVariableAccessor.f1690a = solverVariable;
            str = str + goalVariableAccessor + StringUtils.SPACE;
        }
        return str;
    }
}
