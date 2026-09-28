package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzac extends zzdh implements zzep {
    private static final zzac zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzu zzg;
    private zzk zzh;
    private zzs zzi;
    private zzp zzj;

    static {
        zzac zzacVar = new zzac();
        zzb = zzacVar;
        zzdh.i(zzac.class, zzacVar);
    }

    public static zzab k() {
        return (zzab) zzb.e();
    }

    public static /* synthetic */ void l(zzac zzacVar, zzp zzpVar) {
        zzacVar.zzj = zzpVar;
        zzacVar.zzd |= 8;
    }

    public static /* synthetic */ void m(zzac zzacVar, zzaa zzaaVar) {
        zzacVar.zzf = zzaaVar;
        zzacVar.zze = 5;
    }

    public static /* synthetic */ void n(zzac zzacVar, zzn zznVar) {
        zzacVar.zzf = zznVar;
        zzacVar.zze = 6;
    }

    public static /* synthetic */ void o(zzac zzacVar, zzu zzuVar) {
        zzacVar.zzg = zzuVar;
        zzacVar.zzd |= 1;
    }

    public static /* synthetic */ void p(zzac zzacVar, zzk zzkVar) {
        zzacVar.zzh = zzkVar;
        zzacVar.zzd |= 2;
    }

    public static /* synthetic */ void q(zzac zzacVar, zzs zzsVar) {
        zzacVar.zzi = zzsVar;
        zzacVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005<\u0000\u0006<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh", "zzi", "zzj", zzaa.class, zzn.class});
        }
        if (i3 == 3) {
            return new zzac();
        }
        if (i3 == 4) {
            return new zzab(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
