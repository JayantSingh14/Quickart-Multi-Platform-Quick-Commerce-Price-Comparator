package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzp extends zzdh implements zzep {
    private static final zzp zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzdh.i(zzp.class, zzpVar);
    }

    public static zzo k() {
        return (zzo) zzb.e();
    }

    public static /* synthetic */ void l(zzp zzpVar, String str) {
        zzpVar.zzd |= 2;
        zzpVar.zzf = str;
    }

    public static /* synthetic */ void m(zzp zzpVar, String str) {
        zzpVar.zzd |= 4;
        zzpVar.zzg = str;
    }

    public static /* synthetic */ void n(zzp zzpVar, int i2) {
        zzpVar.zze = i2 - 1;
        zzpVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", zzq.f36235a, "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzp();
        }
        if (i3 == 4) {
            return new zzo(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
