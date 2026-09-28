package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.a;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zzfa {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f36181a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzfp f36182b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzfr f36183c;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzfp zzfpVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f36181a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzfpVar = (zzfp) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        f36182b = zzfpVar;
        f36183c = new zzfr();
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = zzcv.s(i2 << 3) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iF = ((zzcn) list.get(i3)).f();
            iS = a.z(iF, iF, iS);
        }
        return iS;
    }

    public static int c(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzdi)) {
            int iQ = 0;
            while (i2 < size) {
                iQ += zzcv.q(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iQ;
        }
        zzdi zzdiVar = (zzdi) list;
        int iQ2 = 0;
        while (i2 < size) {
            zzdiVar.d(i2);
            iQ2 += zzcv.q(zzdiVar.f36123b[i2]);
            i2++;
        }
        return iQ2;
    }

    public static int d(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzcv.s(i2 << 3) + 4) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzcv.s(i2 << 3) + 8) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzdi)) {
            int iQ = 0;
            while (i2 < size) {
                iQ += zzcv.q(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iQ;
        }
        zzdi zzdiVar = (zzdi) list;
        int iQ2 = 0;
        while (i2 < size) {
            zzdiVar.d(i2);
            iQ2 += zzcv.q(zzdiVar.f36123b[i2]);
            i2++;
        }
        return iQ2;
    }

    public static int i(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzed)) {
            int iT = 0;
            while (i2 < size) {
                iT += zzcv.t(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iT;
        }
        zzed zzedVar = (zzed) list;
        int iT2 = 0;
        while (i2 < size) {
            zzedVar.d(i2);
            iT2 += zzcv.t(zzedVar.f36146b[i2]);
            i2++;
        }
        return iT2;
    }

    public static int j(int i2, Object obj, zzey zzeyVar) {
        int iS;
        int iS2;
        if (obj instanceof zzdu) {
            zzdu zzduVar = (zzdu) obj;
            int i3 = i2 << 3;
            Logger logger = zzcv.f36101b;
            int length = zzduVar.f36140b != null ? ((zzck) zzduVar.f36140b).f36094c.length : zzduVar.f36139a != null ? zzduVar.f36139a.zzn() : 0;
            iS = zzcv.s(length) + length;
            iS2 = zzcv.s(i3);
        } else {
            Logger logger2 = zzcv.f36101b;
            int iA = ((zzca) ((zzeo) obj)).a(zzeyVar);
            iS = zzcv.s(iA) + iA;
            iS2 = zzcv.s(i2 << 3);
        }
        return iS2 + iS;
    }

    public static int k(int i2, List list, zzey zzeyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = zzcv.s(i2 << 3) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdu) {
                zzdu zzduVar = (zzdu) obj;
                int length = zzduVar.f36140b != null ? ((zzck) zzduVar.f36140b).f36094c.length : zzduVar.f36139a != null ? zzduVar.f36139a.zzn() : 0;
                iS = a.z(length, length, iS);
            } else {
                int iA = ((zzca) ((zzeo) obj)).a(zzeyVar);
                iS = a.z(iA, iA, iS);
            }
        }
        return iS;
    }

    public static int l(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzdi)) {
            int iS = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iS += zzcv.s((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return iS;
        }
        zzdi zzdiVar = (zzdi) list;
        int iS2 = 0;
        while (i2 < size) {
            zzdiVar.d(i2);
            int i3 = zzdiVar.f36123b[i2];
            iS2 += zzcv.s((i3 >> 31) ^ (i3 + i3));
            i2++;
        }
        return iS2;
    }

    public static int m(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzed)) {
            int iT = 0;
            while (i2 < size) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iT += zzcv.t((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return iT;
        }
        zzed zzedVar = (zzed) list;
        int iT2 = 0;
        while (i2 < size) {
            zzedVar.d(i2);
            long j2 = zzedVar.f36146b[i2];
            iT2 += zzcv.t((j2 >> 63) ^ (j2 + j2));
            i2++;
        }
        return iT2;
    }

    public static int n(int i2, List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z = list instanceof zzdw;
        int iS = zzcv.s(i2 << 3) * size;
        if (!z) {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzcn) {
                    int iF = ((zzcn) obj).f();
                    iS = a.z(iF, iF, iS);
                } else {
                    iS = zzcv.r((String) obj) + iS;
                }
                i3++;
            }
            return iS;
        }
        zzdw zzdwVar = (zzdw) list;
        while (i3 < size) {
            Object objC = zzdwVar.c(i3);
            if (objC instanceof zzcn) {
                int iF2 = ((zzcn) objC).f();
                iS = a.z(iF2, iF2, iS);
            } else {
                iS = zzcv.r((String) objC) + iS;
            }
            i3++;
        }
        return iS;
    }

    public static int o(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzdi)) {
            int iS = 0;
            while (i2 < size) {
                iS += zzcv.s(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iS;
        }
        zzdi zzdiVar = (zzdi) list;
        int iS2 = 0;
        while (i2 < size) {
            zzdiVar.d(i2);
            iS2 += zzcv.s(zzdiVar.f36123b[i2]);
            i2++;
        }
        return iS2;
    }

    public static int p(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzed)) {
            int iT = 0;
            while (i2 < size) {
                iT += zzcv.t(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iT;
        }
        zzed zzedVar = (zzed) list;
        int iT2 = 0;
        while (i2 < size) {
            zzedVar.d(i2);
            iT2 += zzcv.t(zzedVar.f36146b[i2]);
            i2++;
        }
        return iT2;
    }
}
