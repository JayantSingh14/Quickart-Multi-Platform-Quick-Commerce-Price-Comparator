package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzu extends zzdh implements zzep {
    private static final zzu zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzdh.i(zzu.class, zzuVar);
    }

    public static zzt k() {
        return (zzt) zzb.e();
    }

    public static /* synthetic */ void l(zzu zzuVar, String str) {
        str.getClass();
        zzuVar.zzd |= 1;
        zzuVar.zze = str;
    }

    public static /* synthetic */ void m(zzu zzuVar, String str) {
        zzuVar.zzd |= 2;
        zzuVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzu();
        }
        if (i3 == 4) {
            return new zzt(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
