package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
final class zzhhw extends zzhxq {
    public static final zzhxj b(zzhyo zzhyoVar) throws IOException {
        String strR;
        int iE = zzhyoVar.e();
        zzhxj zzhxjVarD = d(zzhyoVar, iE);
        if (zzhxjVarD == null) {
            return c(zzhyoVar, iE);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            int iA = zzhyoVar.f34516g;
            if (iA == 0) {
                iA = zzhyoVar.a();
            }
            String str = null;
            if (iA == 2 || iA == 4 || iA == 17) {
                if (zzhxjVarD instanceof zzhxi) {
                    int iA2 = zzhyoVar.f34516g;
                    if (iA2 == 0) {
                        iA2 = zzhyoVar.a();
                    }
                    if (iA2 != 4) {
                        throw zzhyoVar.T("END_ARRAY");
                    }
                    int i2 = zzhyoVar.f34520k;
                    zzhyoVar.f34520k = i2 - 1;
                    int[] iArr = zzhyoVar.f34522m;
                    int i3 = i2 - 2;
                    iArr[i3] = iArr[i3] + 1;
                    zzhyoVar.f34516g = 0;
                } else {
                    int iA3 = zzhyoVar.f34516g;
                    if (iA3 == 0) {
                        iA3 = zzhyoVar.a();
                    }
                    if (iA3 != 2) {
                        throw zzhyoVar.T("END_OBJECT");
                    }
                    int i4 = zzhyoVar.f34520k;
                    int i5 = i4 - 1;
                    zzhyoVar.f34520k = i5;
                    zzhyoVar.f34521l[i5] = null;
                    int[] iArr2 = zzhyoVar.f34522m;
                    int i6 = i4 - 2;
                    iArr2[i6] = iArr2[i6] + 1;
                    zzhyoVar.f34516g = 0;
                }
                if (arrayDeque.isEmpty()) {
                    return zzhxjVarD;
                }
                zzhxjVarD = (zzhxj) arrayDeque.removeLast();
            } else {
                if (zzhxjVarD instanceof zzhxl) {
                    int iA4 = zzhyoVar.f34516g;
                    if (iA4 == 0) {
                        iA4 = zzhyoVar.a();
                    }
                    if (iA4 == 14) {
                        strR = zzhyoVar.s();
                    } else if (iA4 == 12) {
                        strR = zzhyoVar.r('\'');
                    } else {
                        if (iA4 != 13) {
                            throw zzhyoVar.T("a name");
                        }
                        strR = zzhyoVar.r('\"');
                    }
                    str = strR;
                    zzhyoVar.f34516g = 0;
                    zzhyoVar.f34521l[zzhyoVar.f34520k - 1] = str;
                    if (!zzhhy.a(str)) {
                        throw new IOException("illegal characters in string");
                    }
                }
                int iE2 = zzhyoVar.e();
                zzhxj zzhxjVarD2 = d(zzhyoVar, iE2);
                zzhxj zzhxjVarC = zzhxjVarD2 == null ? c(zzhyoVar, iE2) : zzhxjVarD2;
                if (zzhxjVarD instanceof zzhxi) {
                    ((zzhxi) zzhxjVarD).f34468a.add(zzhxjVarC);
                } else {
                    zzhxl zzhxlVar = (zzhxl) zzhxjVarD;
                    if (zzhxlVar.f34470a.containsKey(str)) {
                        throw new IOException("duplicate key: ".concat(String.valueOf(str)));
                    }
                    zzhxlVar.f34470a.put(str, zzhxjVarC);
                }
                if (zzhxjVarD2 != null) {
                    arrayDeque.addLast(zzhxjVarD);
                    if (arrayDeque.size() > 100) {
                        throw new IOException("too many recursions");
                    }
                    zzhxjVarD = zzhxjVarC;
                } else {
                    continue;
                }
            }
        }
    }

    public static final zzhxj c(zzhyo zzhyoVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 5) {
            String strB = zzhyoVar.b();
            if (zzhhy.a(strB)) {
                return new zzhxn(strB);
            }
            throw new IOException("illegal characters in string");
        }
        if (i3 == 6) {
            return new zzhxn(new zzhhx(zzhyoVar.b()));
        }
        boolean z = true;
        if (i3 != 7) {
            if (i3 != 8) {
                throw new IllegalStateException("Unexpected token: ".concat(zzhyp.a(i2)));
            }
            int iA = zzhyoVar.f34516g;
            if (iA == 0) {
                iA = zzhyoVar.a();
            }
            if (iA != 7) {
                throw zzhyoVar.T("null");
            }
            zzhyoVar.f34516g = 0;
            int[] iArr = zzhyoVar.f34522m;
            int i4 = zzhyoVar.f34520k - 1;
            iArr[i4] = iArr[i4] + 1;
            return zzhxk.f34469a;
        }
        int iA2 = zzhyoVar.f34516g;
        if (iA2 == 0) {
            iA2 = zzhyoVar.a();
        }
        if (iA2 == 5) {
            zzhyoVar.f34516g = 0;
            int[] iArr2 = zzhyoVar.f34522m;
            int i5 = zzhyoVar.f34520k - 1;
            iArr2[i5] = iArr2[i5] + 1;
        } else {
            if (iA2 != 6) {
                throw zzhyoVar.T("a boolean");
            }
            zzhyoVar.f34516g = 0;
            int[] iArr3 = zzhyoVar.f34522m;
            int i6 = zzhyoVar.f34520k - 1;
            iArr3[i6] = iArr3[i6] + 1;
            z = false;
        }
        return new zzhxn(Boolean.valueOf(z));
    }

    public static final zzhxj d(zzhyo zzhyoVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 0) {
            int iA = zzhyoVar.f34516g;
            if (iA == 0) {
                iA = zzhyoVar.a();
            }
            if (iA != 3) {
                throw zzhyoVar.T("BEGIN_ARRAY");
            }
            zzhyoVar.x(1);
            zzhyoVar.f34522m[zzhyoVar.f34520k - 1] = 0;
            zzhyoVar.f34516g = 0;
            return new zzhxi();
        }
        if (i3 != 2) {
            return null;
        }
        int iA2 = zzhyoVar.f34516g;
        if (iA2 == 0) {
            iA2 = zzhyoVar.a();
        }
        if (iA2 != 1) {
            throw zzhyoVar.T("BEGIN_OBJECT");
        }
        zzhyoVar.x(3);
        zzhyoVar.f34516g = 0;
        return new zzhxl();
    }
}
