package androidx.constraintlayout.core;

import android.support.v4.media.b;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayRow f1647b;

    /* renamed from: c, reason: collision with root package name */
    public final Cache f1648c;

    /* renamed from: a, reason: collision with root package name */
    public int f1646a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1649d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1650e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f1651f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f1652g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f1653h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1654i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1655j = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f1647b = arrayRow;
        this.f1648c = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final boolean a(SolverVariable solverVariable) {
        int i2 = this.f1653h;
        if (i2 != -1) {
            for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
                if (this.f1650e[i2] == solverVariable.f1693b) {
                    return true;
                }
                i2 = this.f1651f[i2];
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final SolverVariable b(int i2) {
        int i3 = this.f1653h;
        for (int i4 = 0; i3 != -1 && i4 < this.f1646a; i4++) {
            if (i4 == i2) {
                return this.f1648c.f1663c[this.f1650e[i3]];
            }
            i3 = this.f1651f[i3];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void c(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.f1653h;
            ArrayRow arrayRow = this.f1647b;
            if (i2 == -1) {
                this.f1653h = 0;
                this.f1652g[0] = f2;
                this.f1650e[0] = solverVariable.f1693b;
                this.f1651f[0] = -1;
                solverVariable.f1703l++;
                solverVariable.a(arrayRow);
                this.f1646a++;
                if (this.f1655j) {
                    return;
                }
                int i3 = this.f1654i + 1;
                this.f1654i = i3;
                int[] iArr = this.f1650e;
                if (i3 >= iArr.length) {
                    this.f1655j = true;
                    this.f1654i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i4 = -1;
            for (int i5 = 0; i2 != -1 && i5 < this.f1646a; i5++) {
                int i6 = this.f1650e[i2];
                int i7 = solverVariable.f1693b;
                if (i6 == i7) {
                    float[] fArr = this.f1652g;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1653h) {
                            this.f1653h = this.f1651f[i2];
                        } else {
                            int[] iArr2 = this.f1651f;
                            iArr2[i4] = iArr2[i2];
                        }
                        if (z) {
                            solverVariable.b(arrayRow);
                        }
                        if (this.f1655j) {
                            this.f1654i = i2;
                        }
                        solverVariable.f1703l--;
                        this.f1646a--;
                        return;
                    }
                    return;
                }
                if (i6 < i7) {
                    i4 = i2;
                }
                i2 = this.f1651f[i2];
            }
            int length = this.f1654i;
            int i8 = length + 1;
            if (this.f1655j) {
                int[] iArr3 = this.f1650e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i8;
            }
            int[] iArr4 = this.f1650e;
            if (length >= iArr4.length && this.f1646a < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.f1650e;
                    if (i9 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i9] == -1) {
                        length = i9;
                        break;
                    }
                    i9++;
                }
            }
            int[] iArr6 = this.f1650e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i10 = this.f1649d * 2;
                this.f1649d = i10;
                this.f1655j = false;
                this.f1654i = length - 1;
                this.f1652g = Arrays.copyOf(this.f1652g, i10);
                this.f1650e = Arrays.copyOf(this.f1650e, this.f1649d);
                this.f1651f = Arrays.copyOf(this.f1651f, this.f1649d);
            }
            this.f1650e[length] = solverVariable.f1693b;
            this.f1652g[length] = f2;
            if (i4 != -1) {
                int[] iArr7 = this.f1651f;
                iArr7[length] = iArr7[i4];
                iArr7[i4] = length;
            } else {
                this.f1651f[length] = this.f1653h;
                this.f1653h = length;
            }
            solverVariable.f1703l++;
            solverVariable.a(arrayRow);
            this.f1646a++;
            if (!this.f1655j) {
                this.f1654i++;
            }
            int i11 = this.f1654i;
            int[] iArr8 = this.f1650e;
            if (i11 >= iArr8.length) {
                this.f1655j = true;
                this.f1654i = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i2 = this.f1653h;
        for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
            SolverVariable solverVariable = this.f1648c.f1663c[this.f1650e[i2]];
            if (solverVariable != null) {
                solverVariable.b(this.f1647b);
            }
            i2 = this.f1651f[i2];
        }
        this.f1653h = -1;
        this.f1654i = -1;
        this.f1655j = false;
        this.f1646a = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void d() {
        int i2 = this.f1653h;
        for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
            float[] fArr = this.f1652g;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f1651f[i2];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float e(SolverVariable solverVariable, boolean z) {
        int i2 = this.f1653h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f1646a) {
            if (this.f1650e[i2] == solverVariable.f1693b) {
                if (i2 == this.f1653h) {
                    this.f1653h = this.f1651f[i2];
                } else {
                    int[] iArr = this.f1651f;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.b(this.f1647b);
                }
                solverVariable.f1703l--;
                this.f1646a--;
                this.f1650e[i2] = -1;
                if (this.f1655j) {
                    this.f1654i = i2;
                }
                return this.f1652g[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1651f[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final int f() {
        return this.f1646a;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float g(ArrayRow arrayRow, boolean z) {
        float fJ = j(arrayRow.f1656a);
        e(arrayRow.f1656a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f1659d;
        int iF = arrayRowVariables.f();
        for (int i2 = 0; i2 < iF; i2++) {
            SolverVariable solverVariableB = arrayRowVariables.b(i2);
            c(solverVariableB, arrayRowVariables.j(solverVariableB) * fJ, z);
        }
        return fJ;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void h(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i2 = this.f1653h;
        ArrayRow arrayRow = this.f1647b;
        if (i2 == -1) {
            this.f1653h = 0;
            this.f1652g[0] = f2;
            this.f1650e[0] = solverVariable.f1693b;
            this.f1651f[0] = -1;
            solverVariable.f1703l++;
            solverVariable.a(arrayRow);
            this.f1646a++;
            if (this.f1655j) {
                return;
            }
            int i3 = this.f1654i + 1;
            this.f1654i = i3;
            int[] iArr = this.f1650e;
            if (i3 >= iArr.length) {
                this.f1655j = true;
                this.f1654i = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f1646a; i5++) {
            int i6 = this.f1650e[i2];
            int i7 = solverVariable.f1693b;
            if (i6 == i7) {
                this.f1652g[i2] = f2;
                return;
            }
            if (i6 < i7) {
                i4 = i2;
            }
            i2 = this.f1651f[i2];
        }
        int length = this.f1654i;
        int i8 = length + 1;
        if (this.f1655j) {
            int[] iArr2 = this.f1650e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i8;
        }
        int[] iArr3 = this.f1650e;
        if (length >= iArr3.length && this.f1646a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f1650e;
                if (i9 >= iArr4.length) {
                    break;
                }
                if (iArr4[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr5 = this.f1650e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i10 = this.f1649d * 2;
            this.f1649d = i10;
            this.f1655j = false;
            this.f1654i = length - 1;
            this.f1652g = Arrays.copyOf(this.f1652g, i10);
            this.f1650e = Arrays.copyOf(this.f1650e, this.f1649d);
            this.f1651f = Arrays.copyOf(this.f1651f, this.f1649d);
        }
        this.f1650e[length] = solverVariable.f1693b;
        this.f1652g[length] = f2;
        if (i4 != -1) {
            int[] iArr6 = this.f1651f;
            iArr6[length] = iArr6[i4];
            iArr6[i4] = length;
        } else {
            this.f1651f[length] = this.f1653h;
            this.f1653h = length;
        }
        solverVariable.f1703l++;
        solverVariable.a(arrayRow);
        int i11 = this.f1646a + 1;
        this.f1646a = i11;
        if (!this.f1655j) {
            this.f1654i++;
        }
        int[] iArr7 = this.f1650e;
        if (i11 >= iArr7.length) {
            this.f1655j = true;
        }
        if (this.f1654i >= iArr7.length) {
            this.f1655j = true;
            this.f1654i = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float i(int i2) {
        int i3 = this.f1653h;
        for (int i4 = 0; i3 != -1 && i4 < this.f1646a; i4++) {
            if (i4 == i2) {
                return this.f1652g[i3];
            }
            i3 = this.f1651f[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float j(SolverVariable solverVariable) {
        int i2 = this.f1653h;
        for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
            if (this.f1650e[i2] == solverVariable.f1693b) {
                return this.f1652g[i2];
            }
            i2 = this.f1651f[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void k(float f2) {
        int i2 = this.f1653h;
        for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
            float[] fArr = this.f1652g;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1651f[i2];
        }
    }

    public final String toString() {
        int i2 = this.f1653h;
        String string = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f1646a; i3++) {
            StringBuilder sbW = b.w(b.k(string, " -> "));
            sbW.append(this.f1652g[i2]);
            sbW.append(" : ");
            StringBuilder sbW2 = b.w(sbW.toString());
            sbW2.append(this.f1648c.f1663c[this.f1650e[i2]]);
            string = sbW2.toString();
            i2 = this.f1651f[i2];
        }
        return string;
    }
}
