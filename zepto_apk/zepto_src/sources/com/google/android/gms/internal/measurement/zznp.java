package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zznp implements zznw {

    /* renamed from: a, reason: collision with root package name */
    public final zznl f37157a;

    /* renamed from: b, reason: collision with root package name */
    public final zzoj f37158b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f37159c;

    public zznp(zzoj zzojVar, zznl zznlVar) {
        zzls zzlsVar = zzlt.f37091a;
        this.f37158b = zzojVar;
        this.f37159c = zznlVar instanceof zzmb;
        this.f37157a = zznlVar;
    }

    public static zznp i(zzoj zzojVar, zznl zznlVar) {
        zzls zzlsVar = zzlt.f37091a;
        return new zznp(zzojVar, zznlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void a(Object obj, Object obj2) {
        zzny.b(obj, obj2);
        if (this.f37159c) {
            zzls zzlsVar = zzlt.f37091a;
            if (((zzmb) obj2).zzb.f37093a.isEmpty()) {
                return;
            }
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean b(Object obj) {
        ((zzmb) obj).zzb.c();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int c(zzme zzmeVar) {
        zzoi zzoiVar = zzmeVar.zzc;
        int iB = zzoiVar.f37191d;
        if (iB == -1) {
            iB = 0;
            for (int i2 = 0; i2 < zzoiVar.f37188a; i2++) {
                int i3 = zzoiVar.f37189b[i2] >>> 3;
                zzlg zzlgVar = (zzlg) zzoiVar.f37190c[i2];
                int iW = zzll.w(8);
                int iW2 = zzll.w(i3) + zzll.w(16);
                int iW3 = zzll.w(24);
                int iF = zzlgVar.f();
                iB = b.b(iW + iW, iW2, e.B(iF, iF, iW3), iB);
            }
            zzoiVar.f37191d = iB;
        }
        if (this.f37159c) {
            zznz zznzVar = ((zzmb) zzmeVar).zzb.f37093a;
            if (zznzVar.f37182b > 0) {
                zzlv.g(zznzVar.b(0));
                throw null;
            }
            Iterator it = zznzVar.c().iterator();
            if (it.hasNext()) {
                zzlv.g((Map.Entry) it.next());
                throw null;
            }
        }
        return iB;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void d(Object obj) {
        this.f37158b.b(obj);
        zzlt.f37091a.a(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void e(Object obj, zzou zzouVar) {
        Iterator itB = ((zzmb) obj).zzb.b();
        if (itB.hasNext()) {
            ((zzlu) ((Map.Entry) itB.next()).getKey()).zzc();
            throw null;
        }
        zzoi zzoiVar = ((zzme) obj).zzc;
        for (int i2 = 0; i2 < zzoiVar.f37188a; i2++) {
            zzouVar.z(zzoiVar.f37189b[i2] >>> 3, zzoiVar.f37190c[i2]);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean f(zzme zzmeVar, zzme zzmeVar2) {
        if (!zzmeVar.zzc.equals(zzmeVar2.zzc)) {
            return false;
        }
        if (this.f37159c) {
            return ((zzmb) zzmeVar).zzb.equals(((zzmb) zzmeVar2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void g(Object obj, byte[] bArr, int i2, int i3, zzkv zzkvVar) {
        zzme zzmeVar = (zzme) obj;
        if (zzmeVar.zzc == zzoi.f37187f) {
            zzmeVar.zzc = zzoi.a();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int h(zzme zzmeVar) {
        int iHashCode = zzmeVar.zzc.hashCode();
        return this.f37159c ? (iHashCode * 53) + ((zzmb) zzmeVar).zzb.f37093a.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        zznl zznlVar = this.f37157a;
        return zznlVar instanceof zzme ? (zzme) ((zzme) zznlVar).r(4) : zznlVar.c().y0();
    }
}
