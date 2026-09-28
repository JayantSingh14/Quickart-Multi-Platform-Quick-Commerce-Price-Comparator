package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zziag {

    /* renamed from: d, reason: collision with root package name */
    public static final zziag f34624d = new zziag(0);

    /* renamed from: a, reason: collision with root package name */
    public final zzicx f34625a = new zzicx();

    /* renamed from: b, reason: collision with root package name */
    public boolean f34626b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f34627c;

    public zziag() {
    }

    public static void e(zzhzw zzhzwVar, zzids zzidsVar, int i2, Object obj) {
        if (zzidsVar == zzids.f34777d) {
            zzhzwVar.g(i2, 3);
            ((zzicc) obj).c(zzhzwVar);
            zzhzwVar.g(i2, 4);
            return;
        }
        zzhzwVar.g(i2, zzidsVar.f34781b);
        zzidt zzidtVar = zzidt.f34782a;
        switch (zzidsVar.ordinal()) {
            case 0:
                zzhzwVar.A(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzhzwVar.y(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzhzwVar.z(((Long) obj).longValue());
                break;
            case 3:
                zzhzwVar.z(((Long) obj).longValue());
                break;
            case 4:
                zzhzwVar.w(((Integer) obj).intValue());
                break;
            case 5:
                zzhzwVar.A(((Long) obj).longValue());
                break;
            case 6:
                zzhzwVar.y(((Integer) obj).intValue());
                break;
            case 7:
                zzhzwVar.v(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzhzl)) {
                    zzhzwVar.B((String) obj);
                    break;
                } else {
                    zzhzwVar.q((zzhzl) obj);
                    break;
                }
            case 9:
                ((zzicc) obj).c(zzhzwVar);
                break;
            case 10:
                zzhzwVar.u((zzicc) obj);
                break;
            case 11:
                if (!(obj instanceof zzhzl)) {
                    byte[] bArr = (byte[]) obj;
                    zzhzwVar.r(bArr.length, bArr);
                    break;
                } else {
                    zzhzwVar.q((zzhzl) obj);
                    break;
                }
            case 12:
                zzhzwVar.x(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zziav)) {
                    zzhzwVar.w(((Integer) obj).intValue());
                    break;
                } else {
                    zzhzwVar.w(((zziav) obj).zza());
                    break;
                }
            case 14:
                zzhzwVar.y(((Integer) obj).intValue());
                break;
            case 15:
                zzhzwVar.A(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzhzwVar.x((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzhzwVar.z((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static int f(zzids zzidsVar, int i2, Object obj) {
        int i3;
        int iB;
        int iB2 = zzhzw.b(i2 << 3);
        if (zzidsVar == zzids.f34777d) {
            iB2 += iB2;
        }
        zzids zzidsVar2 = zzids.f34776c;
        zzidt zzidtVar = zzidt.f34782a;
        int iC = 4;
        switch (zzidsVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = zzhzw.f34603b;
                iC = 8;
                return iB2 + iC;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = zzhzw.f34603b;
                return iB2 + iC;
            case 2:
                iC = zzhzw.c(((Long) obj).longValue());
                return iB2 + iC;
            case 3:
                iC = zzhzw.c(((Long) obj).longValue());
                return iB2 + iC;
            case 4:
                iC = zzhzw.c(((Integer) obj).intValue());
                return iB2 + iC;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = zzhzw.f34603b;
                iC = 8;
                return iB2 + iC;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = zzhzw.f34603b;
                return iB2 + iC;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = zzhzw.f34603b;
                iC = 1;
                return iB2 + iC;
            case 8:
                if (!(obj instanceof zzhzl)) {
                    iC = zzhzw.d((String) obj);
                    return iB2 + iC;
                }
                Logger logger6 = zzhzw.f34603b;
                i3 = ((zzhzl) obj).i();
                iB = zzhzw.b(i3);
                iC = iB + i3;
                return iB2 + iC;
            case 9:
                iC = ((zzicc) obj).d();
                return iB2 + iC;
            case 10:
                if (obj instanceof zzibl) {
                    i3 = ((zzibl) obj).a();
                    iB = zzhzw.b(i3);
                } else {
                    Logger logger7 = zzhzw.f34603b;
                    i3 = ((zzicc) obj).d();
                    iB = zzhzw.b(i3);
                }
                iC = iB + i3;
                return iB2 + iC;
            case 11:
                if (obj instanceof zzhzl) {
                    Logger logger8 = zzhzw.f34603b;
                    i3 = ((zzhzl) obj).i();
                    iB = zzhzw.b(i3);
                } else {
                    Logger logger9 = zzhzw.f34603b;
                    i3 = ((byte[]) obj).length;
                    iB = zzhzw.b(i3);
                }
                iC = iB + i3;
                return iB2 + iC;
            case 12:
                iC = zzhzw.b(((Integer) obj).intValue());
                return iB2 + iC;
            case 13:
                iC = obj instanceof zziav ? zzhzw.c(((zziav) obj).zza()) : zzhzw.c(((Integer) obj).intValue());
                return iB2 + iC;
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = zzhzw.f34603b;
                return iB2 + iC;
            case 15:
                ((Long) obj).getClass();
                Logger logger11 = zzhzw.f34603b;
                iC = 8;
                return iB2 + iC;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iC = zzhzw.b((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iB2 + iC;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iC = zzhzw.c((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iB2 + iC;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int g(zziaf zziafVar, Object obj) {
        zziafVar.getClass();
        return f(null, 0, obj);
    }

    public static boolean h(Map.Entry entry) {
        ((zziaf) entry.getKey()).zzc();
        throw null;
    }

    public static final int i(Map.Entry entry) {
        zziaf zziafVar = (zziaf) entry.getKey();
        entry.getValue();
        zziafVar.zzc();
        throw null;
    }

    public final void a() {
        if (this.f34626b) {
            return;
        }
        zzicx zzicxVar = this.f34625a;
        int i2 = zzicxVar.f34755b;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = ((zzicy) zzicxVar.b(i3)).f34745b;
            if (obj instanceof zziar) {
                zziar zziarVar = (zziar) obj;
                zziarVar.getClass();
                zzicm.f34722c.a(zziarVar.getClass()).b(zziarVar);
                zziarVar.n();
            }
        }
        Iterator it = zzicxVar.c().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof zziar) {
                zziar zziarVar2 = (zziar) value;
                zziarVar2.getClass();
                zzicm.f34722c.a(zziarVar2.getClass()).b(zziarVar2);
                zziarVar2.n();
            }
        }
        zzicxVar.a();
        this.f34626b = true;
    }

    public final Iterator b() {
        zzicx zzicxVar = this.f34625a;
        return zzicxVar.isEmpty() ? Collections.emptyIterator() : this.f34627c ? new zzibk(((zzida) zzicxVar.entrySet()).iterator()) : ((zzida) zzicxVar.entrySet()).iterator();
    }

    public final void c(zziaf zziafVar, Object obj) {
        zziafVar.getClass();
        zziafVar.getClass();
        Charset charset = zzibe.f34660a;
        obj.getClass();
        zzids zzidsVar = zzids.f34776c;
        zzidt zzidtVar = zzidt.f34782a;
        throw null;
    }

    public final Object clone() {
        zziag zziagVar = new zziag();
        zzicx zzicxVar = this.f34625a;
        if (zzicxVar.f34755b > 0) {
            Map.Entry entryB = zzicxVar.b(0);
            zziagVar.c((zziaf) ((zzicy) entryB).f34744a, ((zzicy) entryB).f34745b);
            throw null;
        }
        Iterator it = zzicxVar.c().iterator();
        if (!it.hasNext()) {
            zziagVar.f34627c = this.f34627c;
            return zziagVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        zziagVar.c((zziaf) entry.getKey(), entry.getValue());
        throw null;
    }

    public final boolean d() {
        zzicx zzicxVar = this.f34625a;
        if (zzicxVar.f34755b > 0) {
            h(zzicxVar.b(0));
            throw null;
        }
        Iterator it = zzicxVar.c().iterator();
        if (!it.hasNext()) {
            return true;
        }
        h((Map.Entry) it.next());
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziag) {
            return this.f34625a.equals(((zziag) obj).f34625a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f34625a.hashCode();
    }

    public zziag(int i2) {
        a();
        a();
    }
}
