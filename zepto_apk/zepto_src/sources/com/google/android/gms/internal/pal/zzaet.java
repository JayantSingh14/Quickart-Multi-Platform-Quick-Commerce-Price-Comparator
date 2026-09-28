package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzaet {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f37467a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzafi f37468b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzafi f37469c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzafk f37470d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f37467a = cls;
        f37468b = c(false);
        f37469c = c(true);
        f37470d = new zzafk();
    }

    public static Object a(int i2, List list, zzadd zzaddVar, Object obj, zzafi zzafiVar) {
        if (zzaddVar == null) {
            return obj;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzaddVar.zza(iIntValue)) {
                    if (obj == null) {
                        obj = zzafiVar.f();
                    }
                    zzafiVar.l(obj, i2, iIntValue);
                    it.remove();
                }
            }
            return obj;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (zzaddVar.zza(iIntValue2)) {
                if (i4 != i3) {
                    list.set(i3, num);
                }
                i3++;
            } else {
                if (obj == null) {
                    obj = zzafiVar.f();
                }
                zzafiVar.l(obj, i2, iIntValue2);
            }
        }
        if (i3 == size) {
            return obj;
        }
        list.subList(i3, size).clear();
        return obj;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static zzafi c(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (zzafi) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static int d(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = zzach.u(i2) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iF = ((zzaby) list.get(i3)).f();
            iU = a.d(iF, iF, iU);
        }
        return iU;
    }

    public static int e(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzada)) {
            int iS = 0;
            while (i2 < size) {
                iS += zzach.s(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iS;
        }
        zzada zzadaVar = (zzada) list;
        int iS2 = 0;
        while (i2 < size) {
            zzadaVar.zzi(i2);
            iS2 += zzach.s(zzadaVar.f37408b[i2]);
            i2++;
        }
        return iS2;
    }

    public static int f(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzach.a(i2 << 3) + 4) * size;
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzach.a(i2 << 3) + 8) * size;
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzada)) {
            int iS = 0;
            while (i2 < size) {
                iS += zzach.s(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iS;
        }
        zzada zzadaVar = (zzada) list;
        int iS2 = 0;
        while (i2 < size) {
            zzadaVar.zzi(i2);
            iS2 += zzach.s(zzadaVar.f37408b[i2]);
            i2++;
        }
        return iS2;
    }

    public static int k(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadu)) {
            int iB = 0;
            while (i2 < size) {
                iB += zzach.b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iB;
        }
        zzadu zzaduVar = (zzadu) list;
        int iB2 = 0;
        while (i2 < size) {
            zzaduVar.zzh(i2);
            iB2 += zzach.b(zzaduVar.f37430b[i2]);
            i2++;
        }
        return iB2;
    }

    public static int l(int i2, Object obj, zzaer zzaerVar) {
        if (obj instanceof zzadl) {
            zzadl zzadlVar = (zzadl) obj;
            int iA = zzach.a(i2 << 3);
            int length = zzadlVar.f37425b != null ? ((zzabv) zzadlVar.f37425b).f37362c.length : zzadlVar.f37424a != null ? zzadlVar.f37424a.i() : 0;
            return a.d(length, length, iA);
        }
        int iA2 = zzach.a(i2 << 3);
        zzabi zzabiVar = (zzabi) ((zzaef) obj);
        int iB = zzabiVar.b();
        if (iB == -1) {
            iB = zzaerVar.zza(zzabiVar);
            zzabiVar.c(iB);
        }
        return a.d(iB, iB, iA2);
    }

    public static int m(int i2, List list, zzaer zzaerVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = zzach.u(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzadl) {
                zzadl zzadlVar = (zzadl) obj;
                int length = zzadlVar.f37425b != null ? ((zzabv) zzadlVar.f37425b).f37362c.length : zzadlVar.f37424a != null ? zzadlVar.f37424a.i() : 0;
                iU = a.d(length, length, iU);
            } else {
                zzabi zzabiVar = (zzabi) ((zzaef) obj);
                int iB = zzabiVar.b();
                if (iB == -1) {
                    iB = zzaerVar.zza(zzabiVar);
                    zzabiVar.c(iB);
                }
                iU = a.d(iB, iB, iU);
            }
        }
        return iU;
    }

    public static int n(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzada)) {
            int iA = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iA += zzach.a((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iA;
        }
        zzada zzadaVar = (zzada) list;
        int iA2 = 0;
        while (i2 < size) {
            zzadaVar.zzi(i2);
            int i3 = zzadaVar.f37408b[i2];
            iA2 += zzach.a((i3 >> 31) ^ (i3 + i3));
            i2++;
        }
        return iA2;
    }

    public static int o(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadu)) {
            int iB = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iB += zzach.b((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iB;
        }
        zzadu zzaduVar = (zzadu) list;
        int iB2 = 0;
        while (i2 < size) {
            zzaduVar.zzh(i2);
            long j2 = zzaduVar.f37430b[i2];
            iB2 += zzach.b((j2 >> 63) ^ (j2 + j2));
            i2++;
        }
        return iB2;
    }

    public static int p(int i2, List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iU = zzach.u(i2) * size;
        if (!(list instanceof zzadn)) {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzaby) {
                    int iF = ((zzaby) obj).f();
                    iU = a.d(iF, iF, iU);
                } else {
                    iU = zzach.t((String) obj) + iU;
                }
                i3++;
            }
            return iU;
        }
        zzadn zzadnVar = (zzadn) list;
        while (i3 < size) {
            Object objZzf = zzadnVar.zzf(i3);
            if (objZzf instanceof zzaby) {
                int iF2 = ((zzaby) objZzf).f();
                iU = a.d(iF2, iF2, iU);
            } else {
                iU = zzach.t((String) objZzf) + iU;
            }
            i3++;
        }
        return iU;
    }

    public static int q(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzada)) {
            int iA = 0;
            while (i2 < size) {
                iA += zzach.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iA;
        }
        zzada zzadaVar = (zzada) list;
        int iA2 = 0;
        while (i2 < size) {
            zzadaVar.zzi(i2);
            iA2 += zzach.a(zzadaVar.f37408b[i2]);
            i2++;
        }
        return iA2;
    }

    public static int r(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadu)) {
            int iB = 0;
            while (i2 < size) {
                iB += zzach.b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iB;
        }
        zzadu zzaduVar = (zzadu) list;
        int iB2 = 0;
        while (i2 < size) {
            zzaduVar.zzh(i2);
            iB2 += zzach.b(zzaduVar.f37430b[i2]);
            i2++;
        }
        return iB2;
    }
}
