package com.google.android.gms.internal.atv_ads_framework;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzaa extends zzdh implements zzep {
    private static final zzdn zzb = new zzy();
    private static final zzaa zzd;
    private zzdm zze = zzdi.f36122d;

    static {
        zzaa zzaaVar = new zzaa();
        zzd = zzaaVar;
        zzdh.i(zzaa.class, zzaaVar);
    }

    public static zzz k() {
        return (zzz) zzd.e();
    }

    public static void l(zzaa zzaaVar) {
        zzdm zzdmVar = zzaaVar.zze;
        if (!zzdmVar.zzc()) {
            int size = zzdmVar.size();
            zzaaVar.zze = zzdmVar.zzg(size == 0 ? 10 : size + size);
        }
        zzaaVar.zze.zzh(1);
    }

    public static void m(zzaa zzaaVar, HashSet hashSet) {
        zzdm zzdmVar = zzaaVar.zze;
        if (!zzdmVar.zzc()) {
            int size = zzdmVar.size();
            zzaaVar.zze = zzdmVar.zzg(size == 0 ? 10 : size + size);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            zzaaVar.zze.zzh(((zzx) it.next()).f36241a);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zze", zzw.f36236a});
        }
        if (i3 == 3) {
            return new zzaa();
        }
        if (i3 == 4) {
            return new zzz(zzd);
        }
        if (i3 != 5) {
            return null;
        }
        return zzd;
    }
}
