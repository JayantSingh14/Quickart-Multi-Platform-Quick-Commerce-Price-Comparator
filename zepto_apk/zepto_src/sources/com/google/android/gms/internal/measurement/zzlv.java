package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class zzlv {

    /* renamed from: d, reason: collision with root package name */
    public static final zzlv f37092d = new zzlv(0);

    /* renamed from: a, reason: collision with root package name */
    public final zznz f37093a = new zznz();

    /* renamed from: b, reason: collision with root package name */
    public boolean f37094b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37095c;

    public zzlv() {
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static void d(zzll zzllVar, zzos zzosVar, int i2, Object obj) {
        if (zzosVar == zzos.f37203d) {
            zznl zznlVar = (zznl) obj;
            Charset charset = zzmo.f37112a;
            if (zznlVar instanceof zzks) {
                throw null;
            }
            zzllVar.d(i2, 3);
            zznlVar.d(zzllVar);
            zzllVar.d(i2, 4);
            return;
        }
        zzllVar.d(i2, zzosVar.b());
        zzot zzotVar = zzot.f37207a;
        switch (zzosVar.ordinal()) {
            case 0:
                zzllVar.t(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                zzllVar.r(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                zzllVar.s(((Long) obj).longValue());
                return;
            case 3:
                zzllVar.s(((Long) obj).longValue());
                return;
            case 4:
                zzllVar.p(((Integer) obj).intValue());
                return;
            case 5:
                zzllVar.t(((Long) obj).longValue());
                return;
            case 6:
                zzllVar.r(((Integer) obj).intValue());
                return;
            case 7:
                zzllVar.o(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case 8:
                if (obj instanceof zzlg) {
                    zzllVar.m((zzlg) obj);
                    return;
                } else {
                    zzllVar.u((String) obj);
                    return;
                }
            case 9:
                ((zznl) obj).d(zzllVar);
                return;
            case 10:
                zzllVar.n((zznl) obj);
                return;
            case 11:
                if (obj instanceof zzlg) {
                    zzllVar.m((zzlg) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                zzlj zzljVar = (zzlj) zzllVar;
                zzljVar.q(length);
                zzljVar.x(length, bArr);
                return;
            case 12:
                zzllVar.q(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof zzmi) {
                    zzllVar.p(((zzmi) obj).zza());
                    return;
                } else {
                    zzllVar.p(((Integer) obj).intValue());
                    return;
                }
            case 14:
                zzllVar.r(((Integer) obj).intValue());
                return;
            case 15:
                zzllVar.t(((Long) obj).longValue());
                return;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzllVar.q((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzllVar.s((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return;
            default:
                return;
        }
    }

    public static int e(zzos zzosVar, int i2, Object obj) {
        int iF;
        int iW;
        int iW2 = zzll.w(i2 << 3);
        if (zzosVar == zzos.f37203d) {
            Charset charset = zzmo.f37112a;
            if (((zznl) obj) instanceof zzks) {
                throw null;
            }
            iW2 += iW2;
        }
        zzos zzosVar2 = zzos.f37202c;
        zzot zzotVar = zzot.f37207a;
        int iA = 4;
        switch (zzosVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = zzll.f37079b;
                iA = 8;
                return iW2 + iA;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = zzll.f37079b;
                return iW2 + iA;
            case 2:
                iA = zzll.a(((Long) obj).longValue());
                return iW2 + iA;
            case 3:
                iA = zzll.a(((Long) obj).longValue());
                return iW2 + iA;
            case 4:
                iA = zzll.a(((Integer) obj).intValue());
                return iW2 + iA;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = zzll.f37079b;
                iA = 8;
                return iW2 + iA;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = zzll.f37079b;
                return iW2 + iA;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = zzll.f37079b;
                iA = 1;
                return iW2 + iA;
            case 8:
                if (!(obj instanceof zzlg)) {
                    iA = zzll.b((String) obj);
                    return iW2 + iA;
                }
                Logger logger6 = zzll.f37079b;
                iF = ((zzlg) obj).f();
                iW = zzll.w(iF);
                iA = iW + iF;
                return iW2 + iA;
            case 9:
                iA = ((zznl) obj).a();
                return iW2 + iA;
            case 10:
                if (!(obj instanceof zzmu)) {
                    iA = zzll.c((zznl) obj);
                    return iW2 + iA;
                }
                Logger logger7 = zzll.f37079b;
                iF = ((zzmu) obj).a();
                iW = zzll.w(iF);
                iA = iW + iF;
                return iW2 + iA;
            case 11:
                if (obj instanceof zzlg) {
                    Logger logger8 = zzll.f37079b;
                    iF = ((zzlg) obj).f();
                    iW = zzll.w(iF);
                } else {
                    Logger logger9 = zzll.f37079b;
                    iF = ((byte[]) obj).length;
                    iW = zzll.w(iF);
                }
                iA = iW + iF;
                return iW2 + iA;
            case 12:
                iA = zzll.w(((Integer) obj).intValue());
                return iW2 + iA;
            case 13:
                iA = obj instanceof zzmi ? zzll.a(((zzmi) obj).zza()) : zzll.a(((Integer) obj).intValue());
                return iW2 + iA;
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = zzll.f37079b;
                return iW2 + iA;
            case 15:
                ((Long) obj).getClass();
                Logger logger11 = zzll.f37079b;
                iA = 8;
                return iW2 + iA;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iA = zzll.w((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iW2 + iA;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iA = zzll.a((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iW2 + iA;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean f(Map.Entry entry) {
        ((zzlu) entry.getKey()).zzc();
        throw null;
    }

    public static final int g(Map.Entry entry) {
        zzlu zzluVar = (zzlu) entry.getKey();
        entry.getValue();
        zzluVar.zzc();
        throw null;
    }

    public final void a() {
        if (this.f37094b) {
            return;
        }
        zznz zznzVar = this.f37093a;
        int i2 = zznzVar.f37182b;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = ((zzoa) zznzVar.b(i3)).f37174b;
            if (obj instanceof zzme) {
                ((zzme) obj).k();
            }
        }
        Iterator it = zznzVar.c().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof zzme) {
                ((zzme) value).k();
            }
        }
        zznzVar.a();
        this.f37094b = true;
    }

    public final Iterator b() {
        zznz zznzVar = this.f37093a;
        return zznzVar.isEmpty() ? Collections.emptyIterator() : this.f37095c ? new zzmt(((zzoc) zznzVar.entrySet()).iterator()) : ((zzoc) zznzVar.entrySet()).iterator();
    }

    public final boolean c() {
        zznz zznzVar = this.f37093a;
        if (zznzVar.f37182b > 0) {
            f(zznzVar.b(0));
            throw null;
        }
        Iterator it = zznzVar.c().iterator();
        if (!it.hasNext()) {
            return true;
        }
        f((Map.Entry) it.next());
        throw null;
    }

    public final Object clone() {
        zzlv zzlvVar = new zzlv();
        zznz zznzVar = this.f37093a;
        if (zznzVar.f37182b > 0) {
            Map.Entry entryB = zznzVar.b(0);
            zzlu zzluVar = (zzlu) ((zzoa) entryB).f37173a;
            Object obj = ((zzoa) entryB).f37174b;
            zzluVar.zzd();
            throw null;
        }
        Iterator it = zznzVar.c().iterator();
        if (!it.hasNext()) {
            zzlvVar.f37095c = this.f37095c;
            return zzlvVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        zzlu zzluVar2 = (zzlu) entry.getKey();
        entry.getValue();
        zzluVar2.zzd();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlv) {
            return this.f37093a.equals(((zzlv) obj).f37093a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f37093a.hashCode();
    }

    public zzlv(int i2) {
        a();
        a();
    }
}
