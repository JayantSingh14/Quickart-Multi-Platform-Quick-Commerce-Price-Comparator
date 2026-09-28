package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzs extends zzdh implements zzep {
    private static final zzs zzb;
    private int zzd;
    private String zze = "";

    static {
        zzs zzsVar = new zzs();
        zzb = zzsVar;
        zzdh.i(zzs.class, zzsVar);
    }

    public static zzr k() {
        return (zzr) zzb.e();
    }

    public static /* synthetic */ void l(zzs zzsVar) {
        zzsVar.zzd |= 1;
        zzsVar.zze = "1.0.0";
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i3 == 3) {
            return new zzs();
        }
        if (i3 == 4) {
            return new zzr(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
