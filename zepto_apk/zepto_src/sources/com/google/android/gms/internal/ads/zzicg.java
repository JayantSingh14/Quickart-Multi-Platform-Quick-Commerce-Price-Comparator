package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzicg implements zzicu {

    /* renamed from: a, reason: collision with root package name */
    public final zzicc f34718a;

    /* renamed from: b, reason: collision with root package name */
    public final zzidh f34719b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f34720c;

    public zzicg(zzidh zzidhVar, zzicc zziccVar) {
        zziad zziadVar = zziae.f34623a;
        this.f34719b = zzidhVar;
        this.f34720c = zziccVar instanceof zzian;
        this.f34718a = zziccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void a(Object obj, Object obj2) {
        zzicw.e(obj, obj2);
        if (this.f34720c) {
            zziad zziadVar = zziae.f34623a;
            if (((zzian) obj2).zza.f34625a.isEmpty()) {
                return;
            }
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void b(Object obj) {
        this.f34719b.k(obj);
        zziae.f34623a.a(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void c(Object obj, byte[] bArr, int i2, int i3, zzhyz zzhyzVar) {
        zziar zziarVar = (zziar) obj;
        if (zziarVar.zzt == zzidg.f34760f) {
            zziarVar.zzt = zzidg.a();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void d(Object obj, zzhzr zzhzrVar, zziab zziabVar) {
        this.f34719b.i(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final int e(zziar zziarVar) {
        zzidg zzidgVar = zziarVar.zzt;
        int iB = zzidgVar.f34764d;
        if (iB == -1) {
            iB = 0;
            for (int i2 = 0; i2 < zzidgVar.f34761a; i2++) {
                int i3 = zzidgVar.f34762b[i2] >>> 3;
                zzhzl zzhzlVar = (zzhzl) zzidgVar.f34763c[i2];
                int iB2 = zzhzw.b(8);
                int iB3 = zzhzw.b(i3) + zzhzw.b(16);
                int iB4 = zzhzw.b(24);
                int i4 = zzhzlVar.i();
                iB = android.support.v4.media.b.b(iB2 + iB2, iB3, b.a(i4, i4, iB4), iB);
            }
            zzidgVar.f34764d = iB;
        }
        if (this.f34720c) {
            zzicx zzicxVar = ((zzian) zziarVar).zza.f34625a;
            if (zzicxVar.f34755b > 0) {
                zziag.i(zzicxVar.b(0));
                throw null;
            }
            Iterator it = zzicxVar.c().iterator();
            if (it.hasNext()) {
                zziag.i((Map.Entry) it.next());
                throw null;
            }
        }
        return iB;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final int f(zziar zziarVar) {
        int iHashCode = zziarVar.zzt.hashCode();
        return this.f34720c ? (iHashCode * 53) + ((zzian) zziarVar).zza.f34625a.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final boolean g(zziar zziarVar, zziar zziarVar2) {
        if (!zziarVar.zzt.equals(zziarVar2.zzt)) {
            return false;
        }
        if (this.f34720c) {
            return ((zzian) zziarVar).zza.equals(((zzian) zziarVar2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void h(Object obj, zzhzx zzhzxVar) {
        Iterator itB = ((zzian) obj).zza.b();
        if (itB.hasNext()) {
            ((zziaf) ((Map.Entry) itB.next()).getKey()).zzc();
            throw null;
        }
        zzidg zzidgVar = ((zziar) obj).zzt;
        for (int i2 = 0; i2 < zzidgVar.f34761a; i2++) {
            int i3 = zzidgVar.f34762b[i2] >>> 3;
            Object obj2 = zzidgVar.f34763c[i2];
            zzhzxVar.getClass();
            boolean z = obj2 instanceof zzhzl;
            zzhzw zzhzwVar = zzhzxVar.f34606a;
            if (z) {
                zzhzwVar.t(i3, (zzhzl) obj2);
            } else {
                zzhzwVar.s(i3, (zzicc) obj2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final Object zza() {
        zzicc zziccVar = this.f34718a;
        return zziccVar instanceof zziar ? ((zziar) zziccVar).t() : zziccVar.f().n0();
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final boolean zzl(Object obj) {
        ((zzian) obj).zza.d();
        return true;
    }
}
