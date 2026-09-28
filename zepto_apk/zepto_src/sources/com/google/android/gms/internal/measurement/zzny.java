package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class zzny {

    /* renamed from: a, reason: collision with root package name */
    public static final zzoj f37172a;

    static {
        zznt zzntVar = zznt.f37161c;
        f37172a = new zzoj();
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Object obj, Object obj2) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        zzoi zzoiVar2 = ((zzme) obj2).zzc;
        zzoi zzoiVar3 = zzoi.f37187f;
        if (!zzoiVar3.equals(zzoiVar2)) {
            if (zzoiVar3.equals(zzoiVar)) {
                int i2 = zzoiVar.f37188a + zzoiVar2.f37188a;
                int[] iArrCopyOf = Arrays.copyOf(zzoiVar.f37189b, i2);
                System.arraycopy(zzoiVar2.f37189b, 0, iArrCopyOf, zzoiVar.f37188a, zzoiVar2.f37188a);
                Object[] objArrCopyOf = Arrays.copyOf(zzoiVar.f37190c, i2);
                System.arraycopy(zzoiVar2.f37190c, 0, objArrCopyOf, zzoiVar.f37188a, zzoiVar2.f37188a);
                zzoiVar = new zzoi(i2, iArrCopyOf, objArrCopyOf, true);
            } else {
                zzoiVar.getClass();
                if (!zzoiVar2.equals(zzoiVar3)) {
                    if (!zzoiVar.f37192e) {
                        throw new UnsupportedOperationException();
                    }
                    int i3 = zzoiVar.f37188a + zzoiVar2.f37188a;
                    zzoiVar.e(i3);
                    System.arraycopy(zzoiVar2.f37189b, 0, zzoiVar.f37189b, zzoiVar.f37188a, zzoiVar2.f37188a);
                    System.arraycopy(zzoiVar2.f37190c, 0, zzoiVar.f37190c, zzoiVar.f37188a, zzoiVar2.f37188a);
                    zzoiVar.f37188a = i3;
                }
            }
        }
        zzmeVar.zzc = zzoiVar;
    }

    public static int c(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iA = 0;
            while (i2 < size) {
                iA += zzll.a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iA2 = 0;
        while (i2 < size) {
            iA2 += zzll.a(zzmzVar.l(i2));
            i2++;
        }
        return iA2;
    }

    public static int d(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iA = 0;
            while (i2 < size) {
                iA += zzll.a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iA2 = 0;
        while (i2 < size) {
            iA2 += zzll.a(zzmzVar.l(i2));
            i2++;
        }
        return iA2;
    }

    public static int e(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int iA = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iA += zzll.a((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iA;
        }
        zzmz zzmzVar = (zzmz) list;
        int iA2 = 0;
        while (i2 < size) {
            long jL = zzmzVar.l(i2);
            iA2 += zzll.a((jL >> 63) ^ (jL + jL));
            i2++;
        }
        return iA2;
    }

    public static int f(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iA = 0;
            while (i2 < size) {
                iA += zzll.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iA;
        }
        zzmf zzmfVar = (zzmf) list;
        int iA2 = 0;
        while (i2 < size) {
            iA2 += zzll.a(zzmfVar.d(i2));
            i2++;
        }
        return iA2;
    }

    public static int g(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iA = 0;
            while (i2 < size) {
                iA += zzll.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iA;
        }
        zzmf zzmfVar = (zzmf) list;
        int iA2 = 0;
        while (i2 < size) {
            iA2 += zzll.a(zzmfVar.d(i2));
            i2++;
        }
        return iA2;
    }

    public static int h(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iW = 0;
            while (i2 < size) {
                iW += zzll.w(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iW;
        }
        zzmf zzmfVar = (zzmf) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += zzll.w(zzmfVar.d(i2));
            i2++;
        }
        return iW2;
    }

    public static int i(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmf)) {
            int iW = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iW += zzll.w((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iW;
        }
        zzmf zzmfVar = (zzmf) list;
        int iW2 = 0;
        while (i2 < size) {
            int iD = zzmfVar.d(i2);
            iW2 += zzll.w((iD >> 31) ^ (iD + iD));
            i2++;
        }
        return iW2;
    }

    public static int j(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzll.w(i2 << 3) + 4) * size;
    }

    public static int k(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzll.w(i2 << 3) + 8) * size;
    }

    public static int l(int i2, Object obj, zznw zznwVar) {
        int i3 = i2 << 3;
        if (obj instanceof zzmv) {
            int iW = zzll.w(i3);
            int iA = ((zzmv) obj).a();
            return e.B(iA, iA, iW);
        }
        int iW2 = zzll.w(i3);
        int iG = ((zzkr) ((zznl) obj)).g(zznwVar);
        return e.B(iG, iG, iW2);
    }
}
