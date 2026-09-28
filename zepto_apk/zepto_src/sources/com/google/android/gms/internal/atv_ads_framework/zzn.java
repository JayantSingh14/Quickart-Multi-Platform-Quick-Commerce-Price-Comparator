package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzn extends zzdh implements zzep {
    private static final zzn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzdh.i(zzn.class, zznVar);
    }

    public static zzm k() {
        return (zzm) zzb.e();
    }

    public static /* synthetic */ void l(zzn zznVar) {
        zznVar.zze = 1;
        zznVar.zzd = 1 | zznVar.zzd;
    }

    public static /* synthetic */ void m(zzn zznVar, int i2) {
        zznVar.zzf = i2 - 1;
        zznVar.zzd |= 2;
    }

    public static /* synthetic */ void n(zzn zznVar, int i2) {
        zznVar.zzg = i2 - 1;
        zznVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", zzi.f36233a, "zzf", zzh.f36232a, "zzg", zzl.f36234a});
        }
        if (i3 == 3) {
            return new zzn();
        }
        if (i3 == 4) {
            return new zzm(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
