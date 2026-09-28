package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzicw {

    /* renamed from: a, reason: collision with root package name */
    public static final zzidh f34743a;

    static {
        int i2 = zzhyy.f34536a;
        f34743a = new zzidh();
    }

    public static int a(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhzw.b(i2 << 3) + 4) * size;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhzw.b(i2 << 3) + 8) * size;
    }

    public static int c(int i2, Object obj, zzicu zzicuVar) {
        int i3 = i2 << 3;
        if (obj instanceof zzibm) {
            int iB = zzhzw.b(i3);
            int iA = ((zzibm) obj).a();
            return b.a(iA, iA, iB);
        }
        int iB2 = zzhzw.b(i3);
        int i4 = ((zzhyu) obj).i(zzicuVar);
        return b.a(i4, i4, iB2);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void e(Object obj, Object obj2) {
        zziar zziarVar = (zziar) obj;
        zzidg zzidgVar = zziarVar.zzt;
        zzidg zzidgVar2 = ((zziar) obj2).zzt;
        zzidg zzidgVar3 = zzidg.f34760f;
        if (!zzidgVar3.equals(zzidgVar2)) {
            if (zzidgVar3.equals(zzidgVar)) {
                int i2 = zzidgVar.f34761a + zzidgVar2.f34761a;
                int[] iArrCopyOf = Arrays.copyOf(zzidgVar.f34762b, i2);
                System.arraycopy(zzidgVar2.f34762b, 0, iArrCopyOf, zzidgVar.f34761a, zzidgVar2.f34761a);
                Object[] objArrCopyOf = Arrays.copyOf(zzidgVar.f34763c, i2);
                System.arraycopy(zzidgVar2.f34763c, 0, objArrCopyOf, zzidgVar.f34761a, zzidgVar2.f34761a);
                zzidgVar = new zzidg(i2, iArrCopyOf, objArrCopyOf, true);
            } else {
                zzidgVar.getClass();
                if (!zzidgVar2.equals(zzidgVar3)) {
                    if (!zzidgVar.f34765e) {
                        throw new UnsupportedOperationException();
                    }
                    int i3 = zzidgVar.f34761a + zzidgVar2.f34761a;
                    zzidgVar.e(i3);
                    System.arraycopy(zzidgVar2.f34762b, 0, zzidgVar.f34762b, zzidgVar.f34761a, zzidgVar2.f34761a);
                    System.arraycopy(zzidgVar2.f34763c, 0, zzidgVar.f34763c, zzidgVar.f34761a, zzidgVar2.f34761a);
                    zzidgVar.f34761a = i3;
                }
            }
        }
        zziarVar.zzt = zzidgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object f(Object obj, int i2, zzibd zzibdVar, zziax zziaxVar, Object obj2, zzidh zzidhVar) {
        if (zziaxVar == null) {
            return obj2;
        }
        if (zzibdVar == null) {
            Iterator<E> it = zzibdVar.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zziaxVar.zza(iIntValue)) {
                    if (obj2 == null) {
                        obj2 = zzidhVar.i(obj);
                    }
                    zzidhVar.a(obj2, i2, iIntValue);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = zzibdVar.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) zzibdVar.get(i4);
            int iIntValue2 = num.intValue();
            if (zziaxVar.zza(iIntValue2)) {
                if (i4 != i3) {
                    zzibdVar.set(i3, num);
                }
                i3++;
            } else {
                if (obj2 == null) {
                    obj2 = zzidhVar.i(obj);
                }
                zzidhVar.a(obj2, i2, iIntValue2);
            }
        }
        if (i3 != size) {
            zzibdVar.subList(i3, size).clear();
        }
        return obj2;
    }

    public static void g(int i2, List list, zzhzx zzhzxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z = list instanceof zzibn;
        int i3 = 0;
        zzhzw zzhzwVar = zzhzxVar.f34606a;
        if (!z) {
            while (i3 < list.size()) {
                zzhzwVar.o(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzibn zzibnVar = (zzibn) list;
        while (i3 < list.size()) {
            Object objZzc = zzibnVar.zzc();
            if (objZzc instanceof String) {
                zzhzwVar.o(i2, (String) objZzc);
            } else {
                zzhzwVar.p(i2, (zzhzl) objZzc);
            }
            i3++;
        }
    }

    public static void h(int i2, List list, zzhzx zzhzxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzhzxVar.f34606a.p(i2, (zzhzl) list.get(i3));
        }
    }

    public static void i(int i2, List list, zzhzx zzhzxVar, zzicu zzicuVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzhzxVar.p(i2, list.get(i3), zzicuVar);
        }
    }

    public static int j(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzibq)) {
            int iC = 0;
            while (i2 < size) {
                iC += zzhzw.c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iC;
        }
        zzibq zzibqVar = (zzibq) list;
        int iC2 = 0;
        while (i2 < size) {
            iC2 += zzhzw.c(zzibqVar.l(i2));
            i2++;
        }
        return iC2;
    }

    public static int k(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzibq)) {
            int iC = 0;
            while (i2 < size) {
                iC += zzhzw.c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iC;
        }
        zzibq zzibqVar = (zzibq) list;
        int iC2 = 0;
        while (i2 < size) {
            iC2 += zzhzw.c(zzibqVar.l(i2));
            i2++;
        }
        return iC2;
    }

    public static int l(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzibq)) {
            int iC = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iC += zzhzw.c((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iC;
        }
        zzibq zzibqVar = (zzibq) list;
        int iC2 = 0;
        while (i2 < size) {
            long jL = zzibqVar.l(i2);
            iC2 += zzhzw.c((jL >> 63) ^ (jL + jL));
            i2++;
        }
        return iC2;
    }

    public static int m(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzias)) {
            int iC = 0;
            while (i2 < size) {
                iC += zzhzw.c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iC;
        }
        zzias zziasVar = (zzias) list;
        int iC2 = 0;
        while (i2 < size) {
            iC2 += zzhzw.c(zziasVar.d(i2));
            i2++;
        }
        return iC2;
    }

    public static int n(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzias)) {
            int iC = 0;
            while (i2 < size) {
                iC += zzhzw.c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iC;
        }
        zzias zziasVar = (zzias) list;
        int iC2 = 0;
        while (i2 < size) {
            iC2 += zzhzw.c(zziasVar.d(i2));
            i2++;
        }
        return iC2;
    }

    public static int o(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzias)) {
            int iB = 0;
            while (i2 < size) {
                iB += zzhzw.b(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iB;
        }
        zzias zziasVar = (zzias) list;
        int iB2 = 0;
        while (i2 < size) {
            iB2 += zzhzw.b(zziasVar.d(i2));
            i2++;
        }
        return iB2;
    }

    public static int p(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzias)) {
            int iB = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iB += zzhzw.b((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iB;
        }
        zzias zziasVar = (zzias) list;
        int iB2 = 0;
        while (i2 < size) {
            int iD = zziasVar.d(i2);
            iB2 += zzhzw.b((iD >> 31) ^ (iD + iD));
            i2++;
        }
        return iB2;
    }
}
